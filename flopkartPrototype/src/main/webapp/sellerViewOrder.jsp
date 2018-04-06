<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.iiitb.ooadvoid.AccessProperties" %>
<%@ page import="com.iiitb.ooadvoid.CreateProperties" %> 
<!DOCTYPE html>
<html lang="en">
<head>
<title>Seller Hub</title>
<%@include file="metaContent.jsp" %>
</head>
<body>

<%@include file="headerSeller.jsp" %>		
		
<div class="body-content outer-top-xs">
  <div class="container">
    <div class="row">
      <%@include file="sidebarSeller.jsp" %>
      <input type="text" id="sellerid" name="sellerid" hidden="hidden"/>
      <input type="text" id="count" name="count" hidden="hidden"/>
      <input type="text" id="count2" name="count2" hidden="hidden"/>
      <input type="text" id="img1" name="img1" hidden="hidden"/>
      <div class="col-md-9"> 
        <!-- ========================================== SECTION – HERO ========================================= -->
	      
		 <div class=col-sm-12 id="listingDisplay" style="margin: 0px 0px 0px 0px; padding:50px;background-color:white">
         <div class=row style="text-align:center">
           <div id="listing"></div>
         </div>
      </div>
	 </div>
    <!-- /.row --> 
     </div>
  <!-- /.container --> 
  </div>
</div>
<!-- /.body-content --> 


<!-- JavaScripts placed at the end of the document so the pages load faster --> 
<script src="./bootstrapFiles/js/jquery-1.11.1.min.js"></script> 
<script src="./bootstrapFiles/js/bootstrap.js"></script>
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
<script src="./customJavascripts/cookies.js"></script>
<script src="./customJavascripts/cookies.js"></script>
<script src="./bootstrapFiles/js/sweetalert.min.js"></script>
<script>
$(document).ready(function(){
	
	
 	 	checkCookie();
 	 	var ctxPath = "<%=request.getContextPath()%>";	
 	 	$('#count').val(0);
 	 	$('#count2').val(1000);
 		loadListings();
 		
		 
	});
function checkCookie() 
{
    var result = getCookie("seller_details");
    if (result != "") 
    {	
    		var user = JSON.parse(result);
		setCookie("seller_details", result, 30);
		document.getElementById("sellername").innerText = user.firstName;
		$('#sellerid').val(user.id);
		
	
    } 
    else 
    {	swal("no cookie");
      	window.location = "sellerHome.jsp";
    		logout();
    }
}
	function loadListings(){
		$('#listing').empty();
	    	var ctxPath = "<%=request.getContextPath()%>";
	<%--     	var subcategoryid = "<%=request.getParameter("id")%>"; --%>
	   var sellerid = $("#sellerid").val();
	  //	swal(sellerid);
	    	
		        $.ajax(
		        		{
		        			type : 'GET',
		        			contentType : 'application/json',
		        			url : ctxPath + "/webapi/listings/seller/"+sellerid,
		        			dataType : "json", // data type of response
		        			success : function(result1){
		        				for (var i in result1){
		        					//swal("ItemId: "+result1[i].itemId); success
							$.ajax(
									{	
		        							type : 'GET',
		        							contentType : 'application/json',
		        							url : ctxPath + "/webapi/orders/item/"+result1[i].itemId,
		        							dataType : "json", // data type of response
		        							success : function(result){
		        								if(result != ""){
		        									displayListings(result);
		        									
		        								}
		        							},
		        					    		error:function(err) {
			        					    		swal(err);
			        					    	}
		        						});
		        				}
		        	            
		        	    	},
		        	    	error:function(){
		        	    		swal("error occurred");
		        	    	}
		        		});
		}
	
		function changestatus(orderid, i, j){
			
			var ctxPath = "<%=request.getContextPath()%>";	
			$.ajax(
					{
					type : 'PUT',
					contentType : 'application/json',
					url :  ctxPath +"/webapi/orders/update/orderid/"+orderid,
					data : updatestatus(orderid),
					success : function()
					{
						 document.getElementById(i).innerHTML = "Item Status :  <b> Goods Shipped </b>";
						 document.getElementById(j).style.visibility = "hidden";
						 swal("You Confirmed : Goods Shipped !!");
					},
					error:function(){
		        	    		swal("error occurred");
		        	    	}
		        		});
			
		}
		
		function updatestatus() 
		{
		    
			var status = "Goods Shipped";
			
			var flopkart_order_update = JSON.stringify({
						"status":status
						
		    });
			
			return flopkart_order_update;
			
		}
		function displayListings(result)
		{	
			
			var ctxPath = "<%=request.getContextPath()%>";
		    <% AccessProperties ap = new AccessProperties(); %>
		    var imgServerURL = "<%=ap.getImageServerURL() %>"; 
		    
			var data="";
			var i = $("#count").val();
			var j = $("#count2").val();
			j++;
			i++;
			$('#count').val(i);
			$('#count2').val(j);
			
			
			var xxx = document.getElementById("img1").value;
			//alert($('#img1').val());
			data+="<div class = 'row' style = 'margin:5px 25px;border-style: groove;border-width: 7px;font-size:15px; text-align:left; padding-left:70px;' >"+
			"<div class='col-sm-4' style = 'font-size:15px; text-align:left; padding-top: 40px ; padding-left:0px;'>"+
				" <div style='width: 260px;height: 250px;'>"+
					"<img class='listingImage' id ="+ result[0].itemId +" style='max-height:100%; max-width:100%;' src='"+xxx+"' alt=''>"+
				"</div>"+
			"</div>"+
			"<div class='col-sm-8' style ='font-size:15px; text-align:left; padding:20px;' >"+
			"<h2 style='padding-bottom:20px;'>Ordered Item No: "+i+"</h2>"+
	        "<div style = 'padding-bottom:10px;font-size:15px;'>Order ID :  <b>"+result[0].orderId+"</b></div>"+
	        "<div style = 'padding-bottom:10px;font-size:15px;'>Shipping Address : <b> "+result[0].shippingAddress+"</b></div>"+
	        "<div style = 'padding-bottom:10px;font-size:15px;'>Total Amount : <b> "+result[0].totalAmount+"</b></div>"+
	        "<div  style = 'padding-bottom:10px;font-size:15px;'>Quantity : <b> "+result[0].quantity+"</b></div>"+
	        "<div  id='"+i+"' style = 'padding-bottom:10px;font-size:18px;color:green;'>Item Status :  <b>"+result[0].status+"</b></div><div><input  id='"+j+"' type='button'onclick='changestatus("+result[0].orderId+","+i+","+j+");' value ='Goods Shipped??'/></div>"+
	       	"</div></div>";
	       	
			
	       	$('#listing').append(data);
	       	
			if(result[0].status != "Money Paid" ){
				document.getElementById(j).style.visibility = "hidden";
			}
			
	       	var itemid = result[0].itemId;
			$.ajax(
					{
					type : 'GET',
					contentType : 'application/json',
					url :  ctxPath +"/webapi/listings/item/"+itemid,
					success : function(result)
					{
						var imgs = imgServerURL+result.imgUrl;
						$('#img1').val(imgs);
						document.getElementById(itemid).src = imgs;
					},
					error:function(){
		        	    		swal("error occurred");
		        	    	}
		        		});
		}
		
		function logout()
		{
			deleteCookie("seller_details");
		}
</script>		
</body>
</html>