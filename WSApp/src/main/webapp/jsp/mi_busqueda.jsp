<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>




</head>
<body>
	
	<form:form id="index" modelAttribute="cityWeather" action="mi_resultado"  method="POST">
		
		Ciudad/City<br>
		<form:input type="text" path="city" id="city" name="city"/><br>
		Provincia/State<br>
		<form:input type="text" path="state" id="state" name="state"/><br>
		Pais/Country<br>
		<form:input type="text" path="country" id="country" name="country"/>
		<br><hr><br>
		<form:button id="btnBuscar" type="button" name="btnBuscar">Buscar</form:button>
        <br>
        <hr>
        <br>	
	
	</form:form>

	
	
	<table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${ciudad}</td>
                </tr>
    </table>

</body>
</html>