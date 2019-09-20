<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/companionStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/companion.js"></script>
</head>
<body>
<div id="course">
	<div id="title">
		<img src="resources/img/exbutton.png" onclick="exit()" style="float: right;">
	</div>
	<div id="courseList">
		<span>${leader}</span>
		<span><input type="button" value="신청하기" onclick="companionApply(<%=(String)session.getAttribute("name")%>,${leader})"></span>
	</div>
	<div id="courseList">
		<span>여행장소</span>
		<span>${course.place_name}</span>
	</div>
	<div id="courseList">
		<span>여행기간</span>
		<span>${typeA.day_start}~${term}</span>
	</div>
	<div id="courseList">
		<span>여행타입</span>
		<span>${typeA.travel_theme}</span>
	</div>
	<div id="courseList">
		<span>여행소개</span>
	</div>
	<div id="courseList">${typeA.travel_intro}</div>
</div>
</body>