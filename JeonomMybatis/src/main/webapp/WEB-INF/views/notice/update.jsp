<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>공지사항 수정</title>
	</head>
	<body>
		<fieldset>
			<legend>공지사항 수정</legend>
			<form action="/notice/update.kh" method="post">
				<input type="hidden" name="noticeNo" value="${notice.noticeNo }">
				제목 <input type="text" name="noticeSubject" value="${notice.noticeSubject }"> <br>
				내용 <textarea rows="10" cols="40" name="noticeContent">${notice.noticeContent }</textarea> <br>
				<input type="submit" value="수정">
			</form>
		</fieldset>
		<button onclick="goBack();">뒤로가기</button>
		<script>
			function goBack() {
				history.go(-1);
			}
		</script>
	</body>
</html>