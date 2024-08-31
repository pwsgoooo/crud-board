<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title> !!! let's update ggya > _ < !!! </title>

    <style>
        html,body{
            margin:0;
            padding: 0;
        }
        .container{
            width:70%;
            margin: 0 auto;

        }

        .w100{
            width:100%;
            padding:7px;
        }
        #title{
            margin-bottom: 4px;
        }
        #content{
            height:300px;
        }

        div.container table.w100 td {
            width:33%;
            height: 40px;
        }
        .btn{
            width: 120px;
            height: 30px;
            border: 0;
            border-radius: 3px;
            color:white;
            font-weight: bold;
        }
        .btn:hover{
            cursor: pointer;
        }
        .right02 {
            width:50px;
            position:absolute;
            left:82%;
            margin-top: -38px;
        }

        .bold {
            font-weight: 600;
        }

        .fred {
            color:#FF5959;
        }


        .bggreen{
            background-color: #4FD86D;
        }
        .bglighblue{
            background-color: #14AAFF;
        }
        .bgred{
            background-color: #FF5959;
        }
        .bggray{
            background-color: #CCCCCC;
        }
        .bglightgrey{
            background-color:#F6F6F6;
        }
        #attfile{
            display: inline-block;
        }

        #bottbtnlist{
            width:100%;
            padding: 5% 39%;
        }

        .writedt {
            width: 100%;
            height: 220px;
            padding: 4%;
            border:1px solid black;
        }

        div.writedt input#inputdt{
            width:95%;
            height:150px;
            margin-left: 15px;
        }

        .dt {
            margin-left:5%;
        }

        .btnlist{
            display: inline-flex;
        }
    </style>
</head>
<body>
<div class="container">
    <h3>게시판 상세</h3>
    <input class="w100" type="text" name="title" id="title" placeholder="${detail.title}"/>
    <br/>
    <textarea class="w100" name="content" id="content" placeholder="${detail.content}"></textarea>
    <table class="w100" style="border: 1px solid black;">
        <tr>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <td></td>
        <td style=" text-align: center;">
        </td>
        <td></td>
        </tr>
    </table>
    <script>
        function sacje(){
            if(confirm("댓글을 삭제하시겠습니까?")){
                window.location.href="/delboard/"+'${detail.id}';
            }else {
                alert("이전으로 돌아갑니다.")
            }
        }

        function toupdate(){
            const url ='/update/'+'${detail.id}';
            fetch(url,{
                method : "POST",
                body: JSON.stringify(formData)
            })
        }
        function tolist(){
            confirm("작성중이던 데이터가 삭제될 수 있습니다. 목록으로 돌아가시겠습니까?"){
                window.location.href="/";
            }
        }
    </script>
    <div id="bottbtnlist">
        <button onclick="toupdate();"class="btn bglighblue">확인</button>
        <button onclick="sacje();" class="btn bgred">삭제</button>
        <button onclick="tolist();" class="btn bggray">목록</button>
    </div>
    <div class="writedt bglightgrey">
        <p> 댓글 쓰기</p>
        <input type="text" name="inputdt" placeholder="답글을 작성해주세요. 최대 200자까지 작성할 수 있습니다. 답글 버튼을 눌렀을때 화면에 나타납니다."/>
        <p class=" inb"> {0} / 200</p>
        <button class="inb btn bggreen right02">등록</button>
    </div>
    <hr style="margin:3% 0;">
    <p class="bold"><span>&nbsp;&nbsp;<img src="/15.png" alt="화살아이콘">&nbsp;&nbsp;</span><c:out value="${detail.member}"/><span class="fred "> {n}분전</span></p>

    <div class="dt" style="height: 130px;">
        <br/>
        <p><c:out value="${detail.comment}"/></p>

    </div>
    <hr />
    <div class="writedt bglightgrey">
        <p> 답글 쓰기</p>
        <input type="text" name="inputdt"  placeholder="답글을 작성해주세요. 최대 200자까지 작성할 수 있습니다. 답글 버튼을 눌렀을때 화면에 나타납니다."/>
        <p class=" inb"> {0} / 200</p>
        <button class="inb btn bggreen right02">등록</button>
    </div>
    <hr style="margin:3% 0;">
    <p class="bold"><img src="target/classes/static/asset/img/15.png" alt="ㅇㅇ">&nbsp;&nbsp;<span>{member.username}</span><span class="fred">{n}분전</span></p>
    <div class="dt" style="height:130px;">
        <br/>
        {board.content}
    </div>
    <hr style="margin:3% 0;">

    <div class="writedt bglightgrey">
        <p> 댓글 수정</p>
        <input type="text" name="inputdt"  placeholder="답글을 작성해주세요. 최대 200자까지 작성할 수 있습니다. 답글 버튼을 눌렀을때 화면에 나타납니다."/>
        <p class=" inb"> {0} / 200</p>
        <div class="btnlist" style="height:25px;margin-top:-55px;">
            <button class="inb btn bglighblue right02" style="margin-left:-60px; z-index:1000;">수정</button>
            <button class="inb btn bggray right02">취소</button>
        </div>
    </div>
    <hr style="margin:3% 0;">
    <p class="bold"><img src="/WEB-INF/asset/img/15.png" alt="d">&nbsp;&nbsp;<span>{member.username}</span><span class="fred "> {n}분전</span></p>
    <div class="dt" style="height:130px;">
        <br/>
        {board.content}
    </div>
    <hr style="margin:3% 0;">
</div>
</div>
</body>
</html>