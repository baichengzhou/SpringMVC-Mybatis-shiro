# SpringMVC-Mybatis-shiro
一个基于SpringMVC + Mybatis的Shiro + Redis的权限控制Demo

重要提醒
使用前先看这个地址：http://www.sojson.com/shiro

已经升级，并且解决部分BUG问题，新版本：https://github.com/baichengzhou/SpringMVC-Mybatis-Shiro-redis-0.2


本教程包含的内容。

    SSM（SpringMVC + Spring + Mybatis）框架的增删改查（含分页），所以如果框架小白也是可以看看的。
    View层主要是Freemarker，但是为了考虑到好多人还使用的是JSP，也有一个页面是用JSP实现的，并且框架支持Freemarker 和 JSP 双View展示（优先找Freemarker）。
    Shiro + Redis 的集成，也提供Ehcache的依赖Jar。
    Shiro 初始权限动态加载。
    Shiro 自定义权限校验Filter定义，及功能实现。
    Shiro Ajax请求权限不满足，拦截后解决方案。
    Shiro Freemarker标签使用。
    Shiro JSP标签使用。
    Shiro 登录后跳转到最后一个访问的页面。
    用户禁止登录Demo。
    在线显示，在线用户管理（踢出登录）。
    登录注册密码加密传输Demo（详细请见下面讲解）。
    密码修改。
    用户个人中心。
    权限的增删改查。
    角色的增删改查。
    权限->角色->用户之间的关系维护。
    管理员权限的自动添加（当有一个权限创建，自动添加到管理员角色下，保证管理员是最大权限）。
    Spring定时任务数据化数据。
    集成多种验证码（包括动态的gif验证码哦）。
    后续会陆陆续续升级... ...









