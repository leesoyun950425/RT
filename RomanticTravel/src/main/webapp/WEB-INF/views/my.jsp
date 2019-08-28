<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/myPageStyle.css">
</head>
<body>
<div id="my">
	<h2>회원정보수정</h2>
	<p>회원정보를 수정하실 수 있습니다.</p>
	<table class="myTable" >
		<tr>
			<td width="180" class="td_title">아이디</td>
			<td><input type="text" name="id" id="id"></td>
		</tr>
		<tr>
			<td width="180" class="td_title">이름</td>
			<td><input type="text" name="name" id="name" ></td>
		</tr>
		<tr>
			<td width="180" class="td_title">전화번호</td>
			<td><input type="text" name="tel" id="tel"></td>
		</tr>
		<tr>
			<td width="180" class="td_title">이메일</td>
			<td><input type="text" name="email" id="email"></td>
		</tr>
		<tr>
			<td width="180" class="td_title">생년월일</td>
			<td><input type="text" name="birth" id="birth"></td>
		</tr>
		<tr>
			<td width="180" class="td_title">주소</td>
			<td><input type="text" name="totaddr" id="totaddr"></td>
		</tr>
		<tr>
			<td width="180" class="td_title">관심분야</td>
			<td><input type="text" name="travel_theme" id="travel_theme"></td>
		</tr>
		<tr>
			<td width="180" class="td_title">사진</td>
			<td><input type="text" name="thumb" id="thumb"></td>
		</tr>
		<tr>
			<td width="180" class="td_title">탈퇴</td>
			<td><input type="button" value="탈퇴하기" class="purebtn button-small"></td>
		</tr>
	</table>
	
	<input type="button" class="purebtn" value="수정하기">
</div>
</body>
</html>