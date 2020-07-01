package com.hwadee.ssm.mappers;

import com.hwadee.ssm.entity.Logs;
import com.hwadee.ssm.entity.WorkOvertime;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LogsMapper {
    int insert(Logs record);
    List<Logs> getApplys(String userId, @Param("pageNum") int pageNum,@Param("pageCount") int pageCount);
    WorkOvertime getNeedWork(String workDay);
}