# Spring5

## 1、Spring框架概述

### 1、Spring框架概述

1、Spring是轻量级的开源的JavaEE（java2企业平台版本）框架



2、Spring可以解决企业应用开发的复杂性



3、Spring有两个核心部分：IOC和Aop

​	1）IOC：控制反转，把创建对象的过程交给Spring进行管理

​	2）Aop：面向切面，不修改源代码进行功能增强



4、Spring特点

​	1）方便解耦，简化开发

​	2）Aop编程支持

​	3）方便程序测试

​	4）方便和其他框架整合

​	5）方便啊进行事务操作

​	6）减低API开发难度

本次学习为Spring5；



### 2、入门案例

1、下载Spring5（还是得用青蛙，下载的是那个dist）



2、创建项目



3、导入jar包



4、创建普通类，在类中创建普通方法



5、创建Spring配置文件，在配置文件配置创建对象

1）Spring配置文件使用xml格式 



6、测试



## 2、IOC容器

### 1、IOC底层原理

1）ioc概念和原理

1、什么是IOC

1）控制反转，把对象创建和对象之间的调用过程，交给Spring进行管理

2）使用IOC目的：为了耦合度降低

3）做入门案例就是IOC实现



2、IOC底层原理

1）xml解析、工厂模式、反射



3、IOC原理

![image-20210726201002652](D:\springboot_practice\spring5\images\image-20210726201002652.png)

![image-20210726201133051](D:\springboot_practice\spring5\images\image-20210726201133051.png)

![image-20210726201744872](D:\springboot_practice\spring5\images\image-20210726201744872.png)

反射（字节码控制class）

### 2、IOC接口（BeanFactory）

1、IOC思想基于IOC容器完成，IOC容器底层就是对象工厂



2、Spring提供IOC容器石像两种方式：（两个接口）

​	1）BeanFactory：IOC容器基本实现，是Spring内部的使用的接口，不提供开发人员进行使用

*加载配置文件不会创建对象，在获取（使用）对去采取创建对象



​	2）ApplicationContext：BeanFactory接口的子接口，提供更多更强大的功能，一般由开发人员进行使用

*加载配置文件时候就会把配置文件的对象进行创建



3、ApplicationContext有实现类



### 3、IOC操作Bean管理（基于xml）

1、什么是Bean管理（指的是两个操作）

​	1）Spring创建对象

​	2）Spring注入属性



2、Bean管理操作有两种方式

​	1）基于xml配置文件方式

​	2）基于注解方式实现



**创建对象**

1、在spring配置文件中，使用bean标签，标签里面添加对应属性，就可以实现对象创建

2、在bean标签有很多属性

​	1）id属性：唯一表示

​	2）class属性：类全路径（包类路径）

​	3）创建对象时候，默认也是执行的无参数方法完成对象创建



**注入属性**

1）DI：依赖注入，就是注入属性

1、第一种注入方式：使用set方法进行注入

创建类，定义属性和对应的set方法

在spring配置文件配置对象创建，配置属性注入



2、第二种注入方式：有参构造注入

1）创建类；定义属性，有参构造

2）配置文件配置



**P名称空间注入**

1）使用p名称空间注入，可以简化xml配置

1、添加p名称空间在配置文件中

2、进行属性的注入，在bean标签里面注入



### 4、IOC操作Bean管理（xml注入其他类型属性）

1、字面量

​	1）null值

​	2）属性值包含特殊符号



2、注入属性-外部bean

1）创建两个类service类、dao类

2）在service中调用dao



3、注入属性-内部部bean和级联赋值

1）一对多关系：部门和员工

一个部门有多个员工，一个员工属于一个部门

部门是一，员工是多

2）在实体类之间表示多个关系

3）在spring配置文件中进行配置

4、注入属性-级联赋值



### 5、IOC操作Bean管理（xml注入集合属性）

1、注入数组类型属性

2、注入List集合类型属性

3、注入Map集合类型属性

1）创建对应属性及set方法

