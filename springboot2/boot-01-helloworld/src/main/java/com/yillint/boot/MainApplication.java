package com.yillint.boot;


import ch.qos.logback.core.db.DBHelper;
import com.yillint.boot.bean.Pet;
import com.yillint.boot.bean.User;
import com.yillint.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


/*
*主程序类;主配值类
* @SpringBootApplication:这是一个SpringBoot应用
* */


//@SpringBootApplication(scanBasePackages = "com.yillint")
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.yillint")
public class MainApplication {

    public static void main(String[] args) {

        //1.返回ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2.查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }


        int beanDefinitionCount = run.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);

        //查看一个没有配置的但加载了的组件
        String[] beanNamesForType = run.getBeanNamesForType(CacheAspectSupport.class);
        System.out.println("==============================="+beanNamesForType.length);

        //查看一个配置了的加载了的组件
        String[] beanNamesForType1 = run.getBeanNamesForType(WebMvcProperties.class);
        System.out.println("==============================="+beanNamesForType1.length);

        //3.从容中获取组件
//        Pet tom1 = run.getBean("tom", Pet.class);
//
//        Pet tom2 = run.getBean("tom", Pet.class);
//
//        System.out.println("组件："+(tom1 == tom2));
//
//
//        //4.获取转载组件的配置类容器
//        //com.yillint.boot.config.MyConfig$$EnhancerBySpringCGLIB$$79644171@11a82d0f
//        MyConfig bean = run.getBean(MyConfig.class);
//        System.out.println(bean);
//
//        //猜想：调用配置类的方法实例，会得到不同的实例吗？
//
//        //如果是@Configuration(proxyBeanMethods = true)代理对象方法，SpringBoot总会检查这个组件是否在容器中有
//        //保持组件单实例
//        User user = bean.user01();
//        User user1 = bean.user01();
//        System.out.println((user == user1));
//
//        //配置类中注册方法之间有依赖，如这里的User依赖Pet组件，并且这个User想要之前就在组件中注册的那个Pet，那么代理就要true
//        User user01 = run.getBean("user01",User.class);
//        Pet tom = run.getBean("tom", Pet.class);
//
//        System.out.println("用户的宠物"+(user01.getPet() == tom));
//
//
//        //5.利用@import导入的指定（存在的）组件
//        String[] beanNamesForType = run.getBeanNamesForType(User.class);
//        System.out.println("================================");
//        for (String s : beanNamesForType) {
//            System.out.println(s);
//        }
//
//        DBHelper bean1 = run.getBean(DBHelper.class);
//        System.out.println(bean1);
//
        boolean tom = run.containsBean("tom");
        System.out.println("容器中Tom组件："+tom);

        boolean user01 = run.containsBean("user01");
        System.out.println("容器中user01组件："+user01);

        boolean tom22 = run.containsBean("tom22");
        System.out.println("容器中tom22组件："+tom22);

        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println("容器中haha组件："+haha);
        System.out.println("容器中hehe组件："+hehe);



    }
}

    