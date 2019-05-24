<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="rPath" value="${pageContext.request.contextPath}"/>
<c:set var="dPath" value="${rPath}/resources/dhtmlx" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${rPath}/resources/css/main.css" />
<link rel="stylesheet" href="${dPath}/codebase/dhtmlx.css" />
<script src="${dPath}/codebase/dhtmlx.js"></script>
<script src="${rPath}/resources/js/AjaxUtils.js"></script>
</head>
<body>
<div id="deptGrid" style="width:500px; height:300px"></div>
	부서번호 :
	<input type="number" id="deptNo" class="dept"><br>
	부서명 :
	<input type="text" id="dName" class="dept"><br>
	지역 :
	<input type="text" id="loc" class="dept"><br>
	<button onclick="searchEmp()">검색</button>
	<button onclick="saveEmp()">저장</button>
	<button onclick="saveEmps()">저장s</button>
<div id="empGrid" style="width:500px; height:300px"></div>
	사원번호 :
	<input type="number" id="empNo" class="emp"><br>
	사원이름 :
	<input type="text" id="eName" class="emp"><br>
	부서번호 :
	<input type="text" id="deptNo" class="emp"><br>
	직급 :
	<input type="text" id="job" class="emp"><br>
	<button onclick="searchEmp()">검색</button>
	<button onclick="updateEmp()">수정</button>
	<button onclick="saveEmp()">저장</button>
	<button onclick="saveEmps()">저장s</button>
<script>
var deptGrid = new dhtmlXGridObject('deptGrid');
deptGrid.setHeader('부서번호,부서명,지역');
deptGrid.setColumnIds('deptNo,dname,loc');
deptGrid.setColTypes('ro,ed,ed');
deptGrid.init();
deptGrid.attachEvent('onRowSelect',function(rId,ind){
	var data = deptGrid.getRowData(rId);
	var au = new AjaxUtil({url:'/emps?deptNo='+data.deptNo,suc:callback2});
	au.send();
})

var empGrid = new dhtmlXGridObject('empGrid');
empGrid.setHeader('사원번호,이름,부서번호,직급');
empGrid.setColumnIds('empNo,ename,deptNo,job');
empGrid.setColTypes('ro,ed,ro,ed');
empGrid.init();

function callback(res) {
	deptGrid.parse(res,'js');
	deptGrid.selectRow(0);
	var rowId = deptGrid.getSelectedRowId();
	var data = deptGrid.getRowData(rowId);
	var au = new AjaxUtil({url:'/emps?deptNo='+data.deptNo,suc:callback2});
	au.send();
}
function callback2(res) {
	empGrid.clearAll();
	empGrid.parse(res,'js');
}
function updateEmp() {
	var ids = empGrid.getChangedRows();
	ids = ids.split();
	var data = [];
	for (var id in ids) {
		empGrid.getRowData(rowId);
	}
	alert(JSON.stringify(data));
}
var au = new AjaxUtil({url:'/depts',suc:callback});
au.send();
	// 데이터를 인스턴스화 안시켰기때문에 리턴값이 void 고 리턴이 없다.
</script>
</body>
</html>
