<#macro top index>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
      <div class="container">
      	<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> 
			<span class="icon-bar"></span> 
			<span class="icon-bar"></span> 
			<span class="icon-bar"></span> 
		</a> 
        <a class="brand" href="http://www.sojson.com/admin/index.shtml">综合管理后台</a>
        <ul class="nav">
			<li class="${(index==1)?string('active','')}">
				<a href="http://www.sojson.com/admin/task/index.shtml">任务管理</a>
			</li>
			<li class="${(index==2)?string('active','')}">
				<a href="http://www.sojson.com/admin/user/index.shtml">用户管理</a>
			</li>
			<li class="${(index==3)?string('active','')}">
				<a href="http://www.sojson.com/admin/self/index.shtml">个人中心</a>
			</li>
			<li class="${(index==4)?string('active','')}">
				<a href="http://www.sojson.com/admin/system/index.shtml">系统设置</a>
			</li>
		</ul>
		<ul class="nav pull-right">
			<li>
				<a href="http://www.sojson.com/admin/self/index.shtml">${token.nickname}</a>
			</li>
			<li>
				<a href="javascript:USER.logout()">Logout</a>
			</li>
		</ul>
        <span style="line-height:40px;height:40px;" class="pull-right ">
          <a style="color:#fff;text-decoration:none;" href="http://www.ibenpao.com"> <i class="icon-home icon-white"></i> <strong>回到首页</strong>
          </a>
        </span>
      </div>
    </div>
  </div>
  <script src="/js/user.js"></script>
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