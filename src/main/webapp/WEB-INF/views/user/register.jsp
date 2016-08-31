<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>회원가입</title>
    <meta charset="utf-8">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <div class="page-header">
        <h1>지옥자바
            <small>회원가입</small>
        </h1>
    </div>
    <c:if test="${error != null}">
        <div class="row">
            <div class="col-lg-12">
                <div class="alert alert-danger">${error}</div>
            </div>
        </div>
    </c:if>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <form:form commandName="register">
                        <div class="form-group">
                            <label>아이디</label>
                            <input type="text" class="form-control input-lg" name="email">
                            <form:errors path="email" />
                        </div>
                        <div class="form-group">
                            <label>비밀번호</label>
                            <input type="password" class="form-control input-lg" name="password">
                            <form:errors path="password" />
                        </div>
                        <button type="submit" class="btn btn-primary btn-lg btn-block">회원가입</button>
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