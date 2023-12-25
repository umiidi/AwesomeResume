<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="assets/css/users.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <script src="assets/js/users.js"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>
<body>

<div class="container mycontainer">
    <div class="row">
        <div class="col-4">
            <f:form action="usersm" method="GET" modelAttribute="user">
                <div class="form-group">
                    <label for="name">name:</label>
                    <f:input path="name" placeholder="Enter name" class="form-control"/>
                    <f:errors path="name"/>
                </div>
                <div class="form-group">
                    <label for="surname">surname:</label>
                    <f:input path="surname" placeholder="Enter surname" class="form-control"/>
                    <f:errors path="surname"/>
                </div>
                <f:button type="submit" class="btn btn-primary">Submit</f:button>
            </f:form>
        </div>
    </div>

    <div>
        <table class="table">
            <thead>
            <tr>
                <th>Ad</th>
                <th>Soyad</th>
                <th>Nationality</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${users}" var="u">
                <tr>
                    <td>${u.name}</td>
                    <td>${u.surname}</td>
                    <td>${u.nationality.name}</td>
                    <td style="width: 5px">
                        <button class="btn btn-danger" type="submit"
                                data-toggle="modal" data-target="#exampleModal"
                                onclick="setIdForDelete(${u.id}">
                            <i class="bi bi-trash-fill"></i>
                        </button>
                    </td>
                    <td style="width: 5px">
                        <form action="userdetail" method="GET">
                            <input type="hidden" name="id" value="${u.id}">
                            <button class="btn btn-secondary" type="submit" value="update" name="action">
                                <i class="bi bi-pencil-square"></i>
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure?
            </div>
            <div class="modal-footer">
                <form action="userdetail" method="POST">
                    <input type="hidden" name="id" value="" id="idForDelete">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-danger" value="delete" name="action">Delete</button>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>