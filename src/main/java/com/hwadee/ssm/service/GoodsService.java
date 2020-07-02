package com.hwadee.ssm.service;

import com.hwadee.ssm.entity.Goods;
import com.hwadee.ssm.mappers.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsService {
    @Resource
    private GoodsMapper goodsMapper = null;
    @Autowired
    private GoodsMapper name1;
    public Goods login(String phone, String pwd, int role)
    {
        System.out.println("服务层"+phone);
         Goods login=name1.login(phone,pwd,role);
        //System.out.println("服务层"+login.get(0).getUsername());
        return login;
    }
}