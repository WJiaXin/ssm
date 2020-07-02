package com.hwadee.ssm.controller;

import com.hwadee.ssm.entity.Logs;
import com.hwadee.ssm.entity.WorkOvertime;
import com.hwadee.ssm.service.LogsServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
@Controller
@RequestMapping("/logs")
@Api(value = "组员controller",tags = {"组员操作接口"})
public class LogsController {
    @Resource
    private LogsServiceImpl logsService = null;

    @ApiOperation(value="组员申请",tags={"申请加班"})
    @PostMapping(value = "/applys")
    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "组员电话", dataType = "long",paramType = "query"),
            @ApiImplicitParam(name = "overTime", value = "加班日期", dataType = "String", example = "2020-06-30",paramType = "query"),
            @ApiImplicitParam(name = "award", value = "加班所得", dataType = "String", example = "套餐一",paramType = "query")})
    @ResponseBody
    public int applyWorkOvertime(long userId,String overTime,String award) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        java.sql.Date date = new java.sql.Date(simpleDateFormat.parse(overTime).getTime());
        Logs logs = new Logs();
        logs.setLogUserId(userId);
        logs.setLogDate(date);
        logs.setLogAward(award);
        logs.setLogState(0);
        return logsService.postApplys(logs);
    }

    @ApiOperation(value="获取组员申请记录",tags={"获取申请过的信息"})
    @GetMapping(value = "/applys")
    @ApiImplicitParams({@ApiImplicitParam(name = "userId", value = "组员的手机号", dataType = "String",paramType = "query"),
            @ApiImplicitParam(name = "pageNum", value = "页面页数", dataType = "Integer",paramType = "query")})
    @ResponseBody
    public List<Logs> getApplys(String userId, Integer pageNum) {
        return logsService.getApplys(userId,pageNum,10);
    }

    @ApiOperation(value="获取某一天是否有加班",tags={"获取是否有加班"})
    @GetMapping(value = "/workday")
    @ApiImplicitParam(name = "workDay", value = "选择的日期", dataType = "String",paramType = "query")
    @ResponseBody
    public WorkOvertime getNeedWork(String workDay) {
        return logsService.getNeedWork(workDay);
    }

}