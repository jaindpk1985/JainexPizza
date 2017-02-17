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
				<td width="100" background="images/last.jpg" colspan="3">
				<table>
					<tr>
						<td width="100" align="center"></td>
						<td width="100" align="center"></td>
						<td width="100" align="center"><a href="" class="menu"></a></td>
					</tr>
				</table>
				</td>
			</tr>

			<tr>
				<td colspan="3" class="pageTitle" align="center">Welcome to
				Jainex Pizza. We serve below Pizzas.
				<td>
			</tr>


			<tr>
				<td valign="top" width="241">
				<table border="0" cellpadding="0" cellspacing="0" width="241">



					<tr>
						<td valign="top" width="241"><br>
						<table border="0" cellpadding="0" cellspacing="0" width="241">
							<tr>
								<td colspan="3" valign="top" width="241"><img
									src="images/l_1.jpg" border="0" width="241" height="18" alt=""></td>
							</tr>
							<tr>
								<td valign="top" align="right" background="images/l_l.jpg"
									width="29"></td>
								<td width="188" bgcolor="#9D9EA3" align="center" valign="middle" class="menu">
								For Quick order please call our executive</td>
								<td valign="top" align="left" background="images/l_r.jpg"
									width="24"></td>
							</tr>
							<tr>
								<td valign="top" align="right" background="images/l_l.jpg"
									width="29"></td>
								<td bgcolor="#9D9EA3" width="24" class="menu">@ +91-9911497944</td>
								<td valign="top" align="left" background="images/l_r.jpg"
									width="24"></td>
							</tr>
							<tr>
								<td valign="top" align="right" background="images/l_l.jpg"
									width="29"></td>
								<td bgcolor="#9D9EA3" width="24" class="menu">&nbsp;&nbsp; +91-9998886622</td>
								<td valign="top" align="left" background="images/l_r.jpg"
									width="24"></td>
							</tr>
							<tr>
								<td colspan="3" valign="top"><img src="images/l_2.jpg"
									border="0" width="241" height="17" alt=""></td>
							</tr>
						</table>
						<br/>
						
						<table border="0" cellpadding="0" cellspacing="0" width="241">
							<tr>
								<td colspan="3" valign="top" width="241"><img
									src="images/l_1.jpg" border="0" width="241" height="18" alt=""></td>
							</tr>
							<tr>
								<td valign="top" align="right" background="images/l_l.jpg"
									width="29"></td>
								<td width="188" bgcolor="#9D9EA3" align="center" valign="middle">
								<s:form action="login">
									<s:actionerror />
									<s:textfield name="loginData.userName" size="10" maxlength="40"
										label="User Name" />
									<br>
									<s:password name="loginData.pwd_text" size="10" maxlength="40"
										label="Password" />&nbsp;<s:submit value="Login" />
								</s:form></td>
								<td valign="top" align="left" background="images/l_r.jpg"
									width="24"></td>
							</tr>
							<tr>
								<td valign="top" align="right" background="images/l_l.jpg"
									width="29"></td>
								<td bgcolor="#9D9EA3" width="24"><s:form
									action="newRegisteration" method="post">
									<s:submit value="New Registration" align="middle" />
								</s:form></td>
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
									<tr>
										<td colspan="3" align="center" class="menu">Veg Pizzas</td>
									</tr>
									<s:iterator value="vegPizzas">
										<tr height='50'>
											<td width="130"><img width="120" height="120"
												src="images/pizza1.jpg" /></td>
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
