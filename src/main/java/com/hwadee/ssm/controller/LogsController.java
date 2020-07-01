package com.hwadee.ssm.controller;

import com.hwadee.ssm.entity.Logs;
import com.hwadee.ssm.service.LogsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/logs")
@Api(value = "组员controller",tags = {"组员操作接口"})
public class LogsController {
        @Resource
        private LogsService logsService = null;

        @ApiOperation(value="组员申请",tags={"申请加班"})
        @PostMapping(value = "/applys")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "userId", value = "组员电话", dataType = "String"),
                @ApiImplicitParam(name = "overTime", value = "加班日期", dataType = "String", example = "2020-06-30"),
                @ApiImplicitParam(name = "award", value = "加班所得", dataType = "String", example = "套餐一")
        })
        @ResponseBody
        public int applyWorkOvertime(String userId,String overTime,String award) throws ParseException {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
                Date date = simpleDateFormat.parse(overTime);
                Logs logs = new Logs();
                logs.setLogUserid(userId);
                logs.setLogDate(date);
                logs.setLogAward(award);
                logs.setLogState(0);

                int status = logsService.postApplys(logs);
                return status;
        }

        @ApiOperation(value="获取组员申请记录",tags={"获取申请过的信息"})
        @GetMapping(value = "/applys")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "userId", value = "组员的手机号", dataType = "String"),
                @ApiImplicitParam(name = "pageNum", value = "页面页数", dataType = "Integer")
        })
        @ResponseBody
        public Map getApplys(String userId,int pageNum) {
                List<Logs> logs = logsService.getApplys(userId,pageNum,10);
                Map<String,List<Logs>> map = new HashMap<>();
                map.put("applyList",logs);
                return map;
        }

}
