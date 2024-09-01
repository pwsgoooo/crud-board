package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.w3c.dom.Text;

import java.sql.Timestamp;

//@Data
// dto의 필드명 - input의 name
@Getter
@Setter
@ToString
public class BoardDto{

    private Long id;
//기본생성자
    public BoardDto(){   
    }
    private String title;
    private String content;
    private Timestamp regDate;
    private Timestamp reg_date;
    private String regIp;
    private String regMember;
    private Timestamp modDate;
    private String modIp;
    private String modMember;
    private Timestamp delDate;
    private String delIp;
    private String delMember;
}
