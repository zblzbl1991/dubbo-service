package com.zbl.dubbo.service.impl;

import com.alibaba.cloud.dubbo.service.DubboMetadataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zbl.dubbo.service.EchoService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: EchoServiceImpl
 * Description: <br/>
 * date: 2021/7/27 10:30
 *
 * @author 赵宝龙
 * @since JDK 1.8
 */
@Service
@DubboService
public class EchoServiceImpl implements EchoService {
    @Autowired
    private DubboMetadataService dubboMetadataService;
    @Override
    public String hello(String a)   {
        List<String> lists =new ArrayList<>();
        String serviceRestMetadata = dubboMetadataService.getServiceRestMetadata();

        ObjectMapper objectMapper = new ObjectMapper();
        lists.add(serviceRestMetadata);
        Map<String, String> allExportedURLs = dubboMetadataService.getAllExportedURLs();
        try {
            lists.add(objectMapper.writeValueAsString(allExportedURLs));
            Set<String> allServiceKeys = dubboMetadataService.getAllServiceKeys();
            lists.add(objectMapper.writeValueAsString(allServiceKeys));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            return objectMapper.writeValueAsString(lists);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void hello(int b) {

    }
}
