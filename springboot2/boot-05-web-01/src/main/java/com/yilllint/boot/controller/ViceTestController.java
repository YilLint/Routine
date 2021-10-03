package com.yilllint.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViceTestController {

    @GetMapping("/yillint")
    public String yillint(Model model){

        //model中的数据会被放在请求域中，request.setAttribute("a",aa)
        model.addAttribute("msg","你好 yillint");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
