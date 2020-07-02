package com.hwadee.ssm.service;

import com.hwadee.ssm.entity.Logs;
import com.hwadee.ssm.entity.WorkOvertime;
import com.hwadee.ssm.mappers.LogsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

@Service
public class LogsServiceImpl {
    @Resource
    private LogsMapper logsMapper = null;
    public int postApplys(Logs logs) {
        return logsMapper.insert(logs);
    }
    public List<Logs> getApplys(String userId) {
       return logsMapper.getApplys(userId);
    }
    public WorkOvertime getNeedWork(String workDay) {
        return logsMapper.getNeedWork(workDay);
    }
    public int getApplyState(String userId, String workDay) { return logsMapper.getApplyState(userId,workDay);}
}
