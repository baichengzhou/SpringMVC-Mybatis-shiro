<#macro index index>
<div id="one" class="col-md-2">
	<ul data-spy="affix" class="nav nav-list nav-tabs nav-stacked bs-docs-sidenav dropdown affix" style="top: 100px; z-index: 9999999;">
	  <li class="${(index==1)?string('active',' ')}">
	      <a href="/">
	    	 <i class="glyphicon glyphicon-chevron-right"></i>文件发布
	      </a>
	  </li>
	  <#--
	  <li class="${(index==2)?string('active',' ')} dropdown">
	      <a id="dLabel"href="/admin/doc/index.shtml">
	    	 <i class="glyphicon glyphicon-chevron-right"></i>文章管理
	      </a>
	      <ul class="dropdown-menu" aria-labelledby="dLabel" style="margin-left: 160px; margin-top: -40px;">
              <li><a href="/admin/doc/add.shtml">添加文章</a></li>
              <li><a href="/admin/doc/selfTag.shtml">文章分类</a></li>
          </ul>
	  </li>
	  <li class="${(index==3)?string('active',' ')} dropdown">
	      <a id="dLabel"href="/admin/doc/index.shtml">
	    	 <i class="glyphicon glyphicon-chevron-right"></i>知道管理
	      </a>
	      <ul class="dropdown-menu" aria-labelledby="dLabel" style="margin-left: 160px; margin-top: -40px;">
              <li><a href="/admin/zhidao/index.shtml">知道设置</a></li>
              <li><a href="/admin/zhidao/add.shtml">知道添加</a></li>
          </ul>
	  </li>
	  -->
	  <#--
	  <li class="${(index==3)?string('active',' ')}">
	      <a href="/admin/demo/index.shtml">
	    	 <i class="glyphicon glyphicon-chevron-right"></i>Demo管理
	      </a>
	  </li>
	  -->
	</ul>
</div>
</#macro>