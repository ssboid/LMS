<%-- 
    Document   : AddBooks
    Created on : Apr 25, 2022, 6:34:33 PM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="entrypages.css">
    <title>Add Book | Library Management System</title>
</head>
<body id="bg">
   <div id="head"><a href="http://localhost:8080/LMS/Welcome"><h1>Library Management System</h1></a></div>
 
   <div id="head2"><p>Add a Book</p></div>
       <div id="formcontainer">
        <form action="AddBook" method="get">
            <table>
                <tr>
                    <td>
                        <label class="text" for="bname">Book Name:</label>
                    </td>
                    <td>
                        <input type="text" required name="bname" placeholder="Book name.." class="input">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="text" for="genre">Genre:</label>
                    </td>
                    <td>
                        <input type="text" required name="genre" placeholder="Genre.." class="input">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="text" for="price">Price:</label>
                    </td>
                    <td>
                        <input type="number" required name="price" placeholder="Price.." class="input" min="0">
                    </td>
                </tr>
                <tr >
                    <td colspan="2">
                        <button id="submit" type="submit">Add Book</button>
                    </td>
                </tr>
            </table>
        </form>
       </div>
</body>
</html>