2）在spring配置文件进行配置

4、在集合里面设置对象类型值



5、把集合注入部分提取出来

1）在Spring的配置文件引入新的名称空间util

2）使用util标签完成list集合注入提取



### 6、IOC操作Bean管理（FactoryBean）

1、Spring有两种类型Bean，一种是普通Bean，另外一种是工厂bean（FactoryBean）

2、普通bean：在配置文件中定义Bean类型就是返回类型

3、工厂bean：在配置文件定义bean类型可以和返回类型不一样

第一步：创建类，让这个类作为工厂bean，实现接口FactoryBean

第二步：实现接口里面的方法，在实现的方法中定义返回的bean类型



IOC操作Bean管理（Bean作用域）

1、在spring里面，设置创建Bean实例是单例模式还是多实例

2、在spring默认情况下，bean是单实例

3、如何设置单实例还是多实例

1）spring配置文件就有一个属性（scope）就是设置单实例还是多实例

2）scope值：

prototype：多实例

singleton：单实例，也是默认值

3）prototype和singleton区别

1.分别代表多实例和单实例

2.singleton，加载spring配置文件时就会创建一个单实例对象

prototype，不是在加载spring配置文件时候创建对象，而是在调用getBean方法时创建多实例对象





### 7、IOC操作Bean管理（bean声明周期）

1、生命周期

​	1）从对象创建到对象销毁的过程



2、bean的生命周期

​	1）通过构造器创建bean实例（无参构造）

​	2）为bean的属性设置值和对其他bean引用（调用set方法）

​	3）调用bean的初始化方法（需要进行配置初始化的方法）

​	4）bean可以使用了

​	5）当容器关闭时，调用bean的销毁方法（需要惊醒配置的方法）



3、演示bean的生命周期



4、bean的后置处理器，bean生命周期有7步

​    1）通过构造器创建bean实例（无参构造）

​	2）为bean的属性设置值和对其他bean引用（调用set方法）

​	3）把bean的实例传递给bean后置处理器方法

```
postProcessBeforeInitialization
```

​	4）调用bean的初始化方法（需要进行配置初始化的方法）

```
postProcessAfterInitialization
```

​	5）把bean的实例传递给bean后置处理器方法

​	6）bean可以使用了

​	7）当容器关闭时，调用bean的销毁方法（需要惊醒配置的方法）



5、演示添加后置处理器效果

​	1）创建类，实现接口BeanPostProcessor，创建后置处理器





### 8、IOC操作Bean管理（xml自动装配）

1、什么是自动装配

​	1）根据指定的装配规则（属性名或者属性类型），spring自动将匹配的属性进行注入



2、演示自动装配

1、根据属性名称自动注入

2、根据属性类型自动注入（相同类型的不能注册多个）





### 9、IOC操作Bean管理（外部属性文件）

1、直接配置数据库信息

​	1）配置德鲁伊连接池

​	2）引入druid连接池的jar包



2、引入外部属性文件配置数据库

​	1）创建外部属性文件，properties格式文件，写数据库信息

​	2）把外部properties属性文件引入到spring配置文件中

​		*引入context名称空间

​		在spring配置文件使用标签引用外部属性文件



### 10、IOC操作Bean管理（基于注解）

1、什么是注解

​	1）注解是代码特殊标记，格式:@注解名称（属性名称=属性值，属性名称=属性值。。）

​	2）使用注解，注解作用在类上面，方法上面，属性上面

​	3）使用注解，简化xml配置



2、Spring针对Bean管理中创建对象提供注解

​	1）@Component

​	2）@Service

​	3）@Controller

​	4）@Repository

​		$上面四个都可以用来创建bean实例



3、基于注解方式实现对象创建

第一步	引入依赖

第二步	开启组件扫描

第三步	创建类，在类上面添加对象注解



4、开启组件扫描细节配置



5、属性注入

@AutoWired：根据属性类型进行自动装配

