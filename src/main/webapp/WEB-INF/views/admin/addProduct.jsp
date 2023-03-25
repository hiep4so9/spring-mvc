<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!doctype html>
	<html lang="en">

	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">

		<!-- Bootstrap CSS -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/dangky.css">
		<link rel="stylesheet"
			href="https://fonts.googleapis.com/css2?family=Open Sans:wght@400;600;700&display=swap" />

	</head>

	<body>
		<div class="container mt-5">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="form-box">
						<div class="form-content">
							<h1>Thêm sản phẩm</h1>
							<form action="/spring-mvc/addproduct" name="addProduct" method="POST"
								enctype="multipart/form-data">
								Tên sản phẩm: <input type="text" name="productname"> Giá:
								<input type="text" name="listprice">
								Thể loại:
								<select name="categoryID">
									<option value="1">1</option>
								</select>
								<div>
									<label for="file1">File:</label>
									<input type="file" id="file" name="file1" onchange="previewImage1(event)">
									<img id="preview1" src="#" alt="Preview Image"
										style="display:none; max-width: 200px; max-height: 200px;">
									<c:if test="${not empty message}">
										<div class="alert alert-danger">${message}</div>
									</c:if>
								</div>
								<div>
									<label for="file2">File:</label>
									<input type="file" id="file" name="file2" onchange="previewImage2(event)">
									<img id="preview2" src="#" alt="Preview Image"
										style="display:none; max-width: 200px; max-height: 200px;">
									<c:if test="${not empty message}">
										<div class="alert alert-danger">${message}</div>
									</c:if>
								</div>
								<div>
									<label for="file3">File:</label>
									<input type="file" id="file" name="file3" onchange="previewImage3(event)">
									<img id="preview3" src="#" alt="Preview Image"
										style="display:none; max-width: 200px; max-height: 200px;">
									<c:if test="${not empty message}">
										<div class="alert alert-danger">${message}</div>
									</c:if>
								</div>
								<input type="submit" value="submit">
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script>
			function previewImage1(event) {
				var reader = new FileReader();
				reader.onload = function () {
					var preview = document.getElementById('preview1');
					preview.src = reader.result;
					preview.style.display = 'block';
				}
				reader.readAsDataURL(event.target.files[0]);
			}
			function previewImage2(event) {
				var reader = new FileReader();
				reader.onload = function () {
					var preview = document.getElementById('preview2');
					preview.src = reader.result;
					preview.style.display = 'block';
				}
				reader.readAsDataURL(event.target.files[0]);
			}
			function previewImage3(event) {
				var reader = new FileReader();
				reader.onload = function () {
					var preview = document.getElementById('preview3');
					preview.src = reader.result;
					preview.style.display = 'block';
				}
				reader.readAsDataURL(event.target.files[0]);
			}
		</script>

		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous">


			</script>


	</body>

	</html>