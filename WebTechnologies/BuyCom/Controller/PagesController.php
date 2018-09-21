<?php
require('./Model/Page.php');

class PagesController extends AppController
{

	/**
	 * Permet le bon affichage de la page d'accueil
	 *
	 * @author Grégoire Gaonach
	 * @return none
	 */
	function home(){

		$shop  = new Shop();
		$items = $shop->getItems();

		require('View/Pages/home.php');
	}

}