第一步：把service和dao对象创建，在servce和dao类添加创建对象注解

第二步：在service注入dao对象，在service类中添加dao类型属性，在属性上面使用注解

@Qualifier：根据属性名称进行自动装配

和上一个配合使用，指定派生类

@Resource：以上两者皆可

@Value：注入普通类型属性 



6、完全注解开发

​	1）创建配置类，替代xml配置文件

​	2）编写测试类





## 3、Aop

#### 1、概念

​	1）面向切面编程（方面），利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各个部分之间耦合度降低，提高程序的可重用性，同时提高了开发效率。

​	2）通俗描述：不通过修改源代码的方式，在主干功能里面添加新功能

​	3）例

![image-20210819092402470](D:\springboot_practice\spring5\images\image-20210819092402470.png)

#### 2、底层原理

1、AOP底层使用动态代理

第一种：有接口，使用JDK动态代理

创建接口实现类代理对象，增强类的方法

![image-20210819095041250](D:\springboot_practice\spring5\images\image-20210819095041250.png)



第二种：没有接口，使用CGLIB动态代理

创建子类的代理对象，增强类的方法

![image-20210819095504526](D:\springboot_practice\spring5\images\image-20210819095504526.png)



#### 3、jdk动态代理

1.使用jdk动态代理，使用Proxy类创建出代理对象

​	1）调用newProxyInstaance

​		有三个参数

​			#类加载器

​			#增强方法所在类，这个类实现的接口，支持多个接口

​			#实现这个接口InvocationHandle，创建代理对象，写增强对象



2、编写Jdk动态代理代码

1）创建接口，定义方法



2）创建接口是实现类，实现方法



3）使用Proxy类创建代理对象





#### 4、术语

1.连接点

类里面哪些方法可以增强，这些方法称为连接点。



2.切入点

实际被真正增强的方法，称为切入点



3.通知（增强）

​	1）实际增强的逻辑部分称为通知（增强）

​	2）通知的五种类型

​		#前置通知

​		#后置通知

​		#环绕通知

​		#异常通知

​		#最终通知



4.切面

是动作，把通知应用到切入点的过程



#### 5、准备

1、Spring框架一般是基于AspectJ实现Aop操作

​	1）什么是AspectJ

AspectJ不是Spring的一部分，独立的Aop框架，一般把AspectJ和Spring框架一起使用，进行Aop操作



2、基于AspectJ实现AOP操作

​	1）基于xml配置文件方式

​	2）基于注解方式实现（常用）



3、项目工程中引入AOP相关依赖



4、切入点的表达式

​	1）切入点表达式作用：知道对那个类里面的哪个方法进行增强

​	2）语法结构

```
execution([权限修饰符][返回类型][类全路径][方法名称]([参数列表]))
```

举例：1：对com.yillint.Book类里面的add进行增强

execution（*com.yillint.book.add(..)）



2：对com.yillint.Book类里面的所有方法进行增强

execution（*com.yillint.book.*(..)）



3：对com.yillint包里所有类里面的所有方法进行增强

execution（*com.yillint.*.*(..)）



#### 6、AspectJ注解

1、创建类，在类里面定义方法



2、建立增强类（编写增强逻辑）

​	1）在增强类里面，创建方法，让不同方法代表不同通知（增强）



3、进行通知的配置

​	1）在Spring配置文件中，开启注解扫描

​	2）使用注解创建User和UserProxy对象

​	3）在增强类上面添加注解@Aspect

​	4）在spring配置文件中开启生成代理对象



4、配置不同类型的通知

1）在增强类里面，在作为通知方法上面通过添加通知类型注解，使用切入点表达式配置



5、相同的切入点进行抽取



6、有多个增强类对同一个方法进行增强，设置增强类优先级

1）在增强类上面添加注解@Order（数字类型值），数字类型值越小优先级越高



#### 7、Aspectj配置文件

1、创建两个类，增强类和被增强类

​	

2、在spring配置文件中创建两个类对象



3、在spring配置文件配置切入点



