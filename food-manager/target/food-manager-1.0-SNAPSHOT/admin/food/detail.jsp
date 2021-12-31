<%@ page import="manager.food.food_manager.entity.Food" %>
<%
    request.setCharacterEncoding("utf-8");
    //thêm để không bị lỗi font chữ
    Food food =(Food)request.getAttribute("food");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/admin/include/header.jsp">
        <jsp:param name="title" value="<%=food.getName()%>"/>
        <jsp:param name="description" value="Product detail"/>
        <jsp:param name="keywords" value="Admin, page...."/>
    </jsp:include>
</head>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
    <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
    <span class="w3-bar-item w3-right">Product detail</span>
</div>

<!-- Sidebar/menu -->
<jsp:include page="/admin/include/left-menu.jsp"/> <!--tách giao diện ra các file jsp khác nhau dùng jsp:include để nối vào-->


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">

    <!-- Header -->
    <header class="w3-container" style="padding-top:22px">
        <h5><b><i class="fa fa-dashboard"></i>Product Form</b></h5>
    </header>

    <div class="w3-row-padding w3-margin-bottom">
        <div class="w3-margin">
            <label style="color: brown"> Id</label>
            <p><%=food.getId()%></p>
        </div>
            <div class="w3-margin">
            <label style="color: brown">Name</label>
                <p><%=food.getName()%></p>
            </div>
        <div class="w3-margin">
            <label style="color: brown">Description</label>
            <p><%=food.getDescription()%></p>
        </div>
            <div class="w3-margin">
            <label style="color: brown">Price</label>
                <p><%=food.getPrice()%></p>
            </div><div class="w3-margin">
            <label style="color: brown">Date Create</label>
        <p><%=food.getDaysell()%></p>
        </div>
    </div><div class="w3-margin">
    <label style="color: brown">Date Edit</label>
    <p><%=food.getDatefix()%></p>
    </div>
    <div class="w3-margin">
    <label style="color: brown">Category</label>
    <%if(food.getCategory_id()==1){%>
        <p>Món Nướng</p>
    <%}else if(food.getCategory_id()==2){%>
        <p>Món luộc</p>
    <%}else if(food.getCategory_id()==3){%>
        <p>Món chay</p>
    <%}else{ %>
    Đồ uống
    <%}%>
</div>
<div class="w3-margin">
    <label style="color: brown">Status</label>
    <% if(food.getStatus() ==1){%>
    <p  style="color: rebeccapurple" >Dừng bán</p>

    <%}else if(food.getStatus() ==0) {%>
    <p style="color: blue">  Đang bán </p>
    <%}else {%>
    <p style="color:red;">Đã xóa</p>
    <%}%>
</div>
            <div class="w3-margin">
            <label style="color: brown">Thumbnail</label>
                <img src="<%=food.getThumbnail()%>" alt="<%=food.getName()%>" width="200px"/>
            </div>
        </div>

    </div>
</div>
</body>
</html>
    </div>
    <!-- Footer -->
    <footer class="w3-container w3-padding-16 w3-light-grey">
        <jsp:include page="/admin/include/footer.jsp"/>
    </footer>

    <!-- End page content -->
</div>

<jsp:include page="/admin/include/script.jsp"/>

</body>
</html>




