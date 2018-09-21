<?php

/* TO COMPLETE add include class*/


$index = new Index();

$index->printhtml();


class Index {

    private $_content; //type: AbstractPage

    function __construct(){
        $className= $_GET['action'];
        if(class_exists($className)) {
            $this->_content = new $className();
        } else {
            die ('invalid url');
        }
    }

    public function printhtml() {
        print $this->getHtml();
    }

    function getHtml(){
        $html= '
            <!DOCTYPE html>
            <html>
            <head>
                <title>Buy.com</title>';

        $cssList = $this->_content->getCssList();
        foreach($cssList as $cssPath){
            $html .= ' <link rel="stylesheet" href="css/'.$cssPath.'.css" />';
        }
        $html .= ' </head><body>';

        $header = $this->_content->getHeader()->getHtml();
        if ($header) {
            $html .= '<header>'.$header.'</header>';
        }

        $nav = $this->_content->getNav()->getHtml();
        if ($nav) {
            $html .= '<nav>'.$nav.'</nav>';
        }

        $html .= '<section>'.$this->_content->gethtml().'</section>';


        $footer = $this->_content->getFooter()->getHtml();
        if ($footer) {
            $html .= '<footer>'.$footer.'</footer>';
        }

        $html .= '</body></html>';


        return $html;
    }



}

