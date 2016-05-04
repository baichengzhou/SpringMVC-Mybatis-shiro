<@_html.head/>
		<title>发布平台-ITBOY.NET</title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
		<link   rel="icon" href="http://img.wenyifan.net/images/favicon.ico" type="image/x-icon" />
		<link   rel="shortcut icon" href="http://img.wenyifan.net/images/favicon.ico" />
		<link href="${cdn}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>
		<link href="${cdn}/css/common/base.css?${_v}" rel="stylesheet"/>
		<script  src="http://cdn.sojson.com/js/common/sojson.core.min.js?2016-03-07 05:05:34"></script>
		<script  src="${cdn}/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="http://open.sojson.com/itboy/js/itboy/app/plupload.full.min.js?${_v}"></script>
		<script type="text/javascript" src="http://open.sojson.com/itboy/js/itboy/app/zh_CN.js?${_v}"></script>
		<script type="text/javascript" src="http://open.sojson.com/itboy/js/itboy/app/ui.js?${_v}"></script>
		<script type="text/javascript" src="http://open.sojson.com/itboy/js/itboy/app/qiniu.js?${_v}"></script>
		<script type="text/javascript" src="http://open.sojson.com/itboy/js/itboy/app/main.js?${_v}"></script>
		<#--
		<script src="${cdn}/js/common/jquery/jquery.form-2.82.js?${_v}"></script>
		<script  src="${cdn}/js/layer/layer.js"></script>
		-->
		<script >
		</script>
	</head>
	<body data-target="#one" data-spy="scroll">
		
        <input type="hidden" id="domain" value="http://cdn.itboy.net/">
        <input type="hidden" id="uptoken_url" value="/app_itboy/getToken.shtml">
        <input type="hidden" id="domain_https" value="https://o42of48de.qnssl.com/">
        
        
        
        
		<div class="container" id="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<div class="row">
				<@kc.index 1/>
				<div class="col-md-10">
					<h2>文件发布云端系统</h2>
					<hr>
					<form id="body-form" enctype="multipart/form-data" action="/user/update.shtml" method="post">
						  <div class="form-group">
						    <label for="nickname">选择任意格式文件上传，文件大小小于 <code>2GB</code> ，上传完毕返回 <code>https</code> +  <code>http</code> 链接。</label>
						  </div>
						   <#--
						  <div class="form-group">
						    <label for="nickname">昵称</label>
						    <input type="text" class="form-control" autocomplete="off" id="nickname" maxlength="8" name="nickname" value="" placeholder="请输入昵称">
						  </div>
						   -->
						  <div class="form-group">
						   	<a class="btn btn-default btn-lg"  id="pickfiles" href="javascript:void(0);" >
			                    <i class="glyphicon glyphicon-plus"></i>
			                    <span>选择文件</span>
			                </a>
			                <hr>
						  </div>
						  <#--
						  <div class="form-group">
							  <button type="submit" class="btn btn-success">保存信息</button>
						  </div>
						  -->
					</form>
					
					
					<#--上传提示开始--->
					 <div style="display:none" id="success" class="col-md-12">
			            <div class="alert-success">
		                		队列全部文件处理完毕
			            </div>
			        </div>
			        <div class="col-md-12 xxxx">
			            <table class="table table-striped table-hover text-left"   style="margin-top:40px;display:none">
			                <thead>
			                  <tr>
			                    <th class="col-md-3">文件名</th>
			                    <th class="col-md-1">文件大小</th>
			                    <th class="col-md-8">下载地址</th>
			                  </tr>
			                </thead>
			                <tbody id="fsUploadProgress">
			                </tbody>
			            </table>
			        </div>
			        
		           <div class="modal fade body" id="myModal-img" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				      <div class="modal-dialog">
				        <div class="modal-content">
				          <div class="modal-header">
				            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				            <h4 class="modal-title" id="myModalLabel">图片效果查看</h4>
				          </div>
				          <div class="modal-body">
				            <div class="modal-body-wrapper text-center">
				                <a href="" target="_blank" >
				                    <img src="" alt="" data-key="" data-h="">
				                </a>
				            </div>
				          </div>
				        </div>
				      </div>
				    </div>
					<#--上传提示结束--->
					
					
					      
					
				</div>
				
				
				
				
				
				
			</div><#--/row-->
		</div>
		<#-- 页脚-->
		
	</body>
</html>
