<%
  String title = request.getParameter("title");
  String description = request.getParameter("description");
  String keywords = request.getParameter("keywords");
  // các biến và giá trị trong ngoặc thường lấy theo name
%>
    <title><%= title%></title>
    <meta name="description" content="<%=description%>"/> <!--mô tả web trên gg qua description-->
    <meta name="keywords" content="<%=keywords%>"/> <!--search tren gg theo keywords-->
<%--    <meta charset="UTF-8">--%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
    </style>

