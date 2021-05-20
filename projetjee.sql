-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 20 mai 2021 à 22:06
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projetjee`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `email` varchar(255) NOT NULL,
  `mdp` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`email`, `mdp`, `nom`, `prenom`) VALUES
('emailAdmin', 'mdp', 'nomé', 'prenom');

-- --------------------------------------------------------

--
-- Structure de la table `commercant`
--

DROP TABLE IF EXISTS `commercant`;
CREATE TABLE IF NOT EXISTS `commercant` (
  `email` varchar(255) NOT NULL,
  `mdp` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `localisation` varchar(255) DEFAULT NULL,
  `validation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `commercant`
--

INSERT INTO `commercant` (`email`, `mdp`, `nom`, `prenom`, `categorie`, `localisation`, `validation`) VALUES
('email3', 'mdp', 'nom', 'prenom', 'categorie', 'localisation', 'validé'),
('email12', 'mdp', 'nom', 'prenom', 'categorie', 'localisation', 'non validé'),
('email2', 'mdp2', 'nom2', 'prenom2', 'categorie2', 'localisation2', 'non validé');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(12);

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

DROP TABLE IF EXISTS `panier`;
CREATE TABLE IF NOT EXISTS `panier` (
  `id` bigint(20) NOT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `confirme` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `localisation` varchar(255) DEFAULT NULL,
  `reserve` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `id_com` varchar(255) DEFAULT NULL,
  `id_uti` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdfkot0ftii2fiu4boes89w7f7` (`id_com`),
  KEY `FKs4mx8qta6m6yws7vy2ybjoaet` (`id_uti`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `panier`
--

INSERT INTO `panier` (`id`, `categorie`, `confirme`, `description`, `localisation`, `reserve`, `titre`, `id_com`, `id_uti`) VALUES
(2, 'categorie2', 'confirmé', ' description2', 'localisation2', 'reservé', 'panier 2 ', 'email3', 'email4'),
(3, 'categorie', 'non confirmé', ' description', 'localisation', 'non reservé', 'titre', 'email3', NULL),
(4, 'categorie2', 'non confirmé', ' description2', 'localisation2', 'non reservé', 'panier 2 ', 'email3', NULL),
(5, 'categorie', 'non confirmé', ' description', 'localisation', 'non reservé', 'titre', 'email3', NULL),
(6, 'categorie2', 'non confirmé', ' description2', 'localisation2', 'non reservé', 'panier 2 ', 'email3', NULL),
(7, 'categorie', 'non confirmé', ' description', 'localisation', 'non reservé', 'titre', 'email3', NULL),
(8, 'categorie2', 'non confirmé', ' description2', 'localisation2', 'non reservé', 'panier 2 ', 'email3', NULL),
(9, 'categorie', 'non confirmé', ' description', 'localisation', 'non reservé', 'titre', 'email3', NULL),
(10, 'categorie2', 'non confirmé', ' description2', 'localisation2', 'non reservé', 'panier 2 ', 'email3', NULL),
(11, 'le', 'non confirmé', 'lknl', 'memme', 'non reservé', 'apanyi', 'email3', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `profil`
--

DROP TABLE IF EXISTS `profil`;
CREATE TABLE IF NOT EXISTS `profil` (
  `email` varchar(255) NOT NULL,
  `mdp` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `email` varchar(255) NOT NULL,
  `mdp` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `validation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`email`, `mdp`, `nom`, `prenom`, `validation`) VALUES
('email4', 'mdp1', 'nom1', 'prenom1', 'validé'),
('lknn', 'lknlkn', 'lln', 'klnkln', 'non validé');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
