package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@ToString
public class DetailViewPageDto {

    private Long id;
    private String title;
    private String content;
    private Long commentId;
    private String comment;
    private Long commentParentId;
    private Timestamp commentRegDate;
    private String member;

    private String commentRegIp;
    private Timestamp commentModDate;
    private String commentModIp;
    private String commentMember;

    @Setter
    @Getter
    private List<Map<String,String>> comments = new ArrayList<>();

}