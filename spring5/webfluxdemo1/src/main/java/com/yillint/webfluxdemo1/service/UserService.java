package com.yillint.webfluxdemo1.service;

import com.yillint.webfluxdemo1.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//用户操作的接口
public interface UserService {
    //根据id查询用户
    Mono<User> getUserBuid(int id);

    //查询所有用户
    Flux<User> getAllUser();

    //添加用户
    Mono<Void> saveUserInofo(Mono<User> user);
}
