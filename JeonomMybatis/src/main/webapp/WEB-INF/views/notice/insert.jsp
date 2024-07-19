<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>공지사항 등록</title>
	</head>
	<body>
<!-- 		doGet으로 서블릿에서 insert.jsp를 호출하고 글을 작성하면 -->
<!-- 		doPost로 서블릿에서 데이터 등록 -->
		<form action="/notice/insert.kh" method="post">
			<fieldset>
				<legend>공지사항 등록</legend>
				제목 : <input type="text" name="noticeSubject"> <br> <br>
				내용 : <textarea rows="10" cols="40" name="noticeContent"></textarea>
			</fieldset>
			<input type="submit" value="등록">
		</form>
	</body>
</html>