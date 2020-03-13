<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Тимур
  Date: 13.03.2020
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <a>Result: </a><%=request.getSession().getAttribute("result")%>
    <%List<String> list = (List<String>) request.getSession().getAttribute("operations");%>
    <div><a>Last:</a>
    <%for (int i = 0; i < list.size(); i++) {%>
      <%=list.get(i)%>
      <br>
      <%}%>
    </div>
  </body>
</html>
