<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>detailviewById</title>

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
            height: 150px;
            padding: 2%;
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
<%--<script>--%>
<%--    window.onload=function(){--%>
<%--        console.log('${detail.get(param)}')--%>
<%--        console.log('${detail.get(requestScope)}')--%>
<%--        console.log(typeof ('${detail}'))--%>
<%--    debugger--%>
<%--    }--%>
<%--</script>--%>
<div class="container">
    <h3>게시판 상세</h3>
    <div class="w100" type="text" name="title" id="title"><c:out value="${detail[0].title}"/></div>
    <br/>
    <div class="w100" name="content" id="content"><c:out value="${detail[0].content}"/></div>
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
            window.location.href ='/delboard/'+'${detail[0].id}';
        }
        function toupdate(){
            alert("게시글 수정 페이지로 이동합니다.");
            window.location.href ='/detailviewbyidupdate/'+'${detail[0].id}';
        }
        function tolist(){
            alert("작성중이던 데이터가 삭제될 수 있습니다. 목록으로 돌아가시겠습니까?");
            window.location.href="/";
        }

    </script>
    <div id="bottbtnlist">
        <button onclick="toupdate();" class="btn bglighblue">수정</button>
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
<p class="bold"><span>&nbsp;&nbsp;<img src="" alt="arrImg">&nbsp;&nbsp;</span><c:out value="${detail[0].member}"/><span id="nn" class="fred ">&nbsp; 0 &nbsp;</span><span>분전</span></p>
    <div class="dt" style="height: 130px;">
        <br/>
        <p><c:out value="${detail[0].comment}"/></p>
    </div>
    <hr style="margin:3% 0;">

</body>
</html>