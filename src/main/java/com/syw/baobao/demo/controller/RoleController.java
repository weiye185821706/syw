package com.syw.baobao.demo.controller;

import com.syw.baobao.demo.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/role")
@Api(value = "角色相关")
public class RoleController {
    @Autowired
    private RedisUtil redisUtil;


    @ApiOperation(value = "新增角色操作")
    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    @ResponseBody
    public boolean addRole(@RequestParam(value = "name") String name,
                           @RequestParam(value = "menus") String menus) {
        return true;
    }

    @ApiOperation(value = "角色的跟新")
    @RequestMapping(value = "/updateRole", method = RequestMethod.POST)
    @ResponseBody
    public boolean updateRole(@RequestParam(value = "name") String name,
                              @RequestParam(value = "menus") String menus) {
        return true;
    }

    @ApiOperation(value = "角色的删除")
    @RequestMapping(value = "/deleteRole", method = RequestMethod.GET)
    @ResponseBody
    public boolean deleteRole(@RequestParam(value = "uuid") String uuid) {
        return true;
    }

    @ApiOperation(value = "角色的列表查询")
    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    @ResponseBody
    public String queryList(@RequestParam(value = "page") int page,
                             @RequestParam(value = "pageSize")int pageSize) {
        return redisUtil.get("token").toString();
    }
}
