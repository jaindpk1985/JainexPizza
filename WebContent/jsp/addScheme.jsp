<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Jainex Pizza</title>

<link rel="stylesheet" href="css/style.css" type="text/css" media="all">

<script type="text/JavaScript" src="scripts/calendar.js"></script>
<script type="text/javascript" src="scripts/jquery-1.5.2.js"></script>
<script type="text/javascript" src="scripts/jquery.maskedinput-1.3.js"></script>
<script type="text/javascript">
function setMasking(){

	$('input[name="offersInfo.offerDiscount"]').mask("?99",{placeholder:""});
	$('input[name="offersInfo.startDate"]').mask("99/99/9999",{placeholder:" "});
	$('input[name="offersInfo.endDate"]').mask("99/99/9999",{placeholder:" "});
	
}
</script>
</head>

<body onload="setMasking()">

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
				<td colspan="3" class="pageTitle" align="center">Add
				Scheme/Offers
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


									<tr>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td align="left" valign="top"><img src="images/q.jpg"
											border="0" width="7" height="7" alt=""></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td valign="top" class="news" height="25"><b><a
											href="addPizza.action" class="leftMenu">Add Pizza</a></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
									</tr>
									<tr>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td align="left" valign="top"><img src="images/q.jpg"
											border="0" width="7" height="7" alt=""></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td valign="top" class="news" height="25"><b><a
											href="updatePizzas.action" class="leftMenu">Update Pizza</a></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
									</tr>
									<tr>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td align="left" valign="top"><img src="images/q.jpg"
											border="0" width="7" height="7" alt=""></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td valign="top" class="news" height="25"><b><a
											href="deletePizza.action" class="leftMenu">Delete Pizza</a></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
									</tr>
									<tr>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td align="left" valign="top"><img src="images/q.jpg"
											border="0" width="7" height="7" alt=""></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td valign="top" class="news" height="25"><b><a
											href="addScheme.action" class="leftMenu">Add Scheme</a></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
									</tr>
									<tr>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td align="left" valign="top"><img src="images/q.jpg"
											border="0" width="7" height="7" alt=""></td>
										<td>&nbsp;&nbsp;&nbsp;</td>
										<td valign="top" class="news" height="25"><b><a
											href="addBpo.action" class="leftMenu">Add Bpo Person</a></td>
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

								<form action="addSchemeSave" method="post">
								<table cellpadding="0" cellspacing="0">
									<tr>
										<td><b><s:text name="header.Instructions" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- start error messages  -->
									<tr>
										<td style="color: red"><s:actionerror /></td>
									</tr>
									<!-- end error messages  -->
									<!-- Offers Name -->
									<tr>
										<td><s:textfield name="offersInfo.offerName"
											key="offersInfo.offerName.label" required="true"
											requiredposition="left" maxlength="30" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- Offers Desc-->
									<tr>
										<td><s:textfield name="offersInfo.offerDesc"
											key="offersInfo.offerDesc.label" maxlength="30" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- Offer start Date -->
									<tr>
										<td>
										<table>
											<tr>
												<td><s:textfield name="offersInfo.startDate"
													key="offersInfo.startDate.label" required="true"
													requiredposition="left" maxlength="10" /></td>
												<td><a href="#"
													onclick="calendarPopup(document.getElementsByName('offersInfo.startDate')[0], [0,89]); return false;"><img
													src="images/calendar-blue.png" border="0"></a></td>
											</tr>
										</table>
										</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- Offer end Date -->
									<tr>
										<td>
										<table>
											<tr>
												<td><s:textfield name="offersInfo.endDate"
													key="offersInfo.endDate.label" required="true"
													requiredposition="left" maxlength="10" /></td>
												<td><a href="#"
													onclick="calendarPopup(document.getElementsByName('offersInfo.endDate')[0], [0,89]); return false;"><img
													src="images/calendar-blue.png" border="0"></a></td>
											</tr>
										</table>
										</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- Offer discount-->
									<tr>
										<td><s:textfield name="offersInfo.offerDiscount"
											key="offersInfo.offerDiscount.label" required="true"
											requiredposition="left" maxlength="2" size="5" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>

									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td><s:submit type="button" value="Save" /></td>
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
