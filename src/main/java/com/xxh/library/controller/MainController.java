package com.xxh.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/MainFrame")
    public String MainFrame(@RequestParam("adId") String adId)
    {
        return "main";
    }
    @GetMapping("/readerFrame")
    public String readerFrame(@RequestParam("rdId") String rdId){
        return "readerMain";
    }
}
