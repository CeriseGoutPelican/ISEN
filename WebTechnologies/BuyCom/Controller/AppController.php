<?php 
class AppController
{

	/**
	 * Fonction de construction où l'on fait passer tous les arguments à utiliser pour l'affichage global du site
	 *
	 * @author Grégoire Gaonach
	 */
    public function __construct() {
    	// Utilisateur connecté et passage des informations
    	$user = new User();
        $this->userConnected = $user->is_loggedin();
        if($this->userConnected !== false){
        	$this->user = $user->getUser($_SESSION['user_session']);
        }

        // Panier de course
        $shop = new Shop();
        $this->nbItems = $shop->itemsShoppingCart();
    }

}

//$layout_categories = categories();