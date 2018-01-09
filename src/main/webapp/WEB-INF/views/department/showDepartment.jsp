<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<link rel="stylesheet" type="text/css" href="iconfont/icon-css/iconfont.css">
<link rel="stylesheet" type="text/css" href="./css/departmentCss/showDepartment.css">

            <div class="top-menu">
                <div class="but">
					<button type="button"  class="loadadd">添加部门</button>
					<button type="button" class="btn-delete">删除部门</button>
				</div>
            </div>
        
		<table>
			<thead>
				<th>序号</th>
				<th>名称</th>
				<th>描述</th>
				<th>创建时间</th>
				<th>操作</th>
			</thead>
			<tbody>
				<!-- varStatus获取当前索引或序号 -->
				<c:forEach var="item" items="${departmentmanage}" varStatus="status">
					<tr class="department-remove-id" data-id="${item.id }">
						<!-- count获取当前序号，从1开始 -->
						<!-- index获取当前索引，从0开始 -->

						<td><input type="checkbox" name="checkbox" data-id="${item.id}">${item.id }</td>
						<td>${item.name }</td>
						<td>${item.description }</td>
						<td>${item.createDate }</td>
						<td><button type="button" class="btn-edit" data-id="${item.id}">编辑</button>
							<button type="button" class="btn-remove" data-id="${item.id }">删除</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	 
	<script type="text/javascript" src="./plugins/jquery_2.1.3.js"></script>

	<script type="text/javascript" src="./js/showDepartment.js"></script>
