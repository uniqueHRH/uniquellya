package com.unique.app.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigInteger;

@Getter
@Setter
@ToString
public class MailDTO {
    private BigInteger  seq;
    private String      subject;
    private String      content;
    private String      email;
    private String      sender;
}
