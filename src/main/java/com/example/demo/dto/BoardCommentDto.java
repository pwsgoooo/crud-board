package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.w3c.dom.Text;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class BoardCommentDto {
    private Long id;
    private String title;
    private String content;
    private Timestamp regDate;
    private String regIp;
    private String regMember;
    private Timestamp modDate;
    private String modIp;
    private String modMember;
    private Timestamp delDate;
    private String delIp;
}
