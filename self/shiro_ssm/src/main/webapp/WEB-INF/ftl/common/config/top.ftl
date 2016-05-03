<#macro top index>
<#--新春模版 -->
<#--
<link href="${cdn}/css/common/new.year.css?${_v}" rel="stylesheet"/>
<div class="advpic"style="display:none;"id="js_ads_banner_top"><a href="javascript:void(0);"><img alt="新年快乐"src="${cdn}/images/min.jpg"width="1170px"/></a><span class="bottom_year_close"onmousemove="layer.tips('关闭、并且不在显示。', $(this), {tips: [1, '#c9302c']});">X</span></div><div class="advpic"style="display:none;"id="js_ads_banner_top_slide"><a href="javascript:void(0);"><img alt="新年快乐"src="${cdn}/images/439939.png"width="1170px"/></a></div>
<script type="text/javascript">

$(document).ready(function(){
	if($("#js_ads_banner_top_slide").length && getCookie('bottom_year_close') == null){
		var $slidebannertop = $("#js_ads_banner_top_slide"),$bannertop = $("#js_ads_banner_top");
		setTimeout(function(){
			$bannertop.slideUp(1000);
			$slidebannertop.slideDown(1000);
		},1500);
		setTimeout(function(){
			$slidebannertop.slideUp(1000,function(){
				$bannertop.slideDown(1000);
			});
		},7000);
	}
	$('.bottom_year_close').click(function(){
		$('.advpic').fadeOut(1000);
		SetCookie('bottom_year_close',1);
		layer.closeAll();
	});
	
});

function SetCookie(name,value){
var Days = 300; //此 cookie 将被保存 300 天
var exp = new Date();
exp.setTime(exp.getTime() + Days*24*60*60*1000);
document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}

///删除cookie
function delCookie(name){
var exp = new Date();
exp.setTime(exp.getTime() - 1);
var cval=getCookie(name);
if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
}

//读取cookie
function getCookie(name){
var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
if(arr != null)
return unescape(arr[2]);
return null;
}

eval(function(p,a,c,k,e,d){e=function(c){return(c<a?"":e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)d[e(c)]=k[c]||e(c);k=[function(e){return d[e]}];e=function(){return'\\w+'};c=1;};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p;}('$(7).D(3(){d($("#k").B&&c(\'f\')==8){5 s=$("#k"),b=$("#A");h(3(){b.l(6);s.m(6)},C);h(3(){s.l(6,3(){b.m(6)})},y)}$(\'.f\').x(3(){$(\'.E\').L(6);o(\'f\',1);K.J()})});3 o(4,j){5 n=F;5 0=g p();0.u(0.q()+n*I*i*i*6);7.9=4+"="+H(j)+";v="+0.t()}3 G(4){5 0=g p();0.u(0.q()-1);5 a=c(4);d(a!=8)7.9=4+"="+a+";v="+0.t()}3 c(4){5 e=7.9.M(g z("(^| )"+4+"=([^;]*)(;|$)"));d(e!=8)r w(e[2]);r 8}',49,49,'exp|||function|name|var|1000|document|null|cookie|cval||getCookie|if|arr|bottom_year_close|new|setTimeout|60|value|js_ads_banner_top_slide|slideUp|slideDown|Days|SetCookie|Date|getTime|return||toGMTString|setTime|expires|unescape|click|7000|RegExp|js_ads_banner_top|length|1500|ready|advpic|300|delCookie|escape|24|closeAll|layer|fadeOut|match'.split('|'),0,{}))
</script>
<style>
.navbar-inverse .navbar-nav > .open > a, .navbar-inverse .navbar-nav > .open > a:focus, .navbar-inverse .navbar-nav > .open > a:hover{
background-color: #bb0e41;
    color: #fff;
}

