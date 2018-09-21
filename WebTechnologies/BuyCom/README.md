# Projet web : site de e-commerce ecobuy.com
## Images du projet
### Page d'accueil
![enter image description here](https://pbs.twimg.com/media/DnKIuUNX0AAJIzW.jpg)
### Un exemple de catégorie
![enter image description here](https://pbs.twimg.com/media/DnKIv-2XcAAzz82.jpg)
### Un exemple de page produit
![enter image description here](https://screenshotscdn.firefoxusercontent.com/images/5f045a2d-bb72-40fd-adcb-e37a1ef17a89.png)
### Panier utilisant des cookies
![enter image description here](https://pbs.twimg.com/media/DnKIxiwW0AEEjNF.jpg)
### Connexion / inscription
![enter image description here](https://screenshotscdn.firefoxusercontent.com/images/d7939132-6049-4a07-9fda-f6ed2fa24b1a.png)
### Gestion des adresses 
![enter image description here](https://screenshotscdn.firefoxusercontent.com/images/517a74a2-b13e-4383-a308-b3de6a7909e1.png)

## To-do list
* Terminer la gestion des adresses
* Rendre le code plus propre 
* Faire la page de payement
* Gérer le back-office (état des commandes et de livraison ; ajout et modification d'articles)
* Gérer les cookies pour rester connecté
* Mot de passe oublié 
* Création d'une page de facture et de suivi pour le client
* Page de réclamation
* Gestion des promotions et offres spaciales
* Fonction de recherche

## SQL Export
```sql
-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Ven 21 Septembre 2018 à 11:44
-- Version du serveur :  5.6.20-log
-- Version de PHP :  5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `buycom`
--

-- --------------------------------------------------------

--
-- Structure de la table `addresses`
--

CREATE TABLE IF NOT EXISTS `addresses` (
`id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `postcode` int(5) NOT NULL,
  `city` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `delivery` tinyint(1) NOT NULL,
  `billing` tinyint(1) NOT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Contenu de la table `addresses`
--

INSERT INTO `addresses` (`id`, `user_id`, `name`, `street`, `postcode`, `city`, `country`, `delivery`, `billing`) VALUES
(1, 3, 'Résidence Universitaire', '66 Rue Colbert', 59000, 'Lille', 'France', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
`id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `categories`
--

INSERT INTO `categories` (`id`, `name`) VALUES
(1, 'Courses'),
(2, 'Cuisine\r\n');

-- --------------------------------------------------------

--
-- Structure de la table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
`id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `created` datetime NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `order_products`
--

CREATE TABLE IF NOT EXISTS `order_products` (
`id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
`id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` float NOT NULL,
  `stock` int(11) NOT NULL,
  `description` text NOT NULL,
  `images` int(2) NOT NULL,
  `category_id` int(11) NOT NULL,
  `created` datetime NOT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `products`
--

INSERT INTO `products` (`id`, `name`, `price`, `stock`, `description`, `images`, `category_id`, `created`) VALUES
(1, 'Éponge lavable', 5.5, 10, 'Éponge lavable en microfibre lavable à 40° ou 60° en machine.\r\n\r\nElle dure plusieurs années et permet de ne plus acheter d’éponges jetables, pour le ménage comme pour la cuisine !', 3, 2, '2018-09-14 22:57:00'),
(2, 'Sac à vrac', 4, 2, 'Sac à vrac en coton biologique et commerce équitable\r\n\r\nIl s’utilise pour toutes les courses en vrac, farine, pâtes, riz etc.\r\n\r\nIl peut aussi s’utiliser pour transporter son pain. Il préserve les qualités gustatives du pain coupé.\r\n\r\nFermeture coulissante', 3, 1, '2018-09-14 23:14:00'),
(3, 'Mouchoir bleu', 5, 0, 'Mouchoir en coton biologique réalisé en France.\r\n\r\nIls sont une parfaite alternative zéro déchet aux mouchoirs en papier jetables.\r\n\r\nIls sont lavables en machine jusqu’à 60°.\r\n\r\nDimension : 25 cm X 25 cm\r\n\r\nVous pouvez les emmener partout avec vous grâce à la pochette (disponible ici) en coton biologique faite en France.\r\n\r\nEt vous pouvez stocker les mouchoirs sales dans une seconde pochette avant de les glisser dans votre machine à laver.\r\n\r\nAinsi, l’utilisation de mouchoirs en tissus reste hygiénique et très pratique !\r\n\r\nMouchoir vendu à l’unité.', 2, 2, '2018-09-15 01:10:00'),
(4, '« Sopalin » lavable', 24, 12, 'Ce rouleau permet de remplacer le sopalin.\r\n\r\nIl est composé de 8 « feuilles » d’ essuie-tout au format 20cm x 20 cm.\r\n\r\nIl est esthétique, écologique et économique.\r\n\r\nUne fois la feuille utilisée, il suffit de la laver à la machine à 40°.\r\nEnsuite, rattachez la feuille sur le rouleau avec les autres grâce à ses pressions !\r\n\r\nFait en France', 1, 2, '2018-09-15 21:12:00'),
(5, 'Paille inox', 4, 30, 'Paille en inox 100% parfait pour un cocktail zéro déchet !\r\n\r\ninox 18/8\r\n\r\nPasse au lave-vaisselle.\r\nNe passe pas au four micro-ondes.\r\nIl est fortement conseillé de ne pas boire de liquide trop chauds sous risque de brûlure.\r\n\r\nLongueur : 24 cm\r\nDiamètre : 6 mm', 1, 2, '2018-09-15 15:14:00'),
(6, 'Tote Bag', 10, 23, 'Sac pour les courses en coton biologique issu du commerce équitable.\r\n\r\nDimensions : largeur 39 cm, hauteur du sac 42 cm.\r\n\r\nGrammage du coton : 140 g/m².', 2, 1, '2018-09-15 15:09:00'),
(7, 'Mug bambou 50cL', 7.9, 5, 'Mug isotherme en bambou d’une contenance de 50cL et de couleur rouge\r\n\r\nDouble parois inox intérieure et paroi bambou extérieure.\r\n\r\nCouvercle hermétique avec passage boisson et obturateur.\r\n\r\nMaintient la température environ 3 heures.\r\n\r\nIdéal pour transporter sa boisson chaude ou froide tout au long de la journée.\r\n\r\nMatières : Bambou et inox\r\n\r\n18cm de hauteur et 8,5cm de diamètre.', 2, 2, '2018-09-15 21:19:00');

-- --------------------------------------------------------

--
-- Structure de la table `reviews`
--

CREATE TABLE IF NOT EXISTS `reviews` (
`id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `rating` int(2) NOT NULL,
  `review` text NOT NULL,
  `date` datetime NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
`id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `surname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `name`, `surname`, `password`, `email`) VALUES
(4, 'Grégoire', 'Gaonach', '$2y$10$E4MBMKUQuMfRhbMA8fnFVOOh6QeMH/EZ1H8/9K.Yk6pwJ.rEU/Fhe', 'directsimsplus1@gmail.com'),
(3, 'Grégoire', 'Gaonach', '$2y$10$jChBvYkRLYLZ3lq3YVmA4.DKpoQKUKTskChoIrRwY3rYIAn2r9Ibi', 'directsimsplus@gmail.com');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `addresses`
--
ALTER TABLE `addresses`
 ADD PRIMARY KEY (`id`,`user_id`);

--
-- Index pour la table `categories`
--
ALTER TABLE `categories`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `orders`
--
ALTER TABLE `orders`
 ADD PRIMARY KEY (`id`,`user_id`);

--
-- Index pour la table `order_products`
--
ALTER TABLE `order_products`
 ADD PRIMARY KEY (`id`,`order_id`);

--
-- Index pour la table `products`
--
ALTER TABLE `products`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `reviews`
--
ALTER TABLE `reviews`
 ADD PRIMARY KEY (`id`,`product_id`,`user_id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `addresses`
--
ALTER TABLE `addresses`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `categories`
--
ALTER TABLE `categories`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `orders`
--
ALTER TABLE `orders`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `order_products`
--
ALTER TABLE `order_products`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `products`
--
ALTER TABLE `products`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `reviews`
--
ALTER TABLE `reviews`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

```
