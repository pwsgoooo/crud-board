<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert</title>
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
        .bggreen{
            background-color: #4FD86D;
        }
        .bglighblue{
            background-color: #14AAFF;
        }
        .bggray{
            background-color: #CCCCCC;
        }
        #attfile{
            display: inline-block;
        }

        #bottbtnlist{
            width:100%;
            padding-top:15px;
            padding-left:39%;

        }
        .inb{
            display: inline-block;
        }
        .right0 {
            width:66%;
            position:absolute;
            right:0%;

        }
        .bold {
            font-weight: 800;
        }
        table#list, td{
            border-collapse: collapse;
            border: 1px solid #333;
        }

        #paginglist{
            width:100%;
        }


        #paginglist ul {
            width: 80%;
            margin:15px auto;
            list-style: none;
            display: inline-block;
            left: 0;
        }
        #paginglist ul li{
            border:1px solid black;
            width: 30px;
            height: 30px;
            display: inline-block;
            text-align: center;
            font-size:1.1em;
            font-weight: 600;
            margin-left: 3px;
            justify-content: space-around;
        }

        #paginglist button {
            width:14%;
            display: inline-block;
            right:0;
        }
        td#todetail:hover{
            font-weight: bold;
            cursor: grab;
        }
    </style>
</head>
    <script>
        function toupdate(id){
            window.location.href="/detailviewbyid/"+id;
        }
    </script>
<body>
<div class="container">
    <h3>게시판 목록</h3>
    <p class="inb">검색된 게시물 <span style="color:#14AAFF">{n}</span> / 총 게시물 <span style="color:#14AAFF">{n}</span></p>
    <div class="inb right0" >
        <form action="#" class="inb right0" >
            <label for="searching">검색조건</label>
            <select name="조회사항" id="searching">
                <option value="작성자">작성자</option>
                <option value="제목">제목</option>
                <option value="작성일">작성일</option>
            </select>
            <input type="text" name="sccon" id="sccon">
            <input type="submit" value="검색" class="bglighblue btn" style="width:50px;" />
        </form>
    </div>


    <table id="list" class="w100" style="border: 1px solid black; ">
        <tr class="bggray bold">
            <td style="width:10%;">번호</td>
            <td style="width:50%;">제목</td>
            <td style="width:15%;">작성자</td>
            <td style="width:25%;">작성일</td>
        </tr>
        <c:forEach var="li" items="${list}">
            <tr>
                <td><c:out value="${li.id}"/></td>
                <td id="todetail" onclick="toupdate(parseInt('${li.id}'));"><c:out value="${li.title}"/></td>
                <td><c:out value="${li.regMember}"/></td>
                <td><c:out value="${li.regDate}"/></td>
            </tr>
        </c:forEach>

    </table>
    <div id="paginglist">
        <ul>
            <li>
                <
            </li>
            <li>
                n
            </li>
            <li>
                >
            </li>
        </ul>
        <button onclick="window.location.href='/insert'" class="bglighblue btn" style="width:70px; display: inline-block;">등록</button>
    </div>
</div>
</body>
</html>