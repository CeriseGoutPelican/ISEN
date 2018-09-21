<?php
require_once('./Model/User.php');

class UsersController extends AppController
{

	/**
	 * Permet à un utilisateur de s'inscrire sur le site
	 *
	 * @author Grégoire Gaonach
	 * @return 
	 */
	function signup()
	{
		$user = new User();

		if($user->is_loggedin() !== false){
			header('Location: ../'); 
		}	

		if(isset($_POST['cgu'])){
			$signup = $user->signup($_POST);

			if($signup === true){
				header('Location: /shoppingCart/'); 
			}
		} else {
			$login  = $user->login($_POST);

			if($login === true){
				header('Location: /shoppingCart/'); 
			}
		}

		require('View/Users/signup.php');
	}

	function logout()
	{
		session_unset();
		session_destroy();
		$_SESSION = array();

		header('Location: ' . $_SERVER['HTTP_REFERER']);
	}

}
