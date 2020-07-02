package com.hwadee.ssm.entity;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

@ApiModel(value="workOvertime对象")
public class WorkOvertime implements Serializable {

  private Date data;
  private String award;
  private int type;


  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }


  public String getAward() {
    return award;
  }

  public void setAward(String award) {
    this.award = award;
  }


  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }

}
