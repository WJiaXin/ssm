package com.hwadee.ssm.service;

import com.hwadee.ssm.entity.Logs;
import com.hwadee.ssm.entity.WorkOvertime;
import com.hwadee.ssm.mappers.WorkOvertimeDao;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkOvertimeServiceimpl implements WorkOvertimeService{
    @Autowired
    WorkOvertimeDao workOvertimeDao;

    @Override
    public WorkOvertime getData(String time){
        return workOvertimeDao.getData(time);
    }
    @Override
    public int postData(WorkOvertime workOvertime){
        return workOvertimeDao.postData(workOvertime);
    }
    @Override
    public int putData(WorkOvertime workOvertime){
        return workOvertimeDao.putData(workOvertime);
    }
    @Override
    public List<JSONObject> getDataUsers(String time){
        return workOvertimeDao.getDataUsers(time);
    }
    @Override
    public List<JSONObject> getDataLogs(String time){
        return workOvertimeDao.getDataLogs(time);
    }
    @Override
    public int putLogs(Integer logId,Integer state){
        return workOvertimeDao.putLogs(logId,state);
    }
}
