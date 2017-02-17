<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Jainex Pizza</title>

<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
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
				<td colspan="3" class="pageTitle" align="center">Order Detail
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
									<s:if test="userRole == 'Consumer'">
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



						</td>
					</tr>
				</table>
				</td>
				<td valign="top"><br>
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
								<table>
									<tr>
										<td class="subHead2">Order Id:</td>
										<td><s:property value="orderInfo.orderId" /></td>
									</tr>
									<tr>
										<td>&nbsp</td>
										<td>&nbsp</td>
									</tr>
									<tr>
										<td class="subHead2">Created Time:</td>
										<td><s:property value="orderInfo.orderCreationDate" /></td>
									</tr>
									<tr>
										<td>&nbsp</td>
										<td>&nbsp</td>
									</tr>
									<tr>
										<td class="subHead2">Status:</td>
										<td><s:property value="orderInfo.status" /></td>
									</tr>
									<tr>
										<td>&nbsp</td>
										<td>&nbsp</td>
									</tr>
									<tr>
										<td class="subHead2">Home Delivery/Pick Up:</td>
										<s:if test="orderInfo.homeDelivery">
											<td>Home Delivery</td>
										</s:if>
										<s:else>
											<td>Pick Up</td>
										</s:else>
									</tr>
									<tr>
										<td>&nbsp</td>
										<td>&nbsp</td>
									</tr>
									<tr>
										<td colspan="2" class="menu" align="center">Delivery Address</td>
									</tr>
									<!-- address line -->
									<tr>
										<td  class="subHead2">Address Line:</td>
										<td><s:property value="deliveryAddressInfo.addLine"/></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<!-- city -->
									<tr>
										<td  class="subHead2">City:</td>
										<td><s:property value="deliveryAddressInfo.city"/></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<!-- state -->
									<tr>
										<td  class="subHead2">State:</td>
										<td><s:property value="deliveryAddressInfo.state"/></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<!-- zipcode -->
									<tr>
										<td  class="subHead2">Zip Code:</td>
										<td><s:property value="deliveryAddressInfo.zipCode"/></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td colspan="2" class="menu" align="center">Ordered
										Pizzas</td>
									</tr>

									<tr>
										<td colspan="2">
										<table border="0" cellpadding="0" cellspacing="0" width="475">
											<tr>
												<td class="subHead2">Pizza Name</td>
												<td class="subHead2">Pizza Size</td>
												<td class="subHead2">Quantity</td>
												<td class="subHead2">Toppings</td>
												<td class="subHead2">Total Price</td>
											</tr>
											<s:iterator value="orderPizzasInfoList" status="listIndex">
												<tr>
													<td class="news" height="25" nowrap="nowrap" valign="top"><b><s:property
														value="pizzaName" /></b></td>
													<td class="news" height="25" nowrap="nowrap" valign="top"><b><s:property
														value="orderSize" /></b></td>
													<td class="news" height="25" nowrap="nowrap" valign="top"><b><s:property
														value="quantity" /></b></td>
													<td class="news" height="25">
													<s:iterator value="topingsList">
														<s:property	value="toppingName" />
														<br/>
													</s:iterator>	
													</td>
													<td class="news" height="25" nowrap="nowrap" valign="top"><b><s:property
														value="totalPizzaPrice" /></b></td>
												</tr>
											</s:iterator>
											<tr>
												<td colspan="3" class="subHead2">Total Order Price</td>
												<td colspan="2" class="menu" align="center"><s:property
													value="totalOrderPrice" />Rs</td>
											</tr>

										</table>
										</td>
									</tr>

									<tr>
										<td colspan="2">&nbsp</td>
									</tr>
									<s:if test="orderInfo.status == 'Placed' && userRole=='Bpo'">
										<tr>
											<td colspan="2" class="menu" align="center"><a
												href="completeOrder.action?orderId=<s:property value="orderInfo.orderId" />">Complete
											Order</td>
										</tr>
									</s:if>
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
				<td width="220" valign="top"></td>

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
