package com.hwadee.ssm.mappers;

import com.hwadee.ssm.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GoodsMapper {
    //方法名与Mapper中的方法名对应
   public   Goods  login(@Param("phone") String phone,@Param("pwd") String pwd,@Param("role") int  role);
}
