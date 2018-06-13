<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<form:form method="post" action="/useraddress/saveOrUpdate" commandName="useraddress">
		<form:hidden path="addrid" />
		<form:hidden path="userid" />
		<fieldset class="form-group">
			<form:label path="lane">Lane</form:label>
			<form:input path="lane" type="text" class="form-control"/>
			<form:errors path="lane" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="city">City</form:label>
			<form:input path="city" type="text" class="form-control"/>
			<form:errors path="city" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="state">State</form:label>
			<form:input path="state" type="text" class="form-control"
				/>
			<form:errors path="state" cssClass="text-warning" />
		</fieldset>
		<fieldset class="form-group">
			<form:label path="pincode">Pincode</form:label>
			<form:input path="pincode"  class="form-control"
				required="required" />
			<form:errors path="pincode" cssClass="text-warning" />
		</fieldset>
		<button type="submit" class="btn btn-success">Submit</button>
	</form:form>
</div>

<%@ include file="common/footer.jspf"%>

