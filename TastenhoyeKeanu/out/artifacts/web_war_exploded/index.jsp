<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Veggie</title>
<link rel="stylesheet" href="css/sample.css">
</head>
<body>

	<main>
	<article>
		<h1>Veggie</h1>
		<p><a href="Controller?action=ProductOverview">Toon mij alle producten.</a> </p>

		<form method="post" action="Controller?action=VegiCookie" novalidate="novalidate">
			Ben je vegetarisch?
			<p>
				<label>
					<input type="radio" name="veggie" value="ja"> Ja
				</label>
			</p>
			<p>
				<label>
					<input type="radio" name="veggie" value="neen"> Neen
				</label>
			</p>
			<p>
				<input type="submit" value="Send">
			</p>
		</form>

		<p>${vegi}</p>

		<p>
			<a href="Controller?action=ProductOverview">
				Toon de gerechten van mijn voorkeur.
			</a>
		</p>
	</article>
	</main>
</body>
</html>