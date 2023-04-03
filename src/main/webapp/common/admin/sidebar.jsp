
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<ul class="sidebar navbar-nav">
	
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