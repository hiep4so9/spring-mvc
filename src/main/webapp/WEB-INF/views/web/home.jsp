<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="banner">
	<img class="home-inner" alt=""
		src="${pageContext.request.contextPath}/resources/public/6260298.jpg"
		style="width: 100%; height: 500px; display: flex; justify-items: center;" />
</div>
<!-- partial:index.partial.html -->
<div class="section-products">
	<div class="container">
		<div class="row justify-content-center text-center">
			<div class="col-md-8 col-lg-6">
				<div class="header">
					<h3>Sản phẩm Cửa hàng</h3>
					<h2>Sản phẩm nổi bật</h2>
				</div>
			</div>
		</div>
		<div class="row">

			<div class="col-lg-3 col-md-4 col-sm-5">
				<!--Tim kiem-->
				<div class="1">
					<label for="sel1">Tìm kiếm:</label>
					<form class="d-flex">
						<input class="form-control me-2" type="search"
							placeholder="Search" aria-label="Search">
					</form>
				</div>
				<hr>
				<br>
				<!--Filter Theo Gia-->
				<div class="2">
					<form class="d-flex">
						<div class="form-group" style="width: 100%;">
							<label for="sel1">Giá:</label> <select class="form-control"
								id="sel1">
								<option>Giá tăng dần</option>
								<option>Giá giảm dần</option>
							</select>
						</div>
					</form>
				</div>
				<hr>
				<!--Adruino-->
				<div class="3">
					<h3 style="color: black;">Adruino</h3>
					<hr>
					<p class="buttonClass">
						<a href="#">Phụ Kiện Adruino</a>
					</p>
					<hr>
				</div>
				<div class="4">
					<p class="buttonClass">
						<a href="#"> Adruino Board</a>
					</p>
				</div>
				<hr>
				<!--IOT - INTERNET OF THINGS<-->
				<div class="5">
					<h4 style="color: black;">IOT - INTERNET OF THINGS</h4>
					<hr>
					<p class="buttonClass">
						<a href="#">Phần cứng IOT</a>
					</p>
					<hr>
				</div>
				<div class="6">
					<p class="buttonClass">
						<a href="#">Phụ Kiện IOT</a>
					</p>
				</div>

			</div>

			<div class="col">
				<div class="row">
					<c:forEach items="${productList}" var="product">
						<c:choose>
							<c:when test="${product.status=='1'}">
								<div class="col-md-6 col-lg-4 col-xl-3">
									<div id="product-1" class="single-product">
										<div class="part-1">
											<a href="register.html"><img style="width: 130%"
												src="<c:url value='/resources/img/${product.productImage}'/>"
												alt="" /></a>
											<ul>
												<li><a href="trang-chu/${product.productId}"><i
														class="fas fa-shopping-cart"></i></a></li>
												<li><a href="#"><i class="fas fa-heart"></i></a></li>
												<li><a href="#"><i class="fas fa-plus"></i></a></li>
												<li><a href="#"><i class="fas fa-expand"></i></a></li>
											</ul>
										</div>
										<div class="part-2">
											<h3 class="product-title">${product.productName}</h3>
											<h4 class="product-old-price">Gia:</h4>
											<h4 class="product-price">${product.listPrice}</h4>
										</div>
									</div>
								</div>
							</c:when>
						</c:choose>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>
