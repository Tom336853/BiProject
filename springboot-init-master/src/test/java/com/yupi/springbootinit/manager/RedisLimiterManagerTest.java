package com.yupi.springbootinit.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RedisLimiterManagerTest {

    @Resource
    private RedisLimiterManager redisLimiterManager;
    @Test
    void doRateLimit() {
        String userid = "1";
        for (int i = 0; i < 2; i++) {
            redisLimiterManager.doRateLimit(userid);
            System.out.println("成功");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            redisLimiterManager.doRateLimit(userid);
            System.out.println("成功");
        }
    }
}