<?php 
// Début de session
session_start();

// Core
require('./Core/core.php');
require('./Core/config.php');

// Models
require('./Model/AppModel.php');

// Controllers
require('./Controller/AppController.php');
require('./Controller/ShopController.php');
require('./Controller/PagesController.php');
require('./Controller/CategoriesController.php');
require('./Controller/UsersController.php');
require('./Controller/AddressesController.php');

// Rooting
if(isset($_GET['action'])) {
	if($_GET['action'] == 'home') {
		$page = new PagesController;
		$page->home();
	}
	elseif($_GET['action'] == 'products'){
		// Vérification de la présence d'une catégorie
		if(isset($_GET['category'])){
			$category = intval($_GET['category']);
		} else {
			$category = false;
		}

		$shop = new ShopController;
		$shop->listItems($category);
	}
	elseif($_GET['action'] == 'product'){
		$shop = new ShopController;
		$shop->displayItem(intval($_GET['id']));
	}
	elseif($_GET['action'] == 'shoppingCart'){
		$shop = new ShopController;

		if(isset($_GET['dir']) && isset($_GET['item_id']) && isset($_GET['quantity'])){
			$shop->shoppingCart("update", intval($_GET['item_id']), intval($_GET['quantity']));
		} else {
			$shop->shoppingCart("display");
		}
	}
	elseif($_GET['action'] == 'signup'){
		$user = new UsersController;
		$user->signup();
	}
	elseif($_GET['action'] == 'logout'){
		$user = new UsersController;
		$user->logout();
	}
	elseif($_GET['action'] == 'addresses'){
		$user = new AddressesController;
		$user->display();
	}
	elseif($_GET['action'] == 'editAddress'){
		$user = new AddressesController;
		$user->editAddress();
	}
	else{
		require('View/Layouts/desktop.php');
	}
}
else{
	$page = new PagesController;
	$page->home();
}
