package com.example.demo.controller;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.BoardFileDto;
import com.example.demo.dto.DetailViewPageDto;
import com.example.demo.mapper.BoardMapper;
import com.example.demo.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
@Log4j2
public class BoardController {

    private final BoardService boardService;
    private final BoardMapper boardMapper;

    @Autowired
    public BoardController(BoardService boardService, BoardMapper boardMapper){
        this.boardService = boardService;
        this.boardMapper = boardMapper;
    }

    @GetMapping("/")
    public String gethome(Model model){

        List<BoardDto> list = boardService.printBoardList();

        model.addAttribute("list", list);
//        System.out.println(list);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println("???????????????????????????????????tttime"+timestamp);

        return "board";
    }

    @GetMapping("/insert")
    public String insert(){
        return "insert";
    }

    @PostMapping("/register")
    public String register(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("files") List<MultipartFile> files, Model model) throws IOException {
        boardService.register(title, content, files);

        return "redirect:/";
    }

    @GetMapping("/detailviewbyid/{id}")
    public String viewrow(@PathVariable("id") Long id, Model model) throws IOException{
        try{
//            List<DetailViewPageDto> detail = boardService.printdetail(id);
            List<Map> detail = boardService.printdetail(id);
            model.addAttribute("detail", detail);

            System.out.println(detail);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
            return "detailviewbyid";
    }

    @GetMapping("/detailviewbyidupdate/{id}")
    public String toupdate(@PathVariable("id") Long id, Model model) throws IOException{
        try{
//            List<DetailViewPageDto> detail = boardService.printdetail(id);
            List<Map> detail = boardService.printdetail(id);
            return "detailviewbyidupdate";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/update/{id}")
    public String updtBoard(@PathVariable("id") Long id, @RequestParam("title") String title, @RequestParam("content") String content) throws IOException{
        try{
            boardService.updtBoard(id,title,content);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "/";
    }


    @GetMapping("/delboard/{id}")
    public String doDelete(@RequestParam("id") Long id, Model model) throws IOException{
        try{
            boardService.delBoard(id);
            return "redirect:/";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/test2")
    public String test2(Model model){
        List<BoardDto> list = boardService.printBoardList();
        model.addAttribute("list", list);
         System.out.println(list);
        return "test2";
    }


}

