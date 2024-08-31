package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.w3c.dom.Text;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
public class BoardFileDto {

    private UUID fileUuid;
    private Long boardId;
    private String name;
    private String mimeType;
    private Timestamp regDate;
    private String regIp;
    private String regMember;

}


