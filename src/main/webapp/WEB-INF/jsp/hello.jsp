<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<script src="${ctx}/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(function(){
    $("#btn").click(function(){
       $.post("${ctx}/mvc/getPerson",{name:$("#name").val()},function(data){
            alert(data);
        });
    });
});
</script>
<title>Insert title here</title>
</head>
<body>
     你好!
     </br>
     姓名：<input id="name" type="text"/> 
     </br>
      <input id="btn"   type="button"  value = "say"  height="32"  width="52" />
</body>
</html>