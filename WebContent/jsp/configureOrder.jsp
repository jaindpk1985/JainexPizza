<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Jainex Pizza</title>

<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script type="text/javascript" src="scripts/jquery-1.5.2.js"></script>
<script type="text/javascript" src="scripts/jquery-ui-1.8.6.custom.js"></script>

<script type="text/javascript">

function deleteOrderedItem(id){

        var deleteSelectedOrder = "deletePizzaInOrder.action?index="+id;
         $.ajax({  

                        type: "POST",
                        url:deleteSelectedOrder,  
                        dataType:'json',
                        cache: false,
                        error: function(){              
                                alert('Error in Deleting data');
                        },
                        success: function(data){ 
                				displayOrderedPizzaDataListData(data);
                        }
         }); 
}


function showOption(pizzaId){
				$('#pizzaId').val(pizzaId);
				$('#popupDialog').show("slide", { direction: "up" }, 500);
} 

function closeOption(){
				$('#popupDialog').hide("slide", { direction: "up" }, 500);
} 
function addPizza(){
				
			var pizzaId = $('#pizzaId').val();
			var orderSize = $('#orderSize').val();
			var orderQuantity =$('#quantity').val();
			var toppings = new Array();
			$('form input:checkbox').each(function() {
				if($(this).is(':checked')){
    				toppings.push($(this).val());
    			}
			});
			
		 	$.ajax({
          	url : "addPizzaInOrder.action?orderedPizzaData.pizzaId="+pizzaId+"&orderedPizzaData.orderSize="+orderSize+"&orderedPizzaData.quantity="+orderQuantity+"&toppings="+toppings,
          	type:"POST",
          	cache: false,
          	dataType: "json",
          
          	error: function(XMLHttpRequest, textStatus, errorThrown){
			    				alert('Error in retrieving data: ' + textStatus);
			    			},
	      	success :function(data,args) { 
	      			if(data.orderedPizzaDataList!=null && data.orderedPizzaDataList.length>0)
              		{
                		displayOrderedPizzaDataListData(data);
                		$('#pizzaId').val("");
                		$('#orderSize').val("");
                		$('#quantity').val("");
                		$('form input:checkbox').removeAttr('checked',false);
              		}
             	}
           
          	});
          	$('#popupDialog').hide("slide", { direction: "up" }, 500);
          	
}

function displayOrderedPizzaDataListData(data){

			 var $shoppingCartDiv = $('#shoppingCartDiv');
          	var innerHTML = '<table width="188" border="0" cellpadding="0" cellspacing="0"><tr><td colspan="5" class="menu" align="center">Your Order</td></tr>';
          	if (data.orderedPizzaDataList !=null && data.orderedPizzaDataList.length>0)
			{   
				innerHTML += '<tr><td></td><td class="subHead2">Pizza Name</td><td class="subHead2">Qty</td><td class="subHead2">Price</td><td></td></tr>'
				for (i=0;i<data.orderedPizzaDataList.length;i++)
                {
                       innerHTML +=			'<tr>'
                       innerHTML +=			'<td align="center" width="20"><img src="images/q.jpg"	border="0" width="7" height="7" alt=""></td>'
					   innerHTML +=			'<td id="ordered" class="news" height="25" nowrap="nowrap"><b>'+data.orderedPizzaNames[i]+'</b></td>'
					   innerHTML +=			'<td class="news" height="25"	nowrap="nowrap"><b>'+data.orderedPizzaQuantities[i]+'</b></td>'
					   innerHTML +=		    '<td class="news" height="25"	nowrap="nowrap"><b>'+data.orderedPizzaPrices[i]+'</b></td>'
					   innerHTML +=			'<td width="20"><a href="#" onclick="deleteOrderedItem('+i+')"><img	src="images/delete.png" title="Delete" ></a></td>'
					   innerHTML +=			'</tr>'
                 }
                 innerHTML += '<tr><td colspan="3" class="subHead2">Total Order Price</td><td colspan="2" class="menu" align="center">'+data.totalOrderPrice+'Rs</td></tr></table>'
                 $shoppingCartDiv.empty();
				 $(innerHTML).appendTo($shoppingCartDiv);
			}
			else{
				innerHTML += '<tr><td colspan="5" align="center" class="subHead2">No Item selected</td></tr></table>';
				$shoppingCartDiv.empty();
				 $(innerHTML).appendTo($shoppingCartDiv);
			}

}


function checkOrderedItem(){
	alert($('#ordered').length);

}


</script>
</head>

<body>

