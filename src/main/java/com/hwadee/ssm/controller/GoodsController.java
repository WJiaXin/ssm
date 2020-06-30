package com.hwadee.ssm.controller;

import com.hwadee.ssm.entity.*;
import com.hwadee.ssm.mappers.GoodsMapper;
import com.hwadee.ssm.service.GoodsService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

@RestController
@RequestMapping("/goods")
@Api(value = "用户接口")
public class GoodsController {
    @Resource
    GoodsService goodsService = null;
    @Resource
    private GoodsMapper goodsMapper = null;
    private int pc;
    private String bmtime;
    private int zt;
  //  private int zt2;
    private int zg;
    @RequestMapping("/getPC")
    public void getPC() {

//zt2=goods.getBMZT();
    }

}