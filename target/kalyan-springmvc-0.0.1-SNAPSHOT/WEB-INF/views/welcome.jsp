<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<body style="background-image:url(../images/x.jpg);" >
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.8/angular.min.js"></script>
    	<script>
    	function Hello($scope, $http) {
    	    $http.get('http://localhost:8080/users/springcontent.json').
    	        success(function(data) {
    	            $scope.user = data;
	          });
    	}
    	</script>
<div class="container">
	<spring:message code="welcome.message" /> <kbd>${name}.</kbd>
</div>
<div class="clearfix"></div>
<div class="pull-right ">

<h2>
        <a href="users/page" style="margin-right: 50px;" class="btn btn-info btn-rounded btn-lg">Click to USERS</a>
    </h2>
</div>
<div class="container ">
	<div class="row">
       <div class="col-md-7 ">

<div class="panel panel-default transparent">
  <div class="panel-heading">  <h4 >User Profile :</h4></div>
   <div class="panel-body">
       
    <div class="box box-info" ng-app="" ng-controller="Hello">
        
            <div class="box-body">
                     <div class="col-sm-6 col-sm-6">
                     <div  align="center"> <img alt="User Pic" src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg" id="profile-image1" class="img-circle img-responsive"> 
                
                <input id="profile-image-upload" class="hidden" type="file">
			<div style="color:#999;" >click image to change profile image</div>
                <!--Upload Image Js And Css-->
                     </div>
              <br>
              <!-- /input-group -->
            </div>
            <div class="col-sm-6">
            <h3 style="color:#00b1b1;"><b>{{user.username}} </b></h3></span>
              <span><p>Aspirant</p></span>
              <hr style="margin:5px 0 5px 0; border-bottom:3px #696969 solid;">            
            <div class="bot-border"></div>
            <div class="col-sm-6 col-xs-3 tital " >User Name:</div><div class="col-sm-1 col-xs-2 " style="color:#00b1b1;">{{user.username}}</div>
            <div class="clearfix"></div>
            <div class="bot-border"></div>
            <div class="col-sm-6 col-xs-3 tital " >Password:</div><div class="col-sm-1 col-xs-2 " style="color:#00b1b1;">{{user.password}}</div>
            <div class="clearfix"></div>
            <div class="bot-border"></div>
            <div class="col-sm-6 col-xs-3 tital " >EMail Id:</div><div class="col-sm-1 col-xs-2 " style="color:#00b1b1;">{{user.email}}</div>
            <div class="clearfix"></div>
            <div class="bot-border"></div>
            <div class="col-sm-6 col-xs-3 tital " >Create Time:</div><div class="col-sm-1 col-xs-2 " style="color:#00b1b1;">{{user.createtime}}</div>
            <div class="clearfix"></div>
            <div class="bot-border"></div>
            <div class="col-sm-6 col-xs-3 tital " >User Id:</div><div class="col-sm-1 col-xs-2 " style="color:#00b1b1;">{{user.userid}}</div>
            <div class="clearfix"></div>
            <div class="bot-border"></div>
            <hr style="margin:5px 0 5px 0; border-bottom:3px #696969 solid;">
    </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
        </div>
    </div> 
    </div>
</div>


<%@ include file="common/footer.jspf"%>  
    <script>
              $(function() {
    $('#profile-image1').on('click', function() {
        $('#profile-image-upload').click();
    });
});       

