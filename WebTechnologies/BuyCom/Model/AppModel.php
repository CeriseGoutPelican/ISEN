<?php 
class AppModel
{
	/**
	 * Permet de se connecter à la base de données avec PDO
	 *
	 * @throws Exception si la connexion à la base de données n'est pas possible
	 * @author Grégoire Gaonach
	 * @return La connexion PDO 
	 */
	protected function dbConnect(){

		try{
			$host     = "localhost";
			$dbName   = "buycom";
			$username = "root";
			$password = "root";

			$db = new PDO("mysql:host=".$host.";dbname=".$dbName.";charset=utf8", $username, $password);
			return $db;
		}
		catch(Exception $e){
			die('Erreur lors de la connexion en base de données : '.$e->getMessage());
		}

	}
}

/**
 * Permet de récupérer les catégories en base de données pour l'affichage dans le layout
 *
 * @author Grégoire Gaonach
 * @return un array avec les catégories
 */
/*function categories(){

	$db = dbConnect();
	$req = $db->query(
		'SELECT *
		 FROM `categories`
		 LIMIT 0, 4');
	
	return $req->fetchAll();

}
*/