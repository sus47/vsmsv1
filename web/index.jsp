<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>RESULT PROCESSING SYSTEM</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/x-icon" href="favicon.ico">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

 <!--jQuery library--> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

 <!--Latest compiled JavaScript--> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>
    <body>
        <script>window.location.assign('/RV');</script>
<form method="POST" enctype="multipart/form-data" id="fileUploadForm">
     <input type="file" name="file"/><br/>
     <input type="submit" value="Submit" id="btnSubmit"/>
</form>
        <script>
        $(document).ready(function () {

    $("#btnSubmit").click(function (event) {
alert("nnn");
        //stop submit the form, we will post it manually.
        event.preventDefault();

        // Get form
        var form = $('#fileUploadForm')[0];

		// Create an FormData object
        var data = new FormData(form);

		// If you want to add an extra field for the FormData
        data.append("CustomField", "This is some extra data, testing");

		// disabled the submit button
        $("#btnSubmit").prop("disabled", true);

        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "http://localhost:8084/RPS/api/students/studentphotodetails?photoName=STU-11",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {
alert(data);
//                $("#result").text(data);
//                console.log("SUCCESS : ", data);
//                $("#btnSubmit").prop("disabled", false);

            },
            error: function (e) {

               alert(e);
            }
        });

    });

});
        </script>
        
<!--          $.ajax({
    type: 'POST',
    cache: false,
    contentType: 'multipart/form-data',
    processData: false,
    url: 'http://localhost:8084/RPS/api/students/studentphotodetails?photoName=STU-11',
    data: $('#fileInputBox').attr('file'),
    success: function(data) {
        alert(data);
    }
});-->
        <!--<script>window.location.assign('/RV');</script>-->
    
    </body>
</html>
<!--SELECT CONCAT('DELETE FROM ',`TABLE_NAME`,';') FROM information_schema.`TABLES` WHERE `TABLE_SCHEMA`='rps'-->