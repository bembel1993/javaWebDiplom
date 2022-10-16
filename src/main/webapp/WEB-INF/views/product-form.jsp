<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: royalblue">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> Product Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Product</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${products != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${products == null}">
                    <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${products != null}">
                                Edit Product
                            </c:if>
                            <c:if test="${products == null}">
                                Add New Product
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${products != null}">
                        <input type="hidden" name="id" value="<c:out value='${products.id}' />"/>
                    </c:if>

                    <fieldset class="form-group">
                        <label>Product Name</label> <input type="text"
                                                           value="<c:out value='${products.nameprod}' />"
                                                           class="form-control"
                                                           name="nameprod" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Product price</label> <input type="text"
                                                            value="<c:out value='${products.price}' />"
                                                            class="form-control"
                                                            name="price">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Product Manufacturer</label> <input type="text"
                                                                   value="<c:out value='${products.manufacturer}' />"
                                                                   class="form-control"
                                                                   name="manufacturer">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Product Release Date</label> <input type="text"
                                                                   value="<c:out value='${products.releaseDate}' />"
                                                                   class="form-control"
                                                                   name="releaseDate">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
