<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="" onsubmit=" return false">
		用户名<input type="text" name="name"> 
		密码<input type="password"name="password"> 
		<input class="submit" type="submit" value="立即登录">
	</form>

<script src="./js/jquery-1.12.2.min.js"></script>
	<script type="text/javascript">
		$("form").submit(function() {
			$.ajax({
				type : "post",
				url : "/empsys_ajax/login",
				data : $("form").serialize(),
				dataType : "json",
				success : function(data) {
					if (data.code == 1) {
						window.location.href = "list.jsp";
					} else {
						alert(data.info);
					}
				},
			error:function(){
				alert("ajax请求异常");
			}
		})
	})
	</script>
</body>
</html>