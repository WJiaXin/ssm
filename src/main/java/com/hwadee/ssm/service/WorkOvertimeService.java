package com.hwadee.ssm.service;

import com.hwadee.ssm.entity.Logs;
import com.hwadee.ssm.entity.WorkOvertime;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

public interface WorkOvertimeService {
    WorkOvertime getData(String time);
    int postData(WorkOvertime workOvertime);
    int putData(WorkOvertime workOvertime);
    JSONArray getDataUsers(String time, int page);
    JSONArray getDataLogs(String startTime,String endTime,int page);
    int putLogs(Integer logId,Integer state);
}