7、完全使用注解开发

1）创建配置类，不需要创建xml配置文件





## 4、JdbcTemplate

### 1、概念设准备

1、什么是JDBCTemplate

1）Spring框架对Jdbc进行封装，使用jdbcTemplate方便实现对数据库的操作

2、准备

1）引入相关jar包

2）在spring配置文件配置数据库连接池

3）配置jdbcTemplate对象，注入DataSource

4）创建Service类，创建dao类，在dao注入jdbcTemplate对象

配置文件

service

dao



### 2、操作数据库（添加）

1、对应数据库创建实体类

2、编写service和dao

1）在dao进行数据库添加操作

2）调用Jdbctemplate对象里面update方法实现添加操作

参数为sql语句，可变参数（设置sql值）

3）测试



### 3、查询返回某个值

1、查询表里面有多少条记录，返回是某个值

2、使用JdbcTemplate实现查询返回某个值代码

​	方法queryForObject有两个参数

​		sql语句：

​		返回类型class：



### 4、查询返回对象

1、场景：查询图书详情

2、jdbcTemplate实现查询返回对象

​	方法queryForObject有三个参数

​		sql语句

​		RowMapper，是接口，返回不同类型数据，使用这个接口里面实现完成数据封装。

​		sql语句值



### 5、查询返回集合

1、场景:查询图书列表分页...

2、调用 JdbcTEmplate方法实现查询返回集合

​	query有三个参数

​		sql语句

​		RowMapper，是接口，返回不同类型数据，使用这个接口里面实现完成数据封装。

​		sql语句值

​		

### 6、批量操作

1、批量操作：操作表里面多条纪律

2、jdbc实现批量操作

batchupdate有两个集合

​		SQL语句

​		List集合，添加的多条记录的数据



## 5、事务管理

### 1、概念

什么是事务：事务是数据库操作最基本单元，逻辑上一组操作，要么都成功，如果有一个失败所有操作都失败。

经典例子：银行转账



2、事务的四个特性（ACID）

1)原子性

2)一致性

3)隔离性

4)持久性



### 2、搭建事务的操作环境

![image-20210822205920265](D:\springboot_practice\spring5\images\image-20210822205920265.png)



1、创建数据库表，添加记录



2、创建service，搭建dao，完成对象创建和注入关系

​	1）service注入dao，在dao注入jdbctemplate，在jdbctemolate注入datasource

​	2）在dao层创建对应方法



3、上述代码可能出现问题

![image-20210822213604434](D:\springboot_practice\spring5\images\image-20210822213604434.png)



### 3、Spring事务管理介绍

1、事务一般添加到service层上



2、在Spring进行事务操作一般有两种方式

​	1）编程式事务操作：就是写代码，上面trycatch哪个

​	2）声明式事务操作（更加方便）



3、声明式事务管理

​	1）基于注解（多）

​	2）基于xml配置



4、在Spring进行声明式事务管理，底层使用AOP（面向切面）



### 4、注解声明式事务管理

1、在spring配置事务管理器

2、在spring配置文件，开启事务管理

​	1）命名空间

​	2）开启事务的注解

3、在service类（或者在其内部的方法上添加）上面添加事务注解@Transactional

在对应位置加，对应生效

然后运行就行了。很方便的。



5、参数配置

1.在service类上添加@Transactional注解，在这个注解里面可以配置线管参数

​	1）propagation	事务传播行为

​		多事务方法直接调用，这个过程中事务是如何进行管理的

![image-20210823160638255](D:\springboot_practice\spring5\images\image-20210823160638255.png)

![image-20210823160709883](D:\springboot_practice\spring5\images\image-20210823160709883.png)

​	

​	2）isolation 事务隔离级别

事务有特性成为隔离性，多事务操作之间不会产生影响。不考虑隔离性产生很多问题

有三个读的问题：

​		脏读：一个未提交的事务读到另一个未提交的事务

​		不可重复读：一个未提交的事务读取到另一个已提交的修改事务

