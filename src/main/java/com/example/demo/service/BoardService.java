package com.example.demo.service;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.BoardFileDto;
import com.example.demo.mapper.BoardMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;


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
    public List<Map> printdetail(Long id) {
        List<Map> detail = boardMapper.printdetail(id);
        return detail;
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


    @Transactional
    public String register(String title, String content, List<MultipartFile> files) throws IOException {
        Timestamp regDate = new Timestamp(System.currentTimeMillis());
        BoardDto boardDto = new BoardDto();
        String clientIp = request.getLocalAddr();

        boardDto.setTitle(title);
        boardDto.setContent(content);
        boardDto.setRegDate(new Timestamp(System.currentTimeMillis()));
        boardDto.setRegIp(clientIp);
        boardDto.setRegMember("anonymous");
        boardMapper.registerBoard(boardDto);
        for (MultipartFile file : files) {
            BoardFileDto boardFileDto = new BoardFileDto();
            boardFileDto.setBoardId(boardDto.getId());
            boardFileDto.setName(file.getOriginalFilename());
            boardFileDto.setMimeType(file.getContentType());
            boardFileDto.setRegDate(new Timestamp(System.currentTimeMillis()));
            boardFileDto.setRegIp(clientIp);
            boardFileDto.setRegMember("anonymous");
            boardMapper.registerFiles(boardFileDto);

            String pjPath = System.getProperty("user.dir");
            System.out.println("user.dir:>??"+pjPath);
            UUID uuid = UUID.randomUUID();
            File saveFile = new File((pjPath+"\\src\\main\\resources\\uploads"+file.getOriginalFilename())+uuid);
            file.transferTo(saveFile);
        }
        return "redirect:/";
    }
}


//@Transactional
//public void registerBoard(String title, String content) throws IOException {
//    Timestamp regDate = new Timestamp(System.currentTimeMillis());
//    String clientIp = request.getLocalAddr();
//    BoardDto boardDto = new BoardDto();
//
//    boardDto.setTitle(title);
//    boardDto.setContent(content);
//    boardDto.setRegDate(regDate);
//    boardDto.setRegIp(clientIp);
//    boardDto.setRegMember("anonymous");
//    boardMapper.registerBoard(boardDto);
//}



//        Timestamp regDate = new Timestamp(System.currentTimeMillis());
//        boardDto.setRegDate(regDate);

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

