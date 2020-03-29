package com.exampleproxy;

import com.exampleproxy.test.Apple;
import com.exampleproxy.test.Fruit;
import com.exampleproxy.proxy.DynamicProxy;

public class Main {
    public static void main(String[] args) throws Exception {
        //无代理的情况下
        Apple appleInstance = new Apple();
        appleInstance.canbejuice();
        System.out.println("-------------------------");
        //以目标对象换回一个代理对象
        Fruit appleProxy = (Fruit) DynamicProxy.GetProxy(appleInstance);
        //同样是调用canbejuice方法,代理对象多执行了一些代码
        appleProxy.canbejuice();
    }
}
