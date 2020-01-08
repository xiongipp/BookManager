package com.xxh.library.controller.ReaderTypeController;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xxh.library.entity.Readertype;
import com.xxh.library.service.ReadertypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Readertype)表控制层
 *
 * @author makejava
 * @since 2019-12-13 21:29:05
 */
@RestController
@RequestMapping("readertype")
public class ReadertypeController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private ReadertypeService readertypeService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param readertype 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Readertype> page, Readertype readertype) {
        return success(this.readertypeService.page(page, new QueryWrapper<>(readertype)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.readertypeService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param readertype 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Readertype readertype) {
        return success(this.readertypeService.save(readertype));
    }

    /**
     * 修改数据
     *
     * @param readertype 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Readertype readertype) {
        return success(this.readertypeService.updateById(readertype));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.readertypeService.removeByIds(idList));
    }
}