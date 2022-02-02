<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title>Delete a number</title>
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
<h1>Write a name to be deleted below</h1>
<form:form modelAttribute="deletion" >
    <form:errors path="*" cssClass="errorBlock" element="div"/>
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
                <input type="submit" value="Delete" >
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
