<?php $title = "Inscription / Connexion"; ob_start(); 

	$error = array(
		"noData"         => "",
		"name"           => "Le prénom est trop court",
		"surname"        => "Le nom de famille est trop court",
		"email"          => "Le mail est invalide",
		"matching_email" => "Les deux adresses email ne sont pas identiques",
		"uniqueEmail"    => "L'adresse mail est déjà utilisée",
		"psw"            => "Le mot de passe est trop court (au moins 5 caractères)",
		"matching_psw"   => "Les deux mots de passe ne sont pas identiques",
		"cgu"            => "Il est nécessaire d'accépter les CGU",
		"pdo"            => "Erreur lors de l'enregistrement en base de données",
		"pdoLogin"       => "Erreur de connexion à la base de données",
		"wrongPsw"       => "Le mot de passe ou l'adresse email est erroné");
?>

<section class="login">
	<div class="title">
		<h1>Connexion</h1>
		<span>Retrouvez vos commandes et promotions !</span>
	</div>
	<form action="" method="post" accept-charset="utf-8">
		<div class="error"><?= (isset($login)&&$login!="noData"?'<i class="fas fa-exclamation-triangle"></i> '.$error[$login]:""); ?></div>

		<label for="email"><b>Email</b></label>
		<input type="email" placeholder="mon.email@gmail.com" name="email" value="<?= (isset($_POST['email'])?$_POST['email']:""); ?>" required>

		<label for="psw"><b>Mot de passe</b></label>
		<input type="password" placeholder="Mot de passe..." name="psw" required>
		    
		<button type="submit">Connexion</button>
		<label>
			<input type="checkbox" checked="checked" name="remember"> Se souvenir de moi
		</label>
		<div class="separation"></div>
		<div class="forgotPassword">
			<a href="#" title=""><i class="fas fa-key"></i> Mot de passe oublié ?</a>
		</div>
	</form>
</section>

<section class="signup">
	<div class="title">
		<h1>Inscription</h1>
		<span>Inscrivez-vous pour finaliser votre commande !</span>
	</div>
	<form action="" method="post" accept-charset="utf-8">
		<div class="error"><?= (isset($signup)&&$signup!="noData"?'<i class="fas fa-exclamation-triangle"></i> '.$error[$signup]:""); ?></div>

		<label for="name"><b>Prénom</b></label>
		<input type="text" placeholder="Jean-Michel" name="name" value="<?= (isset($_POST['name'])?$_POST['name']:""); ?>" required>

		<label for="surname"><b>Nom</b></label>
		<input type="text" placeholder="Ecolo" name="surname" value="<?= (isset($_POST['surname'])?$_POST['surname']:""); ?>" required>

		<label for="email1"><b>Email</b></label>
		<input type="email" placeholder="mon.email@gmail.com" name="email1" value="<?= (isset($_POST['email1'])?$_POST['email1']:""); ?>" required>

		<label for="email2"><b>Confirmez l'email</b></label>
		<input type="email" placeholder="mon.email@gmail.com" name="email2" value="<?= (isset($_POST['email1'])?$_POST['email1']:""); ?>" required>

		<label for="psw1"><b>Mot de passe</b></label>
		<input type="password" placeholder="Mot de passe..." name="psw1" required>

		<label for="psw2"><b>Confirmez le mot de passe</b></label>
		<input type="password" placeholder="Mot de passe..." name="psw2" required>

		<label>
			<input type="checkbox" checked="checked" name="cgu"> J'accepte les <a href="#" title="Conditions générales d'utilisation" target="_blank">Conditions générales d'utilisation</a>
		</label>
		    
		<button type="submit">Inscription</button>
	</form>
</section>

<div class="clear"></div>

<?php $content = ob_get_clean(); require('View/Layouts/desktop.php'); ?>