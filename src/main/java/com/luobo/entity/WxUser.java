package com.luobo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class WxUser {

  private Integer id;
  private Integer mainUserId;
  private String openid;
  private String wxNickName;
  private Integer channelId;
  private Integer qridNow;
  private Integer qridFrist;
  private Date subscribe;
  private Date unsubscribe;
  private Integer subscribeState;
  private Integer agentsidCurrent;
  private String memo;
  private Integer bindAid;
  private String userNo;
  private String headimgurl;
  private Integer bindStaff;
  private Integer isSubscribe;

//这里是为了方便mapper的sql编写
//id,mainUserId,openid,wxNickName,channelId,qridNow,qridFrist,subscribe,unsubscribe,subscribeState,agentsidCurrent,memo,bindAid,userNo,headimgurl,bindStaff,isSubscribe,
//#{id},#{mainUserId},#{openid},#{wxNickName},#{channelId},#{qridNow},#{qridFrist},#{subscribe},#{unsubscribe},#{subscribeState},#{agentsidCurrent},#{memo},#{bindAid},#{userNo},#{headimgurl},#{bindStaff},#{isSubscribe},
}
