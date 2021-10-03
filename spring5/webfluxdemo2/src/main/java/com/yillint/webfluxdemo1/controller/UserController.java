package com.yillint.webfluxdemo1.controller;

import com.yillint.webfluxdemo1.entity.User;
import com.yillint.webfluxdemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    //注入service
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public Mono<User> getUserId(@PathVariable int id){
        return userService.getUserBuid(id);
    }

    @GetMapping("/user")
    public Flux<User> getUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/sabeuser")
    public Mono<Void> getUser(@RequestBody User user){
        Mono<User> userMono = Mono.just(user);
        return userService.saveUserInofo(userMono);
    }

}
