package com.hwadee.ssm.service;

import com.hwadee.ssm.entity.WorkOvertime;
import net.sf.json.JSONObject;

import java.util.List;

public interface WorkOvertimeService {
    WorkOvertime getData(String time);
    int postData(WorkOvertime workOvertime);
    int putData(WorkOvertime workOvertime);
    List<JSONObject> getDataUsers(String time);
}
