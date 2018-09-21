<?php 
class Shop extends AppModel
{

	/**
	 * Permet de récupérer en base de données un certain nombre de produits
	 *
	 * @param int  number Nombre de produits à récupérer en base de données
	 * @param int  category ID de la catégorie à rechercher
	 *
	 * @author Grégoire Gaonach
	 * @return Un array avec les produits à afficher
	 */
	public function getItems($number = 6, $category = false){
		
		$db = $this->dbConnect();
		$req = $db->query(
			'SELECT *
			 FROM products
			 WHERE category_id '.(!$category?"IS NOT NULL":"= $category").'
			 ORDER BY created
			 DESC LIMIT 0, '.$number.'');

	    return ($req?$req->fetchAll():false);

	}

	/**
	 * Permet de récupérer en base de données un certain nombre de produits
	 *
	 * @param int  id Le numéro de l'article en base de données
	 *
	 * @author Grégoire Gaonach
	 * @return Un array avec le produit à afficher
	 */
	public function getItem($id){
		
		$db = $this->dbConnect();
		$req = $db->query(
			"SELECT *
			 FROM products
			 WHERE id = $id");

	    return ($req?$req->fetch():false);

	}

	/**
	 * Permet de compter le nombre de produits dans le panier
	 *
	 * @author Grégoire Gaonach
	 * @return Un array avec le produit à afficher
	 */
	public function itemsShoppingCart(){
		
		if(isset($_COOKIE["shopping_cart"])){
			$shoppingCart = json_decode($_COOKIE['shopping_cart'], true);
		} else {
			$shoppingCart = array();
		}

		$total = 0;
		foreach ($shoppingCart as $k => $v) {
			$total += $v;
		}

		return $total;

	}

}

