<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new deal category</title>
</head>
<link rel="stylesheet" href="./bootstrapFiles/css/bootstrap.min.css">
<link rel="stylesheet" href="./bootstrapFiles/css/SellerRegStyle.css">
</head>
<body style="background: url(&quot;./images/sellerHub/Signup-screen-BG.jpg&quot;) no-repeat;
  background-size: 100%;">
	<header>
		<nav class="nav navbar-default" style="background-color:#027cd5">
			<a href="index.jsp"><img class="logo" src="./images/flopkartLogo.jpg"></a>
		</nav>
	</header>
		
	<br/><br/>
	<div class="col-md-8">
		<div class="container" style="text-align: center; width: 400px">
			<h3 style="color:white">Enter new deal category</h3><br/>
			<form>
				<input class="form-control" type="text" id="dealName"
					placeholder="Enter deal name"> 
				<br/>
				<input type="submit"
					onclick="insertDealCategory();" />
			</form>
		</div>
	</div>
	
	<div class="col-md-4" style="text-align:center">
		<h2 style="color:white">Current deals</h2>
		<div style="color:white" id="content"></div>
	</div>
</body>

<script src="./bootstrapFiles/js/jquery-1.11.1.min.js"></script>
<script src="./bootstrapFiles/js/bootstrap.min.js"></script>
<script src="./bootstrapFiles/js/bootstrap-hover-dropdown.min.js"></script>
<script src="./bootstrapFiles/js/owl.carousel.min.js"></script>
<script src="./bootstrapFiles/js/echo.min.js"></script>
<script src="./bootstrapFiles/js/jquery.easing-1.3.min.js"></script>
<script src="./bootstrapFiles/js/bootstrap-slider.min.js"></script>
<script src="./bootstrapFiles/js/jquery.rateit.min.js"></script>
<script src="./bootstrapFiles/js/bootstrap-select.min.js"></script>
<script src="./bootstrapFiles/js/wow.min.js"></script>
<script src="./bootstrapFiles/js/scripts.js"></script>
<script src="./bootstrapFiles/js/sweetalert.min.js"></script>
<script>
$(document).ready(function(){
	fetch();
});

function fetch() 
{
    var ctxPath = "<%=request.getContextPath()%>";
	$.ajax(
	{
		type : 'GET',
		contentType : 'application/json',
		url : ctxPath + "/webapi/deals",
		dataType : "json", // data type of response
		success : function(result){
			var data="<p>";
            for(var i in result){
               data+="<br/>"+(parseInt(i)+1)+") "
               data+="Deal Name: "+result[i].dealname+"<br/>";
            }
            data += "</p>";
            $("#content").html(data);
    	},
    	error:function() {
        	swal("error occurred");
    	}
	});
}

function formToJSON() 
{
	var dealName = $("#dealName").val();
	var flopkartDeal = JSON.stringify({
	    "dealname" : dealName
	});
	//alert(flopkartDeal);
	return flopkartDeal;
}

function render(){
	swal("Succesful entry into the database");
	window.location.reload(true);
}

function insertDealCategory()
{
	var ctxPath = "<%=request.getContextPath()%>";
	$.ajax(
		{
			type : 'POST',
			contentType : 'application/json',
			url : ctxPath + "/webapi/deals/create",
			data : formToJSON(),
			success : render(),
			error: function() {
				swal(JSON.stringify(err));
			}
	});
}
</script>
</html>