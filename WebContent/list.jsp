<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<title>所有员工信息</title>
		<style type="text/css" >
			table td {
				text-align: center;
			}
			/*合并表格的边框*/
			
			table {
				width: 700px;
				border-collapse: collapse;
			}
			
			h3 {
				text-align: center;
			}
			
			div {
				margin: 0 auto;
				width: 700px;
			}
		</style>
		<script type="text/javascript" src="js/jquery-1.12.2.min.js"></script>
	</head>

	<body>
		<div>
			<h3>所有员工信息</h3>
			<a href="add.jsp">添加员工信息</a><br/>
			<table border="1">

				<tr>
					<th>序号</th>
					<th>姓名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>手机</th>
					<th>操作</th>
				</tr>
				<tbody id="tid"></tbody>

			</table>
		</div>
		
		<script type="text/javascript" >
			$(function(){
				loadData();
			})
			
			function loadData(){
				$.ajax({
					type:"get",
					url:"list",
					dataType:"json",
					success:function(data){
						if(data.code == 1){
							// 清空表格的数据
							$("#tid").empty();
							// 找到要遍历的数据
							var infos = data.info;
							// 循环遍历
							$(infos).each(function(){
								// 组装html格式的字符串
								var html = "<tr>";
								html += "	<td>" + this.id + "</td>";
								html += "	<td>" + this.name + "</td>";
								html += "	<td>" + this.sex + "</td>";
								html += "	<td>" + this.age + "</td>";
								html += "	<td>" + this.phone + "</td>";
								// 针对超链接 ，要想发送ajax请求，可以点击超链接时，执行一个函数，在函数中发送ajax请求
								// href='javascript:delEmp()'表示，点击超链接，执行对应的js函数
								html += "	<td><a href='javascript:delEmp(" + this.id + ")'>删除</a> <a href='update.jsp?id=" + this.id + "'>修改</a></td>";
								html += "</tr>";
								// 根据html格式字符串创建dom对象，将对象添加到对应表格的最后
								$("#tid").append($(html));
							})
						}else{
							alert(data.info);
						}
					},
					error:function(){
					}
				})
			}
		</script>
		
		<script type="text/javascript" >
			function delEmp(id){
				$.ajax({
					type:"get",
					url:"delete?id=" + id,
					dataType:"json",
					success:function(data){
						if(data.code == 1){
							//window.location.href = "list.jsp";
							// 因为是在同一页面，没有必要，重新定位到list.jsp
							// 可以直接发送ajax请求，获取所有数据，重新绑定
							loadData();
						}
					}
				})
			}
		</script>
	</body>
</html>