<#macro top index>
<script src="/js/user.login.js"></script>
<div class="navbar navbar-inverse navbar-fixed-top animated fadeInDown" style="z-index: 101;height: 41px;">
	  
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
	     		<a id="_logo"  href="http://www.sojson.com/" style="color:#fff; font-size: 24px;" class="navbar-brand hidden-sm">SSM + Shiro Demo 演示</a>
	          <ul class="nav navbar-nav" id="topMenu">
				<li class="dropdown ${(index==1)?string('active','')}">
					<a aria-expanded="false" aria-haspopup="true" role="button" data-toggle="dropdown" class="dropdown-toggle" href="/user/index.shtml">
						个人中心<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="/user/index.shtml">个人资料</a></li>
						<li><a href="/user/updateSelf.shtml" >资料修改</a></li>
						<li><a href="/user/updatePswd.shtml" >密码修改</a></li>
						<li><a href="/permission/mypermission.shtml">我的权限</a></li>
					</ul>
				</li>	            
				<li class="dropdown ${(index==2)?string('active','')}">
					<a aria-expanded="false" aria-haspopup="true"  role="button" data-toggle="dropdown" class="dropdown-toggle" href="/member/list.shtml">
						用户中心<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="/member/list.shtml">用户列表</a></li>
						<li><a href="/member/online.shtml">在线用户</a></li>
					</ul>
				</li>	            
				<li class="dropdown ${(index==3)?string('active','')}">
					<a aria-expanded="false" aria-haspopup="true"  role="button" data-toggle="dropdown" class="dropdown-toggle" href="/permission/index.shtml">
						权限管理<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="/role/index.shtml">角色列表</a></li>
						<li><a href="/role/allocation.shtml">角色列表</a></li>
						<li><a href="/permission/index.shtml">权限列表</a></li>
						<li><a href="/permission/allocation.shtml">权限分配</a></li>
					</ul>
				</li>	            
	          </ul>
	           <ul class="nav navbar-nav  pull-right" >
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
	          </ul>
	          <style>#topMenu>li>a{padding:10px 13px}</style>
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