package com.example.demo.service;

import com.example.demo.dto.BoardCommentDto;
import com.example.demo.dto.BoardDto;
import com.example.demo.dto.BoardFileDto;
import com.example.demo.dto.DetailViewPageDto;
import com.example.demo.mapper.BoardMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.CDATASection;
//import org.w3c.dom.Text;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BoardService {

    private final BoardMapper boardMapper;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<BoardDto> printBoardList() {
        List<BoardDto> list;
        list = boardMapper.printBoardList();
        return list;
    }

    @Transactional
    public BoardDto printBoardById(Long id) {
        BoardDto row = boardMapper.printBoardById(id);
        return row;

    }

    @Transactional
    public List<DetailViewPageDto> printdetail(Long id) {
        List<DetailViewPageDto> detail = boardMapper.printdetail(id);
        return detail;
    }

    @Transactional
    public void registerBoard(String title, String content) throws IOException {
        Timestamp regDate = new Timestamp(System.currentTimeMillis());
        String clientIp = request.getLocalAddr();
        String regMember = "anonymous"; //session cookie에서 로긴 유저 가져오기
        BoardDto boardDto = new BoardDto();

        boardDto.setTitle(title);
        boardDto.setContent(content);
        boardDto.setRegDate(regDate);
        boardDto.setRegIp(clientIp);
        boardDto.setRegDate(regDate);
        boardDto.setRegMember(regMember);
        boardMapper.registerBoard(boardDto);
    }

    @Transactional
    public void registerFiles(List<MultipartFile> files) throws IOException {
        Timestamp regDate = new Timestamp(System.currentTimeMillis());
        String clientIp = request.getLocalAddr();
        String regMember = "anonymous"; //session cookie에서 로긴 유저 가져오기
        BoardFileDto boardFileDto = new BoardFileDto();
        Long id = (long) boardMapper.printBoardList().size();
        for (MultipartFile file : files) {
            boardFileDto.setBoardId(id);
            boardFileDto.setMimeType(file.getContentType());
            boardFileDto.setRegDate(regDate);
            boardFileDto.setName(file.getOriginalFilename());
            boardFileDto.setRegMember(regMember);
            boardFileDto.setRegIp(clientIp);
            boardMapper.registerFiles(boardFileDto);
        }
    }

    @Transactional
    public void updtBoard(Long id, String title, String content) throws IOException {

        BoardDto updtBoard = boardMapper.printBoardById(id);
        Timestamp modDate = new Timestamp(System.currentTimeMillis());
        String clientIp = request.getLocalAddr();
        String modMember = "anonymous"; //session cookie에서 로긴 유저 가져오기

        updtBoard.setTitle(title);
        updtBoard.setContent(content);
        updtBoard.setModIp(clientIp);
        updtBoard.setModDate(modDate);
        updtBoard.setModMember(modMember);
        boardMapper.updtBoard(updtBoard);
    }

    @Transactional
    public void delBoard(Long id) {
        boardMapper.delBoard(id);
    }

}
//    /* 데이타 입력 */
//    public int regisBoard(String title, Text content) {
//        int intI = BoardDto.boardMapper(title, content);
//        return intI;
//    }
//
//
//    /* 수정하기 Post */
//    public int updtBoard(Integer id, String title, Text content) {
//        int intI = BoardDto.updtBoard(id, title, content);
//        return  intI;
//    }
//

