package com.xxh.library.controller.ReaderController;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxh.library.entity.Reader;
import com.xxh.library.msg.ErrorMsg;
import com.xxh.library.msg.LoginMsg;
import com.xxh.library.service.ReaderService;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Reader)表控制层
 *
 * @author makejava
 * @since 2019-12-09 22:09:12
 */
@RestController
@RequestMapping("reader")
public class ReaderController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ReaderService readerService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param reader 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Reader> page, Reader reader) {
        return success(this.readerService.page(page, new QueryWrapper<>(reader)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.readerService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param reader 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Reader reader) {
        if(readerService.getById(reader.getRdid())!=null){
            ErrorMsg errorMsg=new ErrorMsg();
            errorMsg.userExist();
            return errorMsg;
        }else {
            return success(this.readerService.save(reader));
        }

    }

    /**
     * 修改数据
     *
     * @param reader 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Reader reader) {
        return success(this.readerService.updateById(reader));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.readerService.removeByIds(idList));
    }
    @GetMapping("/login")
    public LoginMsg LoginCheckMsg(String rdId, String rdpwd){
        LoginMsg loginMsg=new LoginMsg();
        Reader reader = readerService.getById(rdId);
        if(reader==null){
            loginMsg.noUser();
        }else {
            if(reader.getRdpwd().equals(rdpwd)){
                loginMsg.succ();
            }else {
                loginMsg.pswWrong();
            }
        }
        return loginMsg;
    }
    @GetMapping("/findReader")
    public R findUser(int rdType,String rdLoc,String rdName,Page<Reader> page){
        QueryWrapper<Reader>queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("rdType", rdType).like("rdName", rdName).eq("rdDept", rdLoc);
        return (success(this.readerService.page(page,queryWrapper)));

    }
}