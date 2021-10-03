package com.yillint.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FormsCongtroller {

    @GetMapping("/form_layouts")
    public String form_layouts(){

        return "forms/form_layouts";
    }

    /**
     * MultipartFile 自动封装上传来的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {

        log.info("上传的信息: email={},username={},headerImg={},photos={}",
                email,username,headerImg.getSize(),photos.length);

        if(!headerImg.isEmpty()){
            //保存到文件服务器,OSS服务器
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("D:\\cache\\"+originalFilename));
        }

        if(photos.length > 0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\cache\\"+originalFilename));
                }
            }
        }

        return "main";
    }

    @GetMapping("/pickers")
    public String pickers(){

        return "forms/pickers";
    }

    @GetMapping("/inline_editors")
    public String inline_editors(){

        return "forms/inline_editors";
    }

    @GetMapping("/form_wizard")
    public String form_wizard(){

        return "forms/form_wizard";
    }

    @GetMapping("/form_validation")
    public String form_validation(){

        return "forms/form_validation";
    }

    @GetMapping("/form_advanced_components")
    public String form_advanced_components(){

        return "forms/form_advanced_components";
    }

    @GetMapping("/editors")
    public String editors(){

        return "forms/editors";
    }

    @GetMapping("/dropzone")
    public String dropzone(){

        return "forms/dropzone";
    }
}
