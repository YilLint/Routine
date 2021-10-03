package com.yillint.webfluxdemo1.service.impl;

import com.yillint.webfluxdemo1.entity.User;
import com.yillint.webfluxdemo1.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;


@Service
public class UserServiceUmpl implements UserService {

    //创建map集合存储数据
    private  final Map<Integer,User> users = new HashMap<>();


    public UserServiceUmpl(){
        this.users.put(1,new User("lucy","man",18));
        this.users.put(2,new User("marry","nv",28));
        this.users.put(3,new User("jack","nv",38));
    }

    //根据id查询
    @Override
    public Mono<User> getUserBuid(int id) {
        return Mono.justOrEmpty(this.users.get(id));
    }

    //查询多个用户
    @Override
    public Flux<User> getAllUser() {
        return Flux.fromIterable(this.users.values());
    }

    //添加
    @Override
    public Mono<Void> saveUserInofo(Mono<User> userMono) {
        return userMono.doOnNext(person -> {
            //想map集合中放值
            int id = users.size()+1;
            users.put(id,person);
        }).thenEmpty(Mono.empty());
    }
}
