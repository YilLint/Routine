package com.yillint.webfluxdemo1.handler;

import com.yillint.webfluxdemo1.entity.User;
import com.yillint.webfluxdemo1.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class UserHandler {

    private final UserService userService;

    public UserHandler(UserService userService){
        this.userService = userService;
    }


    //根据id查询
    public Mono<ServerResponse> getUserByid(ServerRequest request){
        int userId = Integer.
                valueOf(request.pathVariable("id"));
        //空值处理
        Mono<ServerResponse> notFound = ServerResponse.
                notFound().build();
        Mono<User> userMono = this.userService.getUserBuid(userId);
        //把userMono进行转换返回，使用Reactor操作符flatMap
        return
        userMono.flatMap(person -> ServerResponse.ok().
                contentType(MediaType.APPLICATION_JSON).
                body(fromObject(person))).switchIfEmpty(notFound);
    }

    // 查询所有
    public Mono<ServerResponse> getAllUsers(ServerRequest request){
        Flux<User> users = this.userService.getAllUser();
        return ServerResponse.ok().
                contentType(MediaType.APPLICATION_JSON).
                body(users,User.class);
    }
    //返回的时serverrespinse，一个时mono，flux<users>被封装到serverresponse的body中了


    // 添加
    public Mono<ServerResponse> saveUser(ServerRequest request){
        //得到对象
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok().
                build(this.userService.saveUserInofo(userMono));
    }


}
