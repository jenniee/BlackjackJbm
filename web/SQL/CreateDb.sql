-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2016 at 04:43 AM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `blackjackjbm`
--

-- --------------------------------------------------------

--
-- Table structure for table `games`
--

CREATE TABLE `games` (
  `game_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `end_time` timestamp NULL DEFAULT NULL,
  `number_decks` int(2) NOT NULL DEFAULT '1',
  `user_starting_balance` double NOT NULL,
  `game_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `games`
--

INSERT INTO `games` (`game_id`, `user_id`, `start_time`, `end_time`, `number_decks`, `user_starting_balance`, `game_code`) VALUES
(1, 2, '2016-04-13 21:06:12', NULL, 1, 1000, '458fd5c2-422b-4295-8748-664cf3e63615'),
(2, 2, '2016-04-13 21:08:42', NULL, 1, 22500.5, '85d7acc6-7876-41f5-b1b8-282e5371f0ee'),
(3, 2, '2016-04-13 21:17:29', NULL, 1, 22500.5, '0625577d-1398-4338-a1ce-116216b563ab'),
(4, 2, '2016-04-13 21:18:42', NULL, 1, 1051, '22733888-a3d0-4000-901e-c10f6aa59fdb'),
(5, 2, '2016-04-13 21:19:45', NULL, 1, 551, '5c05fb71-ab83-4b1f-ba18-a7b527405ae8'),
(6, 2, '2016-04-13 21:27:41', NULL, 1, 350, '9cff8228-7b9c-4607-9f16-7f37d4502a75'),
(7, 2, '2016-04-13 21:32:32', NULL, 1, 400, '40c97995-3081-49dc-8e0c-9f68ee65cbcf'),
(8, 2, '2016-04-13 21:36:57', NULL, 1, 500, '03977fce-9268-4c37-aa1d-d2dcf45b1654'),
(9, 2, '2016-04-13 21:39:31', NULL, 1, 0, 'e95e4fdc-1d2f-4d49-87bd-58a59dce9b3d'),
(10, 2, '2016-04-13 21:41:10', NULL, 1, 100, 'f2078ce7-e3e2-4af2-b063-7ec53a64e3d8'),
(11, 2, '2016-04-13 21:42:16', NULL, 1, 98, '7e92df2b-e00b-43f9-8e93-b3d2058d8c02'),
(12, 2, '2016-04-13 21:52:40', NULL, 1, 500, '685a077c-c82a-41e5-9629-60cddf02e026'),
(13, 2, '2016-04-13 21:57:20', NULL, 1, 1000, 'e5add7ae-95a0-4edf-a299-ec7887d8ba3c'),
(14, 2, '2016-04-13 21:58:30', NULL, 1, 500, '80216154-b52f-4dd4-adf6-ccddcd8256a7'),
(15, 2, '2016-04-13 22:01:06', NULL, 1, 10, '9a62d064-ddbe-488e-abad-0df48bf402fd'),
(16, 2, '2016-04-13 22:03:29', NULL, 1, 7, '3d27a379-f218-40de-9a8a-00ad97659608'),
(17, 2, '2016-04-13 22:06:02', NULL, 1, 9, '826d26a3-4776-4a00-83ea-e5be4c862eeb'),
(18, 2, '2016-04-13 22:10:03', NULL, 1, 10, '19c49ee8-7140-4b9d-b802-d05c16acf83d'),
(19, 2, '2016-04-13 22:15:04', NULL, 1, 10, '1e2a6a63-0043-461f-81b5-d2387de901ba'),
(20, 2, '2016-04-13 22:16:57', NULL, 1, 9, '578653fd-d54d-4087-aa2b-eaaae3151139'),
(21, 2, '2016-04-13 22:19:30', NULL, 1, 6, '13dde40b-46e1-4184-9760-cadfd73e0e32'),
(22, 3, '2016-04-13 23:03:45', NULL, 1, 1000, '12b55a52-39cd-494f-b637-e96bab6f2985'),
(23, 2, '2016-04-13 23:10:23', NULL, 1, 700, 'f82f130a-ab64-481f-8715-14a00cf186fc'),
(24, 3, '2016-04-13 23:23:30', NULL, 1, 1425, '57a2e24f-3b3e-4c26-94cb-6919c7558e76'),
(25, 13, '2016-04-13 23:35:04', NULL, 1, 1000, '7db13879-84aa-4399-96f8-d5196199e854'),
(26, 2, '2016-04-14 03:03:14', NULL, 1, 675.5, 'e9bf8774-dd79-4112-8d25-b10f60a3aec2'),
(27, 2, '2016-04-14 03:59:01', NULL, 1, 800.5, 'dc3fa359-1564-42a1-ad79-1c9188166a04'),
(28, 2, '2016-04-14 03:59:31', NULL, 1, 299.5, '6641bf9c-f022-4741-8e42-d0c5dd269ec5'),
(29, 2, '2016-04-14 04:11:16', NULL, 1, 1000, '208d602c-a856-4b69-b9a1-6a4c94956b58'),
(30, 2, '2016-04-14 04:12:08', NULL, 1, 899, 'c83fd1d2-0313-40c9-a9fd-1cc77801dda5'),
(31, 14, '2016-04-14 04:46:05', NULL, 1, 1000, '50fd275b-132b-4b0f-8de7-cb968ec99750'),
(32, 14, '2016-04-14 04:46:10', NULL, 1, 1000, 'c41ac646-c41a-46ad-b333-b9a11176159c'),
(33, 21, '2016-04-14 05:25:46', NULL, 1, 1000, '81f4d833-d669-42ff-8893-06a71c3a9b96'),
(34, 21, '2016-04-14 05:32:33', NULL, 1, 899, 'af69c57f-b9c0-47f2-b0d8-2c19464d1834'),
(35, 2, '2016-04-19 02:13:09', NULL, 1, 3914.5, '356985ac-2c68-40f2-a2d7-a96aa41ee5fe'),
(36, 2, '2016-04-19 02:14:49', NULL, 1, 3814.5, '9faa3550-cf1b-494d-8970-10cc2c178a4b'),
(37, 2, '2016-04-19 02:19:11', NULL, 1, 3114.5, 'cbdac5c0-bf2c-40dc-aeee-a797f0cac9de'),
(38, 2, '2016-04-19 02:26:49', NULL, 1, 500, '260591e2-2dc5-47f6-a6cf-33b7f3bb1ae6'),
(39, 2, '2016-04-19 02:41:19', NULL, 1, 2000, '56edcde7-aa98-4157-a2c6-6bee5b4fdb32');

-- --------------------------------------------------------

--
-- Table structure for table `games_meta`
--

CREATE TABLE `games_meta` (
  `meta_id` int(11) NOT NULL,
  `game_id` int(11) NOT NULL,
  `metaKey` varchar(255) NOT NULL,
  `metaValue` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(24) NOT NULL,
  `user_hash_pass` varchar(255) NOT NULL,
  `user_balance` double NOT NULL DEFAULT '1000',
  `user_active` tinyint(1) NOT NULL,
  `user_failed_log_attempts` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_name`, `user_hash_pass`, `user_balance`, `user_active`, `user_failed_log_attempts`) VALUES
(1, 'aaaaa', 'BCEE99FD0D5DB4F062DADDFCB8F70DBDA73ADAAE', 1000, 1, 0),
(2, 'kepoly', 'D6516E030065EA89A8DB4C1724E9DF7988343181', 1200, 1, 0),
(4, 'undefined', 'AB4AED170068B6DE977B3D443D0D3434A0988DFD', 10, 1, 0),
(5, 'undefined', 'AB4AED170068B6DE977B3D443D0D3434A0988DFD', 10, 1, 0),
(6, 'undefined', 'AB4AED170068B6DE977B3D443D0D3434A0988DFD', 10, 1, 0),
(7, 'undefined', 'AB4AED170068B6DE977B3D443D0D3434A0988DFD', 10, 1, 0),
(10, 'kep1122', 'D6516E030065EA89A8DB4C1724E9DF7988343181', 1000, 1, 0),
(13, 'brynku', '6F855ED435B305F6DABD9E4758B08C09008ADDDC', 1000, 1, 0),
(14, 'abcdef', '5197637063E74A2EE108D08D6F33AC4797F34CD7', 999, 1, 0),
(15, 'spadoonk', 'D6516E030065EA89A8DB4C1724E9DF7988343181', 1000, 1, 0),
(16, 'spadoonk', 'D6516E030065EA89A8DB4C1724E9DF7988343181', 1000, 1, 0),
(17, 'bxtoma', 'D6516E030065EA89A8DB4C1724E9DF7988343181', 1000, 1, 0),
(18, 'bxtoma', 'D6516E030065EA89A8DB4C1724E9DF7988343181', 1000, 1, 0),
(19, 'asdfasdf', 'BC359EB326C3D986C82A3BCBBD180B8BDF4431BC', 1000, 1, 0),
(20, 'asdfasdf', 'BC359EB326C3D986C82A3BCBBD180B8BDF4431BC', 1000, 1, 0),
(21, 'aaaaas', '864842065FDC4BD7CC21A7B1C7B6D68B55592754', 1396, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `users_meta`
--

CREATE TABLE `users_meta` (
  `meta_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `total_bet` double NOT NULL DEFAULT '0',
  `total_won` double NOT NULL DEFAULT '0',
  `total_hands` int(11) NOT NULL DEFAULT '0',
  `hands_won` int(11) NOT NULL DEFAULT '0',
  `blackjacks` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users_meta`
--

INSERT INTO `users_meta` (`meta_id`, `user_id`, `total_bet`, `total_won`, `total_hands`, `hands_won`, `blackjacks`) VALUES
(2, 2, 40227.5, 31999, 76, 29, 1),
(3, 21, 1307, 0, 7, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `games`
--
ALTER TABLE `games`
  ADD PRIMARY KEY (`game_id`),
  ADD KEY `fk_user_table_id_for_game_idx` (`user_id`);

--
-- Indexes for table `games_meta`
--
ALTER TABLE `games_meta`
  ADD PRIMARY KEY (`meta_id`),
  ADD KEY `fk_game_table_id_idx` (`game_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `users_meta`
--
ALTER TABLE `users_meta`
  ADD PRIMARY KEY (`meta_id`),
  ADD KEY `fk_user_table_id_idx` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `games`
--
ALTER TABLE `games`
  MODIFY `game_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
--
-- AUTO_INCREMENT for table `games_meta`
--
ALTER TABLE `games_meta`
  MODIFY `meta_id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `users_meta`
--
ALTER TABLE `users_meta`
  MODIFY `meta_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `games_meta`
--

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
