<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello World!</title>
</head>
<body>
    Hello World!
    <br>
    <%
        out.println("Your IP address is " + request.getRemoteAddr());
    %>
</body>
</html>