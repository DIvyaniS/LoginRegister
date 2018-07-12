<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome <a href>${pageContext.request.userPrincipal.name}</a> | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

    </c:if>
    <div>
        <a href = "/addcard">Add add card to begin</a>
    </div>
    <div>
        <a href = "/addmoney">Add money to your wallet</a>
    </div>
    <div>
        <a href = "/sendmoney">Send/Pay money from your wallet</a>
    </div>
    <div>
        <a href = "/checkbal">check your wallet balance</a>
    </div>
    
    
</div>


<!-- <div><form action="/action_page.php">
Enter Amount <input type="text" name="addMoney"><br>

<input type="submit" value="Add Money">
</form></div>


<div class="container">
<div><form action="/action_page.php">

Enter Card No. <input type="text" name="CardNo"><br>

<input type="submit" value="Add Card">
</form></div>
Send money</br>
<button type="button" onclick="alert('Hello world!')">Check balance</button>

View transaction history</br>
<div>
<button onclick="myFunction()">See Transaction History</button>

<p id="demo"></p>

<script>
function myFunction() {
    document.getElementById("demo").innerHTML = "Hello World";
}
</script></div>




</div>

-->
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
