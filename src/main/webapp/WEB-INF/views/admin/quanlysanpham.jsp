<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

		<div class="container">
			<div class="row d-flex justify-content-center">
				<div class="col-12 card">
					<div class="card-header">
						<i class="fas fa-table"></i> Quản lý sản phẩm
					</div>
					<div class="card-body">
						<a class="btn btn-primary" href="/spring-mvc/addproduct" role="button">Thêm</a> <a
							class="btn btn-danger" role="button" onclick=" myFunction()">Xoá</a>
							<table style="width: 100%" id="table-product"
								class="table table-striped table-bordered table-hover ">
								<thead class="thead-dark">
									<tr>
										<th></th>
										<th>Id</th>
										<th>Name</th>
										<th>Price</th>
										<th>Category</th>
										<th>Status</th>
										<th>IMG</th>
										<th>Action</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${productList}" var="product">
										<tr>
											<td><input type="checkbox" name="id[]" value="${product.productId}" id="">
											</td>
											<td>${product.productId}</td>
											<td>${product.productName}</td>
											<td>${product.listPrice}</td>
											<td>${productDAO.getNameById(product.productId)}</td>
											<c:choose>
												<c:when test="${product.status == '1'}">
													<td><span class="badge badge-success">Đang bán</span>
													</td>
													<br />
												</c:when>
												<c:otherwise>
													<td><span class="badge badge-danger">Không bán</span>
														<br />
												</c:otherwise>
											</c:choose>
											<td><img width="40" height="40"
													src="<c:url value='/resources/images/${product.productImage}'/>"
													alt=""></td>
											<th>
												
												<a href="/spring-mvc/editproduct?id=${product.productId}" class="btn btn-success btn-lg active" role="button" aria-pressed="true"><i class="fas fa-edit"></i>
													</a>
												
											</th>
										</tr>
									</c:forEach>
								</tbody>
							</table>
					</div>

				</div>

			</div>
		</div>
		<script>
			// Sử dụng AJAX để gửi dữ liệu lên server

			function myFunction() {
				var selectedValues = [];

				$("input:checkbox[name^='id[]']:checked").each(function () {
					selectedValues.push($(this).val());
					console.log(1);
				});

				// Tạo một object JSON để gửi lên server

				$.ajax({
					type: "POST",
					url: "/spring-mvc/delete-product",
					data: JSON.stringify({
						selectedValues
					}),
					contentType: "application/json; charset=utf-8",
					dataType: "json",
					success: function (response) {
						var table = $('.table').DataTable();
						var selectedRows = $("input:checkbox[name^='id[]']:checked");
						// Lặp qua từng checkbox được chọn
						selectedRows.each(function () {
							// Lấy thẻ <tr> chứa checkbox hiện tại
							var row = $(this).closest("tr");
							// Xoá dòng <tr> khỏi DataTable
							table.row(row).remove().draw();
						});
					},
					error: function (xhr, status, error) {
						console.log(error);
					}
				});
			}
			$(document).ready(function () {
				$('.table').DataTable({
					responsive: true,
					
					select: {
						style: 'os',
						selector: 'td:first-child'
					},
					order: [[1, 'asc']]
				});
			}
			)
		</script>