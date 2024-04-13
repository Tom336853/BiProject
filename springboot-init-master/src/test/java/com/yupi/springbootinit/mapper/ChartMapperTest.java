package com.yupi.springbootinit.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChartMapperTest {

    @Resource
    private ChartMapper chartMapper;
    @Test
    void queryChartData() {
        String chartId = "1769273541895417858";
        String querySql = String.format("select * from chart_%s",chartId);
        System.out.println(querySql);
        List<Map<String,Object>> resultData = chartMapper.queryChartData(querySql);
        System.out.println(resultData);
    }
}