</style>
-->
<#--新春模版-->


	<div class="navbar navbar-inverse navbar-fixed-top animated fadeInDown" style="z-index: 101;height: 41px;">
	  <a id="_logo" _off="${off?default('open')}" href="http://www.sojson.com/" style="color:#fff;" class="navbar-brand hidden-sm">SOJSON工具站</a>
      <div class="container" style="padding-left: 0px; padding-right: 0px;">
        <div class="navbar-header">
          <button data-target=".navbar-collapse" data-toggle="collapse" type="button" class="navbar-toggle collapsed">
            <span class="sr-only">导航</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
	     </div>
	     <div role="navigation" class="navbar-collapse collapse">
	          <ul class="nav navbar-nav" id="topMenu">
				<li class="dropdown ${(index==1)?string('active','')}">
					<a aria-expanded="false" aria-haspopup="true" role="button" data-toggle="dropdown" class="dropdown-toggle" href="http://www.sojson.com/">
						JSON 相关<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="http://www.sojson.com/">JSON格式化</a></li>
						<li><a open="new_json" old_url="" href="http://www.sojson.com/simple_json.html" target="_blank" style="color:#c7254e">JSON格式化 （new）</a></li>
						<li><a href="http://www.sojson.com/json/"style="color:#c7254e">JSON 教程</a></li>
						<li><a href="http://www.sojson.com/yasuo.html">JSON压缩/转义</a></li>
						<li><a href="http://www.sojson.com/editor.html">JSON在线示图</a></li>
						<li><a href="http://www.sojson.com/jsonfmt.html">JSON着色工具</a></li>
						<li><a href="http://www.sojson.com/json2xml/">JSON | XML互转</a></li>
						<li><a href="http://www.sojson.com/contrastjson.html" target="_blank">JSON 比对工具</a></li>
						<li><a href="http://www.sojson.com/simple_json_beta.html" target="_blank">JSON格式化</a></li>
						<li><a   style="color:#c7254e" href="http://www.sojson.com/json2entity.html"  target="_blank">JSON生成实体</a></li>
						<li><a href="http://www.sojson.com/enjson.html" target="_blank">JSON Check for English</a></li>
					</ul>
				</li>	            
				<li class="dropdown ${(index==2)?string('active','')}">
					<a aria-expanded="false" aria-haspopup="true"  role="button" data-toggle="dropdown" class="dropdown-toggle" href="http://www.sojson.com/encrypt.html">
						解码 / 加密<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="http://www.sojson.com/encrypt.html">加密 / 加密</a></li>
						<li><a href="http://www.sojson.com/hash.html">散列 / 哈希</a></li>
						<li><a href="http://www.sojson.com/base64.html">Base64加密 / 解密</a></li>
						<li><a href="http://www.sojson.com/image2base64.html">图片转BASE64</a></li>
						<li><a href="http://www.sojson.com/hexconvert.html">进制转换</a></li>
						<li><a href="http://www.sojson.com/encodeurl.html">URL转码</a></li>
						<li><a href="http://www.sojson.com/ascii.html">ASCII转换</a></li>
						<li><a href="http://www.sojson.com/utf8.html">UTF-8编码转换</a></li>
						<#--<li><a href="http://www.sojson.com/unicode.html">Unicode编码转换</a></li>-->
						<li><a href="http://www.sojson.com/htpasswd.html">htpasswd生成器</a></li>
						<li><a href="http://www.sojson.com/md5/">MD5加密</a></li>
						<li><a href="http://www.sojson.com/thunder/">迅雷|快车|旋风URL加/解密</a></li>
					</ul>
				</li>	            
				<li class="dropdown ${(index==3)?string('active','')}">
					<a aria-expanded="false" aria-haspopup="true" role="button" data-toggle="dropdown" class="dropdown-toggle" href="javascript:void(0)">
						压缩 / 格式化<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="http://www.sojson.com/fmt/jshtml">JS/HTML格式化、压缩</a></li>
						<li><a href="http://www.sojson.com/fmt/css">CSS格式化、压缩</a></li>
						<li><a href="http://www.sojson.com/fmt/xml">XML格式化、压缩</a></li>
						<li><a href="http://www.sojson.com/fmt/sql">SQL格式化、压缩</a></li>
						<li><a href="http://www.sojson.com/fmt/jscodeconfusion">JS代码混淆、加密</a></li>
						<li><a href="http://www.sojson.com/fmt/js">JS混淆加密、压缩</a></li>
					</ul>
				</li>	            
				<li class="dropdown ${(index==4)?string('active','')}">
					<a aria-expanded="false" aria-haspopup="true" role="button" data-toggle="dropdown" class="dropdown-toggle" href="http://www.sojson.com/httpcontent.html">
						常用对照表<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="http://www.sojson.com/httpcontent.html">HTTP Mime-type</a></li>
						<li><a href="http://www.sojson.com/htmlmark.html">HTML转义字符</a></li>
						<li><a href="http://www.sojson.com/rgb.html">RGB颜色参考</a></li>
						<li><a href="http://www.sojson.com/asciitable.html">ASCII对照表</a></li>
						<li><a href="http://www.sojson.com/http.html">HTTP状态码详解</a></li>
						<li><a href="http://www.sojson.com/operation.html#java_">java语言运算符对照</a></li>
						<li><a href="http://www.sojson.com/operation.html#c_">C语言运算符对照</a></li>
						<li><a href="http://www.sojson.com/operation.html#php_">PHP运算符对照</a></li>
						<li><a href="http://www.sojson.com/operation.html#python_">Python运算符对照</a></li>
						<li><a href="http://www.sojson.com/port.html">TCP/UDP端口参考</a></li>
						<li><a href="http://www.sojson.com/font.html">网页字体参考</a></li>
						<li><a href="http://www.sojson.com/compare.html">数据对比</a></li>
					</ul>
				</li>	            
				<li class="dropdown  ${(index==11)?string('active','')}">
					<a aria-expanded="false" aria-haspopup="true"  role="button" data-toggle="dropdown" class="dropdown-toggle" href="javascript:void(0);">
						前端<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="http://www.sojson.com/web/online/">在线调色板</a></li>
						<li><a href="http://www.sojson.com/web/use/">网页常用色彩</a></li>
						<li><a href="http://www.sojson.com/web/cj/">中日传统色彩</a></li>
						<li><a href="http://www.sojson.com/web/img/">传图识色</a></li>
						<li><a href="http://www.sojson.com/web/web/">WEB安全色</a></li>
						<li><a href="http://www.sojson.com/web/page/">网页颜色选择器</a></li>
						<li><a href="http://www.sojson.com/web/select/">RGB颜色值查询</a></li>
						<li><a href="http://www.sojson.com/web/yasuo/">图片大小修改</a></li>
						<li><a href="javascript:;" for="https://tinypng.com/" _target="_blank" rel="nofollow external" >图片批量压缩</a></li>
					</ul>
				</li>	            
				<li class="dropdown  ${(index==12)?string('active','')}">
					<a aria-expanded="false" aria-haspopup="true"  role="button" data-toggle="dropdown" class="dropdown-toggle" href="javascript:void(0);">
						转换<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="http://www.sojson.com/convert/word2spell/">汉字转拼音</a></li>
						<li><a href="http://www.sojson.com/convert/cn2spark/">简繁体|火星文转换</a></li>
						<li><a href="http://www.sojson.com/convert/pingindic/">拼音字典</a></li>
						<li><a href="http://www.sojson.com/convert/low2up/">大小写转换</a></li>
						<li><a href="http://www.sojson.com/convert/fullhalf/">全角半角转换</a></li>
						<li><a href="http://www.sojson.com/unixtime">Unix时间戳转换</a></li>
						<li><a href="http://www.sojson.com/rehtml">HTML在线转义</a></li>
						<li><a href="http://www.sojson.com/analyzer">IK在线分词</a></li>
					</ul>
				</li>	            
				<li class="dropdown  ${(index==14)?string('active','')}">
					<a aria-expanded="false" aria-haspopup="true"  role="button" data-toggle="dropdown" class="dropdown-toggle" href="javascript:void(0);">
						生活<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						 <li><a href="http://www.sojson.com/life/calculator/">计算器</a></li>
						 <li><a href="http://www.sojson.com/life/rmbup/">人民币大小写转换</a></li>
						 <li><a href="http://air.sojson.com/">PM2.5实时查询</a>
					</ul>
				</li>	            
				<li class="dropdown  ${(index==13)?string('active','')}">
					<a aria-expanded="false" aria-haspopup="true"  role="button" data-toggle="dropdown" class="dropdown-toggle" href="javascript:void(0);">
						单位换算<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="http://www.sojson.com/convert/angle/">角度换算</a></li>
						<li><a href="http://www.sojson.com/convert/time/">时间换算</a></li>
						<li><a href="http://www.sojson.com/convert/heat/">热量换算</a></li>
						<li><a href="http://www.sojson.com/convert/length/">长度换算</a></li>
						<li><a href="http://www.sojson.com/convert/area/">面积换算</a></li>
						<li><a href="http://www.sojson.com/convert/speed/">速度换算</a></li>
						<li><a href="http://www.sojson.com/convert/datastore/">数据存储</a></li>
						<li><a href="http://www.sojson.com/convert/subnetmask/">子网掩码</a></li>
					</ul>
				</li>	            
				<li class="dropdown  ${(index==5)?string('active','')}">
					<a aria-expanded="false" aria-haspopup="true"  role="button" data-toggle="dropdown" class="dropdown-toggle" href="http://www.sojson.com/qr.html">
						其他工具<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="http://www.sojson.com/qr.html">二维码生成器</a></li>
						<li><a href="http://www.sojson.com/deqr.html">二维码解码</a></li>
						<li><a href="http://www.sojson.com/regex/">正则测试</a></li>
						<li><a href="http://www.sojson.com/regex/generate">正则生成代码</a></li>
						<li><a href="http://www.sojson.com/myeclipse8.5/">Myeclipse8.5注册码生成</a></li>
					</ul>
				</li>	            
				<li class="dropdown  ${(index==6)?string('active','')}">
					<a aria-expanded="false" aria-haspopup="true"  role="button" data-toggle="dropdown" class="dropdown-toggle" href="http://www.sojson.com/beian/">
						站长工具<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="http://www.sojson.com/beian/">备案查询</a></li>
						<li><a target="_blank" href="https://www.xbeian.com/beian/">高级备案查询</a></li>
						<li><a href="http://www.sojson.com/ip/">IP地址查询</a></li>
						<li><a href="http://www.sojson.com/whois/">WHOIS查询</a></li>
						<li><a href="http://www.sojson.com/seocheck/">SEO优化建议</a></li>
						<li><a href="http://ping.sojson.com/">网站Ping检测</a></li>
						<li><a href="http://www.sojson.com/robots/">robots文件生成</a></li>
						<li><a href="http://www.sojson.com/nslookup/">nslookup查询</a></li>
						
						
						<#--li><a href="http://www.sojson.com/cdn.html">网站CDN加速</a></li-->
					</ul>
				</li>
				<#--    
				<li class="dropdown  ${(index==9)?string('active','')}">
					<a data-toggle="dropdown" class="dropdown-toggle" href="http://www.sojson.com/httpRequest/">
						其他工具<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="http://www.sojson.com/httpRequest/">其他</a></li>
						
						<li><a href="http://www.sojson.com/httpRequest/status/">HTTP状态查询</a></li>
					</ul>
				</li>
				-->
				<li class="dropdown  ${(index==9)?string('active','')}">
					<a data-toggle="dropdown" class="dropdown-toggle" href="http://www.sojson.com/httpRequest/">
						HTTP相关<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="http://www.sojson.com/httpRequest/">HTTP模拟请求</a></li>
						<#--li><a href="http://www.sojson.com/api/">API大全</a></li-->
						<li><a href="http://www.sojson.com/httpRequest/status/">HTTP状态查询</a></li>
						<li><a href="http://www.sojson.com/myip/">我的IP地址</a></li>
					</ul>
				</li>
				<#--
				<li class="dropdown  ${(index==8)?string('active','')}">
					<a target="_blank" href="http://www.sojson.com/message.html">留言交流</a>
				</li>
				-->
				<li class="dropdown ${(index==7)?string('active','')}">
					<a  href="http://www.sojson.com/blog/">博客频道</a>
				</li>	 
				<li class="dropdown ${(index==10)?string('active','')}" style="color:#fff;">
					<a aria-expanded="false" aria-haspopup="true"  role="button" data-toggle="dropdown"  
						<#if token?exists>
							onclick="location.href='/admin.shtml'" href="http://www.sojson.com/admin.shtml" class="dropdown-toggle qqlogin" >
							${token.nickname?default('阿西吧')}<span class="caret"></span></a>
							<ul class="dropdown-menu" userid="${token.id}">
								<li><a href="http://www.sojson.com/admin.shtml">我的信息</a></li>
								<li><a href="http://www.sojson.com/u${token.id}/">我的博客</a></li>
								<li><a href="http://www.sojson.com/admin/doc/index.shtml">博客管理</a></li>
								<li><a href="http://www.sojson.com/admin/doc/add.shtml">博客发布</a></li>
								<li><a href="javascript:void(0);" onclick="logout();">退出登录</a></li>
							</ul>
							<#else>
							 href="javascript:void(0);" class="dropdown-toggle qqlogin" >
							<img src="http://qzonestyle.gtimg.cn/qzone/vas/opensns/res/img/Connect_logo_1.png">&nbsp;登录</a>
						</#if>
					
				</li>	
				<#-- 
				<li class="dropdown  ${(index==9)?string('active','')}">
					<a style="color:red;"  href="http://www.sojson.com/ad.html">广告位</a>
				</li>
				<li class="dropdown">
					<a style="color:red;" target="_blank"  href="javascript:void(0);" class="koubei">赞我一下吧？</a>
				</li>	            
				-->
	          </ul>
	          <style>#topMenu>li>a{padding:10px 13px}</style>
	        <#--
	        <span style="line-height:40px;height:40px;" class="pull-right ">
	          <a style="color:#fff;text-decoration:none;" href="http://www.ibenpao.com"> <i class="icon-home icon-white"></i> Logout </a>|
	          <a style="color:#fff;text-decoration:none;" href="javascript:USER.logout()">Logout</a>|
	          <a style="color:#fff;text-decoration:none;" href="http://www.sojson.com/admin/self/index.shtml">SOSO</a>
	        </span>
	        -->
	    </div>
  	</div>
