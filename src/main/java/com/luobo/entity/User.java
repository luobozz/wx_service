package com.luobo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private long id;
  private String username;
  private String email;
  private String passwordHash;
  private String avatar;

}
