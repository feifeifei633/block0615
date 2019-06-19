package io.llf.demo.java;

public class Test {
    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("a");
        StringBuffer b = new StringBuffer("b");
        method(a,b);
        System.out.println("a:"+a+"  , b:"+b);// b: bb

    }
    private static void method(StringBuffer a,StringBuffer b){
        b.append("b");
        b = a;//b = "a";
        System.out.println("method里B的值是:"+b);//b : a
    }
}
