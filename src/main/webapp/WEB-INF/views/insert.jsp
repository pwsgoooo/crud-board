<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>insert</title>
    <%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"/>--%>
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

        .bottbtnlist{
            width:100%;
            padding-top:15px;
            padding-left:39%;

        }
    </style>
</head>
<body>
<div class="container">
    <h3>게시판 등록</h3>
    <form id="registerform" action="/register" method="post" enctype="multipart/form-data">
        <input class="w100" type="text" name="title" id="title" placeholder=" inset title here (*´ ˘ `*).｡oO ( ♡ )"/>
        <br/>
        <textarea class="w100" name="content" id="content" placeholder="insert content here (ᇂ_Jᇂ)"></textarea>
        <table class="w100" style="border: 1px solid black;">
            <tr>
                <td id="f01" class="infname"> </td>
                <td id="f02" class="infname"> </td>
                <td id="f03" class="infname"></td>
            </tr>
            <tr>
                <td id="f04" class="infname"></td>
                <td id="f05" class="infname"></td>
                <td id="f06" class="infname"></td>
            </tr>
            <td></td>
            <td style=" text-align: center;">
                <input type="file" class="btn bggreen" id="files" name="files" value="파일 첨부" multiple/>
                <!--                    <button class="btn bggreen" id="attfile">파일 첨부</button>-->
            </td>
            <td></td>
            </tr>
        </table>
        <div class="bottbtnlist">
            <button id ="submit" class="btn bglighblue" >등록</button>
        </div>
    </form>
    <div class="bottbtnlist">
        <button class="btn bggray" onclick="backchk()">취소</button>
    </div>
</div>
<script>

    document.getElementById("files").addEventListener('input',
        function (event) {
            const flist = [];
            const infnames = ['f01', 'f02', 'f03', 'f04', 'f05', 'f06'];

            // let chosenfile = event.target.files[i];
            let chosenfile = event.target.files;
            for (let i = 0; i < chosenfile.length && i < infnames.length; i++) {
                console.log(flist.length);
                const cfile = chosenfile[i];
                document.getElementById(infnames[i]).textContent = cfile.name;

                flist.push(cfile);
            }
            console.log(flist);

    });
    document.getElementById("submit").addEventListener('click', function (e) {
        e.preventDefault();

        const form = document.getElementById("registerform");
        const formData = new FormData(form);

        <%--for (let pair of formData.entries()) {--%>
        <%--    console.log(`${pair[0]}: ${pair[1]}`);--%>
        <%--}--%>
        // const files = document.getElementById("files").file;

        const fileIn = document.getElementById("files");
        const fileList = fileIn.files;

        const title = document.getElementById("title").value;
        const content = document.getElementById("content").value;

        // console.log(formData.title.);
        // console.log(formData.content.value);
        // console.log(formData.files.files);


        // const flist = files.files;

        for (let i = 0; i < fileList.length; i++) {
            formData.append("files", fileList[i]);
        }
        //console.log(typeof (files));// obj

        // formData.append("files", files);
        formData.append("title",title);
        formData.append("content",content);

        <%--for (let pair of formData.entries()) {--%>
        <%--    console.log(`${pair[0]}: ${pair[1]}`);--%>
        <%--}--%>

        // body: JSON.stringify(formData)
        fetch("/register", {
            method: "POST",
            body: formData,
        })
        .then((response) => response.json())
        .then((data) => console.log(data))
        .then((window.location.href = "/"))
        .catch((error) => console.error("Error:", error));

    });


    function uptodbchk() {
        if (confirm("글 등록을 요청합니다.")) {
            window.location.href = "/register";
        }
    }

    function backchk() {
        if (confirm("작성중인 글이 있습니다. 이전 페이지로 이동하시겠습니까?")) {
            window.history.back()
        }
    }
</script>


</body>
</html>