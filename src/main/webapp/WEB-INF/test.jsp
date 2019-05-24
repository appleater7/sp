<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="/resources/css/main.css"/>
<link rel="/resources/dhtmlx/codebase/dhtmlx.css"/>
<script src="/resources/dhtmlx/codebase/dhtmlx.js"></script>
</head>
<body>
<div id="topGrid" style=width:400px;height:300px></div>
<div id="middleGrid" style=width:400px;height:200px></div>
<script>
    var topGrid = new dhtmlXGridObject('topGrid');
    topGrid.setImagePath('/resources/dhtmlx/codebase/imgs/');
    topGrid.setHeader('부서번호,부서명,지역');
    topGrid.setColumnIds('deptNo,dName,loc');
    topGrid.setInitWidths('100,100,100');
    topGrid.setColTypes('ed,ed,ed');
    topGrid.setColSorting('int,str,str');
    topGrid.setColAlign("center,center,center")
    topGrid.init();
    
    var middleGrid = new dhtmlXGridObject('middleGrid');
    middleGrid.setImagePath('./resources/dhtmlx/codebase/imgs/');
    middleGrid.setHeader('사원번호,이름,직급,급여');
    middleGrid.setColumnIds('empNo,eName,job,sal');
    middleGrid.setInitWidths('80,200,100,100');
    middleGrid.setColTypes('ro,ed,ed,ed');
    middleGrid.setColSorting('int,str,str,int');
    middleGrid.setColAlign("center,center,center,center")
    middleGrid.init();
</script>
</body>
</html>