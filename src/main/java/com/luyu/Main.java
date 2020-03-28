package com.luyu;

import com.luyu.test.Apple;
import com.luyu.test.Fruit;
import com.luyu.proxy.DynamicProxy;

public class Main {
    public static void main(String[] args) throws Exception {
        //无代理的情况下
        Apple appleInstance = new Apple();
        appleInstance.canbejuice();
        System.out.println("-------------------------");
        //以目标对象换回一个代理对象
        Fruit appleProxy = (Fruit) DynamicProxy.GetProxy(appleInstance);
        appleProxy.canbejuice();
    }
}
