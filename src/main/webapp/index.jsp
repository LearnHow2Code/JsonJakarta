<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>

    <title>JSP Json Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%--    <script src="jquery-3.6.0.min.js" type="text/javascript"></script>--%>
    <script>
        function addNewManufacturer() {
            alert("Hello");
            var Fname = "Alem";
            alert("The name is : ");
            var name = $("#name").val();
            var address = $("#address").val();
            var phone = $("#phone").val();
            alert("The name is : " + name);
            var sendInfo = { Name: name, Address: address, Phone: [{phone1: "2131321312"}, {phone2: "45435435435"}], onlyarray: [10, 20, 30, 40, 50]};
            $.ajax({
                type: "POST",
                url: "<%=request.getContextPath()%>/JsonParsor",
                dataType: "json",
                success: function(msg) {
                    alert(msg);
                },
                data: {d: JSON.stringify(sendInfo)}
            });
        }
  /*   function loadDoc() {
         // alert("Hello 1");
         var xhttp = new XMLHttpRequest();
         // alert("Hello 2 ");
         xhttp.onreadystatechange = function() {
             // alert("Hello 3 ");
             if (this.readyState === 4 && this.status === 200) {
                 // alert("Hello 4 ");
                 document.getElementById("demo").innerHTML =
                     this.responseText;
             }
         };
         xhttp.open("GET", "ajax_info.txt", true);
         xhttp.send();
         // alert("Hello 5 ");
     }*/
    </script>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<h1>Hello World !</h1>
<input type="text" name="name" id="name" />
<input type="text" name="add" id="address" />
<input type="text" name="phone" id="phone" />
<a href="#" onclick="addNewManufacturer();">Ok</a>
<div id="demo">
    <h1>The XMLHttpRequest Object</h1>
    <button type="button" onclick="loadDoc()">Change Content</button>
</div>

</body>
</html>