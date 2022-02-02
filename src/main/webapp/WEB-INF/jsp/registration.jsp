<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Phonebook homepage</title>
    <style>
        .error{
            color:#FF0000
        }
        errorblock{
            color: aliceblue;
            background-color: #ffEEEE;
            border: 3px solid #FF0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<body>
<h1>Welcome to the PhoneBook</h1>
    <form:form modelAttribute="record">
        <form:errors path="*" cssClass="errorBlock" element="div"/>
        <table>
            <tr>
                <td>
                    Name:
                </td>
                <td>
                    <form:input path="name"/>
                </td>
                <td>
                    <form:errors path="name" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td>
                    Phone:
                </td>
                <td>
                    <form:input path="phone"/>
                </td>
                <td>
                    <form:errors path="phone" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <input type="submit" value="Add number">
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
