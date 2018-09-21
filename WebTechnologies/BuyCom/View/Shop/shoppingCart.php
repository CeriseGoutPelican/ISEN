<?php $title = "Panier de course"; ob_start(); ?>

<section class="shoppingCart">
	
	<h1>Votre panier (total : <?= number_format(h($total), 2); ?>€)</h1>

	<div class="product firstRow">
			<span class="img"></span>
			<span class="infos">
				<span class="title">Titre</span>
			</span>
			<span class="price">Prix</span>
			<span class="quantity">Quantité</span>
	</div>
	<div class="clear separation"></div>

	<?php foreach ($items as $v): ?>
		<div class="product <?= ($v['stock']==0?'outofstock':'') ?>">
			<a href="<?= $GLOBALS['URL_BASE'] ?>product/<?= h($v["id"]); ?>/" class="img" style="background-image:url('<?= $GLOBALS['URL_BASE'] ?>webroot/img/products/<?= h($v["id"]); ?>-1.png');"></a>

				<span class="infos">

					<span class="title">
						<a href="<?= $GLOBALS['URL_BASE'] ?>product/<?= h($v["id"]); ?>/" title=""><?= h($v["name"]); ?></a>
					</span>

					<?php if ($v['stock'] == 0){
							echo '<div class="stock state3"><strong>Rupture de stock !</strong></div>';
						} elseif ($v['stock'] > 0 && $v['stock'] <= 3) {
							echo '<div class="stock state2">Il ne reste plus que <strong>'.$v['stock'].' éléments en stock</strong>, dépechez-vous !</div>';
						} else {
							echo '<div class="stock state1">Stock  : <strong>'.$v['stock'].' éléments</strong></div>';
						}
					?>
				</span>

				<span class="price">
					<?= number_format(h($v["price"]), 2); ?>€
				</span>

				<span class="quantity">

					<a title="Retirer un article" href="<?= $GLOBALS['URL_BASE'] ?>shoppingCart/update/<?= $v['id'] ?>/<?= intval($shoppingCart[$v['id']])-1 ?>/"><i class="fas fa-minus-square"></i></a>

					<?= h($shoppingCart[$v['id']]) ?> 

					<?php if ($v['stock'] > intval($shoppingCart[$v['id']])): ?>
						<a title="Ajouter un article" href="<?= $GLOBALS['URL_BASE'] ?>shoppingCart/update/<?= $v['id'] ?>/<?= intval($shoppingCart[$v['id']])+1 ?>/"><i class="fas fa-plus-square"></i></a>
					<?php endif ?>

				</span>
		</div>
		<div class="clear separation"></div>
	<?php endforeach;
	if(!$items): echo "Vous n'avez encore ajouté aucun article dans votre panier."; else: ?>

		<span class="shippingCost">
			Les frais de port s'élèvent à <?= number_format(h($GLOBALS['SHIPPING_COST']), 2); ?>€. Livraison gratuite pour toute commande dépassant les <?= number_format(h($GLOBALS['FREE_SHIPPING']), 2); ?>€.
		</span>

		<a href="<?= $GLOBALS['URL_BASE'] ?>addresses" class="button payment">
			<i class="fas fa-credit-card"></i> Procéder au payement de <?= number_format(h(($total < $GLOBALS['FREE_SHIPPING']?$total+6:$total)), 2); ?>€
		</a>
	<?php endif ?>

	<div class="clear"></div>
</section>

<?php $content = ob_get_clean(); require('View/Layouts/desktop.php'); ?>