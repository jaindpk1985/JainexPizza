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

function setMasking(){

	$('input[name="userProfileInfo.age"]').mask("?999",{placeholder:""});
	$('input[name="userProfileInfo.contactNo"]').mask("?9999999999",{placeholder:""});
	$('input[name="addressInfo.zipCode"]').mask("?999999",{placeholder:""});

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

				<!-- Hoizontal Menu -->

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


			<!-- Page Title -->
			<tr>
				<td colspan="3" class="pageTitle" align="center">Profile
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




						<table style="margin-top:15" border="0" cellpadding="0"
							cellspacing="0">

						</table>
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
								<form action="userProfileSave">
								<table cellpadding="0" cellspacing="0">
									<s:hidden name="userProfileInfo.userProfileId" />
									<s:hidden name="addressInfo.addressId" />
									<tr>
										<td><b><s:text name="profile.instruction" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- start error messages  -->
									<tr>
										<td style="color: red"><s:actionerror /></td>
									</tr>
									<!-- end error messages  -->
									<!-- FirstName -->
									<tr>
										<td><s:textfield name="userProfileInfo.firstName"
											key="userProfileInfo.firstName.label" required="true"
											requiredposition="left" maxlength="25" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- LastName -->
									<tr>
										<td><s:textfield name="userProfileInfo.lastName"
											key="userProfileInfo.lastName.label" maxlength="25" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- age -->
									<tr>
										<td><s:textfield name="userProfileInfo.age"
											key="userProfileInfo.age.label" maxlength="3" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- Gender -->
									<tr>
										<td><s:radio list="genders" name="userProfileInfo.gender"
											key="userProfileInfo.gender.label" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- Email -->
									<tr>
										<td><s:textfield name="userProfileInfo.email"
											key="userProfileInfo.email.label" maxlength="25" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- mobile no -->
									<tr>
										<td><s:textfield name="userProfileInfo.contactNo"
											key="userProfileInfo.contactNo.label" required="true"
											requiredposition="left" maxlength="10" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- address line -->
									<tr>
										<td><s:textfield name="addressInfo.addLine"
											key="addressInfo.addLine.label" required="true"
											requiredposition="left" maxlength="50" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- city -->
									<tr>
										<td><s:textfield name="addressInfo.city"
											key="addressInfo.city.label" required="true"
											requiredposition="left" maxlength="25" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- state -->
									<tr>
										<td><s:textfield name="addressInfo.state"
											key="addressInfo.state.label" required="true"
											requiredposition="left" maxlength="25" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- zipcode -->
									<tr>
										<td><s:textfield name="addressInfo.zipCode"
											key="addressInfo.zipCode.label" required="true"
											requiredposition="left" maxlength="6" /></td>
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
				<td width="220" valign="top">
				<table style="margin-top:15" border="0" cellpadding="0"
					cellspacing="0">

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
