package com.yillint.admin;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


/*@RunWith*/

/**
 * @BootstrapWith(SpringBootTestContextBootstrapper.class)
 * @ExtendWith(SpringExtension.class)
 */

@SpringBootTest
@DisplayName("junit5功能测试类")
public class Junit5Test {

    @Autowired
    JdbcTemplate jdbcTemplate;


    /**
     * 测试前置条件
     */
    @DisplayName("测试前置条件")
    @Test
    void testassuptions(){
        Assumptions.assumeTrue(false,"结果不是true");
        System.out.println("11111");
    }

    /**
     * 断言：前面的断言失败，后面的代码都不会执行
     */
    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions(){
        int cal = cal(3, 2);
        //相等
        assertEquals(6,cal,"业务逻辑计算失败");

        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1,obj2,"两个对象不一样");
    }

    @Test
    @DisplayName("array assertion")
    void array() {
        assertArrayEquals(new int[]{1, 2}, new int[] {1, 2});
    }

    int cal(int i,int j){
        return i+j;
    }


    /**
     * 所有断言需要成功
     */
    @Test
    @DisplayName("组合断言")
    void all() {
        assertAll("test",
                ()-> assertTrue(true && true,"结果不为true"),
                ()-> assertEquals(1,2,"结果不为1"));
        System.out.println("======");
    }

    @DisplayName("测试DisplayName注解")
    @Test
    void testException(){

        //断定业务逻辑一定出异常
        assertThrows(ArithmeticException.class,() -> {
            int i = 10 / 2;
        },"业务逻辑居然正常运行了？");
    }

    @Test
    @DisplayName("超时测试")
    public void timeoutTest() {
        //如果测试方法时间超过1s将会异常
        Assertions.assertTimeout(Duration.ofMillis(1000), () -> Thread.sleep(500));
    }

    @DisplayName("快速失败")
    @Test
    void testFail(){
        //xxxxx

        if(1 == 2) {
            fail("快速失败");
        }
    }

    @DisplayName("测试DisplayName注解")
    @Test
    void testDisplayName(){
        System.out.println(1);
        System.out.println(jdbcTemplate);
    }

    @Disabled
    @DisplayName("测试方法2")
    @Test
    void test2(){
        System.out.println(2);
    }

    @RepeatedTest(5)
    @Test
    void test3(){
        System.out.println(5);
    }

    /**
     * 规定方法超时时间。超出时间测试出异常
     * @throws InterruptedException
     */
    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(600);
    }

    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试就要开始了-----");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("测结束了-----");
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测就要开始了-----");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("所有测结束了-----");
    }

}
