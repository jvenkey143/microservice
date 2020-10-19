<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<f:form action="process" method="post" modelAttribute="studentBean">
	<table>
		<tr>
			<td>Student ID</td>
			<td><f:input path="stdId" /></td>
			<td><f:errors path="stdId" /></td>
		</tr>
		<tr>
			<td>Student Name</td>
			<td><f:input path="stdName" /></td>
			<td><f:errors path="stdName" /></td>
		</tr>
		<tr>
			<td>Student Age</td>
			<td><f:input path="age" /></td>
			<td><f:errors path="age" /></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><f:radiobutton path="gender" value="MALE" label='M' /> <f:radiobutton
					path="gender" value="FEMALE" label='F' /> <f:radiobutton
					path="gender" value="OTHERS" label='OTH' /></td>
			<td><f:errors path="gender" /></td>

		</tr>
		<tr>
          <td>Email</td><td><f:input  path="email"/></td><td><f:errors path="email"/></td>
       </tr>
		<tr>
			<td>DOB(dd/MM/yyyy)</td>
			<td><f:input path="dob" /></td>
			<td><f:errors path="dob" /></td>
		</tr>
		<tr>
			<td>Country</td>
			<td><f:select path="country">
					<f:option value="">--select--</f:option>
					<f:options items="${studentBean.countriesList}"
						itemValue="countryName" itemLabel="countryName" />

				</f:select></td>
			<td><f:errors path="country" /></td>
		</tr>

		<tr>
			<td colspan="3" align="center"><input type="submit"
				value="submit">
		</tr>

	</table>
</f:form>