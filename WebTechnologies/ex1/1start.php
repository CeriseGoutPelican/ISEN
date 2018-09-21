<!DOCTYPE html>
<html>
<head>
    <title></title>
    <style>
        table
        {
            border-collapse: collapse;
        }
        td, th
        {
            border: 1px solid black;
        }
    </style>
</head>
<body>

<?php
/**
 * Created by PhpStorm.
 * User: vincebru
 * Date: 25/09/14
 * Time: 20:58
 */

$dynamicValue = array('45','555');//null; // = rand(0,10);// not interpreted

include('1startBis.php');

echo('<br>echo :');
echo($dynamicValue);
echo('<pre><br>var_dump:');
var_dump($dynamicValue);
echo('<br>');



if (true) {
    echo('test');
    echo('titi');
}



echo "dynamic presentation".$dynamicValue;

?>


</body>
</html>