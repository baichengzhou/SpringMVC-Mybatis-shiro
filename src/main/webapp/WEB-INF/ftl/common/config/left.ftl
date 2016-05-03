<#macro left_task index>
<div id="one"  class="span3">
        <ul data-spy="affix" class="nav nav-list nav-tabs nav-stacked bs-docs-sidenav dropdown affix">
          <li class="${(index==1)?string('active',' ')}">
	          <a href="http://www.sojson.com/admin/task/index.shtml">
	        	 <i class="icon-chevron-right"></i>任务设置
	          </a>
          </li>
          <li class="${(index==2)?string('active',' ')}"><a href="http://www.sojson.com/admin/task/info.shtml"><i class="icon-chevron-right"></i>任务明细管理</a></li>
          <li class="${(index==3)?string('active',' ')}"><a href="http://www.sojson.com/admin/task/integral.shtml"><i class="icon-chevron-right"></i>任务奖励管理</a></li>
          <li class="${(index==4)?string('active',' ')}"><a href="http://www.sojson.com/admin/task/note.shtml"><i class="icon-chevron-right"></i>节点任务管理</a></li>
          <li class="${(index==5)?string('active',' ')}"><a href="http://www.sojson.com/admin/task/run/index.shtml"><i class="icon-chevron-right"></i>奔跑任务管理</a></li>
         <#--
          <li class="${(index==3)?string('active',' ')}">
            <a href="http://www.sojson.com/hao/fenlei/index.shtml">
              <i class="icon-chevron-right"></i>分类网址
            </a>
			 <ul class='dropdown-menu'>
              <li><a href="#body">BODY</a></li>
              <li><a href="#color">颜色设置</a></li>
              <li><a href="#other">其他</a></li>
            </ul>
            
          </li>
          <li class="${(index==4)?string('active',' ')}"><a href="http://www.sojson.com/hao/zuoce/index.shtml"><i class="icon-chevron-right"></i>左侧菜单</a></li>
          -->
        </ul>
      </div>
</#macro>
<#macro left_self index>
<div id="one" style="margin-top:125px;" class="span3">
        <ul data-spy="affix" class="nav nav-list nav-tabs nav-stacked bs-docs-sidenav dropdown affix">
          <li class="${(index==1)?string('active',' ')}">
	          <a href="http://www.sojson.com/admin/self/index.shtml"><i class="icon-chevron-right"></i>个人信息</a>
          </li>
        </ul>
      </div>
</#macro>
<#macro left_user index>
<div id="one" style="margin-top:125px;" class="span3">
        <ul data-spy="affix" class="nav nav-list nav-tabs nav-stacked bs-docs-sidenav dropdown affix">
          <li class="${(index==1)?string('active',' ')}">
	          <a href="http://www.sojson.com/admin/user/index.shtml">
	        	 <i class="icon-chevron-right"></i>用户管理
	          </a>
          </li>
          <li class="${(index==2)?string('active',' ')}"><a href="http://www.sojson.com/admin/user/track.shtml"><i class="icon-chevron-right"></i>用户行为</a></li>
          <#--
          <li class="${(index==3)?string('active',' ')}">
            <a href="http://www.sojson.com/hao/fenlei/index.shtml">
              <i class="icon-chevron-right"></i>分类网址
            </a>
			 <ul class='dropdown-menu'>
              <li><a href="#body">BODY</a></li>
              <li><a href="#color">颜色设置</a></li>
              <li><a href="#other">其他</a></li>
            </ul>
            
          </li>
          <li class="${(index==4)?string('active',' ')}"><a href="http://www.sojson.com/hao/zuoce/index.shtml"><i class="icon-chevron-right"></i>左侧菜单</a></li>
          -->
        </ul>
      </div>
</#macro>
<#macro left_system index>
<div id="one" style="margin-top:125px;" class="span3">
        <ul data-spy="affix" class="nav nav-list nav-tabs nav-stacked bs-docs-sidenav dropdown affix">
          <li class="${(index==1)?string('active',' ')}">
	          <a href="http://www.sojson.com/admin/system/weibo.shtml">
	        	 <i class="icon-chevron-right"></i>微薄设置
	          </a>
          </li>
          <li class="${(index==2)?string('active',' ')}">
	          <a href="http://www.sojson.com/admin/link/index.shtml">
	        	 <i class="icon-chevron-right"></i>友情连接
	          </a>
          </li>
        </ul>
      </div>
</#macro>
<#macro right_zhidao_details index>
	<div class="aside" id="aside">
		<div class="zy-banner">
			
		</div>
		<div class="cpro asideBanner">
		</div>
		<div class="cpro asideBanner">
		</div>
</div>
</#macro>