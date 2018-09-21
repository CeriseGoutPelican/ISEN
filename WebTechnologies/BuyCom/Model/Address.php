<?php 
class Address extends AppModel{

	/**
	 * Description
	 *
	 * @param int  description
	 *
	 * @author Grégoire Gaonach
	 * @return description
	 */
	function editAddress(){

	}

	/**
	 * Permet de récupérer une adresse pour un utilisateur particulier
	 *
	 * @author Grégoire Gaonach
	 * @return un tableau avec les adresses de l'utilisateur
	 */
	function getAddresses(){

		$db  = $this->dbConnect();
		$req = $db->prepare(
			"SELECT *
			 FROM addresses
			 WHERE user_id = ?");

		$req->execute([$_SESSION['user_session']]);
		$addresses = $req->fetchAll(PDO::FETCH_ASSOC);

		return $addresses;

	}

}