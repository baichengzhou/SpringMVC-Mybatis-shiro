<script>
(function(){
	
var u = window.location.href;
	setTimeout(function(){
		
		
		
		var _h = [];
		var t = new Date().getTime();
		_h.push('<script  src="http://cdn.sojson.com/js/common/codecopy/docs.min.js?'+ t +'"></script>\n');
		_h.push('<link   rel="stylesheet" href="http://cdn.sojson.com/js/common/codecopy/docs.min.css?'+ t +'"/>\n');
		if(u.indexOf('/editor.html') == -1){//不是在这个页面才增加
			_h.push('<script type="text/javascript" src="http://cdn.sojson.com/js/json/app-min.js?'+ t +'"></script>\n');
		}
		$("body").append(_h.join(''));
		$('.mallMain > .mallLeft > nav > .nav >li,.mallMain > .mallLeft > nav  >a').fadeIn("slow");
		/*
		try{
			layer.config({
			    extend: 'extend/layer.ext.js'
			}); 
		}catch(e){}
		*/
		/**当分辨率过低隐藏左侧菜单*/
		var w = window.screen.width;
		var h = window.screen.height;
		if(w && h)if(w < 1600  ||  h < 900 ){
			setTimeout(function(){
				$("#leftBut").click();
				$(".rightMenu").hide(1000)//animate({'display':'none'},1000);
			},500);
		}
	},1000);

})();
</script>