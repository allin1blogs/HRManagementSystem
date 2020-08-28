<jsp:include page="../header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="row">
		<div class="taxStyle" style="display: block" id="summary">
			<h4>Summary</h4>


			<div class="col-md-12">
				<h4>Employee Salary Revision</h4>
				<div id="searchBar">
					<h5>Search</h5>
					<input class="form-control" type="text" placeholder="Search..">
				</div>
				<div id="allData">
					<div class="table-responsive">
						<table id="" class="table table-bordred table-striped">

							<thead>

								<th><input type="checkbox" id="checkall" /></th>
								<th>Employee Id</th>
								<th>Employee Name</th>
								<th>Old CTC</th>
								<th>New CTC</th>
								<th>Effective Date</th>
								<th>Comment</th>
								<th>Edit</th>

								<th>Delete</th>
							</thead>
							<tbody id="salaryRevisionTable">
								<c:forEach items="${records}" var="record">
									<tr>
										<td><input type="checkbox" name="snos"
											value="${record.ctcHistoryId}"></td>
										<td>${record.employeeId}</td>
										<td>${record.name}</td>
										<td>${record.cTC}</td>
										<td>${record.newCtc}</td>
										<td>${record.incrementDate}</td>
										<td>${record.comments}</td>
										<td><a href="#" onclick="" style="text-decoration: none;">Edit</a>&nbsp;&nbsp;
										</td>
										<td><a href="#" onclick="" style="text-decoration: none;">Delete</a>
										</td>
									</tr>
								</c:forEach>
								<c:forEach items="${currentRecords}" var="currentRecord">
									<tr>
										<td><input type="checkbox" name="snos"
											value="${currentRecord.employeeCTCId}"></td>
										<td>${currentRecord.employeeId}</td>
										<td>${currentRecord.name}</td>
										<td>${currentRecord.cTC}</td>
										<td>${currentRecord.newCtc}</td>
										<td>${currentRecord.incrementDate}</td>
										<td>${currentRecord.comments}</td>
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


	<div class="modal fade" id="edit" tabindex="-1" role="dialog"
		aria-labelledby="edit" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</button>
					<h4 class="modal-title custom_align" id="Heading">Edit Your
						Detail</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<input class="form-control " type="text" placeholder="Mohsin">
					</div>
					<div class="form-group">

						<input class="form-control " type="text" placeholder="Irshad">
					</div>
					<div class="form-group">
						<textarea rows="2" class="form-control"
							placeholder="CB 106/107 Street # 11 Wah Cantt Islamabad Pakistan"></textarea>


					</div>
				</div>
				<div class="modal-footer ">
					<button type="button" class="btn btn-warning btn-lg"
						style="width: 100%;">
						<span class="glyphicon glyphicon-ok-sign"></span> Update
					</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>



	<div class="modal fade" id="delete" tabindex="-1" role="dialog"
		aria-labelledby="edit" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">
						<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
					</button>
					<h4 class="modal-title custom_align" id="Heading">Delete this
						entry</h4>
				</div>
				<div class="modal-body">

					<div class="alert alert-danger">
						<span class="glyphicon glyphicon-warning-sign"></span> Are you
						sure you want to delete this Record?
					</div>

				</div>
				<div class="modal-footer ">
					<button type="button" class="btn btn-success">
						<span class="glyphicon glyphicon-ok-sign"></span> Yes
					</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove"></span> No
					</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
</div>

</body>
</html>