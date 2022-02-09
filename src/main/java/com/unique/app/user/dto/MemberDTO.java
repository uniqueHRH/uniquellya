package com.unique.app.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@Setter
@ToString
public class MemberDTO {
    private BigInteger seq;
    private String      id;
    private String      pw;
    private String      name;
    private String      role;
    private String      reg_dt;
    private String      leave_dt;
}
