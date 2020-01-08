package com.xxh.library.controller.BorrowController;



import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxh.library.entity.Book;
import com.xxh.library.entity.Borrow;
import com.xxh.library.entity.Reader;
import com.xxh.library.entity.Readertype;
import com.xxh.library.msg.BorrowMsg;
import com.xxh.library.service.BookService;
import com.xxh.library.service.BorrowService;
import com.xxh.library.service.ReaderService;
import com.xxh.library.service.ReadertypeService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.io.Serializable;
import java.util.*;
import java.util.function.DoubleToIntFunction;

/**
 * (Borrow)表控制层
 *
 * @author makejava
 * @since 2019-12-15 15:19:53
 */
@RestController
@RequestMapping("borrow")
public class BorrowController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private BorrowService borrowService;

    @Resource
    private BookService bookService;

    @Resource
    private ReaderService readerService;

    @Resource
    private ReadertypeService readertypeService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param borrow 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Borrow> page, Borrow borrow) {
        return success(this.borrowService.page(page, new QueryWrapper<>(borrow)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {

        return success(this.borrowService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param borrow 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Borrow borrow) {
        return success(this.borrowService.save(borrow));
    }

    /**
     * 修改数据
     *
     * @param borrow 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Borrow borrow) {
        return success(this.borrowService.updateById(borrow));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.borrowService.removeByIds(idList));
    }
    //显示用户已借未还书籍
    @GetMapping("/getBorrowedBookInfo")
    public R getBorrowedBookAndUserInfo(String rdId){
        QueryWrapper<Borrow>wrapper=new QueryWrapper<>();
        wrapper.eq("rdID", rdId).eq("IsHasReturn",0);
        List<Borrow> list = borrowService.list(wrapper);
        //前台要求显示书名和作者，这些借阅信息表都没有，只好加数据实体属性
        //根据借阅信息表的bookID查出书名和作者，再增加到实体对象中。
        for(Borrow b:list){
            Book book = bookService.getById(b.getBkid());
            b.setBookname(book.getBkname());
            b.setAuthorname(book.getBkauthor());
        }
        return success(list);
    }
    //用户已还书籍
    @GetMapping("/getReturnedBookInfo")
    public R getReturnedBookInfo(String rdId)
    {
        QueryWrapper<Borrow>wrapper=new QueryWrapper<>();
        wrapper.eq("rdID", rdId).eq("IsHasReturn",1);
        List<Borrow> list = borrowService.list(wrapper);
        //前台要求显示书名和作者，这些借阅信息表都没有，只好加数据实体属性
        //根据借阅信息表的bookID查出书名和作者，再增加到实体对象中。
        for(Borrow b:list){
            Book book = bookService.getById(b.getBkid());
            b.setBookname(book.getBkname());
            b.setAuthorname(book.getBkauthor());
        }
        return success(list);
    }

    //处理用户借书请求
    //操作3张表
    //1.借阅信息表插入一条借阅信息
    //2.图书表更新图书状态为借出
    //3.更新读者表的已借书数+1
    @GetMapping("/borrowBook")
    public BorrowMsg handlerBorrow(int rdId,int bkId){
        BorrowMsg borrowMsg = new BorrowMsg();//返回信息实体

        //读者信息和读者类型信息的实体
        Reader reader = readerService.getById(rdId);
        Readertype readertype = readertypeService.getById(reader.getRdtype());

        //首先判断用户是否满足借书条件
        //只有当读者已借书数小于读者允许的最大数才能借出
        if(reader.getRdborrowqty()<readertype.getCanlendqty()){
            //借书表的实体
            Borrow borrow = new Borrow();
            borrow.setRdid(rdId);
            borrow.setBkid(bkId);
            Date now = new Date();//获取当前时间
            borrow.setLddateout(now);//设置借出日期
            int canlendday=readertype.getCanlendday();//获取可借天数
            Date returnDate = DateUtils.addDays(now,canlendday);//得到应还日期
            borrow.setLddateretplan(returnDate);//设置应还日期

            //更新图书状态
            Book book = bookService.getById(bkId);
            book.setBkstatus("借出");

            //更新读者信息,借书数+1
            reader.setRdborrowqty(reader.getRdborrowqty()+1);

            //如果服务层将对三张表的操作都执行行成功，返回正确信息
            if(borrowService.save(borrow)&bookService.updateById(book)&readerService.updateById(reader))
            {
                borrowMsg.setMsg("借书成功");
                return borrowMsg;
            }else {
                borrowMsg.setMsg("系统出了点问题，请稍后再试");
                return borrowMsg;
            }
        }else {
            borrowMsg.setMsg("你已经到了借书上限，不能借了");
            return borrowMsg;
        }

    }

    //处理用户还书请求
    //操作3张表
    //1.借阅信息表更新一条还书记录（填入还书日期，算出超出日期和罚金），设置状态为已还
    //2.读者信息表已借书数-1
    //3.图书表更新图书为在馆状态
    @GetMapping("/returnBook")
    public BorrowMsg handlerReturnBook(int rdId,int bkId){
        BorrowMsg borrowMsg = new BorrowMsg();
        Reader reader = readerService.getById(rdId);
        Readertype readerType = readertypeService.getById(reader.getRdtype());
        Book book = bookService.getById(bkId);
        QueryWrapper<Borrow>queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("rdID",rdId).eq("bkID",bkId).eq("isHasReturn",0);
        Borrow borrow = borrowService.getOne(queryWrapper);
        if(borrow.getIshasreturn().equals(1)){
            borrowMsg.setMsg("这本已经还了");
            return borrowMsg;
        }else {
            borrow.setIshasreturn(1);//设置书籍已还
            Date now=new Date();
            borrow.setLddateretact(now);//设置还书日期
            //如果超期了开始计算超期天数和罚金
            if(borrow.getLddateretplan().getTime()<now.getTime()){
                long overDays = DateUtil.between(borrow.getLddateretplan(), now, DateUnit.DAY);
                borrow.setLdoverday((int) overDays);
                float overMoney = readerType.getPunishrate() * overDays;
                borrow.setLdovermoney((int) overMoney);
            }
            borrowService.updateById(borrow);
            //更新读者借书数量信息
            reader.setRdborrowqty(reader.getRdborrowqty()-1);
            readerService.updateById(reader);
            //更新图书信息,
            // 要是图书在借阅期间已经被管理员设置为销毁或者遗失状态，
            // 我就不更新书籍的状态为在馆
            if(!book.getBkstatus().equals("借出")){
                //管理员设置成了其他状态，书籍信息不更新为在馆
            }else {
                book.setBkstatus("在馆");
                bookService.updateById(book);
            }
            borrowMsg.setMsg("还书成功");
            return borrowMsg;
        }
    }

    //处理用户续借请求
    //操作1张表
    //1.借阅信息表将应还日期往后推迟相应天数（由读者类型决定），续借次数+1（若次数达到上限不可借出）

    @GetMapping("/continueBorrow")
    public BorrowMsg handlerContinueBorrow(int rdId,int bkId){
        BorrowMsg borrowMsg = new BorrowMsg();
        Readertype readerType = readertypeService.getById(readerService.getById(rdId).getRdtype());
        QueryWrapper<Borrow>borrowQueryWrapper=new QueryWrapper<>();
        borrowQueryWrapper.eq("rdID",rdId).eq("bkID",bkId);
        Borrow borrow = borrowService.getOne(borrowQueryWrapper);
        //如果读者还未到可续借上限，允许借书
        if(borrow.getIdcountinuetimes()<readerType.getCancontinuetimes()){
            borrow.setIdcountinuetimes(borrow.getIdcountinuetimes()+1);
            Integer continueDay = readerType.getCanlendday();//获取可续借天数
            Date lddateretplan = borrow.getLddateretplan();
            Date returnDate = DateUtils.addDays(lddateretplan,continueDay);//更新应还日期
            borrow.setLddateretplan(returnDate);
            if(borrowService.updateById(borrow)){
                borrowMsg.setMsg("续借成功");
                return borrowMsg;
            }else {
                borrowMsg.setMsg("系统出错了，稍后再试");
                return borrowMsg;
            }
        }else {
            borrowMsg.setMsg("你已经到达续借上限了不能续借");
            return borrowMsg;
        }
    }

}