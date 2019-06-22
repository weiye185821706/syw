package com.syw.baobao.demo.controller;

import com.syw.baobao.demo.entiy.Result;
import com.syw.baobao.demo.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value = "用来测试redis")
public class RedisController {
    @Autowired
    private RedisUtil redisUtil;

    @ResponseBody
    @ApiOperation(value = "存入值到缓存")
    @RequestMapping(value = "/setRedis", method = RequestMethod.POST)
    public Result setRedis() {
        boolean result = false;
        for (int i = 0; i < 8; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("name" + i, "mir叶" + i);
            map.put("address" + i, "重庆" + i);
            map.put("age" + i, 12 + i);
            result = redisUtil.setList("persion", map);
        }
        return Result.success(result);
    }

    @ResponseBody
    @ApiOperation(value = "取出redis缓存的list")
    @RequestMapping(value = "/getRedis", method = RequestMethod.POST)
    public Result getRedis() {
        return Result.success(redisUtil.getLists("persion", 0, -1));
    }

    @ResponseBody
    @ApiOperation(value = "清除redis缓存的list")
    @RequestMapping(value = "/removeRedis", method = RequestMethod.POST)
    public Result removeRedis() {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            map.put("name" + i, "mir叶" + i);
            map.put("address" + i, "重庆" + i);
            map.put("age" + i, 12 + i);
        }
        return Result.success(redisUtil.lRemove("persion", 10, map));
    }
}
