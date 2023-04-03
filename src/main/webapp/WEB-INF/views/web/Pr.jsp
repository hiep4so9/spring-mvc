<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Shop Home Page</title>
    <!-- Load jQuery from a CDN -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <!-- Custom CSS -->
     <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/Pr.css">
  </head>
  <body>
  
<div class="container">
  <div class="main">
      <div class="row">
          <div class="col-md-4 mt-1 ">
              <div class="card text-center sidebar">
                  <div class="card-body">
                      <img src="./public/profile_svg.svg" alt="rounded-circle" width="150">
                      <div class="mt-3">
                          <h3>Tên Đăng Nhập</h3>
                          <button class="btncss">Đổi Mật Khẩu</button>
                      </div>
                  </div>
              </div>
          </div>
          <div class="col-md-8 mt-1">
              <div class="card mb-3 content">
                <div class="hoverbtn">
                <p class="btnSua"><b>Sửa</b><p>
                </div>
                  <h1 class="m-3 pt-3">About</h1>
                  <div class="card-body">
                      <div class="row">
                          <div class="col-md-3">
                              <h5>FullName</h5>
                          </div>
                          <div class="col-md-9 text-secondary">
                              ${fullname}
                          </div>
                      </div>
                      <hr>
                      <div class="row">
                          <div class="col-md-3">
                              <h5>Email</h5>
                          </div>
                          <div class="col-md-9 text-secondary">
                            ${email}
                          </div>
                      </div>
                      <hr>
                      <div class="row">
                          <div class="col-md-3">
                              <h5>Passwork</h5>
                          </div>
                          <div class="col-md-9 text-secondary">
                             ${pass}
                          </div>
                      </div>
                    
                  </div>
              </div>
          </div>
      </div>
  </div>
</div>



    <!-- Bootstrap JS -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</html>
    