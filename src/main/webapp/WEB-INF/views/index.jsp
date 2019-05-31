<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="LoginForm">
	<label for="id">아이디 : </label>
	<input type="text" id="id"><br>
	<label for="id">아이디 : </label>
	<input type="password" id="pwd"><br>
	<button type="button">로그인</button>
</form>
<script src="/resources/js/jquery-3.4.1.js"></script>
<script>
$(document).ready(function(){
	$('[type=button]').click(function(){
var param = { uiId:document.querySelector('#id').value,uiPwd:document.querySelector('#pwd').value};
//var param = {uiId:$('#id').val(),uiPwd:$('#pwd').val()};
		$.ajax({
			url:'/login',
			method:'POST',
			contentType:'application/json',
			data:JSON.stringify(param),
			success:function(res){
				console.log(res);
			}
		});
	});
})

/*
	$(document).ready(function(){
		#('#test').html('하하하');
	})
	alert(document===windoew.document && document===this.document);
	
	function func1(){
		alert(this===window);
	}
	func1();
	alert(this.func1 === window.func1);*/
</script>
</body>
</html>