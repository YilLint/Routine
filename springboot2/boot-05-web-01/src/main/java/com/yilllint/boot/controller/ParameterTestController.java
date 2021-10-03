package com.yilllint.boot.controller;

import com.yilllint.boot.bean.Person;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterTestController {

    /**
     * 数据绑定，页面提交的请求数据（GET、POST），都可以和对象属性绑定
     * @param person
     * @return
     */
    @PostMapping("/saveuser")
    public Person saveuser(Person person){

        return person;
    }



    //  car/2/owner/zhangsan
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> header,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("inters")  List<String> inters,
                                     @RequestParam MultiValueMap<String,String> params){

        Map<String,Object> map = new HashMap<>();

//        map.put("id",id);
//        map.put("name",name);
//        map.put("pv",pv);
//        map.put("userAgent",userAgent);
//        map.put("header",header);
        map.put("年龄",age);
        map.put("兴趣爱好",inters);
        map.put("句柄",params);
        return map;
    }


    @PostMapping("/save")
    public Map postmethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();

        map.put("内容",content);
        return map;
    }

    //1、语法 /cars/sell;low=34;brand=byd,audi,yd
    //2、SpringBoot默认禁用了矩阵变量的功能
    //  手动开启：原理。对于
    //3、矩阵变量必须存url路径变量才能被解析
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();

        map.put("最低价格",low);
        map.put("品牌",brand);
        map.put("路径",path);
        return map;
    }

    ///boss/1;age=20/2;age=10
    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge) {
        Map<String,Object> map = new HashMap<>();

        map.put("老板年龄",bossAge);
        map.put("员工年龄",empAge);
        return map;
    }

}


