package com.hwadee.ssm.controller;

import com.hwadee.ssm.entity.Goods;
import com.hwadee.ssm.entity.Logs;
import com.hwadee.ssm.entity.WorkOvertime;
import com.hwadee.ssm.service.LogsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/logs")
@Api(value = "组员controller",tags = {"组员操作接口"})
public class LogsController {
    @Resource
    private LogsServiceImpl logsService = null;

    @PostMapping(value = "/applys")
    @ResponseBody
    public int applyWorkOvertime(HttpSession session) throws ParseException {
        Goods goods = (Goods) session.getAttribute("goods");
        String userId = goods.getPhone();
        java.util.Date nowdate = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(nowdate);
        Logs logs = new Logs();
        logs.setLogUserId(userId);
        logs.setLogDate(date);
        logs.setLogState(0);
        return logsService.postApplys(logs);
    }

    @GetMapping(value = "/applys")
    @ResponseBody
    public Map getApplys(HttpSession session) {
        int state = -2;
        Goods goods = (Goods) session.getAttribute("goods");
        String userId = goods.getPhone();
        java.util.Date nowdate = new java.util.Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = simpleDateFormat.format(nowdate);
        WorkOvertime workOvertime = logsService.getNeedWork(date);
        if (workOvertime!=null){
            state = logsService.getApplyState(userId,date);
        }
        List<Logs> logs = logsService.getApplys(userId);
        Map map = new HashMap();
        map.put("workOverTime",workOvertime);
        map.put("logs",logs);
        map.put("state",state);
        return map;
    }

    @GetMapping(value = "/workday")
    @ApiImplicitParam(name = "workDay",value = "想查询的日期(例：2020-07-01)",dataType = "String",paramType = "query")
    @ResponseBody
    public WorkOvertime getNeedWork(String workDay) throws ParseException {
        return logsService.getNeedWork(workDay);}

}