<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta charset="utf-8"/>
        <title>View Customers</title>
    </head>
    <body>
        <table>
            <thead>
            <tr>
                <th>Фамилия</th>
                <th>Имя</th>
                <th>Отчество</th>
            </tr>
            </thead>
            <a type="button" href="/createCustomer">Добавить нового</a>
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td>${customer.surname}</td>
                    <td>${customer.name}</td>
                    <td>${customer.lastname}</td>
                    <td><a type="button" href="/updateCustomer?id=${customer.id}">Редактировать</a></td>
                    <td><a type="button" href="/deleteCustomer?id=${customer.id}">Удалить</a></td>
                </tr>
            </c:forEach>
        </table>
        <form method="post" action="/upload" enctype="multipart/form-data">
            <input type="file" name="file" id="file" accept=".csv">
            </br>
            <button type="submit">Импортировать покупателей</button>
        </form>
    </body>
</html>