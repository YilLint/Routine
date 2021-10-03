package com.yillint.boot.config;


import ch.qos.logback.core.db.DBHelper;
import com.yillint.boot.bean.Car;
import com.yillint.boot.bean.Pet;
import com.yillint.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.filter.CharacterEncodingFilter;


/*
* 1、配置类里面使用@Bean标注在方法上给容器添加组件，默认是单实例的
* 2、配置类本身也是组件
* 3、proxyBeanMethods:代理bean的方法
*       Full(proxyBeanMethods = true)
*       Lite(proxyBeanMethods = false)
*
* 4、@Import({User.class, DBHelper.class})
*       给容器中自动创建出这两个类型的组件，默认组件的名字是全类名
*
*
* */


@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)//告诉SpringBoot这是一个配置类 == 配置文件
//@ConditionalOnBean(name = "tom")
@ConditionalOnMissingBean(name = "tom")
@ImportResource("classpath:beans.xml")
//@EnableConfigurationProperties(Car.class)
//1、开启car的配置绑定功能
//2、把这个指定的的Car自动注册到容器中
public class MyConfig {


    /*
    * 外部无论对配置类中的这个组件注册方法多少次，获取的都是之前注册容器中的单实例对象
    * @return
    * */
    @Bean//给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan", 18);
        //user组件依赖了Pet组件
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

//    @Bean("tom")
    @Bean("tom22")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }

//    @Bean
//    public CharacterEncodingFilter filter(){
//        return null;
//    }


}
