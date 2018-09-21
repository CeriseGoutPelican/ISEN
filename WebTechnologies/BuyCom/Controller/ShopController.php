<?php 
require_once('./Model/Shop.php');
require_once('./Model/Category.php');

class ShopController extends AppController
{

	/**
	 * Permet d'afficher la liste des produits de la boutique
	 *
	 * @param int id numéro de la catégorie
	 *
	 * @author Grégoire Gaonach
	 * @return description
	 */
	function listItems($category = false){

		$shop  = new Shop();
		$items = $shop->getItems(12, $category);

		$cat = new Category();
		$category = $cat->infos($category);

		require('View/Shop/listItems.php');
		
	}

	/**
	 * Permet d'afficher un article en particulier
	 *
	 * @param int  id numéro de l'article
	 *
	 * @author Grégoire Gaonach
	 * @return 
	 */
	function displayItem($id = false){

		$shop = new Shop();
		$item = $shop->getItem($id);

		$inCart = 0;
		if(isset($_COOKIE["shopping_cart"])){
			$shoppingCart = json_decode($_COOKIE["shopping_cart"], true);
		} else {
			$shoppingCart = array();
		}
		if(isset($shoppingCart[$item['id']])){
			$inCart = $shoppingCart[$item['id']];
		}

		require('View/Shop/displayItem.php');
		
	}

	/**
	 * Permet d'afficher le panier utilisateur (connecté ou non) à l'aide de cookies
	 *
	 * @author Grégoire Gaonach
	 * @return 
	 */
	function shoppingCart($dir = "display", $item_id = -1, $quantity = -1){

		switch ($dir) {
			case "update":

				// Vérification des paramètres
				if($item_id >= 0 and $quantity >= 0){

					$shoppingCart = array();

					// Vérification du cookie : existe-t-il ?
					if(isset($_COOKIE["shopping_cart"])){
						$shoppingCart = json_decode($_COOKIE["shopping_cart"], true);
					}

					$shoppingCart[$item_id] = $quantity;

					setcookie('shopping_cart', json_encode($shoppingCart), time() + (86400 * 30), "/");

					header('Location: ' . $_SERVER['HTTP_REFERER']);

				}

				break;
			
			default:

				if(isset($_COOKIE["shopping_cart"])){
					$shoppingCart = json_decode($_COOKIE['shopping_cart'], true);
				} else {
					$shoppingCart = array();
				}

				$total = 0;
				$shop  = new Shop();
				$items = array();
				foreach ($shoppingCart as $k => $v) {
					// On vérifie que l'item n'a pas une quantité égale à zéro
					if($v > 0){
						$item = $shop->getItem($k);
						$items[] = $item;

						$total += ($item['price'] * $v);
					}
				}

				require('View/Shop/shoppingCart.php');
				break;
		}
		
	}

}