<table class="mainTable">
	<tr>
		<td bgcolor="#E6E6E6" valign="top">
		<table width="780" border="0" cellpadding="0" cellspacing="0">
			<tr rowspan="3">
				<td colspan="3"><img height="150" width="1020"
					src="images/header.png"></td>



			</tr>
			<tr>
				<td background="images/last.jpg" colspan="3">
				<table>
					<tr>
						<td width="700px" align="left" class="menu">Welcome <s:property value="userFullName"/></td>
						<td width="100px" align="center"><a href="" class="menu"></a></td>
						<td width="100px" align="center"><a href="homeProfile.action"
							class="menu">Home</a></td>
						<td width="100px" align="left"><a href="logOut.action"
							class="menu">Sign Out</a></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td colspan="3" class="pageTitle" align="center">Configure
				Order
				<td>
			</tr>


			<tr>
				<td valign="top" width="241"><br>
				<table border="0" cellpadding="0" cellspacing="0" width="241">
					<tr>
						<td valign="top" width="241">
						<table border="0" cellpadding="0" cellspacing="0" width="241">
							<tr>
								<td colspan="3" valign="top" width="241"><img
									src="images/l_1.jpg" border="0" width="241" height="18" alt=""></td>

							</tr>
							<tr>
								<td valign="top" align="right" background="images/l_l.jpg"
									width="29"></td>
								<td valign="top" width="188" bgcolor="#9D9EA3">
								<table border="0" cellpadding="0" cellspacing="0" width="188">
									<s:if test="userRole=='Consumer'">
										<tr>
											<td>&nbsp;&nbsp;&nbsp;</td>
											<td align="left" valign="top"><img src="images/q.jpg"
												border="0" width="7" height="7" alt=""></td>
											<td>&nbsp;&nbsp;&nbsp;</td>
											<td valign="top" class="news" height="25"><b><a
												href="userProfile.action" class="leftMenu">Create
											Profile</a></b></td>
											<td>&nbsp;&nbsp;&nbsp;</td>
										</tr>
										<tr>
											<td>&nbsp;&nbsp;&nbsp;</td>
											<td align="left" valign="top"><img src="images/q.jpg"
												border="0" width="7" height="7" alt=""></td>
											<td>&nbsp;&nbsp;&nbsp;</td>
											<td valign="top" class="news" height="25"><b><a
												href="userPreferences.action" class="leftMenu">Create
											Preferences</a></b></td>
											<td>&nbsp;&nbsp;&nbsp;</td>
										</tr>
										<tr>
											<td>&nbsp;&nbsp;&nbsp;</td>
											<td align="left" valign="top"><img src="images/q.jpg"
												border="0" width="7" height="7" alt=""></td>
											<td>&nbsp;&nbsp;&nbsp;</td>
											<td valign="top" class="news" height="25"><b><a
												href="customerOrders.action" class="leftMenu">Order
											History</a></td>
											<td>&nbsp;&nbsp;&nbsp;</td>
										</tr>
										<tr>
											<td>&nbsp;&nbsp;&nbsp;</td>
											<td align="left" valign="top"><img src="images/q.jpg"
												border="0" width="7" height="7" alt=""></td>
											<td>&nbsp;&nbsp;&nbsp;</td>
											<td valign="top" class="news" height="25"><b><a
												href="configureOrder.action" class="leftMenu">Configure
											Order</a></b></td>
											<td>&nbsp;&nbsp;&nbsp;</td>
										</tr>
									</s:if>

									<s:if test="userRole == 'Bpo'">
										<tr>
											<td>&nbsp;&nbsp;&nbsp;</td>
											<td align="left" valign="top"><img src="images/q.jpg"
												border="0" width="7" height="7" alt=""></td>
											<td>&nbsp;&nbsp;&nbsp;</td>
											<td valign="top" class="news" height="25"><b><a
												href="addCustomer.action" class="leftMenu">Cofigure
											Customer Orders</a></td>
											<td>&nbsp;&nbsp;&nbsp;</td>
										</tr>
										<tr>
											<td>&nbsp;&nbsp;&nbsp;</td>
											<td align="left" valign="top"><img src="images/q.jpg"
												border="0" width="7" height="7" alt=""></td>
											<td>&nbsp;&nbsp;&nbsp;</td>
											<td valign="top" class="news" height="25"><b><a
												href="customerOrders.action" class="leftMenu">Customer
											Orders</a></td>
											<td>&nbsp;&nbsp;&nbsp;</td>
										</tr>
									</s:if>
								</table>
								</td>
								<td valign="top" align="left" background="images/l_r.jpg"
									width="24"></td>
							</tr>
							<tr>
								<td colspan="3" valign="top"><img src="images/l_2.jpg"
									border="0" width="241" height="17" alt=""></td>

							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<td valign="top" width="241"><br>


						<!--Shopping cart-->

						<table style="margin-top:15" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<td colspan="3" valign="top" width="241"><img
									src="images/l_1.jpg" border="0" height="18" alt=""></td>

							</tr>
							<tr>
								<td valign="top" align="right" background="images/l_l.jpg"
									width="29"></td>
								<td valign="top" width="188" bgcolor="#9D9EA3">
								<div id="shoppingCartDiv">
								<table width="188" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td colspan="5" class="menu" align="center">Your Order</td>
									</tr>

									<s:if
										test="orderedPizzaDataList !=null && orderedPizzaDataList.size() > 0">
										<tr>
											<td></td>
											<td class="subHead2">Pizza Name</td>
											<td class="subHead2">Qty</td>
											<td class="subHead2">Price</td>
											<td></td>
										</tr>
										<s:iterator value="orderedPizzaDataList" status="listIndex">
											<tr>
												<td align="center" width="20"><img src="images/q.jpg"
													border="0" width="7" height="7" alt=""></td>
												<td id="ordered" class="news" height="25" nowrap="nowrap"><b><s:property
													value="pizzaName" /></b></td>
												<td class="news" height="25" nowrap="nowrap"><b><s:property
													value="quantity" /></b></td>
												<td class="news" height="25" nowrap="nowrap"><b><s:property
													value="totalPizzaPrice" /></b></td>
												<td width="20"><a href="#"
													onclick="deleteOrderedItem(<s:property value="%{#listIndex.index}" />)"><img
													src="images/delete.png" title="Delete"></a></td>
											</tr>
										</s:iterator>
										<tr>
											<td colspan="3" class="subHead2">Total Order Price</td>
											<td colspan="2" class="menu" align="center"><s:property
												value="totalOrderPrice" />Rs</td>
										</tr>
									</s:if>
									<s:else>
										<tr>
											<td colspan="5" align="center" class="subHead2" />No Item
											selected
										</tr>
									</s:else>





								</table>
								</div>


								</td>
								<td valign="top" align="left" background="images/l_r.jpg"
									width="24"></td>
							</tr>
							<tr>
								<td colspan="3" valign="top"><img src="images/l_2.jpg"
									border="0" width="241" height="17" alt=""></td>

							</tr>
						</table>


						<table style="margin-top:15" border="0" cellpadding="0"
							cellspacing="0">
							<tr>
								<td colspan="3" valign="top" width="241"><img
									src="images/l_1.jpg" border="0" height="18" alt=""></td>

							</tr>
							<tr>
								<td valign="top" align="right" background="images/l_l.jpg"
									width="29"></td>
								<td valign="top" width="188" bgcolor="#9D9EA3">
								<form action="payment" method="post">
								<table width="188" border="0" cellpadding="0" cellspacing="0">
									<tr height="10">
										<td colspan="2" class="subHead" align="center" height="20"
											valign="middle"><s:radio id="delivery"
											list="deliverChoices" name="deliveryChoice"></s:radio></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td colspan="2" align="center"><s:submit
											value="Place Order" onclick="" align="center" /></td>
									</tr>

								</table>
								</form>
								</td>
								<td valign="top" align="left" background="images/l_r.jpg"
									width="24"></td>
							</tr>
							<tr>
								<td colspan="3" valign="top"><img src="images/l_2.jpg"
									border="0" width="241" height="17" alt=""></td>

							</tr>
						</table>




						</td>
					</tr>
				</table>
				</td>
				<td valign="top"><br>

				<!-- Selected Pizza List -->

				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td valign="top">
						<table border="0" cellpadding="0" cellspacing="0" width="539">
							<tr>
								<td colspan="3" valign="top" width="539"><img
									src="images/r_1.jpg" border="0" width="539" height="18" alt=""></td>
							</tr>

							<tr>
								<td valign="top" align="right" background="images/r_l.jpg"
									width="25"></td>
								<td valign="top" width="475" bgcolor="#9D9EA3">
								<table border="0" cellpadding="0" cellspacing="0" width="475">
									<s:if test="userRole=='Consumer'">
										<tr>
											<td colspan="3" align="center" class="menu" bgcolor="Black">Select
											Pizza from your Preferences</td>
										</tr>
										<s:if
											test="prefPizzaDataList!=null && prefPizzaDataList.size()>0">
											<s:iterator value="prefPizzaDataList">
												<tr id="prefTd" height='50'>
													<td width="130"><img width="120" height="120"
														src="images/pizza1.jpg"></td>
													<td valign="top">
													<table height="120">
														<tr widht="200">
															<td colspan="3" class="subHead"><s:property
																value="pizzaName" /></td>
														</tr>
														<tr>
															<td colspan="3"><s:property value="description" /></td>
														</tr>
														<tr>
															<td class="subHead2">Small</td>
															<td class="subHead2">Medium</td>
															<td class="subHead2">Large</td>
														</tr>
														<tr>
															<td><s:property value="smallPrice" /></td>
															<td><s:property value="mediumPrice" /></td>
															<td><s:property value="largePrice" /></td>
														</tr>
													</table>
													</td>
													<td><a href="#"
														onclick="showOption(<s:property value="pizzaId" />)"><img
														src="images/select.JPG"></a></td>
												</tr>
											</s:iterator>
										</s:if>
										<s:else>
											<tr>
												<td colspan="3" align="center" class="subHead2">Currently
												no preferences selected</td>
											</tr>
										</s:else>
										<tr>
											<td colspan="3" align="center" class="menu" bgcolor="Black"
												width="20">&nbsp;</td>
										</tr>
									</s:if>

									<tr>
										<td colspan="3" align="center" class="menu">Veg Pizzas</td>
									</tr>
									<s:iterator value="vegPizzas">
										<tr height='50'>
											<td width="130"><img width="120" height="120"
												src="images/pizza1.jpg"></td>
											<td valign="top">
											<table height="120">
												<tr widht="200">
													<td colspan="3" class="subHead"><s:property
														value="pizzaName" /></td>
												</tr>
												<tr>
													<td colspan="3"><s:property value="description" /></td>
												</tr>
												<tr>
													<td class="subHead2">Small</td>
													<td class="subHead2">Medium</td>
													<td class="subHead2">Large</td>
												</tr>
												<tr>
													<td><s:property value="smallPrice" /></td>
													<td><s:property value="mediumPrice" /></td>
													<td><s:property value="largePrice" /></td>
												</tr>
											</table>
											</td>
											<td><a href="#"
												onclick="showOption(<s:property value="pizzaId" />)"><img
												src="images/select.JPG"></a></td>
										</tr>
									</s:iterator>
									<tr>
										<td colspan="3" align="center" class="menu">Non Veg
										Pizzas</td>
									</tr>
									<s:iterator value="nonVegPizzas">
										<tr height='50'>
											<td width="130"><img width="120" height="120"
												src="images/pizza1.jpg"></td>
											<td valign="top">
											<table height="120">
												<tr widht="200">
													<td colspan="3" class="subHead"><s:property
														value="pizzaName" /></td>
												</tr>
												<tr>
													<td colspan="3"><s:property value="description" /></td>
												</tr>
												<tr>
													<td class="subHead2">Small</td>
													<td class="subHead2">Medium</td>
													<td class="subHead2">Large</td>
												</tr>
												<tr>
													<td><s:property value="smallPrice" /></td>
													<td><s:property value="mediumPrice" /></td>
													<td><s:property value="largePrice" /></td>
												</tr>
											</table>
											</td>
											<td><a href="#"
												onclick="showOption(<s:property value="pizzaId" />)"><img
												src="images/select.JPG"></a></td>
										</tr>
									</s:iterator>
								</table>
								</td>

								<td valign="top" align="left" background="images/r_r.jpg"
									width="39"></td>

							</tr>
							<tr>
								<td colspan="3" valign="top"><img src="images/r_2.jpg"
									border="0" width="539" height="14" alt=""></td>

							</tr>
						</table>
						</td>
					</tr>
				</table>
				</td>
				<td width="220" valign="top">
				<table style="margin-top:15" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td colspan="3" valign="top" width="241"><img
							src="images/l_1.jpg" border="0" height="18" alt=""></td>

					</tr>
					<tr>
						<td valign="top" align="right" background="images/l_l.jpg"
							width="29"></td>
						<td valign="top" width="188" bgcolor="#9D9EA3">
						<table width="188" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td colspan="3" class="menu" align="center">Veg Toppings</td>
							</tr>
							<s:iterator value="vegToppings">
								<tr>
									<td align="center" width="20"><img src="images/q.jpg"
										border="0" width="7" height="7" alt=""></td>
									<td width="150" class="news subHead2" height="25"
										nowrap="nowrap"><b><s:property value="toppingName" /></b>
									</td>
									<td width="20"><s:property value="toppingBasePrice" /></td>
								</tr>
							</s:iterator>
							<tr>
								<td colspan="3" class="menu" align="center">Non Veg
								Toppings</td>
							</tr>
							<s:iterator value="nonVegToppings">
								<tr>
									<td align="center" width="20"><img src="images/q.jpg"
										border="0" width="7" height="7" alt=""></td>
									<td width="150" class="news subHead2" height="25"
										nowrap="nowrap"><b><s:property value="toppingName" /></b>
									</td>
									<td width="20"><s:property value="toppingBasePrice" /></td>
								</tr>
							</s:iterator>

						</table>
						</td>
						<td valign="top" align="left" background="images/l_r.jpg"
							width="24"></td>
					</tr>
					<tr>
						<td colspan="3" valign="top"><img src="images/l_2.jpg"
							border="0" width="241" height="17" alt=""></td>

					</tr>
				</table>

				<!-- PIZZA option div -->

				<div id="popupDialog"
					style="position: absolute; left: 400px; top:230px; display:none; z-index:100;">
				<table style="margin-top:15" border="0" cellpadding="0"
					cellspacing="0">
					<tr>
						<td colspan="3" valign="top" width="241"><img
							src="images/l_1.jpg" border="0" height="18" alt=""></td>

					</tr>
					<tr>
						<td valign="top" align="right" background="images/l_l.jpg"
							width="29"></td>
						<td valign="top" width="188" bgcolor="#9D9EA3">
						<form id="pizzaOption"><s:hidden id="pizzaId"></s:hidden>
						<table width="188" border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td colspan="2" class="subHead" align="center">Select Pizza
								Options</td>
							</tr>
							<tr>
								<td>
								<table width="20">
									<tr>
										<td class="tdLabel"></td>
										<td class="subHead4">Size</td>
									</tr>
									<tr>
										<td class="subHead4" align="left"><s:select
											list="sizeList" name="orderSize" /></td>
									</tr>
									<tr>
										<td class="tdLabel"></td>
										<td class="subHead4">Quantity</td>
									</tr>
									<tr>
										<td class="subHead4" align="left"><s:select
											list="quantityList" name="quantity" /></td>
									</tr>
								</table>
								</td>

								<td class="subHead2">
								<table>
									<tr>
										<td class="menu">Veg Toppings</td>
									</tr>
									<s:iterator value="vegToppings">
										<tr>
											<td class="subHead2"><input type="checkbox"
												value="<s:property value="toppingId"/>" name="toppingName" /><s:property
												value="toppingName" /></td>
										</tr>
									</s:iterator>
									<tr>
										<td class="menu">Non Veg Toppings</td>
									</tr>
									<s:iterator value="nonVegToppings">
										<tr>
											<td class="subHead2"><input type="checkbox"
												value="<s:property value="toppingId"/>" name="toppingName" /><s:property
												value="toppingName" /></td>
										</tr>
									</s:iterator>
								</table>
								</td>
							</tr>
							<tr>
								<td align="center"><a href="javascript:void(0);"
									onclick="addPizza()"><img width="38" height="30"
									src="images/add.JPG" /></a></td>
								<td align="center"><a href="javascript:void(0);"
									onclick="closeOption()"><img width="45" height="30"
									src="images/cancel.JPG" /></a></td>
							</tr>

						</table>
						</form>
						</td>
						<td valign="top" align="left" background="images/l_r.jpg"
							width="24"></td>
					</tr>
					<tr>
						<td colspan="3" valign="top"><img src="images/l_2.jpg"
							border="0" width="241" height="17" alt=""></td>

					</tr>
				</table>
				</div>


				<!-- Section --></td>

			</tr>
			<tr>
				<td valign="top" colspan="3">&nbsp;<br>
				</td>

			</tr>

			<tr>
				<td valign="middle" colspan="3" width="780"
					background="images/last.jpg" height="53" align="center">
				&nbsp;&nbsp;&nbsp;<a href="" class="bot"></a>&nbsp;&nbsp;&nbsp; <a
					href="" class="bot">Privacy Policy</a>&nbsp;&nbsp;&nbsp; <a href=""
					class="bot">Careers</a>&nbsp;&nbsp;&nbsp; <a href="" class="bot">Contact
				us</a>&nbsp;&nbsp;&nbsp; <a href="" class="bot">About Us</a>&nbsp;&nbsp;&nbsp;
				<br>
				<br>
				<span class="copy">© Copyright, 2012, jainex pizza</span></td>


			</tr>
		</table>


		</td>
		<td width="100%" background="images/bg.gif">&nbsp;</td>
	</tr>
</table>
<div id="popDialog1"></div>
</body>
</html>
