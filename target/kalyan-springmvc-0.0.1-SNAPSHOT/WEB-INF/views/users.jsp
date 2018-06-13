<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<table class="table table-striped">
		<caption><spring:message code="users.caption" /></caption>
		<thead>
			<tr>
				<th>username</th>
				<th>create Date</th>
				<th>email</th>
				<th>password</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.username}</td>
					<td>${user.createtime}</td>
					<td>${user.email}</td>
					<td>${user.password}</td>
					<td><a type="button" class="btn btn-info" href="/useraddress/page?addrid=${user.userid}">Address</a>
						<a type="button" class="btn btn-primary" href="/users/update-user?id=${user.userid}">Edit</a> 	
						<a type="button" class="btn btn-warning" href="/users/delete-user?id=${user.userid}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		 <a type="button" class="btn btn-success" href="/users/add-user">Add user</a>    
	</div>
	<div>${message} </div>
</div>
<style>
$( function() {
    $( "#datepicker" ).datepicker({ dateFormat: 'dd/mm/yy' });
     } );	 
	 
</style>

<%@ include file="common/footer.jspf"%>