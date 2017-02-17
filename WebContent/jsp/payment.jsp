<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Jainex Pizza</title>

<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script type="text/javascript" src="scripts/jquery-1.5.2.js"></script>
<script type="text/javascript" src="scripts/jquery.maskedinput-1.3.js"></script>
<script type="text/javascript">

function setReadOnly(){

	$('#amount').attr('readonly', true);

}

function setMasking(){
	$('input[name="addressInfo.zipCode"]').mask("?999999",{placeholder:""});
	$('input[name="paymentInfo.cardNumber"]').mask("?9999999999999999",{placeholder:""});
	$('input[name="paymentInfo.verificationNumber"]').mask("?9999",{placeholder:""});

}

</script>
</head>

<body onload="setReadOnly(),setMasking()">

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
				<td colspan="3" class="pageTitle" align="center">Payment
				Information
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
								<form action="savePayment" method="post">
								<table border="0" cellpadding="0" cellspacing="0" width="475">
									<tr>
										<td><b><s:text name="confirmAddress.instruction" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- address line -->
									<tr>
										<td><s:textfield name="addressInfo.addLine"
											key="createAccount.AddressLine" maxlength="50" required="true"
											requiredposition="left"/></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- city -->
									<tr>
										<td><s:textfield name="addressInfo.city"
											key="createAccount.City" maxlength="25" required="true"
											requiredposition="left"/></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- state -->
									<tr>
										<td><s:textfield name="addressInfo.state"
											key="createAccount.State" maxlength="10" required="true"
											requiredposition="left"/></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- zipcode -->
									<tr>
										<td><s:textfield name="addressInfo.zipCode"
											key="createAccount.ZipCode" maxlength="6" required="true"
											requiredposition="left"/></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td><b><s:text name="profile.instruction" /></td>
									</tr>
									<tr>
										<td>&nbsp</td>
									</tr>
									<tr>
										<td><s:select name="paymentInfo.cardType"
											key="paymentInfo.cardType.label" list="cardTypeList"
											required="true" requiredposition="left" /></td>
									</tr>
									<tr>
										<td>&nbsp</td>
									</tr>
									<tr>
										<td><s:textfield name="paymentInfo.cardHolderName"
											key="paymentInfo.cardHolderName.label" required="true"
											requiredposition="left" maxlength="50" /></td>
									</tr>
									<tr>
										<td>&nbsp</td>
									</tr>
									<tr>
										<td><s:textfield name="paymentInfo.bankName"
											key="paymentInfo.bankName.label" required="true"
											requiredposition="left" maxlength="30" /></td>
									</tr>
									<tr>
										<td>&nbsp</td>
									</tr>
									<tr>
										<td><s:textfield name="paymentInfo.cardNumber"
											key="paymentInfo.cardNumber.label" required="true"
											requiredposition="left" maxlength="19" /></td>
									</tr>
									<tr>
										<td>&nbsp</td>
									</tr>
									<tr>
										<td><s:textfield name="paymentInfo.verificationNumber"
											key="paymentInfo.verificationNumber.label" required="true"
											requiredposition="left" maxlength="4" /></td>
									</tr>
									<tr>
										<td>&nbsp</td>
									</tr>
									<tr>
										<td><s:select name="paymentInfo.expiredMonth"
											key="paymentInfo.expiredMonth.label" list="expMonthList"
											required="true" requiredposition="left" /></td>
									</tr>
									<tr>
										<td>&nbsp</td>
									</tr>
									<tr>
										<td><s:select name="paymentInfo.expiredYear"
											key="paymentInfo.expiredYear.label" list="expYearList"
											required="true" requiredposition="left" /></td>
									</tr>
									<tr>
										<td>&nbsp</td>
									</tr>
									<tr>
										<td><s:textfield id="amount" name="paymentInfo.amount"
											key="paymentInfo.amount.label" required="true"
											requiredposition="left" maxlength="10" /></td>
									</tr>
									<tr>
										<td>&nbsp</td>
									</tr>
									<tr>
										<td colspan="2"><s:submit value="Pay" align="center" /></td>
									</tr>

								</table>
								</form>
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
