<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<div class="container">
	<div class="row d-flex justify-content-center">
		<div class="col">


			<div class="card">
				<div class="card-header">
					<i class="fas fa-table"></i> Quản lý hóa đơn
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<a class="btn btn-primary" href="/spring-mvc/addBill" role="button">Thêm</a>
						<table id="table-product"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
									<th>Id</th>
									<th>Ngày đặt hàng</th>
									<th>Tổng tiền</th>
									<th>Trạng thái</th>
									<th>Ngày tạo</th>
									<th>Mã khách hàng</th>
									<th>diachi</th>
									<th>Action</th>
								</tr>
							</thead>
							
							<tbody>
								<c:forEach items="${billList}" var="bill">
								<% System.out.println( "billList= " + 
                     pageContext.findAttribute("billList") ); %>
									<tr>
										<td>${bill.bill_id}</td>
										<td>${bill.date_order}</td>
										<td>${bill.total}</td>
										<td>${bill.status}</td>
										<td>${bill.create_at}</td>
<%-- 										<td>${bill.Id_customer}</td> --%>
										<td>${bill.id_customer}</td>
										<td>${bill.diachi}</td>
										<form method="post" action="">
										<td><input  type="hidden" name="id" value="${bill.bill_id}"></td>
										<!-- <th>Type user</th> -->
										<td><button type="submit">Gửi Hàng</button></td>
											</form>
											<form method="post" action="/spring-mvc/quanlydondathangg">
											<td><input  type="hidden" name="id" value="${bill.bill_id}"></td>
										<td><button type="submit">Hoàn Thành</button></td>
										</form>
										
										</tr>
								</c:forEach>
							</tbody>
						
						</table>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		setTimeout(function() {
			$("table").DataTable({
				rowReorder : {
					selector : "td:nth-child(2)",
				},
				responsive : true,
			});
		}, 500);
	});
</script>
