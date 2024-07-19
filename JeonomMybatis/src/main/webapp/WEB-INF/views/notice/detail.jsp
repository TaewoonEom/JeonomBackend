<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>공지사항 상세</title>
	</head>
	<body>
		<span>글번호 : ${notice.noticeNo }</span>
		<span>글쓴이 : ${notice.noticeWriter }</span>
		<span>작성일 : ${notice.regDate }</span>
		<span>조회수 : ${notice.viewCount }</span> <br>
		<span>글제목 : ${notice.noticeSubject }</span> <br>
		<span>글내용 : ${notice.noticeContent }</span> <br>
		<a href="javascript:history.go(-1);">뒤로가기</a>
		<a href="/notice/update.kh?noticeNo=${notice.noticeNo }">수정하기</a>
		<a href="javascript:void(0);" onclick="checkDelete();">삭제하기</a>
		<script>
			function checkDelete() {
				if(confirm("삭제하시겠습니까?")) {
					location.href="/notice/delete.kh?noticeNo=${notice.noticeNo }";
				}
			}
		</script>
	</body>
</html>