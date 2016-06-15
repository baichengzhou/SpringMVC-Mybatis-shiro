<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8" />
		<title>${token.nickname} —个人中心</title>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport" />
		<link   rel="icon" href="http://img.wenyifan.net/images/favicon.ico" type="image/x-icon" />
		<link   rel="shortcut icon" href="http://img.wenyifan.net/images/favicon.ico" />
		<link href="/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>
		<link href="/css/common/base.css?${_v}" rel="stylesheet"/>
		<script  src="http://open.sojson.com/common/jquery/jquery1.8.3.min.js"></script>
		<script  src="/js/common/layer/layer.js"></script>
		<script  src="/js/common/bootstrap/3.3.5/js/bootstrap.min.js"></script>
		<script >
		/*
		function callResult(result){
				console.log(result)
			}
		     
		      $.ajax({
				type:"get",
				url: "http://123.57.163.79:9200/zhidao_index/zhidao_type/_search",//查询ES的URL
				data:data,//查询ES的条件
				dataType:"jsonp",//JSONP类型指定
				jsonp:"callback",//默认callback
				jsonpCallback:"callResult",//成功回调的方法
				async: false,
				beforeSend:function(){
				},
				success:function(result){
				},
				error:function(e){
					console.log(e)
				}
			});
			
			
		    var data ={query:{bool:{must:[{query_string:{default_field:"title",query:"新闻媒体"}}],must_not:[],should:[]}},from:0,size:10,sort:[],aggs:{}};
			
			
			var searchData ={"query":{"match":{"title":"新闻"}},"highlight":{"pre_tags":["<strong>","<strong>"],"post_tags":["</strong>","</strong>"],"fields":{"title":{}}}};
	     $.ajax({
	          //url: "http://47.90.22.70:9200/nutch/doc/_search?q="+searchTxt+"&from=0&size=10",//查询ES的URL
	          url: "http://47.90.22.70:9200/_search",//查询ES的URL
	          type: "post",
	          data :data,
	          dataType:"json",//JSONP类型指定
	          //jsonp:"callback",//默认callback
	          //jsonpCallback:"callResult",//成功回调的方法
	          //async: false,
	          beforeSend:function(){
	          },
	          success:function(result){
	              console.log(result)
	             // showData(result)
	             
	
	          }})
				*/
		</script>
	</head>
	<body data-target="#one" data-spy="scroll">
		<@_top.top 1/>
		<div class="container" style="padding-bottom: 15px;min-height: 300px; margin-top: 40px;">
			<div class="row">
				<@_left.user 1/>
				<div class="col-md-10">
					<h2>个人资料</h2>
					<hr>
					<table class="table table-bordered">
						<tr>
							<th>昵称</th>
							<td>${token.nickname?default('未设置')}</td>
						</tr>
						<tr>
							<th>Email/帐号</th>
							<td>${token.email?default('未设置')}</td>
						</tr>
						<tr>
							<th>创建时间</th>
							<td>${token.createTime?string('yyyy-MM-dd HH:mm')}</td>
						</tr>
						<tr>
							<th>最后登录时间</th>
							<td>${token.lastLoginTime?string('yyyy-MM-dd HH:mm')}</td>
						</tr>
					</table>
				</div>
			</div>
			<#--/row-->
		</div>
			
	</body>
</html>