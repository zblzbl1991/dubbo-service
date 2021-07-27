package com.zbl.controller;

import com.alibaba.cloud.dubbo.service.DubboMetadataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zbl.dubbo.service.EchoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: EchoController
 * Description: <br/>
 * date: 2021/7/27 11:38
 *
 * @author 赵宝龙
 * @since JDK 1.8
 */
@RestController
public class EchoController {
    @DubboReference
    private EchoService echoService;
    @Autowired
    private DubboMetadataService dubboMetadataService;

    @GetMapping("/echo")
    public String echo() throws JsonProcessingException {

        String hello = echoService.hello("a");
        return hello;
    }
}
