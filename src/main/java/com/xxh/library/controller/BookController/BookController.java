package com.xxh.library.controller.BookController;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxh.library.entity.Book;
import com.xxh.library.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Book)表控制层
 *
 * @author makejava
 * @since 2019-12-14 12:13:40
 */
@RestController
@RequestMapping("book")
public class BookController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private BookService bookService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param book 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Book> page, Book book) {
        return success(this.bookService.page(page, new QueryWrapper<>(book)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.bookService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param book 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Book book) {
        return success(this.bookService.save(book));
    }

    /**
     * 修改数据
     *
     * @param book 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Book book) {
        return success(this.bookService.updateById(book));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.bookService.removeByIds(idList));
    }


    //根据书名查出书籍信息的后台api接口
    @GetMapping("/getByName")
    public R getByBookName(String bookname,Page<Book> page){
        QueryWrapper<Book>queryWrapper=new QueryWrapper<>();
        queryWrapper.like("bkName",bookname);
        return success(this.bookService.page(page,queryWrapper));
    }
    //根据作者查出书籍信息的后台api接口
    @GetMapping("/getByAuthor")
    public R getByBookAuthor(String authorname,Page<Book> page){
        QueryWrapper<Book>queryWrapper=new QueryWrapper<>();
        queryWrapper.like("bkAuthor",authorname);
        return success(this.bookService.page(page,queryWrapper));
    }
    //根据出版社查出书籍信息的后台api接口
    @GetMapping("/getByPress")
    public R getByBookPresser(String pressname,Page<Book> page){
        QueryWrapper<Book>queryWrapper=new QueryWrapper<>();
        queryWrapper.like("bkPress",pressname);
        return success(this.bookService.page(page,queryWrapper));
    }
    //高级查询根据多字段查出结果
    @GetMapping("/getByMiltField")
    public R getBookByMiltFields(String bookname,String pressname,String author,String brief,String cateloge,Page<Book> page){
        QueryWrapper<Book>queryWrapper=new QueryWrapper<>();
        queryWrapper.like("bkPress",pressname)
                .like("bkName",bookname)
                .like("bkAuthor",author)
                .like("bkBrief",brief)
                .like("bkCatalog",cateloge);
        return success(this.bookService.page(page,queryWrapper));
    }
}