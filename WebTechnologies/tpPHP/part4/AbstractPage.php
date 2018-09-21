<?php

include ('Header.php');
include ('Nav.php');
include ('Footer.php');



/**
 * Created by PhpStorm.
 * User: vincebru
 * Date: 23/10/14
 * Time: 20:15
 */

class AbstractPage {

    protected $_withHeader;
    protected $_withNav;
    protected $_withFooter;

    protected $_returnview;


    function __construct() {
        $this->_withHeader = false;
        $this->_withNav = false;
        $this->_withFooter = false;
    }

    public function getCssList() {
        if ($this->_returnview) {
            return $this->_returnview->getCssList();
        } else {
            return array();
        }

    }

    public function gethtml() {
        if ($this->_returnview) {
            return $this->_returnview->gethtml();
        } else {
            return "";
        }
    }

    public function isWithHeader(){
        if ($this->_returnview) {
            return $this->_returnview->isWithHeader();
        } else {
            return $this->_withHeader;
        }
    }

    public function isWithNav(){
        if ($this->_returnview) {
            return $this->_returnview->isWithNav();
        } else {
            return $this->_withNav;
        }
    }

    public function isWithFooter(){
        if ($this->_returnview) {
            return $this->_returnview->isWithFooter();
        } else {
            return $this->_withFooter;
        }
    }

    public function getHeader(){
        if (!$this->isWithHeader()) {
            return new Abstractdiv();
        } else {
            return new Header();
        }
    }

    public function getNav(){
        if (!$this->isWithNav()) {
            return new Abstractdiv();
        } else {
            return new Nav();
        }
    }

    public function getFooter(){
        if ($this->isWithFooter()) {
            return new Footer();
        } else {
            return new Abstractdiv();
        }
    }
} 