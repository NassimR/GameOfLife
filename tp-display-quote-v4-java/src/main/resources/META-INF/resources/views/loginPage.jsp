<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Page de login pour l'application</title>

    <script type="text/javascript"
            src="/resources/js/jquery-2.2.0.js"></script>
    <script type="text/javascript" src="/resources/js/bootstrap.js"></script>

    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-theme.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">

    <link href="/resources/css/signin.css" rel="stylesheet">

</head>

<body>

<div class="container">

    <form class="form-signin" action="/login" method="post">
        <h2 class="form-signin-heading">Authentification</h2>
        <label for="username" class="sr-only">User</label>
        <input id="username" class="form-control" placeholder="Pseudonyme" name="username" required autofocus>
        <br/>
        <label for="password" class="sr-only">User</label>
        <input id="password" type="password" class="form-control" placeholder="Password" name="password" required autofocus>
        <br/>
        <button class="btn btn-lg  btn-success btn-block" type="submit">S'authentifier</button>
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
    </form>
</div>
</body>
</html>
