package com.hwadee.ssm.mappers;

import com.hwadee.ssm.entity.WorkOvertime;
import org.apache.ibatis.annotations.Mapper;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WorkOvertimeDao {
    WorkOvertime getData(String time);
    int postData(WorkOvertime workOvertime);
    int putData(WorkOvertime workOvertime);
    List<JSONObject> getDataUsers(String time);
}