​		虚（幻）读：一个未提交的事务读取到另一个已提交的添加事务

通过事务隔离级别解决上面读的问题

![image-20210823162837351](D:\springboot_practice\spring5\images\image-20210823162837351.png)

spring默认可重复读



​	3）timeout	超时时间

事务需要在一定时间内提交，否则回滚

默认值未-1（不超时），设置以秒为单位



​	4）readOnly	是否只读

读就是查询，写就是修改

默认值为false，即可读可修改

true就只能查



​	5）rollbackFor	回滚

设置出现那些异常进行事务回滚



​	6）noRollbackfor	不回滚

设置出现那些异常不进行事务回滚



### 5、XMl声明式事务管理

1、在spring配置文件中进行配置

​	配置事务管理器

​	配置通知

​	配置配置切入点和切面



### 6、完全注解声明式事务管理

1、创建配置类，使用配置类替代xml配置文件



## 6、Spring5新特性

### 1、新功能 

1、整个Spring5框架代码基于Java8,运行时兼容JDK9，许多不建议使用类和方法在代码库中删除。



### 2、Spring5.0框架自带了通用的日志封装

​	1）已经移除了Log4jConfigListener，官方建议Log4j2

​	2）整合了Log4j2



1、引入jar包

2、创建log4j2.xml配置文件





### 3、Spring5框架核心容器支持@Nullable注解

​	1）@Nullable注解可以使用在方法上面，属性上面，参数上面，表示方法返回可以为空，属性值可以为空，参数值可以为空。



### 4、Spring5核心容器支持函数式风格GenericApplicationContext



### 5、Spring5支持整合JUnit5

​	1）整合Junit4

引入依赖jar包

创建测试类，使用注解完成



​	2）Spring5整合junit5

引入junit5的jar包

创建测试类，使用注解完成



### 6、SpringWebFlux

1、SpringWebFlux介绍

1）是Spring5添加新的模块，用于web开发的，功能和SpringMVC类似的，Webflux使用当前一种比较流行响应式编程出现的框架

2）使用传统的web框架，比如SpringMVC，这些基于Servlet容器，Webflux是一种异步阻塞的框架，异步阻塞的框架在Servlet3.1以后支持，核心是基于Reactor的相关API实现的。

3）异步非阻塞：

​	异步和同步

​	阻塞和非阻塞

都是针对对象不一样

​		**异步同步针对调用者**，调用者发送请求，如果等着对方回应后才去做其他事情就是同步，如果发送请求之后不等着对方回应就去做其他事情就是异步

​		**阻塞和非阻塞针对被调用者**，被调用者受到求情后，做完请求才给出返回就是阻塞，收到请求就马上给出反馈然后去做其他事情就是非阻塞。

​	Webflux特点;

​	异步非阻塞：有限的资源下，提高系统吞吐量和伸缩性，以Reactor为基础实现响应式编程

​	函数式编程：Spring5基于java8，Webflux使用java8编程方式实现路由请求。



比较SpringMVC

![image-20210824202301131](D:\springboot_practice\spring5\images\image-20210824202301131.png)

两个框架都可以使用注解方式，都运行在tomcat容器中

SpringMVC采用命令式编程WebFlux采用异步响应式编程



2、响应式编程

响应式编程:响应式编程是一种面向数据流和变化传播的编程范式。这意味着可以在编程语言中很方便的表达静态或动态的数据流，而相关的计算模型会自动将变化的值通过数据流进行传播。



java8及其之前版本

提供的观察者模式的两个类Observe和Observable



响应式编程（Reactor实现）

1）响应式编程中，Reactor是满足Reactive规范框架

2）Reactor有两个核心类，Mono和Flux，这两个类实现接口Publisher

3）Flux对象实现发布者，返回N个元素；Mono实现发布者，返回0或者一个元素。

flux和moni都是数据流的发送者，他们可以发送三种数据信号

