package com.hwadee.ssm.entity;


import java.io.Serializable;

public class Logs implements Serializable {

  private long logId;
  private long logUserId;
  private long logState;
  private java.sql.Date logDate;
  private String logAward;


  public long getLogId() {
    return logId;
  }

  public void setLogId(long logId) {
    this.logId = logId;
  }


  public long getLogUserId() {
    return logUserId;
  }

  public void setLogUserId(long logUserId) {
    this.logUserId = logUserId;
  }


  public long getLogState() {
    return logState;
  }

  public void setLogState(long logState) {
    this.logState = logState;
  }


  public java.sql.Date getLogDate() {
    return logDate;
  }

  public void setLogDate(java.sql.Date logDate) {
    this.logDate = logDate;
  }


  public String getLogAward() {
    return logAward;
  }

  public void setLogAward(String logAward) {
    this.logAward = logAward;
  }

}
