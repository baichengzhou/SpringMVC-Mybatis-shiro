<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>Shiro Demo | 注册</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <#--link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'-->
		<link rel="stylesheet" href="http://open.sojson.com/itboy/js/itboy/app/reset.css"/>
        <link rel="stylesheet" href="http://open.sojson.com/itboy/js/itboy/app/supersized.css"/>
        <link rel="stylesheet" href="http://open.sojson.com/itboy/js/itboy/app/style.css"/>
		<style>
			#vcode >img{cursor:pointer;margin-bottom: -15px;border-radius:5px;}
		</style>
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://static.supportfolios.com/js/www/html5shiv.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container" style="margin: 100px auto 0px;">
            <h1>Register</h1>
            <form id="_form" action="" method="post">
                <input type="text" name="nickname" id="nickname" class="username" placeholder="Nickname">
                <input type="text" name="account"  id="account" placeholder="Account">
                <input type="password" name="password" id="password" class="password" placeholder="Password">
                <input type="password" id="re_password"  placeholder="Repeat the password">
                <div style="text-align: left; margin-left: 10px;" id="vcode">
	                <input type="text" name="vcode" id="vcode"  placeholder="Verification code" style="width: 110px; margin-left: -8px; margin-right: 8px;">
                	<img src="/open/getGifCode.shtml" />
                </div>
                <button type="button" class="register">Register</button>
                <button type="button" id="login" >Login</button>
                <div class="error"><span>+</span></div>
            </form>
        </div>

        <!-- Javascript -->
         <script  src="http://open.sojson.com/common/jquery/jquery1.8.3.min.js"></script>
        <script src="http://open.sojson.com/common/MD5.js"></script>
        <script src="http://open.sojson.com/itboy/js/itboy/app/supersized.3.2.7.min.js"></script>
        <script src="http://open.sojson.com/itboy/js/itboy/app/supersized-init.js"></script>
		<script  src="/js/common/layer/layer.js"></script>
        <script >
			jQuery(document).ready(function() {
				//验证码
				$("#vcode").on("click",'img',function(){
					var i = new Image();
					i.src = '/open/getGifCode.shtml?'  + Math.random();
					$(i).replaceAll(this);
					//$(this).clone(true).attr("src",'/open/getGifCode.shtml?'  + Math.random()).replaceAll(this);
				});
			    $('.register').click(function(){
			    	var form = $(this);
			    	var error= form.find(".error");
			    	var tops = ['27px','96px','165px','235px','304px','372px'];
			    	var inputs = $("form :text,form :password");
			    	for(var i=0;i<inputs.length;i++){
			    		var self = $(inputs[i]);
			    		if(self.val() == ''){
			    			 error.fadeOut('fast', function(){
			               		 $(this).css('top', tops[i]);
				            });
				            error.fadeIn('fast', function(){
				               self.focus();
				            });
				            return false;
			    		}
			    	}
			    	var re_password = $("#re_password").val();
			    	var password = $("#password").val();
			    	if(password != re_password){
			    		layer.msg('2次密码输出不一样',function(){});
			    		return false;
			    	}
			    	$.post("/u/subRegister.shtml",$("#_form").serialize() ,function(result){
			    		if(result && result.status!= 200){
			    			layer.msg(result.message,function(){});
			    			return;
			    		}else{
			    			layer.msg('登录成功！' );
			    			window.location.href= result.back_url || "/";
			    		}
			    	},"json");
			        
			    });
			    $("form :text,form :password").keyup(function(){
			        $(this).parent().find('.error').fadeOut('fast');
			    });
			    
			    $("#login").click(function(){
			    	window.location.href="login.shtml";
			    });
			    $("#register").click(function(){
			    	window.location.href="register.shtml";
			    });
			    
			
			});
        </script>

    </body>

</html>

