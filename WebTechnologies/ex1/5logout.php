<?php
session_start();
/**
 * Created by PhpStorm.
 * User: vincebru
 * Date: 25/09/14
 * Time: 22:16
 */

echo('bye bye<br />');

session_destroy();

include_once("2login.html");