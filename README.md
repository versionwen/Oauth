#### **为什么自己想到做这个**
因为自己写一些系统每一个都要做一个登录系统觉得太麻烦了，于是想出来写这么一个系统
##### 1.SSO定义
SSO, is a property of access control of multiple related, but independent software systems. With this property a user logs with a single ID and password to gain access to connected system or systems without using different usernames or passwords, or in some configurations seamlessly sign on at each system.
##### 2.为什么需要SSO
HTTP是无状态的协议，这意味着服务器无法确认用户的信息。于是乎，W3C就提出了：给每一个用户都发一个通行证，无论谁访问的时候都需要携带通行证，这样服务器就可以从通行证上确认用户的信息。通行证就是Cookie。

如果说Cookie是检查用户身上的”通行证“来确认用户的身份，那么Session就是通过检查服务器上的”客户明细表“来确认用户的身份的。Session相当于在服务器中建立了一份“客户明细表”。

HTTP协议是无状态的，Session不能依据HTTP连接来判断是否为同一个用户。于是乎：服务器向用户浏览器发送了一个名为JESSIONID的Cookie，它的值是Session的id值。其实Session是依据Cookie来识别是否是同一个用户。

所以，一般我们单系统实现登录会这样做：

登录：将用户信息保存在Session对象中
如果在Session对象中能查到，说明已经登录
如果在Session对象中查不到，说明没登录（或者已经退出了登录）
注销（退出登录）：从Session中删除用户的信息
记住我（关闭掉浏览器后，重新打开浏览器还能保持登录状态）：配合Cookie来用
##### 3.多系统登录的问题与解决
###### 3.1 Session不共享问题
单系统登录功能主要是用Session保存用户信息来实现的，但我们清楚的是：多系统即可能有多个Tomcat，而Session是依赖当前系统的Tomcat，所以系统A的Session和系统B的Session是不共享的。
###### 3.2 解决方式
SSO系统生成一个token，并将用户信息存到Redis中，并设置过期时间
其他系统请求SSO系统进行登录，得到SSO返回的token，写到Cookie中
每次请求时，Cookie都会带上，拦截器得到token，判断是否已经登录
###### 3.3 Cookie跨域的问题
1服务端将Cookie写到客户端后，客户端对Cookie进行解析，将Token解析出来，此后请求都把这个Token带上就行了
多个域名共享Cookie，在写到客户端的时候设置Cookie的domain。
将Token保存在SessionStroage中（不依赖Cookie就没有跨域的问题了）
##### 4 系统实现
本系统是基于Spring security来实现SSO
