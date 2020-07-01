package com.hwadee.ssm.service;

import com.hwadee.ssm.entity.Logs;
import com.hwadee.ssm.entity.WorkOvertime;
import net.sf.json.JSONObject;

import java.util.List;

public interface LogsService {
    int postApplys(Logs logs);
    List<Logs> getApplys(String userId, int pageNum,int pageCount);
    WorkOvertime getNeedWork(String workDay);
}
