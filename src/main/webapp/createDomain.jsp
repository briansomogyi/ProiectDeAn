<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Create New Domain</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/adminlte.min.css">
</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">
		<!-- Navbar -->
		<nav
			class="main-header navbar navbar-expand navbar-white navbar-light">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
					href="#" role="button"><i class="fas fa-bars"></i></a></li>
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/domains" class="nav-link">Home</a>
				</li>
			</ul>
		</nav>
		<!-- /.navbar -->

		<!-- Sidebar -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<a href="${pageContext.request.contextPath}/domains" class="brand-link">
				<img
				src="${pageContext.request.contextPath}/resources/img/AdminLTELogo.png"
				alt="Logo" class="brand-image img-circle elevation-3"> <span
				class="brand-text font-weight-light">Domains App</span>
			</a>
		</aside>
		<!-- /.sidebar -->

		<!-- Content Wrapper -->
		<div class="content-wrapper">
			<!-- Content Header -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>Create New Domain</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a
									href="${pageContext.request.contextPath}/domains">Home</a></li>
								<li class="breadcrumb-item active">Create New Domain</li>
							</ol>
						</div>
					</div>
				</div>
			</section>
			<!-- Main Content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-8 offset-md-2">
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">New Domain Details</h3>
								</div>
								<form:form method="post"
									action="${pageContext.request.contextPath}/domains/saveNewDomain"
									modelAttribute="newDomain">
									<div class="card-body">
										<div class="form-group">
											<label for="domainName">Domain name</label>
											<form:input path="domainName" class="form-control" />
										</div>
									</div>
									<div class="card-footer text-center">
										<button type="submit" class="btn btn-success">
											<i class="fas fa-save"></i> Save Domain
										</button>
										<a href="${pageContext.request.contextPath}/domains"
											class="btn btn-secondary"><i class="fas fa-arrow-left"></i>
											Cancel</a>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
		<!-- /.content-wrapper -->

		<!-- Footer -->
		<footer class="main-footer">
			<div class="float-right d-none d-sm-inline">Domain Create Page</div>
			<strong>Copyright &copy; 2024 <a href="#">Your Company</a>.
			</strong> All rights reserved.
		</footer>
	</div>
	<!-- ./wrapper -->

	<!-- Scripts -->
	<script
		src="${pageContext.request.contextPath}/resources/plugins/jquery/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/adminlte.min.js"></script>
</body>
</html>