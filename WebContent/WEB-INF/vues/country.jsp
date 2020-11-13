<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
	<body>
		<h1>ma page country</h1>
		<section class="formulaire">
            <form  action="country"  method="Post">       
                <label for="nomPays">Nom: </label><input class="input" type="text" name="nomPays">
                <br><br>
                <input type="hidden" name="action" value="creer"/>
                <input type="submit" name="" class="input" value="Soumettre la requete">
            </form>
            <small>${message}</small>
        </section>
        <ul>
			<c:forEach items = "${liste}"  var="pays">
				 <li>${pays.nom}</li><br>
				 <form  action="countryModifier" method ="get">
						 <input type="hidden" name="id" value="${pays.id }"/>
						 <input class="btn" type="submit" value="MODIFER"/>
				</form>
               <br>
		    </c:forEach>
		    	
	    </ul>
	</body>
</html>