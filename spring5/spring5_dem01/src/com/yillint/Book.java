package com.yillint;

/**
 * 演示使用set方法进行注入属性
 */
public class Book {

    //创建属性
    private String bname;
    private String bauthor;
    private String address;


    //创建属性对应的set方法
    //set注入属性
    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void testDemo(){
        System.out.println(bname + "::" + bauthor + "::" + address);
    }


/*    //有参构造注入
    public Book(String bname) {
        this.bname = bname;
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.setBname("abc");
    }*/


}
