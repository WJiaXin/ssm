package com.hwadee.ssm.service;

import com.hwadee.ssm.entity.Logs;
import com.hwadee.ssm.entity.WorkOvertime;
import com.hwadee.ssm.mappers.LogsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LogsServiceImpl {
    @Resource
    private LogsMapper logsMapper = null;
    public int postApplys(Logs logs) {
        return logsMapper.insert(logs);
    }
    public List<Logs> getApplys(String userId, int pageNum, int pageCount) {
       return logsMapper.getApplys(userId,pageNum,pageCount);
    }
    public WorkOvertime getNeedWork(String workDay) {
        return logsMapper.getNeedWork(workDay);
    }
}
