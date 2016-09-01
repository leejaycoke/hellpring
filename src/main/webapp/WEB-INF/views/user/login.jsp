<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>로그인</title>
    <meta charset="utf-8">

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

</head>
<body>

<div class="container">
    <div class="page-header">
        <h1>지옥자바
            <small>로그인</small>
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
                    <form:form commandName="login">
                        <div class="form-group">
                            <label>이메일 주소</label>
                            <form:input path="email" cssClass="form-control input-lg" />
                            <form:errors path="email"/>
                        </div>
                        <div class="form-group">
                            <label>비밀번호</label>
                            <form:password path="password" cssClass="form-control input-lg" />
                            <form:errors path="password"/>
                        </div>
                        <div class="checkbox">
                            <label>
                                <form:checkbox path="remember" /> 아이디 저장
                            </label>
                        </div>

                        <form:errors />
                        <button type="submit" class="btn btn-success btn-lg btn-block">로그인</button>
                    </form:form>
                </div>
            </div>
            <div class="pull-right"><a href="/user/register"><h4>회원가입</h4></a></div>
        </div>
    </div>
</div>
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>