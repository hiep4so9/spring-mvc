<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="mt-5"></div>
<div class="mt-5"></div>

<div class="mt-5"></div>

<div class="mt-5"></div>
<div class="mt-5"></div>
	
<div class="container-fluid">
	<div class="row px-5">
		<div class="col-md-7">
			<div class="shopping-cart">
				<h5>Giỏ Hàng</h5>
				<hr>
			</div>

			<c:forEach items="${list}" var="product">
				<div class="row border-top border-bottom">
					<div class="row main align-items-center">
						<div class="col-2">
							<img class="img-fluid"
								src="<c:url value='/resources/img/${product.productImage}'/>">
						</div>
						<div class="col">
							<div class="row text-muted">${product.productName}</div>
							<div class="row">Cotton T-shirt</div>
						</div>
						<div class="col">
							<input type="number" value="1" min="1" onchange="updateTotal()" />
						</div>
						<div class="col">
							&euro; ${product.listPrice} <span class="close">&#10005;</span>
						</div>
					</div>
				</div>
			</c:forEach>

			<div class="row">
				<div class="col text-right">
					<strong>Tổng tiền:</strong> <span id="totalPrice">&euro; 0</span>
				</div>
			</div>

		</div>

		<div class="col-md-4 offset-md-1 border rounded mt-5 bg-white h-25">
			<div class="pt-4">
				<h6>Thanh Toán</h6>
				<hr>
				<div class="row price-details">
					<div class="col-md-6">
						<div>
							<h6>Số lượng (Item)</h6>
						</div>
						<hr>
						<div>
							<h6>Phí Vận Chuyển</h6>
						</div>
						<hr>
						<div>
							<h6>Tổng tiền</h6>
						</div>
						<hr>
						<div>
							<h6>Chọn Địa chỉ</h6>
						</div>
					</div>
					<div class="col-md-6">
						<div>
							<h6>Số lượng (Item) ở đây</h6>
						</div>
						<hr>
						<div>
							<h6>FREE</h6>
						</div>
						<hr>
						<div>
							<h6>Tổng tiền ở đây</h6>
						</div>
						<hr>
						<div>
							<form>
								<select id="country" name="country">
									<option value="An Giang">An Giang
									<option value="Bà Rịa - Vũng Tàu">Bà Rịa - Vũng Tàu
									<option value="Bắc Giang">Bắc Giang
									<option value="Bắc Kạn">Bắc Kạn
									<option value="Bạc Liêu">Bạc Liêu
									<option value="Bắc Ninh">Bắc Ninh
									<option value="Bến Tre">Bến Tre
									<option value="Bình Định">Bình Định
									<option value="Bình Dương">Bình Dương
									<option value="Bình Phước">Bình Phước
									<option value="Bình Thuận">Bình Thuận
									<option value="Bình Thuận">Bình Thuận
									<option value="Cà Mau">Cà Mau
									<option value="Cao Bằng">Cao Bằng
									<option value="Đắk Lắk">Đắk Lắk
									<option value="Đắk Nông">Đắk Nông
									<option value="Điện Biên">Điện Biên
									<option value="Đồng Nai">Đồng Nai
									<option value="Đồng Tháp">Đồng Tháp
									<option value="Đồng Tháp">Đồng Tháp
									<option value="Gia Lai">Gia Lai
									<option value="Hà Giang">Hà Giang
									<option value="Hà Nam">Hà Nam
									<option value="Hà Tĩnh">Hà Tĩnh
									<option value="Hải Dương">Hải Dương
									<option value="Hậu Giang">Hậu Giang
									<option value="Hòa Bình">Hòa Bình
									<option value="Hưng Yên">Hưng Yên
									<option value="Khánh Hòa">Khánh Hòa
									<option value="Kiên Giang">Kiên Giang
									<option value="Kon Tum">Kon Tum
									<option value="Lai Châu">Lai Châu
									<option value="Lâm Đồng">Lâm Đồng
									<option value="Lạng Sơn">Lạng Sơn
									<option value="Lào Cai">Lào Cai
									<option value="Long An">Long An
									<option value="Nam Định">Nam Định
									<option value="Nghệ An">Nghệ An
									<option value="Ninh Bình">Ninh Bình
									<option value="Ninh Thuận">Ninh Thuận
									<option value="Phú Thọ">Phú Thọ
									<option value="Quảng Bình">Quảng Bình
									<option value="Quảng Bình">Quảng Bình
									<option value="Quảng Ngãi">Quảng Ngãi
									<option value="Quảng Ninh">Quảng Ninh
									<option value="Quảng Trị">Quảng Trị
									<option value="Sóc Trăng">Sóc Trăng
									<option value="Sơn La">Sơn La
									<option value="Tây Ninh">Tây Ninh
									<option value="Thái Bình">Thái Bình
									<option value="Thái Nguyên">Thái Nguyên
									<option value="Thanh Hóa">Thanh Hóa
									<option value="Thừa Thiên Huế">Thừa Thiên Huế
									<option value="Tiền Giang">Tiền Giang
									<option value="Trà Vinh">Trà Vinh
									<option value="Tuyên Quang">Tuyên Quang
									<option value="Vĩnh Long">Vĩnh Long
									<option value="Vĩnh Phúc">Vĩnh Phúc
									<option value="Yên Bái">Yên Bái
									<option value="Phú Yên">Phú Yên
									<option value="Tp.Cần Thơ">Tp.Cần Thơ
									<option value="Tp.Đà Nẵng">Tp.Đà Nẵng
									<option value="Tp.Hải Phòng">Tp.Hải Phòng
									<option value="Tp.Hà Nội">Tp.Hà Nội
									<option value="TP  HCM">TP HCM
								</select>
							</form>
						</div>
					</div>
				</div>

			</div>

		</div>
	</div>
	<div class="container-fluid"
		style="position: absolute; margin-top: -15px; right: 400px; left: 990px; width: 30%;">
		<div class="btnMove">
			<div class="btnReload">
				Làm Mới
				<div></div>
			</div>
		</div>
	</div>
</div>


	<!-- Bootstrap JS -->
	<script>
		function updateTotal() {
			var totalPrice = 0;
			var inputs = document.querySelectorAll('input[type="number"]');
			inputs.forEach(function(input) {
				var quantity = input.value;
				var price = input.parentElement.nextElementSibling.textContent
						.replace(/\D/g, '');
				totalPrice += quantity * price;
			});
			document.getElementById("totalPrice").innerHTML = "&euro; "
					+ totalPrice;
		}
	</script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>