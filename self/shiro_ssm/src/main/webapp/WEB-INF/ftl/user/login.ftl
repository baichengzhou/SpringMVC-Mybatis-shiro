
<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>登录</title>
        <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
        <link   rel="icon" href="http://img.wenyifan.net/images/favicon.ico" type="image/x-icon" />
		<link   rel="shortcut icon" href="http://img.wenyifan.net/images/favicon.ico" />
        <!-- CSS -->
        <link rel="stylesheet" href="http://open.sojson.com/itboy/js/itboy/app/reset.css">
        <link rel="stylesheet" href="http://open.sojson.com/itboy/js/itboy/app/supersized.css">
  

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://static.supportfolios.com/js/www/html5shiv.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container">
            <h1>Login</h1>
            <form id="_form" action="" method="post">
                <input type="text" name="account" class="username" placeholder="Account">
                <input type="password" name="password" class="password" placeholder="Password">
                <div style="text-align: left; margin-left: 10px;">
                <label><input type="checkbox" checked="checked"  id="rememberMe"style="width: 10px; height: 10px;">记住我</label>
                </div>
                <button type="button" id="login">登录</button>
                <button type="button" id="register" class="register">Register</button>
                
                <div class="error"><span>+</span></div>
            </form>
            <#--
            <div class="connect">
                <p>Or connect with:</p>
                <p>
                    <a class="facebook" href=""></a>
                    <a class="twitter" href=""></a>
                </p>
            </div>
            -->
        </div>

        <!-- Javascript -->
       <script  src="http://cdn.sojson.com/js/common/sojson.core.min.js"></script>
        <script src="http://open.sojson.com/common/MD5.js"></script>
        <script src="http://open.sojson.com/itboy/js/itboy/app/supersized.3.2.7.min.js"></script>
        <script src="http://open.sojson.com/itboy/js/itboy/app/supersized-init.js"></script>
		<script  src="${cdn}/js/layer/layer.js"></script>
        <link rel="stylesheet" href="http://open.sojson.com/itboy/js/itboy/app/style.css">
        <script >
			jQuery(document).ready(function() {
			
			
				document.onkeydown=function(event){
					var e = event || window.event || arguments.callee.caller.arguments[0];
					if(e && e.keyCode==13){ 
						$('#login').click();
					}
				}; 
			
			
			    $('#login').click(function(){
			    	
			        var username = $('.username').val();
			        var password = $('.password').val();
			        if(username == '') {
			            $('.error').fadeOut('fast', function(){
			                $('.error').css('top', '27px').show();
			            });
			            $('.error').fadeIn('fast', function(){
			                $('.username').focus();
			            });
			            return false;
			        }
			        if(password == '') {
			            $('.error').fadeOut('fast', function(){
			                $('.error').css('top', '96px').show();
			            });
			            $(this).find('.error').fadeIn('fast', function(){
			                $('.password').focus();
			            });
			            return false;
			        }
			        var password = MD5(username +"#" + password);
			        $.post("/u/submitLogin.shtml",{password:password,email:username,rememberMe:$("#rememberMe").is(':checked')} ,function(result){
			    		if(result && result.status == 300){
			    			layer.msg(result.message,function(){});
			    			$('.password').val('');
			    			return;
			    		}else{
			    			layer.msg('登录成功！');
			    			setTimeout(function(){
				    			window.location.href= result.back_url || "/";
			    			},1000)
			    		}
			    	},"json");
			        
			    });
			    $('.page-container form .username, .page-container form .password').keyup(function(){
			        $(this).parent().find('.error').fadeOut('fast');
			    });
			    $("#register").click(function(){
			    	window.location.href="register.shtml";
			    });
			});
        </script>

    </body>

</html>

