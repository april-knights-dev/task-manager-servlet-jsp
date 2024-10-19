<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>タスクリスト</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }
        h1 {
            color: #333;
        }
        form {
            background: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
            margin-bottom: 20px;
        }
        input[type="text"],
        textarea,
        input[type="date"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            background-color: #0073e6;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #005bb5;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #0073e6;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        a {
            color: #e63946;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <%-- エラーメッセージの表示 --%>
    <c:if test="${not empty sessionScope.errorMessage}">
        <p style="color: red;">${sessionScope.errorMessage}</p>
        <% session.removeAttribute("errorMessage"); %>
    </c:if>
    <h1>タスクリスト</h1>
    <form action="addTask" method="post">
        タイトル: <input type="text" name="title" required><br>
        説明: <textarea name="description" required></textarea><br>
        期限: <input type="date" name="dueDate" required><br>
        <input type="submit" value="タスクを追加">
    </form>
    <c:if test="${not empty tasks}">
        <table>
            <tr>
                <th>タイトル</th>
                <th>説明</th>
                <th>期限</th>
                <th>完了</th>
                <th>アクション</th>
            </tr>
            <c:forEach var="task" items="${tasks}">
                <tr>
                    <td>${task.title}</td>
                    <td>${task.description}</td>
                    <td>${task.dueDate}</td>
                    <td>${task.completed ? '完了' : '未完了'}</td>
                    <td>
                        <a href="deleteTask?id=${task.id}">削除</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty tasks}">
        <p>タスクはありません。</p>
    </c:if>
</body>
</html>
