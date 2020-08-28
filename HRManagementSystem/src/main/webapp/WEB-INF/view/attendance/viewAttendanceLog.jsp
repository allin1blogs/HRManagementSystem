<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="../header.jsp" />
<div class="container">
	<div class="row">
		<div class="taxStyle" style="display: block" id="summary">
			<h4>Summary</h4>


			<div class="col-md-12">
				<div class="row">
					<h4>Employee Salary Revision</h4>
					<div class="col-sm-6">
						<div class="row">
							<div class="col-sm-4">
								<h3 style="margin-left: 44px;">Timesheet</h3>
							</div>
							<div class="col-sm-4">
								<form action="/attendance/uploadAttendance" id="uploadForm"
									enctype="multipart/form-data" method="post">
									<ul style="border: none; margin-left: -27px;">
										<li><label class="btn btn-danger"><i
												class="fa fa-upload"></i> <input type="file"
												style="display: none;" name="csv" accept=".csv" required>
										</label></li>
										<li><input type="submit" class="btn btn-primary"
											style="background-color: white; color: black; border-color: black;"
											value="Import"></li>
									</ul>
								</form>
							</div>
							<div class="col-sm-4">
								<form action="/attendance/uploadAttendance" id="uploadForm"
									 method="post">
									<ul style="border: none; margin-left: -27px;">
										<li><label class="btn btn-success"><i
												class="fa fa-upload fa-rotate-180"
												style="padding-bottom: 9px;"></i> </label></li>
										<li><input type="button" class="btn btn-primary"
											style="background-color: white; color: black; border-color: black;"
											onclick="exportTimeSheetForm()" value="Export"></li>
									</ul>
								</form>
							</div>
						</div>
					</div>
					<div id="searchBar" class="col-sm-6">
						<h5>Search</h5>
						<input class="form-control" type="text" placeholder="Search..">
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div id="allData">
					<div class="table-responsive">
						<table id="" class="table table-bordred table-striped">

							<thead>

								<th><input type="checkbox" id="checkall" /></th>
								<th>Employee Id</th>
								<th>Project Id</th>
								<th>Manager Id</th>
								<th>Date</th>
								<th>Working Hours</th>
								<th>Over Time</th>
								<th>Edit</th>
								<th>Delete</th>
							</thead>
							<tbody id="salaryRevisionTable">
								<c:forEach items="${records}" var="record">
									<tr>
										<td><input type="checkbox" name="snos"
											value="${record.attendanceId}"></td>
										<c:if test="${record.employeeId!=' '}">
											<td id="employeeId" value="${record.employeeId}">${record.employeeId}<p
													window.onload="employeeInfo('${record.employeeId}')"></p></td>
										</c:if>
										<td>${record.projectId}</td>
										<td>${record.managerId}</td>
										<td>${record.date}</td>
										<td>${record.workingHours}</td>
										<td>${record.overTime}</td>
										<td><a href="#" onclick="" style="text-decoration: none;">Edit</a>&nbsp;&nbsp;
										</td>
										<td><a href="#" onclick="" style="text-decoration: none;">Delete</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>

						</table>

						<div class="clearfix"></div>
						<ul class="pagination pull-right">
							<li class="disabled"><a href="#"><span
									class="glyphicon glyphicon-chevron-left"></span></a></li>
							<li class="active"><a href="#">1</a></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#"><span
									class="glyphicon glyphicon-chevron-right"></span></a></li>
						</ul>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
 <!-- Start Export Form -->
<div class="form-popup" id="myForm">
  <form class="form-horizontal" action="/attendance/exportData" th:action="@{exportData}"
							method="GET" th:object="${timesheet}">
    <h4>Select Date Range</h4>

    <label for="fromDate"><b>From</b></label>
   <input type="date" name="fromDate" th:field="*{fromDate}" /><br />

    <label for="toDate"><b>To</b></label>
    <input type="date" name="toDate" th:field="*{toDate}" /><br />

    <button type="submit" class="btn">Export</button>
    <button type="button" class="btn cancel" onclick="closeForm()">Close</button>
  </form>
</div>
<!-- End Export Form -->
</body>
</html>