<!doctype html>
<html>
	<head>
		<!-- Meta données -->
		<meta charset="utf-8">
		<meta name="description" content="Buy.com - Votre site de e-commerce">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title><?= (isset($title)?$title:"Erreur 404") ?> - Ecobuy.com</title>

		<!-- Design : CSS --> 
		<link rel="stylesheet" href="<?= $GLOBALS['URL_BASE'] ?>webroot/css/design.css">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
		
		<script src="<?= $GLOBALS['URL_BASE'] ?>webroot/js/jquery.js"></script>
	</head>
	<body>

		<header>

			<div id="promo">
				<div class="centered">
					<div class="promoMessage">
						<i class="fas fa-truck"></i> Livraison gratuite dès <?= $GLOBALS['FREE_SHIPPING']; ?>€ d'achat !
					</div>
					<div class="cart">
						<a href="<?= $GLOBALS['URL_BASE'] ?>shoppingCart/" title="">
							<i class="fas fa-shopping-cart"></i>
							<span class="nbItems"><?= $this->nbItems ?></span>
						</a>
					</div>
					<div class="search">
						<form action="<?= $GLOBALS['URL_BASE'] ?>search.php">
							<input type="text" placeholder="Rechercher..." name="q">
							<button type="submit"><i class="fas fa-search"></i></button>
						</form>
					</div>
					<div class="userArea">
						<?php if($this->userConnected === true): ?>
							Bienvenue <b><?= $this->user['name'] ?></b>
							<a class="logout" href="<?= $GLOBALS['URL_BASE'] ?>logout/" title="Déconnexion"><i class="fas fa-sign-out-alt"></i></a>
						<?php else: ?>
							<a href="<?= $GLOBALS['URL_BASE'] ?>signup/" title="">Connectez-vous</a> ou <a href="<?= $GLOBALS['URL_BASE'] ?>signup/" title="">créez un compte</a>
						<?php endif ?>
					</div>
				</div>
			</div>

			<div id="title">
				<a href="<?= $GLOBALS['URL_BASE'] ?>" title="">
					<img src="<?= $GLOBALS['URL_BASE'] ?>webroot/img/logo.png" alt="Ecobuy.com">
				</a>
			</div>

			<nav>
				<ul>
					<li><a href="<?= $GLOBALS['URL_BASE'] ?>">Accueil</a></li>

					<li><a href="<?= $GLOBALS['URL_BASE'] ?>products/1/">Courses</a></li>
					<li><a href="<?= $GLOBALS['URL_BASE'] ?>products/2/">Cuisine</a></li>
				</ul>
			</nav>

			<div class="clear"></div>
		</header>

		<?= (isset($content)?$content:"Erreur 404 : Le docmument n'a pas été trouvé.") ?>

		<footer>
			<ul>
				<li><a href="#" title="">Conditions générales de vente</a></li>
				<li><a href="#" title="">Vos informations personnelles</a></li>
				<li><a href="" title="">Cookies</a></li>
				<li>© 2018-<?php echo date("Y"); ?>, Ecobuy.com</li>
			</ul>
		</footer>

		<script src="<?= $GLOBALS['URL_BASE'] ?>webroot/js/main.js"></script>
	</body>
</html>