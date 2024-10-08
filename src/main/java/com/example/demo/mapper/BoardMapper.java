package com.example.demo.mapper;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.BoardFileDto;
import com.example.demo.dto.DetailViewPageDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
//import com.example.demo.dto.BoardCommentDto;
//import org.apache.ibatis.annotations.ResultMap;
//import org.springframework.web.multipart.MultipartFile;

//import java.util.ArrayList;
//
// import java.util.Map;

@Mapper
public interface BoardMapper {


    List<BoardDto> printBoardList();

    BoardDto printBoardById(Long id);

   // List<BoardCommentDto> printcomment(Long id);

//    @ResultMap("BoardCommentResultMap")
    List<Map> printdetail(Long id);

    void register(String title, String content, List<MultipartFile> files);
//    void registerBoard(String title, String content);
    void registerBoard(BoardDto boardDto);

//    void registerFiles(List<MultipartFile> files);
    void registerFiles(BoardFileDto boardFileDto);

    void updtBoard(BoardDto boardDto);

    void delBoard(Long id);

}
