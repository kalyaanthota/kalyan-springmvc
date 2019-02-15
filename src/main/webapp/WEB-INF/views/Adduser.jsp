<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<form:form method="post" action="/users/saveOrUpdate" commandName="user">
		<form:hidden path="userid" />
		<fieldset class="form-group">
			<form:label path="username">user name</form:label>
			<form:input path="username" type="text" class="form-control"
				required="required" />
			<form:errors path="username" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="password">password</form:label>
			<form:input path="password" type="text" class="form-control"
				required="required" />
			<form:errors path="password" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="createtime">create time</form:label>
			<!-- <form:input path="createtime" type="text" class="form-control"   />  -->
			<form:input path="createtime"  type="text" class="form-control" id="datepicker" />
			<form:errors path="createtime" cssClass="text-warning" />
		</fieldset>
		
		<fieldset class="form-group">
			<form:label path="email">email</form:label>
			<form:input path="email" type="text" class="form-control"
				required="required" />
			<form:errors path="email" cssClass="text-warning" />
		</fieldset>
		<button type="submit" class="btn btn-success">Submit</button>
	</form:form>
</div>
  
<style>
$( function() {
    $( "#datepicker" ).datepicker({ dateFormat: 'dd/mm/yy' });
     } );	 
	 
</style>    
<%@ include file="common/footer.jspf"%>

