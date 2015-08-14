# JspServlet_150813_22-14

整理的以前最原生态的jsp和servvlet代码  没有用到spring  mybatis等框架

 工程说明：
           0.数据库 jsp_servlet_test   表1：t_user(id user_name user_password)  表2:(id user_id course_name)

           1.只有纯servlet 和 jsp页面 
             1.1 在web.xml 中配置servlet的对应mapping      配置context数据库连接,通过contexlistener去读取并创建连接存放在context中
             1.2 views 直接放在webapp下面，与web－inf平级。

           2.servlet中直接使用绝对路径实现请求跳转，不要忘了.jsp后缀
               request.getRequestDispatcher("views/register/register.jsp")
             2.1 首页使用的是链接直接跳转到jsp页面  <form action="/views/login/login.jsp">
             2.2 到登录页也是<a href="/views/login/login.jsp"> 去登录页 </a>
             2.3 详情页增加课程 和 编辑课程 也是链接过去的

           3.所有请求都是发送post请求到对应的servlet(没有划分为service、dao层处理，但是将实体提取出来了)，
             通过请求后追加参数值对到servlet中获取这个参数值来判断其具体操作（增删改）,
             然后在post中匹配调用不同的方法。
             
    问题：删除课程处有点问题还没解决  
