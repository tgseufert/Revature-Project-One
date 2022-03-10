<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Viewing saved recipe</title>
<link rel="stylesheet" href="projectOneCss/project1styles.css">

<style>
    .center{
    text-align:center;
    border: 5px solid black;
    }
</style>

</head>
<body>
    <header>
        <h1>${name}</h1>
    </header>

    <div class="center">
        <ul>
            <h3>Ingredients:</h3>
            <li>ing1</li>
            <li>ing2</li>
            <li>ing3</li>
        </ul>
        </br>
        <p>${instructions}</p>
    </div>
    <p>
    <a href="/Project_1">Return home</a>
    </p>

</body>
</html>