package com.hwadee.ssm.entity;


import java.io.Serializable;
import java.util.Date;

public class Logs implements Serializable {

  private int logId;
  private long logUserId;
  private int logState;
  private String logDate;
  private String logAward;


  public int getLogId() {
    return logId;
  }

  public void setLogId(int logId) {
    this.logId = logId;
  }


  public long getLogUserId() {
    return logUserId;
  }

  public void setLogUserId(long logUserId) {
    this.logUserId = logUserId;
  }


  public int getLogState() {
    return logState;
  }

  public void setLogState(int logState) {
    this.logState = logState;
  }


  public String getLogDate() {
    return logDate;
  }

  public void setLogDate(String logDate) {
    this.logDate = logDate;
  }


  public String getLogAward() {
    return logAward;
  }

  public void setLogAward(String logAward) {
    this.logAward = logAward;
  }

}
