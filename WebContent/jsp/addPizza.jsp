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

	$('input[name="pizzaBasePrice"]').mask("?99999",{placeholder:""});
	
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
				<s:if test="updatedPizzaId == null">
					<td colspan="3" class="pageTitle" align="center">Add Pizza
					<td>
				</s:if>
				<s:else>
					<td colspan="3" class="pageTitle" align="center">Update Pizza
					<td>
				</s:else>
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
								<form action="addPizzaSave" method="post"
									enctype="multipart/form-data"><s:hidden
									name="updatedPizzaId" />
								<table cellpadding="0" cellspacing="0">
									<tr>
										<td><b><s:text name="header.Instructions" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- start error messages  -->
									<tr>
										<td><s:actionerror /></td>
									</tr>
									<!-- end error messages  -->
									<!-- PizzaName -->
									<tr>
										<td><s:textfield name="pizzaData.pizzaName"
											key="pizzaData.pizzaName.label" required="true"
											requiredposition="left" maxlength="50" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- Pizza Desc-->
									<tr>
										<td><s:textfield name="pizzaData.description"
											key="pizzaData.description.label" maxlength="100" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- Category -->
									<tr>
										<td><s:radio list="%{#{true:'Veg',false:'Non-Veg'}}"
											name="pizzaData.isVeg" key="pizzaData.isVeg.label"
											required="true" requiredposition="left" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- Image upload -->
									<tr>
										<td><s:file name="image"
											key="pizzaData.pizzaImageName.label" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>
									<!-- Base Price -->
									<tr>
										<td><s:textfield name="pizzaBasePrice"
											key="pizzaData.basePrice.label" required="true"
											requiredposition="left" maxlength="10" /></td>
									</tr>
									<tr>
										<td>&nbsp;</td>
									</tr>

									<tr>
										<td>&nbsp;</td>
									</tr>
									<tr>
										<td><s:submit type="button" onclick="" value="Save" /></td>
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
