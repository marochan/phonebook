<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Phonebook homepage</title>
</head>
<body>
<h1>Welcome to the PhoneBook</h1>
    <form:form modelAttribute="record">
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
                <td>
                    Phone:
                </td>
                <td>
                    <form:input path="phone"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Add number">
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
