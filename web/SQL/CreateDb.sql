-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 14, 2016 at 07:23 PM
-- Server version: 5.6.24
-- PHP Version: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `blackjackjbm`
--

-- --------------------------------------------------------

--
-- Table structure for table `games`
--

CREATE TABLE IF NOT EXISTS `games` (
  `game_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `end_time` timestamp NULL DEFAULT NULL,
  `number_decks` int(2) NOT NULL DEFAULT '1',
  `user_starting_balance` int(12) NOT NULL,
  `game_code` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `games`
--

INSERT INTO `games` (`game_id`, `user_id`, `start_time`, `end_time`, `number_decks`, `user_starting_balance`, `game_code`) VALUES
(1, 2, '2016-04-14 17:17:40', NULL, 1, 1000, '21ce528e-899d-467c-8522-7654c93feb57'),
(2, 2, '2016-04-14 17:19:10', NULL, 1, 1000, '036ef915-f0c1-42ce-b073-c6d9ce7aee1d');

-- --------------------------------------------------------

--
-- Table structure for table `games_meta`
--

CREATE TABLE IF NOT EXISTS `games_meta` (
  `meta_id` int(11) NOT NULL,
  `game_id` int(11) NOT NULL,
  `metaKey` varchar(255) NOT NULL,
  `metaValue` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(24) NOT NULL,
  `user_hash_pass` varchar(255) NOT NULL,
  `user_balance` double NOT NULL DEFAULT '1000',
  `user_active` tinyint(1) NOT NULL,
  `user_failed_log_attempts` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_name`, `user_hash_pass`, `user_balance`, `user_active`, `user_failed_log_attempts`) VALUES
(1, 'brynku', 'B0FD9B6D3B65EF11A61F5FDAAF1F3F69A6664367', 1600, 1, 0),
(2, 'kepoly', 'D6516E030065EA89A8DB4C1724E9DF7988343181', 2000, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `users_meta`
--

CREATE TABLE IF NOT EXISTS `users_meta` (
  `meta_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `total_bet` double NOT NULL DEFAULT '0',
  `total_won` double NOT NULL DEFAULT '0',
  `total_hands` int(11) NOT NULL DEFAULT '0',
  `hands_won` int(11) NOT NULL DEFAULT '0',
  `blackjacks` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users_meta`
--

INSERT INTO `users_meta` (`meta_id`, `user_id`, `total_bet`, `total_won`, `total_hands`, `hands_won`, `blackjacks`) VALUES
(1, 1, 11000, 0, 34, 0, 0),
(2, 2, 30500, 0, 35, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `games`
--
ALTER TABLE `games`
  ADD PRIMARY KEY (`game_id`), ADD KEY `fk_user_table_id_for_game_idx` (`user_id`);

--
-- Indexes for table `games_meta`
--
ALTER TABLE `games_meta`
  ADD PRIMARY KEY (`meta_id`), ADD KEY `fk_game_table_id_idx` (`game_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `users_meta`
--
ALTER TABLE `users_meta`
  ADD PRIMARY KEY (`meta_id`), ADD KEY `fk_user_table_id_idx` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `games`
--
ALTER TABLE `games`
  MODIFY `game_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `games_meta`
--
ALTER TABLE `games_meta`
  MODIFY `meta_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `users_meta`
--
ALTER TABLE `users_meta`
  MODIFY `meta_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
