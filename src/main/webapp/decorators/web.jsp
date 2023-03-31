<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="/common/taglib.jsp" %>
		<!DOCTYPE html>
		<html lang="en">
 
		<head>
	<meta charset="UTF-8">
	<title>CodePen - Popular Products Section Using HTML , CSS , Bootstrap</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css'>

	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/trangchu.css">
</head>

<body>

<jsp:include page="/common/web/headerr.jsp"/>
				<!-- Header End====================================================================== -->

	  <div class="banner">
		<img class="home-inner" alt="" src="${pageContext.request.contextPath}/resources/public/6260298.jpg" style="width: 100%; height: 500px; display: flex; justify-items: center;" />
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
							<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
						</form>
					</div>
					<hr>
					<br>
					<!--Filter Theo Gia-->
					<div class="2">
						<form class="d-flex">
							<div class="form-group" style="width: 100%;">
								<label for="sel1">Giá:</label>
								<select class="form-control" id="sel1">
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
				
						<!-- Single Product -->
						<div class="col-md-6 col-lg-4 col-xl-3">
							<div id="product-1" class="single-product">
								<div class="part-1">
								<a href="register.html"><img style="width: 130%"
											src="<c:url value='/resources/img/${product.productImage}'/>" alt="" /></a>
									<ul>
										<li><a href="trang-chu/${product.productId}"><i class="fas fa-shopping-cart"></i></a></li>
										<li><a href="#"><i class="fas fa-heart"></i></a></li>
										<li><a href="#"><i class="fas fa-plus"></i></a></li>
										<li><a href="#"><i class="fas fa-expand"></i></a></li>
									</ul>
								</div>
								<div class="part-2">
									<h3 class="product-title">${product.productName}</h3>
									<h4 class="product-old-price">Gia: </h4>
									<h4 class="product-price">${product.listPrice}</h4>
								</div>
							</div>
						</div>
					
						</c:forEach>
					


					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	      <%@ include file="/common/web/footer.jsp" %>
	
	<!-- partial -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>

		</html>