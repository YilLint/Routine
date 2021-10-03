package com.yillint.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yillint.admin.bean.User;
import com.yillint.admin.exception.UserTooManyException;
import com.yillint.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    /**
     *
     * @param a 不带请求参数或者参数不对 400：badrequest  一般都是浏览器的参数没有传递正确
     * @return
     */
    @GetMapping("/basic_table")
    public String basic_table(@RequestParam("a") int a){

        int i=10/0;
        return "table/basic_table";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             RedirectAttributes ra){

        userService.removeById(id);

        ra.addAttribute("pn",pn);

        return "redirect:/dynamic_table";
    }


    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1")Integer pn,  Model model){
        //表格内容的遍历
//          response.sendError
//        List<User> users = Arrays.asList(new User("zhangsan", "1"),
//                new User("lisi", "12"),
//                new User("haha", "123"),
//                new User("hehe", "1234"));
//        model.addAttribute("users",users);
//
//        if(users.size() > 3){
//            throw new UserTooManyException();
//        }

        //从数据库中，读取数据进行展示
        List<User> list = userService.list();
//        model.addAttribute("users",list);

        //分页查询数据
        Page<User> userPage = new Page<>(pn, 2);

        //分页查询的结果
        Page<User> page = userService.page(userPage, null);
        long current = page.getCurrent();
        long total = page.getTotal();
        long pages = page.getPages();
        List<User> records = page.getRecords();

        model.addAttribute("page",page);

        return "table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){

        return "table/editable_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "table/responsive_table";
    }
}
