<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pet Services Website</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<style>
    body {
        margin: 0;
        padding: 0;
        height: 100vh;
        background-image: url('images/thankyou.jpg');
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
    }
a {
        text-decoration: none;
        color: #333;
        font-size: 20px;
    }
    
    a:hover {
        background: silver;
        transform: translateY(-10px);
    }

    nav {
        display: flex;
        justify-content: flex-end;
        padding: 20px;
        position: absolute;
        top: 0;
        width: 80vw;
    }

    nav ul {
        list-style: none;
        margin: 0;
        padding: 0;
        display: flex;
    }

    nav ul li {
        padding: 10px;
    }
    .container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 60vh;
        margin: 0;
    }

    .box {
        margin-top: 0;
    }

    .box div {
        padding-top: 0px;
        text-align: center;
        padding: 40px;
        font-size: 13px;
        font-weight: 300;
        border-radius: 20px;
        background: #eee;
        transition: background 0.4s, transform 0.4s;
    }
    

    .box div:hover {
        background: silver;
        transform: translateY(-10px);
    }

    .cent {
        /* border: 5px; */
        margin: auto;
        width: 40%;
        padding: 10px;
    }
</style>

<body>

<%  String myname=(String)session.getAttribute("key");

if (myname == null) {
    // If session is expired or user is not logged in, redirect to home page
    response.sendRedirect("index.html");
    return;
}
%>

        <nav>
            <ul>
                <li><a href="Home" >Home</a></li>
                
            </ul>
        </nav>
    <div class="container">
        <div class="box cent">
            <div>
            <h3 style='color:rgb(133, 117, 72)'> <%= myname  %> </h3>
                <h3 style='color:green'>Thank You for Contacting Us!</h3>
                <p>Your submission has been received. Our representative will contact you shortly to assist with your
                    inquiry.</p>
                    
            </div>
        </div>
 
    </div>

</body>

</html>