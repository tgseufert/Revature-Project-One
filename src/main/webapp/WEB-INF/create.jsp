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
        <h1>Added/Updated recipe</h1>
    </header>

    <div class="center">
        <h2>${name} was ${status}.</h2>


    </div>
    <p>
        <a href="/Project_1">Return home</a>
    </p>
  <p>
              <a href="search?saved+recipes=${name}">View recipe</a>
          </p>
</body>
</html>