package com.xxh.library.controller.readerBorrorInfo;

import com.xxh.library.entity.Reader;
import com.xxh.library.entity.ReaderBorrowInfo;
import com.xxh.library.entity.Readertype;
import com.xxh.library.service.ReaderService;
import com.xxh.library.service.ReadertypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
//自定义控制器，根据读者ID返回读者可以借阅权限信息，包括可以借多少本。
@RestController
@RequestMapping("readerBorrowInfo")
public class readerBorrowInfoController {
    @Resource
    private ReaderService readerService;
    @Resource
    private ReadertypeService readertypeService;

//
    @GetMapping("/getInfo")
    public ReaderBorrowInfo getReaderBorrowInfo (int id){
        ReaderBorrowInfo readerBorrowInfo = new ReaderBorrowInfo();
        Reader reader = readerService.getById(id);
        if(reader!=null){
            readerBorrowInfo.setName(reader.getRdname());
            readerBorrowInfo.setLocate(reader.getRddept());
            readerBorrowInfo.setHasLearned(reader.getRdborrowqty());

            int typeid=reader.getRdtype();
            Readertype readertype = readertypeService.getById(typeid);
            readerBorrowInfo.setCanBorrowNum(readertype.getCanlendqty());
            readerBorrowInfo.setCanBorrowDay(readertype.getCanlendday());
            readerBorrowInfo.setReaderType(readertype.getRdtypename());
            readerBorrowInfo.setMsg("ok");
            return readerBorrowInfo;
        }else {
            readerBorrowInfo.setMsg("user not exist");
            return  readerBorrowInfo;
        }

    }
}
