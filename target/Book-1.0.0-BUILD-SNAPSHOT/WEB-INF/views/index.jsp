<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <link href="<c:url value="/resources/css/home.css" />" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phone book</title>

        <script src="http://code.jquery.com/jquery-3.3.1.js"
                integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="
        crossorigin="anonymous"></script>

        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body>

        <div class="col-md-6 center_panel">
            <div class="panel panel-default panel-table">
                <div class="panel-body">
                    <table class="table table-striped table-bordered table-list">
                        <thead>
                            <tr>
                                <th class="hidden-xs">ID</th>
                                <th>Name</th>
                                <th>Phone</th>
                                <th>Email</th>
                            </tr> 
                        </thead>
                        <tbody id="tbody">

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        
        <script type="text/javascript">
            $(function () {
                console.log("ajax start");
                $.ajax({
                    url: 'http://localhost:8080/Book/getJsonPhoneBook',
                    type: "POST",
                    success: function (data) {
                        console.log(data);
                        for (i = 0; i < data.length; i++) {
                            $("#tbody").append(
                                    "<tr>" +
                                    "<td class='hidden-xs'>" + data[i].id + "</td>" +
                                    "<td>" + data[i].name + "</td>" +
                                    "<td>" + data[i].phone + "</td>" +
                                    "<td>" + data[i].email + "</td>" +
                                    "</tr>"
                                    );
                        }
                    },
                    error: function (XmlHttpRequest, textStatus, errorThrown) {
                        alert(errorThrown);
                    }
                });
            });
        </script>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>