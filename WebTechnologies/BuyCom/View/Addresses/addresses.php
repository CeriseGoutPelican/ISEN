<?php $title = "Ajouter une adresse"; ob_start(); ?>

<div class="addresses">

	<a href="" class="button newAdress">
		<i class="fas fa-address-book"></i> Ajouter une nouvelle adresse
	</a>

	<h1>Choisir une adresse de livraison</h1>

	<div class="clear"></div>
		
	<?php foreach ($addresses as $v): ?>
		<div class="address">
			<div class="options">
				
					<input type="radio" id="delivery_<?= $v['id'] ?>" name="feature" value="delivery_<?= $v['id'] ?>" />
					<label for="delivery_<?= $v['id'] ?>">Livraison</label>

					<br>

					<input type="radio" id="billing_<?= $v['id'] ?>" name="feature" value="billing_<?= $v['id'] ?>" />
					<label for="billing_<?= $v['id'] ?>">Facturation</label>
					
			</div>
			<div class="name">
				<?= $v['name'] ?>
			</div>
			<div class="description">
				<?= $v['street'].' '.$v['postcode'].' '.$v['city'].' '.$v['country'] ?>
			</div>
		</div>
	<?php endforeach;
		if(sizeof($addresses) <= 0): ?>

			Aucune addresse n'est encore sauvegardée pour votre compte. <a href="" title="En créer une ?">En créer une ?</a>

	<?php endif; ?>

	<a href="#"" class="button payment">
		<i class="fas fa-credit-card"></i> Procéder au payement
	</a>

	<div class="clear"></div>

</div>

<?php $content = ob_get_clean(); require('View/Layouts/desktop.php'); ?>