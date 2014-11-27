<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="es.banco.modelo.TarjetaCredito"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VISTA INDIVIDUAL</title>
<link rel="stylesheet" type="text/css" href="css/estilo.css"/>
</head>
<body>
<form action="Pagar" method="get">
 <% TarjetaCredito tarjetaCredito = (TarjetaCredito)request.getAttribute("tarjetacredito"); %>
<table>
    <tr>
      <th>Id</th>
      <th>Número</th>
      <th>Cupo Máximo</th>
      <th>Cupo Disponible</th>
      <th>Tipo</th>
      <th>Numero de Comprobación</th>
      <th>Contrasenha</th>
   </tr>
   <tr>
      <td><input type="text" name="id" value="<%=tarjetaCredito.getId() %>" readonly="readonly"/></td> 
      <td><input type="text" name="numero" value="<%=tarjetaCredito.getNumero() %>" readonly="readonly"/></td>
      <td><input type="text" name="cupoMaximo" value="<%=tarjetaCredito.getCupoMaximo() %>" readonly="readonly"/></td>
      <td><input type="text" name="cupoDisponible" value="<%=tarjetaCredito.getCupoDisponible() %>"/></td>
      <td><input type="text" name="tipo" value="<%=tarjetaCredito.getTipo() %>" readonly="readonly"/></td>
      <td><input type="text" name="numeroComprobacion" value="<%=tarjetaCredito.getNumeroComprobacion() %>" readonly="readonly"/></td>
      <td><input type="text" name="contrasenha" value="<%=tarjetaCredito.getContrasenha() %>" readonly="readonly"/></td>
  </tr>
</table>
 <input class="botones" type="submit" value="AmpliarCupo" id="ampliarCupo" name="ampliarCupo"/>
</form>
  <a href="index.html">Ir a inicio</a>
</body>
</html>