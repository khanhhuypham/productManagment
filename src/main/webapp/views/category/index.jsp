<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <style>
        <%@include file="../sidebar/sideBar.css"%>
    </style>


    <link href="https://cdn.lineicons.com/4.0/lineicons.css" rel="stylesheet" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
          integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>

<div class="wrapper" id="wrapper">
    <%@include file="../sidebar/sideBar.jsp"%>
    <div class="main">
        <div class="text-center content" id="content">
            <div class="container-fluid header">
                <div class="d-flex justify-content-between align-items-center">

                    <a class="btn btn-primary" href="category/add">
                        Thêm mới +
                    </a>


                    <div class="input-group">
                        <input type="search" class="form-control" placeholder="Nhập từ khóa tìm kiếm"
                               id="searchKeyWordOfClass" onsearch="">
                    </div>

                    <div class="d-flex align-items-center">
                        <span class="p-2">Sắp xếp</span>
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                                    aria-expanded="false">
                                Tùy chọn
                            </button>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </div>
                    </div>

                </div>

                <div>
                    <table class="table text-center">
                        <thead>
                        <tr>
                            <th>STT</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th colspan="2">Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${categories}" var="category" varStatus="loop">

                            <tr>
                                <td scope="row">${loop.index+1}</td>
                                <td>${category.name}</td>
                                <td>${category.description}</td>
                                <td>
                                    <a href="/category/update/${category.id}" class="btn btn-primary">Edit</a>
                                    <a href="/category/delete/${category.id}" class="btn btn-danger">Delete</a>
                                </td>
                            </tr>

                        </c:forEach>
                        </tbody>
                    </table>

                </div>

            </div>
        </div>
    </div>


</div>

</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous">
</script>

<script type="module">
    const hamBurger = document.querySelector(".toggle-btn");

    hamBurger.addEventListener("click", function () {
        document.querySelector("#sidebar").classList.toggle("expand");
    });
</script>

</html>

