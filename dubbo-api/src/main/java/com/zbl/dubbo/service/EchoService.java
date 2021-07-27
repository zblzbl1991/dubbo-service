package com.zbl.dubbo.service;

/**
 * ClassName: EchoService
 * Description: <br/>
 * date: 2021/7/27 10:26
 *
 * @author 赵宝龙
 * @since JDK 1.8
 */
public interface EchoService {
    String hello(String a)  ;

    void hello(int b);
}
