package com.example.demo.controller;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.DetailViewPageDto;
import com.example.demo.mapper.BoardMapper;
import com.example.demo.service.BoardService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        System.out.println(list);

        return "board";
    }

    @GetMapping("/detailviewbyid/{id}")
    public String viewrow(@PathVariable("id") Long id, Model model) throws IOException{
        try{
            List<DetailViewPageDto> detail = boardService.printdetail(id);
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
            List<DetailViewPageDto> detail = boardService.printdetail(id);
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



    @GetMapping("/insert")
    public String insert(){
        return "insert";
    }


    @GetMapping("/delboard/{id}")
    public String doDelete(@RequestParam("id") Long id, Model model) throws IOException{
        try{
            boardService.delBoard(id);
            return "board";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public String register(@RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("files") List<MultipartFile> files) throws IOException {
    @PostMapping("/register")
    public String register(@RequestParam("title") String title, @RequestParam("content") String content) throws IOException {
        boardService.registerBoard(title, content);
//        boardService.registerFiles(files);

        return "redirect:/";
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
//    @PostMapping("/uptodb")
//    public String doCoffeePost(HttpServletRequest request, Model model){
//
////        Integer id = request.getParameter("id");
//        String title  = request.getParameter("title");
//        String content  = request.getParameter("content");
//        log.info(title);
//
//        /* 전체리스트 조회 - 오버로딩 */
//        List<<BoardDto> list = boardService.printBoardList();
//
//        model.addAttribute("list", list);
//        // System.out.println(list);
//
//        return "test2";
//    }
//
//    /* 등록하기 Get */
//    @GetMapping("/register")
//    public String doInsert(){
//        return "insert";
//    }
//
//    /* 등록하기 Post , HttpServletRequest 사용 */
//    @PostMapping("/insert")
//    public String doInsertPost(@RequestParam(value="title") String title,
//                               @RequestParam(value="content") Text content,
//                               Model model){
//        log.info(title + content);
//        int intI = boardService.regisBoard(title, content);
//
//        return "redirect:/";
//    }
//
//    /* 수정하기 Post , @RequestParam 사용 */
//    @PostMapping("/update")
//    public String doUpdatePost(
//            @RequestParam(value="id") Integer id,
//            @RequestParam(value="title") String title,
//            @RequestParam(value="content") Text content
//    ){
//
//        int intI  = boardService.updtBoard(id, title, content);
//
//        return "redirect:/";
//    }
//
