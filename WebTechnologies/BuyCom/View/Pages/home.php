<?php $title = "Accueil"; ob_start(); ?>

<section class="carousel">
	<img src="./webroot/img/header.jpg" alt="Image : magasin bio, intérieur">
</section>

<section class="welcome">
	<h1>Bienvenue sur Ecobuy.com</h1>

	<p>
		Nous pensons sincèrement qu’une prise de conscience <strong>écologique</strong> est indissociable du <strong>développement</strong> d’une entreprise. C’est pourquoi, à Ecobuy.com nous avons décidé de vous offrir des produits respectant un <strong>commerce éthique</strong>, <strong>responsable</strong> et <strong>économiquement intéressant</strong>. 
	</p>
</section>

<section class="shoppingList">

	<?php foreach ($items as $v): ?>
		<a href="<?= $GLOBALS['URL_BASE'] ?>product/<?= h($v["id"]); ?>/" class="product">
			<div class="img" style="background-image:url('<?= $GLOBALS['URL_BASE'] ?>webroot/img/products/<?= h($v["id"]); ?>-1.png');"></div>
				<span class="title">
					<?= h($v["name"]); ?>
				</span>
				<span class="price">
					<?= number_format(h($v["price"]), 2); ?>€
				</span>
		</a>
	<?php endforeach ?>

	<div class="clear"></div>
</section>

<?php $content = ob_get_clean(); require('View/Layouts/desktop.php'); ?>