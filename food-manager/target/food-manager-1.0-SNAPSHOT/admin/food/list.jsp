
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="manager.food.food_manager.entity.Food" %>
<%@ page import="java.util.ArrayList" %><%
    request.setCharacterEncoding("utf-8");
    //thêm để không bị lỗi font chữ
   ArrayList<Food> list = (ArrayList<Food>)request.getAttribute("list");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="/admin/include/header.jsp">
        <jsp:param name="title" value="Product list"/>
        <jsp:param name="description" value="Product list"/>
        <jsp:param name="keywords" value="Admin, page...."/>
    </jsp:include>
</head>
<body class="w3-light-grey">

<!-- Top container -->
<div class="w3-bar w3-top w3-black w3-large" style="z-index:4">
    <button class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
    <span class="w3-bar-item w3-right">Admin page</span>
</div>

<!-- Sidebar/menu -->
<jsp:include page="/admin/include/left-menu.jsp"/> <!--tách giao diện ra các file jsp khác nhau dùng jsp:include để nối vào-->


<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:300px;margin-top:43px;">
    <!-- Header -->
    <header class="w3-container" style="padding-top:22px">
        <h5><b><i class="fa fa-dashboard"></i> My Dashboard</b></h5>
    </header>

    <div class="w3-row-padding w3-margin-bottom">

        <table class="w3-table-all">
            <tr>
                <th>ID</th>
                <th>Image</th>
                <th>Name</th>
                <th>Description</th>
                <th>Ngày tạo món</th>
                <th>Ngày chỉnh sửa</th>
                <th>Price</th>
                <th>Loại món</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            <%
                for(int i = 0;i<list.size();i++){
                    if(list.get(i).getStatus() !=-1){
            %>
                <th><%=list.get(i).getId()%></th>
                <th><img src="<%=list.get(i).getThumbnail()%>" width="100px"  class="w3-border w3-padding"alt="Alps"></th>
                <th><%=list.get(i).getName()%></th>
                <th><%=list.get(i).getDescription()%></th>
                <th><%=list.get(i).getDaysell()%></th>
                <th><%=list.get(i).getDatefix()%></th>
                <th><%=list.get(i).getPrice()%> VNĐ</th>
                <%if(list.get(i).getCategory_id()==1){%>
                <th>Món Nướng</th>
                <%}else if(list.get(i).getCategory_id()==2){%>
                <th>Món luộc</th>
                <%}else if(list.get(i).getCategory_id()==3){%>
                <th>Món chay</th>
                <%}else{ %>
                <th>Đồ uống</th>
                <%}%>
                <% if(list.get(i).getStatus() ==1){%>
            <th  style="color: rebeccapurple" >Dừng bán</th>

                <%}else if(list.get(i).getStatus() ==0) {%>
            <th style="color: blue">  Đang bán </th>
                <%}else {%>
                    <th style="color:red;">Đã xóa</th>
                <%}%>
                <%if(list.get(i).getStatus()==-1){%>
                <th><a href="/admin/food/detail?id=<%=list.get(i).getId()%>" style="color: rebeccapurple">Detail</a>&nbsp;
                    <a class="btn-delete" onclick="restoreFood(<%=list.get(i).getId()%>)" href="#" className="btn btn-outline-brown" style="color: brown">Restore</a> &nbsp;
                </th>
                <%}else{%>
                <th><a href="/admin/food/detail?id=<%=list.get(i).getId()%>" style="color: rebeccapurple">Detail</a>&nbsp;
                    <a href="/admin/food/edit?id=<%=list.get(i).getId()%>" style="color: red" >Edit</a>&nbsp;
                    <a class="btn-delete" onclick="deleteFood(<%=list.get(i).getId()%>)" href="#" className="btn btn-outline-red">Delete</a>
                </th>
                <%}%>
            </tr>

            <%
                    }
                }
            %>
        </table>
    </div>
    <!-- Footer -->
    <footer class="w3-container w3-padding-16 w3-light-grey">
        <jsp:include page="/admin/include/footer.jsp"/>
    </footer>

    <!-- End page content -->
</div>

<jsp:include page="/admin/include/script.jsp"/>
<script>
    function deleteFood(id){
        if(confirm("bạn có muốn xóa món ăn này không")){
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function (){
                if(xhr.readyState ==4 && xhr.status ==200){
                    alert('Delete thành công');
                    window.location.reload();
                }
            }
            xhr.open('DELETE','/admin/food/delete?id='+id);
            xhr.send();

        }
    }
    function restoreFood(id){
        if(confirm("bạn có muốn khôi phục món ăn này không")){
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function (){
                if(xhr.readyState ==4 && xhr.status ==200){
                    alert('Khôi phục thành công');
                    window.location.reload();
                }
            }
            xhr.open('DELETE','/admin/food/restore?id='+id);
            xhr.send();

        }
    }
</script>
</body>
</html>
