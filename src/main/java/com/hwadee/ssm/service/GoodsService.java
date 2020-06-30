package com.hwadee.ssm.service;

import com.github.pagehelper.PageHelper;
import com.hwadee.ssm.entity.Goods;
import com.hwadee.ssm.mappers.GoodsMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
public class GoodsService {
    @Resource
    private GoodsMapper goodsMapper = null;


}
