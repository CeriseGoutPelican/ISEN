<?php
/**
 * Created by PhpStorm.
 * User: vincebru
 * Date: 23/10/14
 * Time: 21:20
 */

class Header extends AbstractDiv{
    public function gethtml() {
        return '
            <a id="headertitle" href="index.php?action=main">Buy.com</a>
        ';
    }
} 