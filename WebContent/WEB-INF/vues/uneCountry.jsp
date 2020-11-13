<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>ma page une country</h1>
	<section >
            <form  action="countryModifier"  method="Post">       
                <label for="nomPaysModifier">Nom: </label><input type="text" name="nom" value="${pays.nom}">
                <input type="hidden" name="id" value="${pays.id }"/>
                <input type="hidden" name="queFaire" value="Modifier"/>
                <input type="submit"   value="MODIFIER">
            </form>
            <small>${message}</small>
        </section>
        <br>
        <section >
            <form  action="countryModifier"  method="Post">       
                <input type="hidden" name="id" value="${pays.id }"/>
                <input type="hidden" name="nom" value="${pays.nom }"/>
                <input type="hidden" name="queFaire" value="Supprimer"/>
                <input type="submit" name="" value="SUPPRIMER">
                <small>${message}</small>
            </form>
        </section>
        <a href="country">retour</a>
</body>
</html>