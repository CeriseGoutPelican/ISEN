<?php
session_start();
/**
 * Created by PhpStorm.
 * User: vincebru
 * Date: 25/09/14
 * Time: 21:36
 */

function verifLogin($login, $pwd) {
    $users= array(
        "robert" => "toto",
        "john" => "titi",
        "suzanne" => "tata"
    );

    return isset($users[$login]) && $users[$login] == $pwd;

}

if (!isset($_SESSION['token'])) {
    $login = $_GET['login'];
    $pwd = $_GET['password'];

    /*
    echo $login;
    ?><br /><?php
    echo $pwd;*/



    if ( verifLogin($login, $pwd) ) {
        $token = md5($login);
        $_SESSION['token'] = $token;
        echo "successful authentication<br />";

    } else {
        echo "authentification failed";
        include "2login.html";
        die;
    }
}


