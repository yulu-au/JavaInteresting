package com.exampleproxy.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy {
    /*
    功能: 动态代理的实现 动态代理其实就是代理对象调用目标对象的同名方法,并在调用前后加增强代码
    参数 : 目标对象
    返回值: 代理对象
     */
    public static Object GetProxy(final Object obj) throws Exception {
        //通过接口拿到代理类的信息
        Class proxyClazz = java.lang.reflect.Proxy.getProxyClass(obj.getClass().getClassLoader(), obj.getClass().getInterfaces());
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        //构造代理类的对象
        Object proxy = constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("there can be replace ");
                Object result = method.invoke(obj, args);
                System.out.println("there can be replace ");
                return result;
            }
        });
        return proxy;
    }
}
