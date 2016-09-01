<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>게시판 목록</title>
    <meta charset="utf-8">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="page-header">
        <h1>지옥자바
            <small>게시글 작성</small>
        </h1>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form:form commandName="write">
                        <div class="form-group">
                            <label>작성자</label>
                            <p>${sessionScope.get("account")}</p>
                        </div>
                        <div class="form-group">
                            <label>제목</label>
                            <form:input path="title" cssClass="form-control input-lg"/>
                            <form:errors path="title"/>
                        </div>
                        <div class="form-group">
                            <label>내용</label>
                            <form:textarea path="content" cssClass="form-control input-lg"/>
                            <form:errors path="content"/>
                        </div>
                        <form:errors/>
                        <button type="submit" class="btn btn-default btn-lg pull-right">완료</button>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>