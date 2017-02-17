<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Jainex Pizza</title>

<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<script type="text/javascript" src="scripts/jquery-1.5.2.js"></script>
<script type="text/javascript" src="scripts/jquery-ui-1.8.6.custom.js"></script>
<script type="text/javascript" src="scripts/jquery.maskedinput-1.3.js"></script>

<script type="text/javascript">

function setMasking(){

	$('input[name="userProfileInfo.contactNo"]').mask("?9999999999",{placeholder:""});
	$('input[name="addressInfo.zipCode"]').mask("?999999",{placeholder:""});

}
function submitForm(btnName)
        {
            var form = document.getElementById("registration");
            if (btnName =='save'){
            	document.forms[0].action = 'newRegisterationSave';
                document.forms[0].submit();
            }
            else if(btnName =='cancel')
                window.location = 'welcome.action';
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
						<td width="100px" align="center"><a href="#"
							class="menu"></a></td>
						<td width="100px" align="center"><a href="" class="menu"></a></td>
						<td width="100px" align="center"><a href="" class="menu"></a></td>
						<td width="600px" align="right"><a href="#"
							class="menu"></a></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr>
				<td colspan="3" class="pageTitle" align="center">New
				Registration
				<td>
			</tr>

			<tr>
				<td valign="top" width="241"><br>
				<table border="0" cellpadding="0" cellspacing="0" width="241">
					<tr>
						<td valign="top" width="241">
						<table border="0" cellpadding="0" cellspacing="0" width="241">

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

								<form id="registration" method="post">
								<table cellpadding="0" cellspacing="0">
									<tr>
										<td><b><s:text name="createAccount.Instructions" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- start error messages  -->
									<tr>
										<td><s:actionerror /></td>
									</tr>
									<!-- end error messages  -->
									<!-- FirstName -->
									<tr>
										<td><s:textfield name="userProfileInfo.firstName"
											key="createAccount.FirstName" required="true"
											requiredposition="left" maxlength="25" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- LastName -->
									<tr>
										<td><s:textfield name="userProfileInfo.lastName"
											key="createAccount.LastName" maxlength="25" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- username -->
									<tr>
										<td><s:textfield name="loginData.userName"
											key="createAccount.UserName" required="true"
											requiredposition="left" maxlength="25" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- pwd -->
									<tr>
										<td><s:password name="loginData.pwd_text"
											key="createAccount.Password" required="true"
											requiredposition="left" maxlength="25" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- confirm pwd -->
									<tr>
										<td><s:password name="loginData.confirmPassword"
											key="createAccount.confirmPassword" required="true"
											requiredposition="left" maxlength="25" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- mobile no -->
									<tr>
										<td><s:textfield name="userProfileInfo.contactNo"
											key="createAccount.MobileNo" required="true"
											requiredposition="left" maxlength="10" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- address line -->
									<tr>
										<td><s:textfield name="addressInfo.addLine"
											key="createAccount.AddressLine" required="true"
											requiredposition="left" maxlength="50" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- city -->
									<tr>
										<td><s:textfield name="addressInfo.city"
											key="createAccount.City" required="true"
											requiredposition="left" maxlength="25" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- state -->
									<tr>
										<td><s:textfield name="addressInfo.state"
											key="createAccount.State" required="true"
											requiredposition="left" maxlength="10" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- zipcode -->
									<tr>
										<td><s:textfield name="addressInfo.zipCode"
											key="createAccount.ZipCode" required="true"
											requiredposition="left" maxlength="6" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td><input name="cancel" type="button" value="Cancel"
											onclick="submitForm('cancel')" /><s:submit name="save"
											type="button" value="Save" onclick="submitForm('save')" /></td>
									</tr>
								</table>

								</from>
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
