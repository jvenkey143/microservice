<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<f:form action="saveProduct" method="post" modelAttribute="product">
	<table>
		<tr>
			<td>Product ID</td>
			<td><f:input path="prodID" /></td>
		</tr>
		<tr>
			<td>Product Name</td>
			<td><f:input path="prodName" /></td>
		</tr>
		<tr>
			<td>Product Cost</td>
			<td><f:input path="cost" /></td>
		</tr>
		<tr>
			<td>Product Color</td>
			<td><f:input path="color" /></td>
		</tr>
		<tr>
			<td colspan="3" align="center"><input type="submit"
				value="submit">
		</tr>

	</table>
</f:form>