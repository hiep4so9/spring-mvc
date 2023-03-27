<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<ul class="sidebar navbar-nav">
	<li class="nav-item active"><a class="nav-link" href="index.html">
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
	</a></li>
	<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
		href="#" id="pagesDropdown" role="button" data-toggle="dropdown"
		aria-haspopup="true" aria-expanded="false"> <i
			class="fas fa-fw fa-folder"></i> <span>Pages</span>
	</a>
		<div class="dropdown-menu" aria-labelledby="pagesDropdown">
			<h6 class="dropdown-header">Login Screens:</h6>
			<a class="dropdown-item" href="login.html">Login</a> <a
				class="dropdown-item" href="register.html">Register</a> <a
				class="dropdown-item" href="forgot-password.html">Forgot
				Password</a>
			<div class="dropdown-divider"></div>
			<h6 class="dropdown-header">Other Pages:</h6>
			<a class="dropdown-item" href="404.html">404 Page</a> <a
				class="dropdown-item" href="blank.html">Blank Page</a>
		</div></li>
	<li class="nav-item"><a class="nav-link" href="charts.html"> <i
			class="fas fa-fw fa-chart-area"></i> <span>Charts</span>
	</a></li>
	<li class="nav-item"><a class="nav-link" href="tables.html"> <i
			class="fas fa-fw fa-table"></i> <span>Tables</span>
	</a></li>
	<li class="nav-item"><a class="nav-link"
		href="/spring-mvc/quanlyuser"> <i class="fas fa-fw fa-table"></i>
			<span>User management</span>
	</a></li>

	<li class="nav-item"><a class="nav-link"
		href="/spring-mvc/quanlykhachhang"> <i class="fas fa-fw fa-table"></i>
			<span>Customer management</span>
	</a></li>
	<li class="nav-item"><a class="nav-link"
		href="/spring-mvc/quanlyproduct"> <i class="fas fa-fw fa-table"></i>
			<span>Product management</span>
	</a></li>
	<li class="nav-item"><a class="nav-link"
		href="/spring-mvc/quanlyhoadon"> <i class="fas fa-fw fa-table"></i>
			<span>Bill management</span>
	</a></li>

	<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
		href="/spring-mvc/quanlyhoadon" id="pagesDropdown" role="button"
		data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			<i class="fas fa-fw fa-table"></i> <span>Bill management</span>
	</a>
		<div class="dropdown-menu" aria-labelledby="pagesDropdown">
			<a class="dropdown-item" href="/spring-mvc/quanlydondathang">Quản lý đơn đặt hàng</a> <a
				class="dropdown-item" href="/spring-mvc/quanlydonhang">Quản lý đơn hàng</a>
		</div></li>
</ul>