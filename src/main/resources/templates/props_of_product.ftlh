<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Props</title>
</head>
<body>
<h1>Positions exists</h1>
<table>
    <tr>
        <th>ID</th>
        <th>Colour</th>
        <th>Action</th>
    </tr>
    <#list props as prop>
        <tr>
            <td>${prop.id}</td>
            <td>${prop.colour}</td>
        </tr>
    </#list>
</table>
<h1>Free positions</h1>
<table>
    <tr>
        <th>ID</th>
        <th>colour</th>
    </tr>
    <#list unusedProps as prop>
        <tr>
            <td>${prop.id}</td>
            <td>${prop.colour}</td>
            <td>
                <form method="post" action="/product/${productId}/props">
                    <input name="propId" type="hidden" value="${prop.id}">
                    <input type="submit" value="Add">
                </form>
            </td>
        </tr>
    </#list>
</table>
</body>
</html>