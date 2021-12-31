<%@page import="manager.food.food_manager.entity.Category" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="manager.food.food_manager.entity.Food" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.time.LocalDate" %>
<%
    request.setCharacterEncoding("utf-8");
    //thêm để không bị lỗi font chữ
    Food  food =(Food) request.getAttribute("food");
    if(food==null){
        food = new Food();
    }
  HashMap<String,String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if(errors==null){
        errors = new HashMap<>();
    }
    LocalDate localDate = LocalDate.now();
    String local = localDate.toString();
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/admin/include/header.jsp">
        <jsp:param name="title" value="Food form"/>
        <jsp:param name="description" value="Food form"/>
        <jsp:param name="keywords" value="Admin, page...."/>
    </jsp:include>
    <style>.msg-error{color: red}</style>
</head>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
    <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
    <span class="w3-bar-item w3-right">Create Food Form</span>
</div>

<!-- Sidebar/menu -->
<jsp:include page="/admin/include/left-menu.jsp"/> <!--tách giao diện ra các file jsp khác nhau dùng jsp:include để nối vào-->


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

    <!-- Header -->
    <header class="w3-container" style="padding-top:22px">
        <h5><b><i class="fa fa-dashboard"></i>Food Form</b></h5>
    </header>

    <div class="w3-row-padding w3-margin-bottom">
        <form action="" method="post" class="w3-container">
            <div class="w3-margin">
                <label>Name</label>
                <input class="w3-input" value="<%=food.getName()%>" name="name" type="text" >
                <br>
                <%if(errors.containsKey("name")){%>
                <span class="msg-error"><%=errors.get("name")%></span>
                <%}%>
            </div>
            <div class="w3-margin">
                <label>Description</label>
                <input class="w3-input" value="<%=food.getDescription()%>" name="description" type="text">
                <br>
                <%if(errors.containsKey("description")){%>
                <span class="msg-error"><%=errors.get("description")%></span>
                <%}%>
            </div>
            <div class="w3-margin">
                <label>Price</label>
                <input class="w3-input" value="<%=food.getPrice()%>" name="price" type="text">
                <br>
                <%if(errors.containsKey("price")){%>
                <span class="msg-error"><%=errors.get("price")%></span>
                <%}%>
            </div>
            <div class="w3-margin">
                <label>Thumbnail</label>
                <input class="w3-input" value="<%=food.getThumbnail()%>" name="thumbnail" type="url">
                <br>
                <%if(errors.containsKey("thumbnail")){%>
                <span class="msg-error"><%=errors.get("thumbnail")%></span>
                <%}%>
            </div>
            <div class="w3-margin">
                <label>Date Create</label>
                <input class="w3-input" name="daysell" value="<%=local%>"  type="date" readonly>
                <br>
                <%if(errors.containsKey("daysell")){%>
                <span class="msg-error"><%=errors.get("daysell")%></span>
                <%}%>
            </div>
            <div class="w3-margin">
                <label>Date Edit</label>
                <input class="w3-input" name="datefix"  value="<%=local%>"   type="date" readonly>
                <br>
                <%if(errors.containsKey("datefix")){%>
                <span class="msg-error"><%=errors.get("datefix")%></span>
                <%}%>
            </div>
            <div class="w3-margin">
                <label>Loại món</label>
                <br>
                <select name="category_id" >
                    <%if (food.getCategory_id()==4){%>
                    <option value="4">Đồ uống</option>
                    <option value="1">Món nướng</option>
                    <option value="2">Món luộc</option>
                    <option value="3">Món chay</option>
                    <%}else if(food.getCategory_id()==2){%>
                    <option value="2">Món luộc</option>
                    <option value="1">Món nướng</option>
                    <option value="3">Món chay</option>
                    <option value="4">Đồ uống</option>
                    <%}else if(food.getCategory_id()==3){%>
                    <option value="3">Món chay</option>
                    <option value="1">Món nướng</option>
                    <option value="2">Món luộc</option>
                    <option value="4">Đồ uống</option>
                    <%}else {%>
                    <option value="1">Món nướng</option>
                    <option value="2">Món luộc</option>
                    <option value="3">Món chay</option>
                    <option value="4">Đồ uống</option>
                    <%}%>
                </select>
            </div>
            <div class="w3-margin">
                <label>Status</label>
                <br>
                <select  name="status" id="status">
                    <%if (food.getStatus()==1){%>
                    <option value="1">Dừng bán</option>
                    <option value="0">Đang bán</option>
                    <option value="-1">Đã xóa</option>
                    <%}else if(food.getStatus()==0){%>
                    <option value="0">Đang bán</option>
                    <option value="1">Dừng bán</option>
                    <option value="-1">Đã xóa</option>
                    <%}else {%>
                    <option value="-1">Đã xóa</option>
                    <option value="0">Đang bán</option>
                    <option value="1">Dừng bán</option>
                    <%}%>
                </select>
            </div>

            <button class="w3-button  w3-blue w3-margin">Submit </button>
        </form>
    </div>
</div>
<!-- Footer -->
<footer class="w3-container w3-padding-16 w3-light-grey">
    <jsp:include page="/admin/include/footer.jsp"/>
</footer>

<!-- End page content -->
</body>

</div>
<jsp:include page="/admin/include/script.jsp"/>
</html>




