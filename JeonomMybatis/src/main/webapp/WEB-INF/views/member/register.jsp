<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>회원가입</title>
	</head>
	<body>
<!-- 		http://127.0.0.1/member/join.do -->
<!-- url주소에서 파일정보 매핑하기 위해서 -->
<!-- 기존 : webapp안에 jsp파일 위치 -->
<!-- 변경 : WEB-INF안에 views 폴더 생성 후 member 폴더 생성 후 jsp파일 위치 -->
<!-- 무조건 get방식으로 함!!! -->
		<h1>회원가입</h1>
		<h3>회원정보를 입력하세요</h3>
		<form action="/member/join.kh" method="post">
		<fieldset>
			<legend>회원가입</legend>
			아이디 : <input type="text" name="member-id"> <br>
			비밀번호 : <input type="password" name="memberPw"> <br>
			이름 : <input type="text" name="member-name"> <br>
			성별 : 남 <input type="radio" name="gender" value="M"> 
				   여 <input type="radio" name="gender" value="F"> <br>
			나이 : <input type="number" name="age"> <br>
			이메일 : <input type="email" name="email"> <br>
			전화번호 : <input type="text" name="phone" placeholder="(-)빼고 입력"> <br>
			주소 : <input type="text" name="address"> <br>
			취미 : <input type="text" name="hobby"> <br><br>
			<input type="submit" value="회원가입">
		</fieldset>
		</form>
	</body>
</html>