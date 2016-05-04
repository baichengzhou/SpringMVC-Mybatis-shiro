<#macro footer index>
	<#-- 判断 -->
	<#if index != 100>
		<@_footer.footer_tip/>
	</#if>
	<#-- 左侧菜单  + 弹窗支付宝 -->
	<div class="modal fade" id="myModal">
	  <div class="modal-dialog" style="width:850px">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title"><code>支付宝</code> && <code>微信付款</code> 二维码</h4>
	      </div>
	      <div class="modal-body">
	        <img alt="支付扫码" img-data="${cdn}/system/pay.png">
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">好了，扫完了</button>
	      </div>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
	<#--保存云端--->
	
	<div class="modal fade" id="saveCloudWindow" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="exampleModalLabel">保存文档到云端</h4>
	      </div>
	      <div class="modal-body">
	        <form>
	          <div class="form-group">
	            <label for="recipient-name" class="control-label">名称（必须输入）:</label>
	            <input type="text" class="form-control"   AUTOCOMPLETE="off"  placeholder="输入一个名称，下次你自己能认识即可！" maxlength="64" id="title" name="title">
	          </div>
	          <div class="form-group">
	            <label for="recipient-name" class="control-label">标签（以“,”间隔，至少给一个）:</label>
	            <input type="text" class="form-control"   AUTOCOMPLETE="off"  placeholder="标签以“,”间隔，至少给一个" maxlength="64" id="tagNames" name="tagNames">
	          </div>
	          <div class="form-group">
	            <label for="message-text" class="control-label">描述（你最好是输入一下，字数限制：140字）:</label>
	            <textarea class="form-control"   AUTOCOMPLETE="off"  placeholder="简单给个描述，将要保存的信息它是干哈的！" maxlength="140"  id="description" name="description"></textarea>
	          </div>
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="saveCloudExe">保存云端</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	
	
	<#--/保存云端--->
	
	
	
	


	<#-- footer -->
	<footer class="footer ">
      <div class="container">
        <div class="row footer-top">
          <div class="col-sm-8 col-lg-8">
            <h4>
              <img alt="SO JSON 在线工具" src="http://cdn.sojson.com/images/logo.png"/>
            </h4><#--由<code><a target="_blank" href="http://www.itnan.net/">IT男</a></code>-->
            <p>本网站所有工具，都是站长整合网上已有工具、开源包等，并全部遵循原有协议发布，著作权归属原作者或是团队。</p>
          </div>
          <div class="col-sm-4  col-lg-4"><!-- col-lg-offset-1-->
            <div class="row about">
              <div class="col-xs-4">
                <h4>关于</h4>
                <ul class="list-unstyled">
                  <li><a href="http://www.sojson.com/about.html">关于我们</a></li>
                  <li><a href="http://www.sojson.com/ad.html">广告合作</a></li>
                  <li><a href="http://www.sojson.com/links.html">友情链接</a></li>
                </ul>
              </div>
              <div class="col-xs-4">
                <h4>联系方式</h4>
                <ul class="list-unstyled">
                  <li><a rel='nofollow external  noindex' _target="_blank" href="javascript:;" for="http://wpa.qq.com/msgrd?v=3&amp;uin=8446666&amp;site=qq&amp;menu=yes">QQ联系我</a></li>
                  <li><a rel="nofollow" href="mailto:i@itboy.net">电子邮件</a></li>
                  <li><a href="http://www.sojson.com/cdn.html">CDN加速</a></li>
                </ul>
              </div>
              <div class="col-xs-4">
                <h4>赞助商</h4>
                <ul class="list-unstyled">
                  <li>
	                  <a _target="_blank" rel='nofollow external noindex' for="http://www.qiniu.com?from=www.sojson.com" click-data="{'begin_date':'2016-01-01','end_date':'2016-12-31'}"  title="SOJSON云存储赞助商:七牛云存储" href="javascript:void(0);">
	                 	 <img  src="//cdn.sojson.com/images/qiniucdn15.png">
	                  </a>
                  </li>
                  <li style="margin-top: 10px;">
	                  <a target="_blank"  click-data="{'begin_date':'2016-04-19','end_date':'2017-04-20'}" title="SOJSON云存储赞助商:EasyAPI文档管理" href="//www.easyapi.com?from=www.sojson.com">
	                 	 <img  src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAF8AAAAPCAMAAAC1HOMwAAAAclBMVEUAAAAvh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8Evh8FeRs2mAAAAJXRSTlMAImbemYjuu3cRzFVd9Muqf0QNOjEaCPnCswPYeksn5tCobM2YGWYfXgAAAfFJREFUOMu9k1my2jAQRdWarAE/Y8DM8Ibk7n+LaU3YJpXfnKLkbiGfkq7K4r8Qz+dtLcfzxitrv9yRm+msRWMc5vUE4tHDly7E9OBxhgq1+wX0vpQbmN0JzOWYPLfZD7f0R1Ae+TWDoLWWeYzCgbEoyLx8j1OPTfNvdz0S9+T5EC86rPYPzWNnubPKgn9WQSkpSAYrDQTx8ur/xs8e53f/7dr8FguciPk5gBC5E1wQRotRoKSplZBwA5wr/qnvJ6FwePNb3/yeNBwxilXcyg5DPFiHfCSPBb7505lU8TsMKUTz5lfHRT7ociy6dAF2mIUqdA1QOV1Y5HNUePAdsG/t/73M32FMN0A1fsDKhEkzIaAS4IVP+TsotP0/svl6w2PlV9PqfpX1Eq7UBtChXXQejUzYV/4HrTt0WqfML9iWl4bmPwH9hcTKf4BCV2suySFT/RXT/J5oxEjE6T1Pp2cR9FPxX/f7Pb82+9umqVUSRCWf6u90wWc/OhTyxdZtXQN+kr9u4t2vEWBjLkeXYlnlA5VA6saOu9j+ErvP9mXd8XH9h98by9MUEGLT2lU+Zj6NU4YOueHJKCQ+d0X2BPZ/+b/Kl4shb8axVRZ/XOVTacca0BDfattsF3UXIio3+yd1yVpDbWbUuXytkaK17bnmD9VyOopP8/yaAAAAAElFTkSuQmCC">
	                  </a>
                  </li>
                </ul>
              </div>
            </div>
    
          </div>
        </div>
        
        <#if index == 1>
        <div class="row footer-bottom">
          <ul class="list-inline text-left"  style="margin-left: 15px;">
            <li>友情链接（QQ:8446666）</li>
            <li><a target="_blank" href="http://www.zuidaima.com/" title="最代码">最代码</a></li>
            <li><a target="_blank" href="http://wangeditor.github.io/"title="wangeditor">wangeditor</a></li>
            <li><a target="_blank" href="http://www.misarpc.com"title="IT极客社区">IT极客社区</a></li>
            <li><a target="_blank" href="http://www.daxueit.com"title="it学习网">it学习网</a></li>
            <li><a target="_blank" href="http://www.bjpowernode.com/" qx="1327668980" title="北京动力节点">Java培训</a></li>
            <li><a target="_blank" href="http://www.pm265.com/"title="产品经理导航">PM265</a></li>
            <li><a target="_blank" href="http://www.sjcha.com/"title="世纪查询网">世纪查询网</a></li>
            <li><a target="_blank" href="http://www.qi-yue.net/" qx="289204338" title="柒月网络">柒月网络</a></li>
            <li><a target="_blank" href="http://www.zhiluo.net/" qx="2053654815"title="会员管理软件">会员管理软件</a></li>
            <li><a target="_blank" href="http://www.ylmfu.com/" qx="2504284012" title="U盘启动盘制作工具">U盘启动盘制作工具</a></li>
            <li><a target="_blank" href="http://www.icoolxue.com/" qx="57848963"title="爱酷学习网">爱酷学习网</a></li>
            <li><a target="_blank" href="http://www.downkuai.com/" qx="433985"title="当快软件园">当快软件园</a></li>
          </ul>
        </div>
        </#if>
        <hr>
        <div class="row footer-bottom">
          <ul class="list-inline text-center">
            <li><a _target="_blank" href="javascript:;" for='http://www.miibeian.gov.cn' >京ICP备13051813号-5</a></li>
            <style>.xsd>a>img{margin: 0;}</style>
            <li class="xsd">
            	
				<script>
					<#-- Baidu Button BEGIN -->
					var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
						document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3F8c252d4132aa580c66a9f0f2a7e150cd' type='text/javascript'%3E%3C/script%3E"));
			
					(function(){
					    var bp = document.createElement('script');
					    bp.src = '//push.zhanzhang.baidu.com/push.js';
					    var s = document.getElementsByTagName("script")[0];
					    s.parentNode.insertBefore(bp, s);
					})();
					<#-- Baidu Button END -->
               		
				    
				    $(function(){
				    	var G = []	 
	       			    function q(a) {
					        var b = -1;
					        G.forEach(function(c, d) {
					            c.url == a && (b = d)
					        });
					        return b
					    }
					    function c() {
					        var a = window.location.href,
					            b = q(a),
					            c = null,
					            d = null,
					            f = $(".js-smohan-right-click-back"),
					            e = $(".js-smohan-right-click-forward"),
					            B = $(".js-smohan-right-click-reload");
					        0 < b && (c = G[b - 1], d = G[b + 1]);
					        b = document.title.split(" - " + document.title);
					        B.attr({
					            href: a,
					            "data-title": b[0]
					        });
					        c ? f.removeClass("disabled").attr({
					            href: c.url,
					            "data-title": c.title
					        }) : f.addClass("disabled").attr({
					            href: "",
					            "data-title": ""
					        });
					        d ? e.removeClass("disabled").attr({
					            href: d.url,
					            "data-title": d.title
					        }) : e.addClass("disabled").attr({
					            href: "",
					            "data-title": ""
					        })
					    }
				    
				        var x = $("#top_ishow"),
				            b = function() {
				                200 <= (document.documentElement && document.documentElement.scrollTop || document.body.scrollTop) ? x.addClass("_ishow") : x.removeClass("_ishow");
				            };
				        window.addEventListener("scroll", b, false);
				        b();
				        x.on("click", function() {
				            return $('html,body').stop().animate({scrollTop:0},500),!1;
				        });
						document.addEventListener("keydown", function(a) {
							if(so("[_off]").attr('_off')== 'open'){
			               		a = a || window.event;
				                var b = parseInt(a.keyCode);
				                if (a.ctrlKey && (115 === b || 83 === b)) {
				                    a.returnValue = false, a.preventDefault(), layer.msg("保存不了吧。<br>加QQ群：259217951。",function(){});
				                } else if (123 === b || a.ctrlKey && a.shiftKey && 73 === b || a.ctrlKey && 85 === b) {
				                    a.returnValue = false, a.preventDefault(), layer.msg("FireBug出不来了吧。<br>加QQ群：259217951。",function(){});//k.showTip(2, "这个真的没有什么好看的，还是看内容吧", 2, k.fuckYou)
				                }
							}
		                });
		                 var a1 = document.getElementById("smohan-right-click");
		                 var b = function() {
		                     a1.style.display = "none"
		                 };
		                 document.addEventListener("contextmenu", function(b) {
		                    b = b || window.event;
		                    b.preventDefault();
		                    b.stopPropagation();
		                    var c = $(window).width(),
		                        d = $(window).height(),
		                        f = b.clientX;
		                    b = b.clientY;
		                    var e = f,
		                        g = b,
		                        c = c - 140,
		                        d = d - 160;
		                    f >= c && (e = c);
		                    b >= d && (g = d);
		                    a1.style.display = "block";
		                    a1.style.left = e + "px";
		                    a1.style.top = g + "px"
		                }, false);
		                 document.addEventListener("scroll", b, false);
               			 document.addEventListener("click", b, false);
               			 
               			 <#--关闭特效-->
               			 so('#_texiao').add(so('#_texiao').parent()).on('click',function(e){
               			 	e.preventDefault();
               			 	var vc = so("canvas[id*=c_n");
               			 	
               			 	if(vc&&vc.length){
	               			 	vc.add($('script#c_n_script')).remove();
	               			 	var _cn_ = layer.confirm('是否以后都不显示了？', function(){
								 	so.setCookie("_texiao",!1,'.sojson.com');
								 	layer.close(_cn_);
								});   
	               			 	so('#_texiao').text('显示特效'),so('#_texiao_ico').attr('class','glyphicon glyphicon-ok');
               			 	}else{
               			 		var script = document.createElement('script');
               			 		script.type = "text/javascript";
               			 		script.id = "c_n_script";
               			 		script.src  = "${cdn}/js/common/canvas-nest.min.js";
               			 		$(script).attr('color',"47,135,193");
               			 		$(script).attr('opacity',"0.5");
               			 		$(script).attr('zIndex',"-2");
               			 		$(script).attr('count',"200");
               			 		$(script).appendTo(so('body'));
               			 		so.setCookie("_texiao",!0,'.sojson.com');
               			 		so('#_texiao').text('关闭特效'),so('#_texiao_ico').attr('class','glyphicon glyphicon-remove');
               			 	}
               			 });
               			 
               			 <#--
               			 function da() {
					        $(document).on("click", '[rel="pjax"]', function(a) {
					            a.preventDefault();
					            a = $(this).attr("href");
					            var b = $(this).attr("data-title"),
					                b = b ? b + " - " + document.title : document.title;
					            if ($(this).hasClass("disabled")) {
					                return false
					            }
					            document.title = "加载中...";
					         
					            if (a) {
					                window.history.pushState({
					                    url: a,
					                    title: b
					                }, b, a);
					                var c = b;
					                20 < G.length && (G = []);
					                var d = q(a); - 1 != d && delete G[d];
					                G.push({
					                    url: a,
					                    title: c
					                });
					                W = document.title = b;
					            }
					            return false
					        })
					    }
               			window.history.pushState && (da(), $(window).on("popstate", function() {
					        history.state ? (document.title = history.state.title) : history.pushState({
					            url: window.location.pathname,
					            title: document.title
					        }, document.title, window.location.pathname);
					        W = document.title
					    }))
               			 -->
               			 
               			 $(".js-smohan-right-click-reload").click(function(){
               			 	layer.load();
               			 	$.refresh(window.location.href,1);
               			 })
					});
					(function(so){
						var _scroll = function(){
								layer.closeAll();
								return t = document.documentElement.scrollTop || document.body.scrollTop,
								t > 50 ? $("#scrollUp").show(100):$("#scrollUp").hide(100);
							}
						so(window).scroll(_scroll);
						_scroll();//开始就加载一次
					})(so);
				</script>
			</li>
            <li>京公网安备11010802014000</li>
          </ul>
        </div>
      </div>
    </footer>
    
    <#if _texiao?exists && _texiao>
	    <script type="text/javascript" color="47,135,193" opacity='0.5' zIndex="-2" count="200" src="${cdn}/js/common/canvas-nest.min.js"></script>
    </#if>
    <div  class="fixed"> 
	 	<a id="top_ishow"class="top " style="visibility: visible;" href="javascript:void(0);" onmouseover="layer.tips('返回顶部 go ~', $(this), {tips: [2, '#2f87c1']});"><i class="glyphicon glyphicon-chevron-up" style="top: -3px;"></i></a> 
		<a class="feeback" href="http://www.sojson.com/message.html"  rel="nofollow noindex"  onmouseover="layer.tips('有意见就说吧', $(this), {tips: [2, '#2f87c1']});" target="_blank">反馈意见</a> 
	</div>
	
	<div class="u-click-right-wrap" id="smohan-right-click" style="display: none;">
			<ul id="m_right">
				<li>
					<a class="js-smohan-right-click-forward" href="http://www.sojson.com/me/history.shtml"  rel="nofollow noindex"  href="javascript:void(0);" rel="pjax">
						<span class="glyphicon glyphicon-globe"></span>
						<span id="_history">浏览记录</span>
					</a>
				</li>
				<li>
					<a class="js-smohan-right-click-back"  href="javascript:void(0);" rel="pjax">
						<span id="_texiao_ico"class="<#if _texiao?exists && _texiao>glyphicon glyphicon-remove<#else>glyphicon glyphicon-ok</#if>"></span>
						<span id="_texiao"><#if _texiao?exists && _texiao>关闭特效<#else>开启特效</#if></span>
					</a>
				</li>
				<li>
					<a class="js-smohan-right-click-reload" href="javascript:void(0);" rel="pjax">
						<span class="glyphicon glyphicon-refresh"></span>
						<span>刷新</span>
					</a>
				</li>
				<li>
					<a class="js-smohan-right-click-back" href="http://www.sojson.com/message.html"  rel="nofollow noindex"  href="javascript:void(0);" rel="pjax">
						<span class="glyphicon glyphicon-envelope"></span>
						<span>意见交流</span>
					</a>
				</li>
				<li>
					<a href="http://www.sojson.com/about.html"  rel="nofollow noindex"  rel="pjax"
					class="js-smohan-right-click-about">
						<span class="glyphicon glyphicon-info-sign"></span>
						<span>关于</span>
					</a>
				</li>
			</ul>
		</div>
    <#--
    <a id="scrollUp" onclick="return $('html,body').stop().animate({scrollTop:0},500),!1;" href="javascript:void(0);" style="position: fixed; z-index: 2147483647; display: none;"><i class="glyphicon glyphicon-chevron-up"></i></a>
    -->
  </#macro>
  
  <#macro footer_tip>
	<div id="floatbottom">
		<div class="bottom_div">&nbsp;</div>
		<div class="bottom_main">
			<span class="bottom_con" style="font-size:38px;color:#6DBFBB;">
					<a href="http://www.sojson.com/room.html" onmouseover="layer.tips('Nodejs + socket Demo', $(this), {tips: [1, '#78BA32']});" class="btn btn-success">Nodejs + socket Demo</a>
					<a id="sponsorCode" href="javascript:void(0);" onmouseover="layer.tips('赞助支持支付宝、微信二维码！', $(this), {tips: [1, '#78BA32']});" class="btn btn-success">赞助二维码</a>
					<a href="http://www.sojson.com/subsidize.html" target="_blank" onmouseover="layer.tips('这里可以查看赞助名单哦！', $(this), {tips: [1, '#ac2925']});" class="btn btn-info">赞助名单</a>
					<a href="javascript:void(0);" for="http://koubei.baidu.com/s/www.sojson.com" _target="_blank" rel="nofollow external"  onmouseover="layer.tips('百度口碑点个赞咯！', $(this), {tips: [1, '#ac2925']});" class="btn btn-warning">百度口碑点赞</a>
					<a href="http://www.sojson.com/photo.html"  target="_blank"  rel="nofollow noindex" onmouseover="layer.tips('查看QQ群美女帅哥！', $(this), {tips: [1, '#ac2925']});" class="btn btn-danger ">查看QQ群美女帅哥</a>
					<a href="javascript:void(0);" for="http://jq.qq.com/?_wv=1027&k=YpqCNd"   rel="nofollow external" _target="_blank" onmouseover="layer.tips('点击加QQ群！', $(this), {tips: [1, '#ac2925']});" class="btn btn-default">点击加QQ群</a>
					<a href="http://www.sojson.com/music.html"  target="_blank"  rel="nofollow noindex" onmouseover="layer.tips('听音乐！', $(this), {tips: [1, '#ac2925']});" class="btn btn-default">听音乐</a>
			</span>
			<span title="关闭" onclick="$('#floatbottom').fadeOut(500);layer.closeAll();" class="bottom_close">X</span>
		</div>
	</div>
  </#macro>