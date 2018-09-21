<?php 
class Category extends AppModel{

	/**
	 * Permet de récupérer les informations d'une catégorie
	 *
	 * @param int  category l'id de la catégorie
	 *
	 * @author Grégoire Gaonach
	 * @return Un array avec les informations de la catégory
	 */
	public function infos($category){
		
		$db = $this->dbConnect();
		$req = $db->query(
			"SELECT *
			 FROM categories
			 WHERE id = $category");

	    return ($req?$req->fetch():false);

	}

}

