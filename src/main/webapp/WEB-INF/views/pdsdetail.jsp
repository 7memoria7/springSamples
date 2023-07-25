<%@page import="ssg.com.a.dto.PdsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	PdsDto pds = (PdsDto)request.getAttribute("pds");
%>    
        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdsdetail</title>
</head>
<body>

<h1>자료 상세 보기</h1>
<hr>

<div align="center">
<table border="1">
<col width="150px"><col width="500px">

<tr>
	<th>아이디</th>
	<td><%=pds.getId() %></td>
</tr>
<tr>
	<th>다운로드 수</th>
	<td><%=pds.getDowncount() %></td>
</tr>
<tr>
	<th>등록일</th>
	<td><%=pds.getRegdate() %></td>
</tr>
<tr>
	<th>제목</th>
	<td><%=pds.getTitle() %></td>
</tr>
<tr>
	<th>다운로드</th>
	<td>
		<%=pds.getFilename() %>&nbsp;&nbsp;
			<input type="button" value="다운로드" 
			onclick="filedown(<%=pds.getSeq() %>,'<%=pds.getNewfilename() %>','<%=pds.getFilename() %>')">
	</td>		<!-- seq는 숫자니깐,  '' 안붙여줘도되고,          나머지는 문자열이므로 ''를 붙여줘야한다. -->
</tr>
<tr>
	<th>내용</th>
	<td>
		<textarea row="5" cols="50"><%=pds.getContent() %></textarea>
	</td>
</tr>

</table>
</div>



<!--  get 방식으로 보낼때의 소스코드! 
<script type="text/javascript">
function filedown(seq, newfilename, filename){
	location.href = "filedownload.do?seq=" + seq + "&newfilename" + newfilename + "&filename" + filename;
}

</script> -->

<!-- post로 보낼때 -->
<form name="file_down" action="filedownload.do" method="post">
	<input type="hidden" name="newfilename">
	<input type="hidden" name="filename">
	<input type="hidden" name="seq">

</form>
<script type="text/javascript">
function filedown(seq, newfilename, filename){
	document.file_down.newfilename.value = newfilename;
	document.file_down.filename.value = filename;
	document.file_down.seq.value = seq;
	document.file_down.submit();
}
</script>



</body>
</html>


