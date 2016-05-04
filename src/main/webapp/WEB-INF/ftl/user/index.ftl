<@_html.head/>
		<title>${user.nickname} —个人中心 —SO JSON 在线工具（sojson.com）</title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
		<link   rel="icon" href="http://img.wenyifan.net/images/favicon.ico" type="image/x-icon" />
		<link   rel="shortcut icon" href="http://img.wenyifan.net/images/favicon.ico" />
		<link href="${cdn}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>
		<link href="${cdn}/css/common/site.min.css?${_v}" rel="stylesheet"/>
		<link href="${cdn}/css/common/base.css?${_v}" rel="stylesheet"/>
		<script  src="${cdn}/js/common/sojson.core.min.js?${_v}"></script>
		<script  src="${cdn}/js/layer/layer.js"></script>
		<script  src="${cdn}/js/common/sojson.js?${_v}"></script>
		<script  src="${cdn}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script >
		</script>
	</head>
	<body data-target="#one" data-spy="scroll">
		
		
		
	<@_top.top 7/>
		
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<div class="row">
				<@admin_left.index 1/>
				<div class="col-md-10">
					<h2>个人中心</h2>
					<hr>
					<form id="formId" enctype="multipart/form-data" action="/user/update.shtml" method="post">
						  <input type="hidden" value="${user.id}" name="id"/>
						  <div class="form-group">
						    <label for="nickname">昵称</label>
						    <input type="text" class="form-control" autocomplete="off" id="nickname" maxlength="8" name="nickname" value="${user.nickname?default('未设置')}" placeholder="请输入昵称">
						  </div>
						  <div class="form-group">
						    <label for="exampleInputPassword1">职业</label>
						    <input type="text" class="form-control" maxlength="16" autocomplete="off" id="job" value="${user.job?default('')}" name="job" placeholder="请输入职业信息">
						  </div>
						  <div class="form-group">
						    <label for="exampleInputPassword1">现居</label>
						    <input type="text" class="form-control" id="address" autocomplete="off" maxlength="16" value="${user.address?default('')}" name="address" placeholder="请输入现住地址，如：帝都，魔都">
						  </div>
						  <div class="form-group">
						    <label for="exampleInputPassword1">个人介绍</label>
						    <textarea type="text" class="form-control" i maxlength="250" autocomplete="off" id="intro" name="intro" placeholder="请输入个人介绍，如：本人学识渊博、经验丰富，代码风骚、效率恐怖，c/c++、java、php无不精通，熟练掌握各种框架，深山苦练20余年，一天只睡4小时，电话通知出bug后秒登vpn，千里之外定位问题，瞬息之间修复上线。">${user.intro?default('')}</textarea>
						  </div>
						  <div class="form-group">
						    <label for="exampleInputPassword1">QQ号码</label>
						    <input type="text" class="form-control" id="qq" autocomplete="off" maxlength="11" value="${user.qq?default('')}" name="qq" placeholder="输入本人QQ号码，方便及时沟通。">
						     <p class="help-block">非必填，方便你发布文章后，其他人看到文章和你直接联系，探讨问题。</p>
						  </div>
						  <div class="form-group">
						    <label for="exampleInputPassword1">关于我.（如：<a href="http://www.sojson.com/aboutsoso" target="_blank">soso的主页</a>）</label>
						    <input type="text" class="form-control" id="link" autocomplete="off" maxlength="256" value="${user.link?default('')}" name="link" placeholder="输入本人主页地址。">
						  	<p class="help-block">可以自定义一个页面，可以和站长提交页面。</p>
						  </div>
						  <div class="form-group">
						    <label for="exampleInputFile">头像</label>
						    <div class="form-group">
							    <img id="portrait" src="${user.portrait?default('')}" style="max-width: 500px;"/>
							    <input type="file" name="portraitFile" id="portraitFile">
							</div>
						    <p class="help-block">头像支持<code>png,jpg,gif等图片类型</code>。大小限制为<code>1MB</code>以下。宽不低于：<code>95px</code>，高不低于：<code>125px</code>。</p>
						  </div>
						  <div class="form-group">
							  <button type="submit" class="btn btn-success">保存信息</button>
						  </div>
						</form>
					
				</div>
				 <#--地图
				<@_html.tool_map/>
				-->
			</div><#--/row-->
		</div>
		<#-- 页脚-->
		<@_footer.footer 0/>
		
		<script src="${cdn}/js/common/jquery/jquery.form-2.82.js?${_v}"></script>
		<script>
			$(function(){
				var load;
				$("#formId").ajaxForm({
			    	success:function (result){
			    		layer.close(load);
			    		if(result && result.status == 300){
			    			layer.msg(result.message,function(){});
			    			return !1;
			    		}
			    		if(result && result.status == 500){
			    			layer.msg("操作失败！",function(){});
			    			return !1;
			    		}
			    		layer.msg('操作成功！');
			    		$.refresh();
			    	},
			    	beforeSubmit:function(){
			    		//判断参数
			    		if($.trim($("#nickname").val()) == ''){
				    		layer.msg('请输入您的昵称',function(){});
				    		$("#nickname").parent().addClass('red');
				    		$('html,body').animate({scrollTop:$("#nickname").offset().top - 80},500);
				    		return false;
			    		}else{
			    			$("#nickname").parent().removeClass('red');
			    		}
			    		if($.trim($("#job").val()) == ''){
				    		layer.msg('请输入您的职业',function(){});
				    		$("#job").parent().addClass('red');
				    		$('html,body').animate({scrollTop:$("#job").offset().top - 60},500);
				    		return false;
			    		}else{
			    			$("#job").parent().removeClass('red');
			    		}
			    		if($.trim($("#address").val()) == ''){
				    		layer.msg('请输入现居地',function(){});
				    		$("#address").parent().addClass('red');
				    		$('html,body').animate({scrollTop:$("#address").offset().top - 60},500);
				    		return false;
			    		}else{
			    			$("#address").parent().removeClass('red');
			    		}
			    		if($.trim($("#intro").val()) == ''){
				    		layer.msg('请输入你的个人介绍',function(){});
				    		$("#intro").parent().addClass('red');
				    		$('html,body').animate({scrollTop:$("#intro").offset().top - 60},500);
				    		return false;
			    		}else{
			    			$("#intro").parent().removeClass('red');
			    		}
			    		load = layer.load('正在提交！！！');
			    	},
			    	dataType:"json",
			    	clearForm:false
				});
			
		    var input = document.getElementById("portraitFile");
			$("#portraitFile").val('');
		    if (typeof(FileReader) === 'undefined') {
		        layer.msg("抱歉，你的浏览器不支持 FileReader，请使用支持HTML5浏览器操作！",$.defn());
		        input.setAttribute('disabled', 'disabled');
		    } else {
		        input.addEventListener('change', readFile, false);
		    }
		});
		function readFile() {
			var load = layer.load();
		    var file = this.files[0];
		    //这里我们判断下类型如果不是图片就返回 去掉就可以上传任意文件 
		    if('' == file.type || file.type.indexOf("image/")==-1){ 
		    	layer.close(load);
		    	$("#portraitFile").val('');
		   		return layer.msg("请确保文件为图像类型"),!1; 
		    } 
		    if(file.size/1024/1024 >1){
		    	layer.close(load);
		    	$("#portraitFile").val('');
		    	return layer.msg("图片超过1MB。请重新选择。"),!1; 
		    }
		    var reader = new FileReader();
		    reader.readAsDataURL(file);
		    reader.onload = function(e) {
		    	$("#portrait").attr("src", this.result);
				layer.close(load);
		    }
		}
		</script>
			
	</body>
</html>