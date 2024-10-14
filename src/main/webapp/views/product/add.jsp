<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 9/27/2024
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="container">
    <div class="row">

        <div class="col-lg-6">
            <h1 class="text-danger"> ${err}</h1>

            <f:form action="/add" method="post" modelAttribute="product" enctype="multipart/form-data">

                <div class="mb-1">
                    <label class="col-form-label d-flex justify-content-start">
                        <span>Name</span>
                        <span class="text-alert">(*)</span>
                    </label>
                    <f:input type="text" class="form-control" path="name" placeholder="Please enter name"/>
                </div>

                <div class="mb-1">
                    <label class="col-form-label d-flex justify-content-start">
                        <span>Price</span>
                        <span class="text-alert">(*)</span>
                    </label>

                    <f:input type="number" class="form-control" path="price" placeholder="Please enter price"/>
                </div>



                <div class="mb-1">

                    <label class="col-form-label d-flex justify-content-start">
                        <span>Category</span>
                        <span class="text-alert">(*)</span>
                    </label>

                    <f:select class="form-control" path="category.id">
                        <c:forEach items="${categories}" var="category">
                            <option value="${category.id}">
                                    ${category.name}
                            </option>
                        </c:forEach>
                    </f:select>

                </div>

                <div class="mb-1">
                    <label >Product image </label><br>
                    <input type="file" class="form-control" name="imgFile" />
                </div>


                <div class="mb-1">
                    <label >Status </label><br>

                    <div class="form-check form-check-inline">
                        <label class="form-check-label">
                            <f:radiobutton path="status" value="1"/> ACTIVE
                        </label>
                    </div>

                    <div class="form-check form-check-inline">
                        <label class="form-check-label">
                            <f:radiobutton path="status" value="0" /> DEACTIVE
                        </label>
                    </div>


                </div>


                <div class="modal-footer">
                    <a href="" class="btn btn-secondary">Trở lại</a>
                    <button type="submit" class="btn btn-primary">Thêm mới</button>
                </div>

            </f:form>
        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>

