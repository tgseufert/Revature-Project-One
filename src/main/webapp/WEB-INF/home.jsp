<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project 1 home</title>

    <link rel="stylesheet" href="projectOneCss/project1styles.css">
</head>
<body>

<header>
    <h1>Recipe Repository</h1>
</header>
    <span class="selector">
        <h2>Recipe selector</h2>

            <form action="search" method="get">
                <input type="text" name="saved recipes">
                <input type="submit" value="get recipes">
            </form>
       </br></br> </br> </br>
        <h2>Delete recipe</h2>
        <form action="delete" method="get">

            <input type="text" name="deletion recipe">
            <input type="submit" value="get recipes">
        </form>
    </span>

    <span class="creator">
        <h2>Create or edit a recipe</h2>

        <form action="create" method="post">
            <h3>Name: <input type="text" name="recipe name"></br></h3>
            <ol>
                <li><input type="text" name="ingredient0"><input type="text" name="quantity0"></li>
                <li><input type="text" name="ingredient1"><input type="text" name="quantity1"></li>
                <li><input type="text" name="ingredient2"><input type="text" name="quantity2"></li>

            </ol>
            <textarea rows="5" cols="30" name="add recipe"></textarea></br>
            <input type="submit" for="add recipe" value="Add recipe ">
            <input type="submit" for="add recipe" value="Update recipe">
        </form>

    </span>

</body>

<!--<script scr="projectOneScripts/projectOneScripts.js"></script>-->
</html>
