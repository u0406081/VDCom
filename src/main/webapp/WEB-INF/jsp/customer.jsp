<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit/create customer</title>
</head>
<body>

    <form:form action="/updateCustomer" method="post" modelAttribute="customer">
        <table>
            <form:hidden path="id" value="${customer.id}"/>
            <tr>
                <td>Фамилия</td>
                <td><form:input type="text" path="surname" value="${customer.surname}"/></td>
            </tr>
            <tr>
                <td>Имя</td>
                <td><form:input type="text" path="name" value="${customer.name}"/></td>
            </tr>
            <tr>
                <td>Отчество</td>
                <td><form:input path="lastname" value="${customer.lastname}"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="Сохранить"/></td>
                <td></td>
            </tr>
        </table>
    </form:form>
</body>
</html>