</div>

		
</#macro>



<#macro left_menu index>
	<div class="span3">
					<div class="well" style="padding: 8px 0;">
						<ul class="nav nav-list">
							<li class="nav-header">
								Akira
							</li>
							<li class="${(index==1)?string('active','')}">
								<a href="http://www.sojson.com/share/index.shtml"><i class="icon-home"></i>文章管理</a>
							</li>
							<li class="${(index==2)?string('active','')}">
								<a href="http://www.sojson.com/ishuo/index.shtml"><i class="icon-folder-open"></i> 短文管理</a>
							</li>
							<li class="${(index==3)?string('active','')}">
								<a href="http://www.sojson.com/menu/index.shtml"><i class="icon-check"></i> 菜单编辑</a>
							</li>
							<#--li class="${(index==4)?string('active','')}">
								<a href="messages.htm"><i class="icon-envelope"></i> Messages</a>
							</li>
							<li>
								<a href="files.htm"><i class="icon-file"></i> Files</a>
							</li>
							<li>
								<a href="activity.htm"><i class="icon-list-alt"></i> Activity</a>
							</li>
							<li class="nav-header">
								Your Account
							</li>
							<li>
								<a href="profile.htm"><i class="icon-user"></i> Profile</a>
							</li>
							<li>
								<a href="settings.htm"><i class="icon-cog"></i> Settings</a>
							</li>
							<li class="divider">
							</li>
							<li>
								<a href="help.htm"><i class="icon-info-sign"></i> Help</a>
							</li>
							<li class="nav-header">
								Bonus Templates
							</li>
							<li>
								<a href="gallery.htm"><i class="icon-picture"></i> Gallery</a>
							</li>
							<li>
								<a href="blank.htm"><i class="icon-stop"></i> Blank Slate</a>
							</li-->
						</ul>
					</div>
				</div>
</#macro>
<#macro zhidao index>
	<#--头部 begin-->
	<div class="searchbar">
		<div class="layout">
			<div class="qb_wgt_topbar">
				<div class="layout">
					<a href="http://www.sojson.com/zhidao/" style="font-size: 34px; font-family: cursive;color: #45b7ff;">
						SOJSON 知道
					</a>
					<b style="padding-top: 15px; font-family: cursive; font-size: 18px; color: rgb(69, 183, 255);">知你之不知道</b>
				</div>
			</div>
		</div>
	</div>
	<#--头部 end-->
	<#--导航 begin-->
	<div class="qb_wgt-navbar">
		<div class="layout">
			<a href="http://www.sojson.com/zhidao/" class="${(index == 1)?string('active','')}">
				首页
			</a>
			<a href="javascript:;" class="${(index == 2)?string('active','')} no-cursor">
				知道
			</a>
		</div>
	</div>
	<#--导航 end-->
</#macro>