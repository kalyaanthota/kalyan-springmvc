   <%@ include file="common/header.jspf"%>  
<body style="background-image:url(../images/Black-Background.jpg);" >
    
    
    <div class="container" > 
<div id="infobox" style="margin-top:50px;" class=" col-md-8  ">                    
            <div class="panel panel-default transparent" >
                    <div class="panel-heading">
                        <div class="panel-title">Design & Developed by:</div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body " >

                      <div class="jumbotron">
  <h1 class="display-4">Kalyan Thota.</h1>
  <p class="lead">I am Enginner, Software { Developer, Designer, Architect }.</p>
  <hr class="my-4">
  <p><h6> This application is powered by: </h6>
  <p>
  <img border="0" src="/images/bootstrap.png" alt="java" width="70" height="50" />
  <img border="0" src="/images/AngularJS-large.png" alt="java" width="70" height="50" />
  <img border="0" src="/images/html-icon.png" alt="java" width="70" height="50" />
  <img border="0" src="/images/java_logo.png" alt="java" width="70" height="50" />
  <img border="0" src="/images/JSP.png" alt="java" width="70" height="50" />
  <img border="0" src="/images/spring_framework.png" alt="java" width="70" height="50" />
  <img border="0" src="/images/java-jdbc.png" alt="java" width="70" height="50" />
  <img border="0" src="/images/hibernate.png" alt="java" width="70" height="50" /> 
  <img border="0" src="/images/development.png" alt="java" width="70" height="50" />
  </p>
 
</div>
                        </div>                     
                    </div>  
        </div>
     
       
        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-4">                    
            <div class="panel panel-info" >
                    <div class="panel-heading">
                        <div class="panel-title">Sign In</div>
                        <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#">Forgot password?</a></div>
                    </div>     

                    <div style="padding-top:30px" class="panel-body" >

                        <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
                            
                        <form id="loginform" class="form-horizontal" role="form"  action='/loginpage' method='POST'>
                                    
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                                        <input id="username" type="text" class="form-control" name="username" value="asdf" placeholder="username or email">                                        
                                    </div>
                                
                            <div style="margin-bottom: 25px" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                                        <input id="password" type="password" class="form-control" name="password" value="asdf" placeholder="password">
                                    </div>
                                    

                                
                            <div class="input-group">
                                      <div class="checkbox">
                                        <label>
                                          <input id="login-remember" type="checkbox" name="remember" value="1"> Remember me
                                        </label>
                                      </div>
                                    </div>


                                <div style="margin-top:10px" class="form-group">
                                    <!-- Button -->

                                    <div class="col-sm-12 controls">
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <input name="submit" type="submit" value="Login" class="btn btn-success"/>
                                      
                                      <a id="btn-fblogin" href="www.facebook.com" class="btn btn-primary">Login with Facebook</a>

                                    </div>
                                </div>


                                <div class="form-group">
                                    <div class="col-md-12 control">
                                        <div style="border-top: 1px solid#888; padding-top:15px; font-size:85%" >
                                            <i class="text-warning" >Don't have an account!   </i> 
                                        <a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                            Sign Up Here
                                        </a>
                                        </div>
                                    </div>
                                </div>    
                            </form>     



                        </div>                     
                    </div>  
        </div>
        <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-4">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">Sign Up</div>
                            <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#" onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign In</a></div>
                        </div>  
                        <div class="panel-body" >
                            <form id="signupform" class="form-horizontal" role="form">
                                
                                <div id="signupalert" style="display:none" class="alert alert-danger">
                                    <p>Error:</p>
                                    <span></span>
                                </div>
                                    
                                <div class="form-group">
                                    <label for="email" class="col-md-3 control-label">Email</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="email" placeholder="Email Address">
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label for="firstname" class="col-md-3 control-label">First Name</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="firstname" placeholder="First Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="lastname" class="col-md-3 control-label">Last Name</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="lastname" placeholder="Last Name">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="col-md-3 control-label">Password</label>
                                    <div class="col-md-9">
                                        <input type="password" class="form-control" name="passwd" placeholder="Password">
                                    </div>
                                </div>
                                    
                                <div class="form-group">
                                    <label for="icode" class="col-md-3 control-label">Invitation Code</label>
                                    <div class="col-md-9">
                                        <input type="text" class="form-control" name="icode" placeholder="">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <!-- Button -->                                        
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-signup" type="button" class="btn btn-info"><i class="icon-hand-right"></i> Sign Up</button>
                                        <span style="margin-left:8px;"></span>  
                                    </div>
                                </div>
                                
                                <div style="border-top: 1px solid #999; padding-top:20px"  class="form-group">
                                    
                                    <div class="col-md-offset-3 col-md-9">
                                        <button id="btn-fbsignup" type="button" class="btn btn-primary"><i class="icon-facebook"></i>   Sign Up with Facebook</button>
                                    </div>                                           
                                        
                                </div>
                               
                            </form>
                         </div>
                    </div>
			</div> 
    </div>
 </body>   
