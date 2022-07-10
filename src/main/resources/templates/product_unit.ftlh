<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Имя</title>
</head>
<body>
<h3>Name - ${product.name}</h3>
<br>
<form method="post" action="/product/${product.id}/update">
    <label>
        Name: <input name="name" value="${product.name}">
    </label>
    <label>
        Cost: <input name="cost" value="${product.cost}">
    </label>
    <input type="submit" value="Save">
</form>
</body>
</html>