<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/myPageStyle.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/myPage.js"></script>
</head>
<body>
<div id="my">
	<h2>회원정보수정</h2>
	<p>회원정보를 수정하실 수 있습니다.</p>
	<table class="myTable" >
		<tr>
			<td width="180" class="td_title">아이디</td>
			<td><input type="text" name="id" id="id" value="${dto.id}" readonly="readonly"></td>
		</tr>
		<tr>
			<td width="180" class="td_title">이름</td>
			<td><input type="text" name="name" id="name" value="${dto.name}"></td>
		</tr>
		<tr>
			<td width="180" class="td_title">전화번호</td>
			<td><input type="text" name="tel" id="tel" value="${dto.tel}"></td>
		</tr>
		<tr>
			<td width="180" class="td_title">이메일</td>
			<td><input type="text" name="email" id="email" value="${dto.email}"></td>
		</tr>
		<tr>
			<td width="180" class="td_title">생년월일</td>
			<td><input type="text" name="birth" id="birth" value="${dto.birth}"></td>
		</tr>
		<tr>
			<td width="180" class="td_title">주소</td>
			<td><input type="text" name="totaddr" id="totaddr" value="${dto.roadaddr}"></td>
		</tr>
		<tr>
			<td width="180" class="td_title">관심분야</td>
			<td><input type="text" name="travel_theme" id="travel_theme" value="${dto.travel_theme}"></td>
		</tr>
		<tr>
			<td width="180" class="td_title">사진</td>
			<td><img src="resources/img/${dto.thumb}"><input type="file" value="변경하기"></td>
		</tr>
		<tr>
			<td width="180" class="td_title">탈퇴</td>
			<td><input type="button" value="탈퇴하기" class="purebtn button-small" ></td>
		</tr>
	</table>
	
	<input type="button" class="purebtn" id="update" value="수정하기" >
</div>
</body>
</html>