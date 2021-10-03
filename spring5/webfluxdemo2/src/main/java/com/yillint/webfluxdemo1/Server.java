package com.yillint.webfluxdemo1;

import com.yillint.webfluxdemo1.handler.UserHandler;
import com.yillint.webfluxdemo1.service.impl.UserServiceUmpl;


import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.netty.http.server.HttpServer;


import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;

public class Server {

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        server.createReactorServer();
        System.out.println("enter to exit");
        System.in.read();
    }

    //1 创建Router路由
    public RouterFunction<ServerResponse> routingFunction(){
        UserServiceUmpl userService = new UserServiceUmpl();
        UserHandler handler = new UserHandler(userService);

        return RouterFunctions.route(
                GET("/users/{id}").and(accept(APPLICATION_JSON)),handler::getUserByid)
                .andRoute(GET("/users").and(accept(APPLICATION_JSON)),handler::getAllUsers);

    }


    //创建服务器完成适配
        public void createReactorServer(){
            //路由和handler适配
            RouterFunction<ServerResponse> router = routingFunction();
            HttpHandler httpHandler = toHttpHandler(router);
            ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);

            //创建服务器
            HttpServer httpServer = HttpServer.create();
            httpServer.handle(adapter).bindNow();

    }

}
