<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title>Delete a number</title>
</head>
<body>
<h1>Write a name to be deleted below</h1>
<form:form modelAttribute="deletion">
    <table>
        <tr>
            <td>
                Name:
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Delete">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
