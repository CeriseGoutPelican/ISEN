<?php $title = $item['name']; ob_start(); ?>

<section class="item">

	<div class="images">
		<div class="thumbnails">
			<?php for ($i = 1; $i <= $item['images']; $i++): ?>
				<div class="thumbs" style="background-image:url('<?= $GLOBALS['URL_BASE'] ?>webroot/img/products/<?= h($item["id"]).'-'.$i; ?>.png');"></div>
			<?php endfor; ?>
		</div>
		<div class="image" style="background-image:url('<?= $GLOBALS['URL_BASE'] ?>webroot/img/products/<?= h($item["id"]); ?>-1.png');">
			
		</div>
		<div class="clear"></div>
	</div>

	<div class="description">

		<?php if ($item['stock'] > 0 && $item['stock'] > $inCart): ?>
			<a href="<?= $GLOBALS['URL_BASE'] ?>shoppingCart/update/<?= $item['id'] ?>/<?= $inCart+1 ?>/" class="button addToCart">
				<i class="fas fa-cart-plus"></i> Ajouter au panier (<?= $inCart ?>)
			</a>
		<?php endif ?>

		<h1><?= h($item['name']); ?></h1>

		<div class="price"><?= number_format(h($item["price"]), 2); ?>€</div>
		•
		<?php if ($item['stock'] == 0){
				echo '<div class="stock state3"><strong>Rupture de stock !</strong></div>';
			} elseif ($item['stock'] > 0 && $item['stock'] <= 3) {
				echo '<div class="stock state2">Il ne reste plus que <strong>'.$item['stock'].' éléments en stock</strong>, dépechez-vous !</div>';
			} else {
				echo '<div class="stock state1">Stock  : <strong>'.$item['stock'].' éléments</strong></div>';
			}
		?>

		<div class="separation"></div>
		
		<?= nl2br(h($item['description'])); ?>

	</div>

	<div class="clear"></div>
	
</section>

<script type="text/javascript">
	$(document).ready(function(){
		$(".thumbs").hover(function() {
			 $('.item .images .image').attr("style",$(this).attr("style"));
		}, function() {});
	});
</script>

<?php $content = ob_get_clean(); require('View/Layouts/desktop.php'); ?>