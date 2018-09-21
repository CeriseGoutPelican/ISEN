<?php 
class User extends AppModel{

	/**
	 * Permet de se connecter au site
	 *
	 * @param var post_data Les données de type $_POST envoyées par l'utilisateur
	 *
	 * @author Grégoire Gaonach
	 * @return callback true/erreur quant à la connexion
	 */
	function login($post_data = false){

		if(!$post_data){
			return "noData";
		}

		try{

			$db  = $this->dbConnect();
			$req = $db->prepare("SELECT * FROM users WHERE email=:email LIMIT 1");
			$req->execute(array(':email'=>$post_data['email']));

			$userRow=$req->fetch(PDO::FETCH_ASSOC);

			if($req->rowCount() > 0)
			{
				if(password_verify($post_data['psw'], $userRow['password']))
				{
					$_SESSION['user_session'] = $userRow['id'];
					return true;
				}
				else
				{
					return "wrongPsw";
				}
			}

		}
		catch(PDOException $e){
			return "pdoLogin";
		}

	}

	/**
	 * Permet de vérifier si un utilisateur est connecté et de le reconnecter avec un cookie si
	 * nécessaire
	 *
	 * @author Grégoire Gaonach
	 * @return true si l'utilisateur est connecté
	 */
	public function is_loggedin(){

		if(isset($_SESSION['user_session'])){
			return true;
		}
		return false;

	}

	/**
	 * Permet de traiter les données envoyées par l'utilisateur et d'inscrire l'utilisateur si tout 
	 * va bien
	 *
	 * @param var post_data Les données de type $_POST envoyées par l'utilisateur
	 *
	 * @author Grégoire Gaonach
	 * @return callback true/erreur quant à l'inscription
	 */
	function signup($post_data = false)
	{
		if(!$post_data){
			return "noData";
		}

		$callback = true;

		// Vérification utilisateur
		if(!isset($post_data['name']) || strlen(($post_data['name'])) < 1){
			$callback = "name";
		}
		if(!isset($post_data['surname']) || strlen(($post_data['surname'])) < 1){
			$callback = "surname";
		}
		if(!isset($post_data['email1']) || !isset($post_data['email2']) || !filter_var($post_data['email1'], FILTER_VALIDATE_EMAIL) || !filter_var($post_data['email2'], FILTER_VALIDATE_EMAIL)){
			$callback = "email";
		}
		if($post_data['email1'] != $post_data['email2']){
			$callback = "matching_email";
		}
		if($this->uniqueEmail($post_data['email1']) != 0){
			$callback = "uniqueEmail";
		}
		if(!isset($post_data['psw1']) || !isset($post_data['psw2']) || strlen(($post_data['psw1'])) <= 5){
			$callback = "psw";
		}
		if($post_data['psw1'] != $post_data['psw2']){
			$callback = "matching_psw";
		}
		if(!isset($post_data['cgu']) || $post_data['cgu'] != "on"){
			$callback = "cgu";
		}

		if($callback === true){ //
			try
			{
				$new_password = password_hash($post_data['psw1'], PASSWORD_DEFAULT);

				$db   = $this->dbConnect();
				$req = $db->prepare("INSERT INTO users(name,surname,password,email) 
				                            VALUES(:name,:surname,:password,:email)");

				$req->bindparam(":name", $post_data['name']);
				$req->bindparam(":surname", $post_data['surname']);
				$req->bindparam(":password", $new_password);    
				$req->bindparam(":email", $post_data['email1']);           
				$req->execute(); 

				return true;
			}
			catch(PDOException $e)
			{
				$callback = "pdo";
			}
		}

		return $callback;

	}

	/**
	 * Permet de récupérer en base de données l'utilisateur demandé
	 *
	 * @param int  id Le numéro unique de l'utilisateur
	 *
	 * @author Grégoire Gaonach
	 * @return Un array avec les infos utilisateur (false si aucun utilisateur trouvé)
	 */
	public function getUser($id){
		
		$db = $this->dbConnect();
		$req = $db->query(
			"SELECT *
			 FROM users
			 WHERE id = $id");

	    return ($req?$req->fetch():false);

	}

	/**
	 * Retourne le nombre d'utilisateur trouvé avec un mail particulier
	 *
	 * @param var   le mail à rechercher
	 *
	 * @author Grégoire Gaonach
	 * @return Le nombre de colonnes trouvés
	 */
	function uniqueEmail($email = ""){

		$db = $this->dbConnect();
		$req = $db->prepare(
			"SELECT count(*)
			 FROM users
			 WHERE email = ?");

		$req->execute([$email]);

	    return $req->fetchColumn();

	}

	/**
	 * Permet d'ajouter une nouvelle addresse de livraison et/ou de facturation
	 *
	 * @param var post_data Les données de type $_POST envoyées par l'utilisateur
	 * @param int id l'id de l'adresse si on est sur une modification
	 *
	 * @author Grégoire Gaonach
	 * @return callback true/erreur quant à l'ajout d'une adresse
	 */
	function editAddress($post_data = false, $id = 0)
	{
		if(!$post_data){
			return "noData";
		}

		$callback = true;

		// Vérification utilisateur
		if(!isset($post_data['name']) || strlen(($post_data['name'])) < 1){
			$callback = "name";
		}
		if(!isset($post_data['surname']) || strlen(($post_data['surname'])) < 1){
			$callback = "surname";
		}

		if($callback === true){ //
			try
			{
				$db   = $this->dbConnect();
				$req = $db->prepare("INSERT INTO users(name,surname,password,email) 
				                            VALUES(:name,:surname,:password,:email)");

				$req->bindparam(":name", $post_data['name']);
				$req->bindparam(":surname", $post_data['surname']);
				$req->bindparam(":password", $new_password);    
				$req->bindparam(":email", $post_data['email1']);           
				$req->execute(); 

				return true;
			}
			catch(PDOException $e)
			{
				$callback = "pdo";
			}
		}

		return $callback;

	}

}

