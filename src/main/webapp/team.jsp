<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Team Details</title>

<!-- Google Font: Source Sans Pro -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/fontawesome-free/css/all.min.css">
<!-- DataTables -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/datatables-bs4/css/dataTables.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/datatables-responsive/css/responsive.bootstrap4.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/plugins/datatables-buttons/css/buttons.bootstrap4.min.css">
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
					href="${pageContext.request.contextPath}/teams" class="nav-link">Home</a>
				</li>
			</ul>
		</nav>
		<!-- /.navbar -->

		<!-- Sidebar -->
		<aside class="main-sidebar sidebar-dark-primary elevation-4">
			<a href="${pageContext.request.contextPath}/teams" class="brand-link">
				<img
				src="${pageContext.request.contextPath}/resources/img/AdminLTELogo.png"
				alt="Logo" class="brand-image img-circle elevation-3"> <span
				class="brand-text font-weight-light">Teams App</span>
			</a>
		</aside>
		<!-- /.navbar -->

		<!-- Content Wrapper -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>Team Details</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Team Details</li>
							</ol>
						</div>
					</div>
				</div>
			</section>
			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-6 offset-md-3">
							<!-- Team Card -->
							<div class="card card-primary">
								<div class="card-header">
									<h3 class="card-title">Team Information</h3>
								</div>
								<div class="card-body">
									<strong><i class="fas fa-signature mr-1"></i> Team
										name</strong>
									<p class="text-muted">
										<c:out value="${team.teamName}" />
									</p>
								</div>
								<!-- /.card-body -->
							</div>
							<!-- /.card -->

							<!-- Back Button -->
							<div class="text-center">
								<a href="teams" class="btn btn-secondary"> <i
									class="fas fa-arrow-left"></i> Back to List
								</a>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Footer -->
		<footer class="main-footer">
			<div class="float-right d-none d-sm-inline">Team Details Page</div>
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
		src="${pageContext.request.contextPath}/resources/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/plugins/datatables-responsive/js/dataTables.responsive.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/plugins/datatables-responsive/js/responsive.bootstrap4.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/adminlte.min.js"></script>

	<!-- Scripts -->
</body>
</html>