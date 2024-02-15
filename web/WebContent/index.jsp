<%@ page import="java.util.ArrayList" %>
<%@ page import="Classes.Item" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/WebContent/stable/head.jsp"%>
<body>
<%@include file="/WebContent/stable/navBar.jsp"%>
<div class="container">
    <h2 class=" mt-5 fw-bold text-center">
        Welcome to BITLAB SHOP
    </h2>
    <p class="text-center mb-5 fw-light">Electronic devices with high quality and service</p>
    <div class="row row-cols-1 row-cols-md-3 g-4 mb-5">
        <% ArrayList<Item> itemCard = (ArrayList<Item>) request.getAttribute("tovar");
            if (itemCard != null){
                for (Item item : itemCard){
        %>
        <div class="col">
            <div class="card">
                <div class="card-body text-center">
                    <h4 class="card-title mb-4 bg-secondary bg-opacity-10" style="padding: 10px"><%=item.getName()%></h4>
                    <h3 class="card-title text-success mb-4">$<%=item.getPrice()%></h3>
                    <p class="card-text mb-5" style="width: 28%; margin: 0 auto;"><%=item.getDescription()%></p>
                    <a href="#" class="btn btn-primary bg-success" style="width: 100%">Buy Now</a>
                </div>
            </div>
        </div>
        <% }
        }%>
    </div>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</html>
