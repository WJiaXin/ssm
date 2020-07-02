package com.hwadee.ssm.controller;

import com.hwadee.ssm.entity.*;
import com.hwadee.ssm.mappers.GoodsMapper;
import com.hwadee.ssm.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.io.File;
import java.util.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@Api("")
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    GoodsService goodsService = null;
    @Resource
    private GoodsMapper goodsMapper = null;
    private int pc;
    private String bmtime;
    private int zt;
    @Autowired
    GoodsService ServiceLogin;
  //  private int zt2;
    private int zg;
    @ApiOperation("登录功能")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Goods login(@RequestBody(required=true) Map<String,Object> map, HttpServletRequest request) throws Exception{
        String a="请求成功";
        System.out.println("请求成功");
        /*String username = map.get("username").toString();
        String password = map.get("password").toString();
        System.out.println("username: " + username);
        System.out.println("password: " + password);*/

        String username = map.get("username").toString();
        String password = map.get("password").toString();
        String st = map.get("st").toString();
        int role;
        role=Integer.parseInt(st);
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("st: " + st);
         Goods  goodsList=ServiceLogin.login(username,password,role);
       //System.out.println("控制层" +goodsList.get(0).getUsername());
         request.getSession().setAttribute("goods",goodsList);
        try
        {
            if(goodsList.getUsername()!=null&&goodsList.getUsername()!="")
            {
                return goodsList;
            }
        }
        catch(Exception e)
        {
          return null;
        }
        return goodsList;

//zt2=goods.getBMZT();
    }
    @ApiOperation("登录判断")
    @RequestMapping(value = "/checklogin", method = RequestMethod.POST)
    public boolean checklogin(HttpServletRequest request)
    {
      Goods goods= (Goods) request.getSession().getAttribute("goods");
      if(goods==null)
      { return false; }
      else return true;
    }
}