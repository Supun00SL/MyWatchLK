<%-- 
    Document   : ERROR500
    Created on : Aug 2, 2017, 7:34:49 AM
    Author     : Supun Madushanka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
        <script  type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
        <script  type="text/javascript" src="js/bootstrap.js"></script>
        <title>Internal Server Error</title>
    </head>
    <body>
    <center>
        <br>
        <img src="img/500-Internal-Server-Error.jpg" class="img-responsive" width="60%">
        <br>
        <form method="post" action="Send500ErrorMail">
            <input type="submit" value="Report the Problem" class="btn btn-warning">

        </form>

    </center>
</body>

</html>
