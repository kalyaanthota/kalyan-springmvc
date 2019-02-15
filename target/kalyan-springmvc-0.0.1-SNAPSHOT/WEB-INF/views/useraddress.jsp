<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>



<div class="pull-right ">

<h2>
        <a href="/users/page" style="margin-right: 20px;" class="btn btn-info btn-rounded btn-md">USERS</a>
    </h2>
</div>

<div class="container clearfix">
	<table class="table table-striped">
		<caption><spring:message code="useraddress.caption" /></caption>
		<thead>
			<tr>
				<th>username</th>
				<th>create Date</th>
				<th>email</th>
				<th>password</th>
			</tr>
		</thead>
		<tbody>
				<tr>
					<td>${user.username}</td>
					<td>${user.createtime}</td>
					<td>${user.email}</td>
					<td>${user.password}</td>
				</tr>
		</tbody>
	</table>
	
	
	<div align="right">
		 <a type="button" class="btn btn-success" href="/useraddress/add-useraddress?userid=${user.userid}">Add user address</a>    
	</div>
	
	<hr>
<div class="clearfix"></div>
	<div id="tabs">
  <ul>
 <c:forEach items="${useraddress}" var="addr">	
    <li><a href="#tabs-${addr.addrid}">${addr.addrid},${addr.city}</a></li>
    </c:forEach>  
  </ul>
<c:forEach items="${useraddress}" var="addr">	
  <div id="tabs-${addr.addrid}">
   
			<table class="table table-striped">
					<thead>
						<tr>
							<th>lane</th>
							<th>city</th>
							<th>state</th>
							<th>pincode</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${addr.lane}</td>
							<td>${addr.city}</td>
							<td>${addr.state}</td>
							<td>${addr.pincode}</td>
						</tr>
					</tbody>
				</table>
				<table class="table table-dark"><tr><td align="right">
						<a type="button" style="margin-right: 10px;" class="btn btn-primary btn-rounded btn-sm"  href="/useraddress/update-useraddress?addrid=${addr.addrid}">Edit</a> 	
						<a type="button" style="margin-right: 10px;" class="btn btn-warning btn-rounded btn-sm" href="/useraddress/delete-useraddress?addrid=${addr.addrid}&userid=${addr.userid}">Delete</a>
					</td></tr></table>
  </div>
  </c:forEach> 
</div>
	
	<div>${message.message} </div>
</div>


  <script>
  $( function() {
    $( "#tabs" ).tabs({
     /*  event: "mouseover" */
    });
  } );
  
  </script>
<%@ include file="common/footer.jspf"%>