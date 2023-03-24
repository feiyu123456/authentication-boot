##前言

Http协议本身是无状态的，即使是同一台电脑同一个浏览器打开同一个页面两次，服务器不知道这两次请求是同一个客户端发送过来的。两次请求是完全独立的。例如，第一次请求时已经登录了，第二次在请求服务器会忘了你已经登录过。

为了解决这个问题，就有了cookie和session。它们的出现是为了让服务器“记住”之前这个客户端的一些数据，让Http保持状态。

现在流行两种登录认证方式：session和JWT,无论是那种方式其原理就是token机制，即保存凭证：

1.前端发起登录认证请求

2.后端登录验证通过，返回给前端一个凭证

3.前端发起新的请求时携带凭证

```java
@Data
public class User {
    private String username;
    private String password;
}
```



##1.认证流程
基于Session认证方式的流程是，用户认证成功后，在服务端生成用户相关的数据保存在session(当前会话)，而发给客户端的 sesssion_id 存放到 cookie 中，
这样用客户端请求时带上 session_id 就可以验证服务器端是否存在session 数据，以此完成用户的合法校验。当用户退出系统或session过期销毁时,客户端的session_id也就无效了。

下图是session认证方式的流程图：

略

基于Session的认证机制由Servlet规范定制，Servlet容器已实现，用户通过HttpSession的操作方法即可实现，如

下是HttpSession相关的操作API。

| 方法                                   | 含义                    |
| :------------------------------------- | ----------------------- |
| HttpSession getSession(Boolean create) | 获取当前HttpSession对象 |
| void setAttribute(String name)         | 向session中存放对象     |
| object getAttribute(String name)       | 从session中获取对象     |
| void removeAttribute(String name)      | 移除session中的对象     |
| void invalidate()                      | 使HttpSession失效       |

以下步骤对应到springboot只需配置文件中配置即可,剩下的[自动装配](https://so.csdn.net/so/search?q=自动装配&spm=1001.2101.3001.7020)



##2.小结

基于Session的认证方式是一种常见的认证方式，至今还有非常多的系统在使用因为老的系统对于不是高并发或者分布式不可能好好用着做代码升级。我们在此小节使用Spring mvc技术对它进行简单实现，旨在让大家更清晰实在的了解用户认证、授权以及会话的功能意义及实现套路，也就是它们分别干了哪些事儿？大概需要怎么做？

而在正式生产项目中，我们往往会考虑使用第三方安全框架（如 spring security，shiro等安全框架）来实现认证授权功能，因为这样做能一定程度提高生产力，提高软件标准化程度，另外往往这些框架的可扩展性考虑的非常全面。但是缺点也非常明显，这些通用化组件为了提高支持范围会增加很多可能我们不需要的功能，结构上也会比较抽象，如果我们不够了解它，一旦出现问题，将会很难定位。