元素值，错误信号，完成信号，，终止信号用于告诉订阅者数据流结束啦。从无信号种植数据同时把粗无信息传给订阅者。

4）代码演示

​	引入依赖

​	编译代码（发送信号）



5）三种信号特点

​	错误信号和完成信号都是终止信号，不能共存的。

​	如果没有发送任何元素值，而是直接发送错误或完成信号，表示空数据流

​	如果没有错误信号，没有万册灰姑娘信号，表示无线数据流。



6）调用just或者其他方法知识声明数据流，数据流并没有发出，只有订阅后才会发数据流，不订阅什么也不会发生。



7）操作符

​		对数据流进行一道道操作，成为操作符，比如工厂流水线。

map 元素映射为新元素

flatmap元素映射为流：把每个元素转换流，把转换之后多个流合并大的流



3、SpringWebFlux执行流程和核心API

SpringWebflux基于reactor，默认容器时Netty,Netty时高性能，NIO异步非阻塞框架，一部非则色的框架。

​	1）Netty

​	2）SPringWebFlux执行过程和SpringMVC相似

*SpringWebflux核心控制器：DisPatchHandler，实现接口WebHandler

3）SpringWebflux里面dispathcerHandler，负责请求的处理

HandlerMapping： 请求查询到处理的方法

HanddlerAdapter：真正负责请求处理

HandlerResulthandler：响应处理结果

4）SopingWeblux实现函数式编程，两个接口：ROuterFUnction（路由处理）和HandlerFUnction（喊出处理）



4、基于注解编程模型

SpringWebflux实现方式有两种：；注解编程模型方式和函数式编程模型

使用注解编程模型方式和之前SpringMVC使用相似的，只要把相关以来配置到项目中soringBoot自动配置相关运行容器，默认情况加使用Netty服务器。



第一步：创建SPringBoot，引入Webflux依赖

第二部：配置启动的端口号

第三步：创建接口定义操作的方法

第四步：创建controller



SpringMVC方式实现，同步阻塞的方式，基于SpringMVC+Servlet+Tomcat

SpringWebflux方式实现，异步非阻塞的方式，基于SpringWebFlux+Reactor+Netty



5、基于函数时编程模型

1）在使用函数时编程模型时候，需要自己初始化服务器

2）基于函数时编程模型时候，有两个核心接口：RouterFUnction（实现路由功能，请i去转法给对应的handler）和HandlerFUnction（处理请求生成响应的函数）。核心任务定义两个函数式接口的实现且启动所需要的服务器。

3）SpringWebflux请求和响应不再是ServeletRequest和ServletResponse，而是ServerRequest和ServerResponse

第一步 把注解编程模型工程复制

第二步 创建Handler（具体实现方法）

第三步初始化服务器，编写Router

![image-20210827162445781](D:\springboot_practice\spring5\images\image-20210827162445781.png)

创建服务器完成适配

最终调用



4）使用WebClient调用



# 总结

1、Spring框架概述

​	1）轻量级开源javaEE框架，为了解决企业开发复杂性，两个核心组成：IOC和AOP

​	2）基于Spring5.2.6版本

2、IOC容器

​	1）IOC底层原理（工厂、反射等）

​	2）IOC接口（BeanFactory）

​	3）IOC操作Bean管理（基于xml）

​	4）IOC操作Bean管理（基于注解）

3、AOP

​	1）底层原理:动态代理，有接口（JDK动态代理），没有接口（CGLIB动天地阿里）

​	2）术语：切入点、增强（通知）、切面

​	3）基于AspectJ实现Aop操作

4、JdbcTemplate

​	1）使用其实现对数据库crud操作

​	2）实现批量操作

5、事务管理

​	1）事务概念

​	2)重要概念（创博行为和隔离级别）

​	3）基于注解实现声明式事务管理

6、Spring5新特性

​	1）整合日记框架

​	2）@Nullable注解

​	3）函数式注解对象

​	4）整合junit5单元测试框架

​	5）SpringWebflux使用

















