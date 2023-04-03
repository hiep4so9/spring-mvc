<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="navbar-brand">
		<a href="trang-chu"><img
			src="${pageContext.request.contextPath}/resources/public/nhat.png"
			style="height: fit-content; width: 40px; position: relative; left: 100px;"></a>

	</div>
	<form class="form-inline my-2 my-lg-0"
		style="position: relative; left: 500px;">
		<input class="form-control mr-sm-2" type="search" placeholder="Search"
			aria-label="Search">
		<button class="btn btn-outline-success my-2 my-sm-0" type="submit"
			style="position: absolute; left: 240px; top: -1px;">Search</button>
	</form>




	<%
	if (request.getSession().getAttribute("userSession") != null) {
	%>
	<div class="dropdown" style="position: relative; left: 920px;">
		<button class="btn btn-secondary dropdown-toggle" type="button"
			id="profileDropdownMenuButton" data-toggle="dropdown"
			aria-haspopup="true" aria-expanded="false">
			<i class="fas fa-user"></i>
		</button>
		<div class="dropdown-menu" aria-labelledby="profileDropdownMenuButton">
			<a class="dropdown-item" href="profile">Profile</a> <a
				class="dropdown-item" href="hoadonkhach">Quản lý đơnhàng</a>
			<div class="dropdown-divider"></div>
			<a class="dropdown-item" href="#">Logout</a>
		</div>
	</div>
	<div class="cart-icon" style="position: relative; left: 800px;">
		<a href="cart"> <i style="color: white"
			class="fas fa-shopping-cart">${a }</i>

		</a>
	</div>
	<%
	} else {
	%>
	<div class="dropdown" style="position: relative; left: 920px;">

		<a class="btn btn-secondary" href="/spring-mvc/dangnhap"> LOGIN </a> 
		<a
			class="btn btn-secondary" href="/spring-mvc/dangky"> SIGN UP </a>
	</div>

	<%
	}
	%>
</nav>