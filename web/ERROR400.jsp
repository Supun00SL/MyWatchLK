<%-- 
    Document   : ERROR400
    Created on : Aug 2, 2017, 8:00:29 AM
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
        <title>Bad Request</title>
    </head>
    <body>
       <center>
           <img src="img/error400Badrequest.jpg" class="img-responsive">
        <button class="btn btn-info" onclick="goto()">Go to Home</button>

    </center>
    </body>
    <script>
    function goto() {
        window.location = "index.jsp";
    }
</script>
</html>
