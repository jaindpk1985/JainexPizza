<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Jainex Pizza</title>

<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script type="text/javascript" src="scripts/jquery-1.5.2.js"></script>
<script>
function addPreference(pizzaId){
	$.ajax({
          url : "addPreference.action?selectedPizzaId="+ pizzaId,
          type:"POST",
          dataType: "json",
          error: function(XMLHttpRequest, textStatus, errorThrown){
			    				//alert('Error in retrieving data: ' + textStatus);
			    			},
          success :function(data,args) {        
          			if(data.prefPizzaDataList!=null && data.prefPizzaDataList.length>0)
              		{
                		displayPrefListData(data);
              		}
             	}
           
          });
          
}
function deletePreference(pizzaId){
	$.ajax({
          url : "deletePreference.action?selectedPizzaId="+ pizzaId,
          type:"POST",
          dataType: "json",
          error: function(XMLHttpRequest, textStatus, errorThrown){
			    				//alert('Error in retrieving data: ' + textStatus);
			    			},
          success :function(data,args) {        
                		displayPrefListData(data);
             	}
           
          });
}
function displayPrefListData(data){
          	var innerHTML = '<table  width="188" border="0" cellpadding="0" cellspacing="0" ><tr><td colspan="3" class="menu" align="center">Your Preferences</td></tr>';
          	if (data.prefPizzaDataList !=null && data.prefPizzaDataList.length>0)
			{
				for (i=0;i<data.prefPizzaDataList.length;i++)
                {
                       innerHTML +=   '<tr>'
                       innerHTML +=       '<td align="center" width="20"><img src="images/q.jpg" border="0" width="7" height="7" alt=""></td>'
	                   innerHTML +=       '<td width="150" class="news subHead2" height="25" nowrap="nowrap"><b>'+data.prefPizzaNames[i]+'</b></td>'
                       innerHTML +=       '<td width="20"><a href="" onclick="deletePreference('+data.prefPizzaIds[i]+')"><img src="images/delete.png" title="Delete"></a></td>'
                       innerHTML +=   '</tr>'
                 }
			}
			innerHTML += "</table>";
            $('#prefDiv').empty();
		    $('#prefDiv').append(innerHTML);
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

				<!-- Hoizontal Menu -->

			</tr>
			<tr>
				<td background="images/last.jpg" colspan="3">
				<table>
					<tr>
						<td width="700px" align="left" class="menu">Welcome <s:property
							value="userFullName" /></td>
						<td width="100px" align="center"><a href="" class="menu"></a></td>
						<td width="100px" align="center"><a href="homeProfile.action"
							class="menu">Home</a></td>
						<td width="100px" align="left"><a href="logOut.action"
							class="menu">Sign Out</a></td>
					</tr>
				</table>
				</td>
			</tr>


			<!-- Page Title -->
			<tr>
				<td colspan="3" class="pageTitle" align="center">Create
				Preferences
				<td>
			</tr>


			<!-- Side Navigation -->


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
									<tr>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td align="left" valign="top"><img src="images/q.jpg"
											border="0" width="7" height="7" alt=""></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td valign="top" class="news" height="25"><b><a
											href="userProfile.action" class="leftMenu">Create Profile</a></b>
										</td>
										<td>&nbsp;&nbsp;&nbsp;</td>
									</tr>
									<tr>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td align="left" valign="top"><img src="images/q.jpg"
											border="0" width="7" height="7" alt=""></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td valign="top" class="news" height="25"><b><a
											href="userPreferences.action" class="leftMenu">Create
										Preferences</a></td>
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
										Order</a></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
									</tr>

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


						<!-- User selected preferences -->

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
								<div id="prefDiv">
								<table width="188" border="0" cellpadding="0" cellspacing="0">
									<tr>
										<td colspan="3" class="menu" align="center">Your
										Preferences</td>
									</tr>
									<s:iterator value="prefPizzaDataList">
										<tr>
											<td align="center" width="20"><img src="images/q.jpg"
												border="0" width="7" height="7" alt=""></td>
											<td width="150" class="news subHead2" height="25"
												nowrap="nowrap"><b><s:property value="pizzaName" /></b>
											</td>
											<td width="20"><a href="#"
												onclick="deletePreference(<s:property value="pizzaId" />)"><img
												src="images/delete.png" title="Delete"></a></td>
										</tr>
									</s:iterator>

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
						</td>
					</tr>
				</table>
				</td>
				<td valign="top"><br>
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td valign="top"><!-- Pizza List block -->


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
									<tr>
										<td colspan="3" class="menu" align="center">Veg Pizzas</td>
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
												onclick="addPreference(<s:property value="pizzaId"/>)"><img
												src="images/select.JPG"></a></td>
										</tr>
									</s:iterator>
									<tr>
										<td colspan="3" class="menu" align="center">Non Veg
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
											<td><a href=""
												onclick="addPreference(<s:property value="pizzaId"/>)"><img
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




				</td>

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

</body>
</html>
