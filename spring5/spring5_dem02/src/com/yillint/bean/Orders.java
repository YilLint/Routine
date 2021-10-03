package com.yillint.bean;

public class Orders {

    public Orders() {
        System.out.println("第一步，无参数的构造创建bean实例");
    }

    private String oname;
    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步，调用set方法，设置属性值");
    }

    //创建执行初始化的方法
    public void initMethod(){
        System.out.println("第三步，创建执行初始化方法");
    }

    //创建执行销毁的方法
    public void destroyMethod(){
        System.out.println("第五步，创建执行销毁方法");
    }

}
