<?php
require_once('./Model/Address.php');

class AddressesController extends AppController{

	function display()
	{
		$user = new User();
		$address = new Address();

		if($user->is_loggedin() === false){
			header('Location: /signup/');
		}

		$addresses = $address->getAddresses();

		require('View/Addresses/addresses.php');
	}

}