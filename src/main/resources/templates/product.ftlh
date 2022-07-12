<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Product list</title>
</head>
<body>
<h1>Add product</h1>
<form method="post" action="/product">
    <label>Name:
        <input name="name" placeholder="Name">
    </label>
    <input type="submit" value="Add">
</form>
<table>
    <tr>
        <th>ID</th>
        <th>name</th>
        <th>Activity</th>
    </tr>
    <#list product as product>
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>
                <form method="post" action="/product/${product.id}/delete">
                    <input type="submit" value="Delete">
                </form>
                <a href="/product/${product.id}">In</a>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>