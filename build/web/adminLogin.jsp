<%-- 
    Document   : adminLogin
    Created on : Oct 10, 2016, 10:39:38 AM
    Author     : Supun Madushanka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
        <script src="js/bootstrap.js"></script>
        <title>Admin Login</title>

        <style>
            .panel{
                text-align: center;
                width: 40%;
                position: relative;
                margin-left: 27%;
                margin-top: 10%;

            }
            .label{
                background-color: #663300;

            }
            .label-default{
                float: left;
                font-family: "Century Gothic";
                font-size: 20px;
                background-color: transparent;
                color: #333333;
            }
            .form-control{
                float: right;
                width: 50%

            }
            .btn-info{
                float: right;

            }
            .warinintxt{
                color: #ff3333;

            }

        </style>

        <script>
            function getData() {
                var xhttp;

                if (window.XMLHttpRequest) {
                    xhttp = new XMLHttpRequest();
                } else {
                    xhttp = new ActiveXObject("Microsoft.XMLHTTP");
                }
                var stat = document.getElementById("status");

                xhttp.onreadystatechange = function () {
                    if (xhttp.readyState === 4 & xhttp.status === 200) {
                        var text = xhttp.responseText;
                        if (text.length > 0) {
                            stat.innerHTML = xhttp.responseText;
                            document.getElementById("uname").value = '';
                            document.getElementById("pword").value = '';
                        } else {
                            window.location = "AdminHome.jsp";
                        }
                    }

                };
                xhttp.open("POST", "AdminLoginStatus", false);
                xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xhttp.send("u=" + document.getElementById("uname").value + "&p=" + document.getElementById("pword").value);

            }
            
            window.history.forward();
            function noBack() {
                window.history.forward();
            }
        </script>

    </head>

    <body onload="noBack()" onpageshow="if (event.persisted) noBack();" onunload="">
        <%
          
             HttpSession hs = request.getSession();
             
             if(hs.getAttribute("client")!=null){
                response.sendRedirect("index.jsp");            
             }
             
             if(hs.getAttribute("admin")!=null){
                response.sendRedirect("AdminHome.jsp");
             }
             
             if(hs.getAttribute("supplier")!=null){
                response.sendRedirect("SupplierHome.jsp");
             }
            
        %>
        <div class="panel">
            <div class="panel-title">
                <h1>Admin Login</h1>
            </div>
            <div class="panel-body">

                <label class="label label-default">User Name : </label>
                <input type="text" class="form-control" id="uname" placeholder="User Name"><br><br>
                <label class=" label label-default">Password  :  </label>
                <input type="password" class="form-control" id="pword" placeholder="Password"><br><br>

            </div>
            <div id="status" class="warinintxt">
            </div>
            <div class="panel-footer">
                <button type="submit" class="btn btn-info" id="login" onclick="getData()">Login</button>
            </div>
        </div>
    </body>
</html>
