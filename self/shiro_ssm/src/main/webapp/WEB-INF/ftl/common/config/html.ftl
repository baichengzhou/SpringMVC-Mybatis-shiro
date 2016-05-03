<#macro head>
<!DOCTYPE html>
<html lang="zh-cn">
	<head>
		<meta charset="utf-8" />
<!--
{
    "站长": "soso，QQ:8446666",
    "域名": "http://www.sojson.com",
    "开发语言": "最牛逼的语言——Java ^_^",
    "编码": "UTF-8",
    "技术使用": [
        "SpringMVC",
        "Mybatis ",
        "Freemarker",
        "Shiro"
    ],
    "数据存储": [
        "Redis",
        "RDS",
        "七牛云存储"
    ],
    "服务器": [
        {
            "阿里云ECS": {
                "配置": [
                    {
                        "CPU": "2核",
                        "内存": "4GB",
                        "一年费用": "¥2440.00"
                    }
                ]
            }
        }
    ]
}
/*
还不够清楚？
你是来拔代码的吧？
可以 ===> 加QQ群：259217951
*/
-->
</#macro>
<#macro tool_map>
	<div class="container well fff" style="border-radius: 0px;">
		<h3>工具导航地图</h3>
		<div class="">
			<ul class="list-inline" style="padding-bottom:-2px !important; padding-bottom:3px;">
				<li><strong>JSON相关</strong>：<a href="http://www.sojson.com/" target="_blank">JSON格式化</a></li><li>-</li>
				<li><a href="http://www.sojson.com/yasuo.html" target="_blank">JSON压缩/转义</a></li><li>-</li>
				<li><a href="http://www.sojson.com/editor.html" target="_blank">JSON在线编辑</a></li><li>-</li>
				<li><a href="http://www.sojson.com/jsonfmt.html" target="_blank">JSON着色工具</a></li><li>-</li>
				<li><a href="http://www.sojson.com/json2xml/">JSON | XML互转</a></li><li>-</li>
				<li><a href="http://www.sojson.com/contrastjson.html" target="_blank">JSON 比对工具</a></li><li>-</li>
				<li><a href="http://www.sojson.com/enjson.html" target="_blank">JSON Check for English</a></li><li>-</li>
				<li><a href="http://www.sojson.com/json/"style="color:#c7254e">JSON 教程</a></li><li>-</li>
				<li><a   style="color:#c7254e" href="http://www.sojson.com/json2entity.html"  target="_blank">JSON生成实体</a></li>
			</ul>
			<ul class="list-inline">
				<li><strong>常用对照表</strong>：<a href="http://www.sojson.com/httpcontent.html" target="_blank" class="imt">HTTP Mime-type</a></li><li>-</li>
				<li><a href="http://www.sojson.com/htmlmark.html" target="_blank" class="imt">HTML转义字符</a></li><li>-</li>
				<li><a href="http://www.sojson.com/rgb.html" target="_blank" class="imt">RGB颜色参考</a></li><li>-</li>
				<li><a href="http://www.sojson.com/asciitable.html" target="_blank" class="imt">ASCII对照表</a></li><li>-</li>
				<li><a href="http://www.sojson.com/http.html" target="_blank">HTTP状态码详解</a></li><li>-</li>
				<li><a href="http://www.sojson.com/operation.html" target="_blank" class="imt">运算符对照</a></li><li>-</li>
				<li><a href="http://www.sojson.com/port.html" target="_blank" class="imt">TCP/UDP端口参考</a></li><li>-</li>
				<li><a href="http://www.sojson.com/font.html" target="_blank" class="imt">字体参考</a></li>
			</ul>
			<ul class="list-inline">
				<li><strong>前&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;端</strong>：<a href="http://www.sojson.com/web/online/">在线调色板</a></li><li>-</li>
				<li><a href="http://www.sojson.com/web/use/">网页常用色彩</a></li><li>-</li>
				<li><a href="http://www.sojson.com/web/cj/">中日传统色彩</a></li><li>-</li>
				<li><a href="http://www.sojson.com/web/img/">传图识色</a></li><li>-</li>
				<li><a href="http://www.sojson.com/web/web/">WEB安全色</a></li><li>-</li>
				<li><a href="http://www.sojson.com/web/page/">网页颜色选择器</a></li><li>-</li>
				<li><a href="http://www.sojson.com/web/select/">RGB颜色值查询</a></li>
				<li><a href="http://www.sojson.com/web/yasuo/">图片大小修改</a></li>
			</ul>
			<ul class="list-inline">
				<li><strong>转&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;换</strong>：<a href="http://www.sojson.com/convert/word2spell/">汉字转拼音</a></li><li>-</li>
				<li><a href="http://www.sojson.com/convert/cn2spark/">简繁体|火星文转换</a></li><li>-</li>
				<li><a href="http://www.sojson.com/convert/pingindic/">拼音字典</a></li><li>-</li>
				<li><a href="http://www.sojson.com/convert/low2up/">大小写转换</a></li><li>-</li>
				<li><a href="http://www.sojson.com/convert/fullhalf/">全角半角转换</a></li><li>-</li>
				<li><a href="http://www.sojson.com/unixtime">Unix时间戳转换</a></li>
				<li><a href="http://www.sojson.com/rehtml">HTML在线转义</a></li>
				<li><a href="http://www.sojson.com/analyzer">IK在线分词</a></li>
			</ul>
			<ul class="list-inline">
				<li><strong>单位换算</strong>：<a href="http://www.sojson.com/convert/angle/">角度换算</a></li><li>-</li>
				
				<li><a href="http://www.sojson.com/convert/time/">时间换算</a></li><li>-</li>
				<li><a href="http://www.sojson.com/convert/heat/">热量换算</a></li><li>-</li>
				<li><a href="http://www.sojson.com/convert/length/">长度换算</a></li><li>-</li>
				<li><a href="http://www.sojson.com/convert/area/">面积换算</a></li><li>-</li>
				<li><a href="http://www.sojson.com/convert/speed/">速度换算</a></li><li>-</li>
				<li><a href="http://www.sojson.com/convert/datastore/">数据存储</a></li><li>-</li>
				<li><a href="http://www.sojson.com/convert/subnetmask/">子网掩码</a></li><li>-</li>
				<li><a href="http://www.sojson.com/convert/power/">功率换算</a></li><li>-</li>
				<li><a href="http://www.sojson.com/convert/pressure/">压力换算</a></li><li>-</li>
				<li><a href="http://www.sojson.com/convert/temperature/">温度换算</a></li><li>-</li>
				<li><a href="http://www.sojson.com/convert/density/">密度换算</a></li><li>-</li>
				<li><a href="http://www.sojson.com/convert/force/">力换算</a></li><li>-</li>
				<li><a href="http://www.sojson.com/convert/volume/">体积换算</a></li>
			</ul>
			<ul class="list-inline">
				<li><strong>生活工具</strong>：<a href="http://www.sojson.com/life/calculator/">计算器</a></li><li>-</li>
				<li><a href="http://www.sojson.com/life/rmbup/">人民币大小写转换</a><li>-</li>
				<li><a href="http://air.sojson.com/">PM2.5实时查询</a>
			</ul>
			<ul class="list-inline">
				<li><strong>格式化、压缩</strong>：<a href="http://www.sojson.com/fmt/jshtml" target="_blank">JS/HTML格式化、压缩</a></li><li>-</li>
				<li><a href="http://www.sojson.com/fmt/css" target="_blank" class="imt">CSS格式化、压缩</a></li><li>-</li>
				<li><a href="http://www.sojson.com/fmt/xml" target="_blank" class="imt">XML格式化、压缩</a></li><li>-</li>
				<li><a href="http://www.sojson.com/fmt/sql" target="_blank" class="imt">SQL格式化、压缩</a></li><li>-</li>
				<li><a href="http://www.sojson.com/fmt/jscodeconfusion">JS代码混淆、加密</a></li><li>-</li>
				<li><a href="http://www.sojson.com/fmt/js">JS混淆加密、压缩</a></li>
			</ul>
			<ul class="list-inline">
				<li><strong>二&nbsp;&nbsp;维&nbsp;&nbsp;码</strong>：<a href="http://www.sojson.com/qr.html" target="_blank">二维码生成器</a></li><li>-</li>
				<li><a href="http://www.sojson.com/deqr.html" target="_blank">二维码解码</a></li><li>-</li>
				<li><a href="http://www.sojson.com/regex/">正则测试</a></li><li>-</li>
				<li><a href="http://www.sojson.com/regex/generate">正则生成代码</a></li><li>-</li>
				<li><a href="http://www.sojson.com/myeclipse8.5/">Myeclipse8.5注册码生成</a></li>
			</ul>
			<ul class="list-inline">
				<li><strong>站长工具</strong>：<a href="http://www.sojson.com/beian/" target="_blank">备案查询</a></li><li>-</li>
				<li><a for="https://www.xbeian.com/beian/" href="javascript:;" _target="_blank">高级备案查询</a></li><li>-</li>
				<li><a href="http://www.sojson.com/ip/" target="_blank">IP地址查询</a></li><li>-</li>
				<li><a href="http://www.sojson.com/whois/" target="_blank">Whois查询</a></li><li>-</li>
				<li><a href="http://www.sojson.com/seocheck/" target="_blank">SEO优化建议</a></li><li>-</li>
				<li><a href="http://ping.sojson.com/" target="_blank">网站Ping检测</a></li><li>-</li>
				<li><a href="http://www.sojson.com/nslookup/" target="_blank">nslookup查询</a></li><li>-</li>
				<li><a href="http://www.sojson.com/robots/" target="_blank">robots文件生成</a></li><li>-</li>
				<li><a href="http://www.sojson.com/cdn.html" target="_blank" style="color: red; font-family: serif;">网站CDN加速</a></li><li></li>
			</ul>
			<ul class="list-inline">
				<li><strong>合作网站</strong>：</li><li>-</li><#--<a href="http://www.itnan.net/" target="_blank">it男</a>-->
				<li><a href="http://www.sojson.com/ad.html" target="_blank">合作说明</a></li>
			</ul>
			<div style="clear:both;"></div>
		</div>
	</div>
</#macro>