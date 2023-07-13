<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>

<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript"></script>
<!-- 쿠키 :  저장공간! -->


<style type="text/css">
.center{
	margin: auto;
	width: 350px;
	border: 3px solid #0000ff;
	padding: 10px
}
</style>

</head>
<body>
 
<h2>login</h2>

<div class="center">
<form action="loginAf.do" method="post">
<table class="table">
<tr>
<th>아이디</th>
	<td>
		<input type="text" class="form-control" id="id" name="id" size="20"><br>
		<input type="checkbox" id="chk_save_id">id저장 <!-- 아이디저장 -->
	</td>
</tr>

<tr>
<th>패스워드</th>
	<td>
		<input type="password" class="form-control" name="pwd" value="" size="20">
	</td>
</tr>

<tr>
	<td colspan="2">
		<input type="submit" class="btn btn-primary" value="login">
		<a href="regi.do">회원가입</a>
	</td>
</tr>
</table>

</form>
</div>

<script type="text/javascript">

/*
	session : server에 저장. login정보 저장.   Objcet
	cookie  : client에 저장. id를 저장. pw 저장    	String
	
 */
 
 let user_id = $.cookie("user_id"); // user id가 쿠키에 저장되어있으면 가져오는 문법
 if(user_id != null){	// 저장한 아이디가 있음
	$("#id").val(user_id);
 	$("#chk_save_id").prop("checked", true); 		// 체크박스의 체크가되게 만들어준다.
 }
 
 $("#chk_save_id").click(function(){
	//  alert('click'); 
	// alert($("#chk_save_id").is(":checked"));
	 if($("#chk_save_id").is(":checked") == true ){	// id를 저장 cookie에 저장한다.
		
		if( $("#id").val().trim() == ""){	// 빈문자열이었을 경우
			alert('id를 입력해 주십시오');
			$("#chk_save_id").prop("checked", false);	
		}else{
			// cookie저장
			$.cookie("user_id", $("#id").val().trim(), {expires:7, path:'./'});
		}
		
	}else{	// cookie에 저장하지 않음(삭제)
  			$.removeCookie("user_id",{path:'./'}); // 기한을 없애면 쿠키는 삭제된다.
	}
	
 });
 
 </script>

</body>
</html>