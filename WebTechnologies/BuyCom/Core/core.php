<?php
/**
 * Fonction de debug
 *
 * @param int  description
 *
 * @author Grégoire Gaonach
 * @return description
 */
function debug($var, $die = false){
	error_reporting(E_ALL);

	echo '<pre style="width: 94%; margin: 1.5%; padding: 1.5%; background: #FFC600; overflow: scroll; border: 1px solid #CC6C00; border-radius: 5px;"><h1 style="margin-top: 0; color: #CC6C00; font-size: 18px;">Debug <small>('.debug_backtrace()[0]["file"].' - line '.debug_backtrace()[0]["line"].')</small></h1>';
	print_r($var);
	echo '</pre>';

	if($die)
		die();
}

/**
 * Permet de sécuriser l'affichage d'une variable
 *
 * @param var  Variable à sécuriser
 *
 * @author Grégoire Gaonach
 * @return string la variable sécurisée
 */
function h($var = ""){
	return  htmlspecialchars($var);
}