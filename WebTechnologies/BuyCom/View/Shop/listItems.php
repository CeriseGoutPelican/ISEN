<?php $title = "Liste des produits"; ob_start(); ?>

<h1><?= ($category['name']?$category['name']:"Toutes les catégories") ?></h1>

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
	<?php endforeach;
	if(!$items) echo "Il n'y a aucun article à afficher dans cette catégorie."; ?>

	<div class="clear"></div>
</section>

<?php $content = ob_get_clean(); require('View/Layouts/desktop.php'); ?>