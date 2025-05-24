-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2025 at 11:30 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `assessment_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `covid_cases`
--

CREATE TABLE `covid_cases` (
  `id` bigint(20) NOT NULL,
  `report_date` date NOT NULL,
  `county` varchar(255) DEFAULT NULL,
  `confirmed_cases` int(11) NOT NULL,
  `hospitalized_cases` int(11) DEFAULT NULL,
  `deaths` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `covid_cases`
--

INSERT INTO `covid_cases` (`id`, `report_date`, `county`, `confirmed_cases`, `hospitalized_cases`, `deaths`) VALUES
(1, '2023-01-01', 'Dublin', 1250, 45, 12),
(2, '2023-01-01', 'Cork', 780, 32, 8),
(3, '2023-01-01', 'Galway', 420, 15, 3),
(4, '2023-01-02', 'Dublin', 1310, 48, 14),
(5, '2023-01-02', 'Cork', 810, 34, 9),
(6, '2023-01-02', 'Galway', 435, 16, 3),
(7, '2023-01-03', 'Dublin', 1385, 50, 16),
(8, '2023-01-03', 'Cork', 845, 36, 10),
(9, '2023-01-03', 'Galway', 455, 18, 4),
(11, '2023-01-01', 'Dublin', 1250, 45, 12),
(12, '2023-01-01', 'Cork', 780, 32, 8),
(13, '2023-01-01', 'Galway', 420, 15, 3),
(14, '2023-01-01', 'Limerick', 380, 12, 2),
(15, '2023-01-01', 'Waterford', 290, 8, 1),
(16, '2023-01-01', 'Kildare', 410, 14, 4),
(17, '2023-01-01', 'Meath', 360, 11, 3),
(18, '2023-01-01', 'Tipperary', 320, 10, 2),
(19, '2023-01-01', 'Donegal', 280, 9, 2),
(20, '2023-01-02', 'Dublin', 1310, 48, 14),
(21, '2023-01-02', 'Cork', 810, 34, 9),
(22, '2023-01-02', 'Galway', 435, 16, 3),
(23, '2023-01-02', 'Limerick', 395, 13, 2),
(24, '2023-01-02', 'Waterford', 305, 9, 1),
(25, '2023-01-02', 'Kildare', 425, 15, 4),
(26, '2023-01-02', 'Meath', 375, 12, 3),
(27, '2023-01-02', 'Tipperary', 335, 11, 2),
(28, '2023-01-02', 'Donegal', 295, 10, 2),
(29, '2023-01-03', 'Dublin', 1385, 50, 16),
(30, '2023-01-03', 'Cork', 845, 36, 10),
(31, '2023-01-03', 'Galway', 455, 18, 4),
(32, '2023-01-03', 'Limerick', 410, 14, 3),
(33, '2023-01-03', 'Waterford', 320, 10, 1),
(34, '2023-01-03', 'Kildare', 440, 16, 5),
(35, '2023-01-03', 'Meath', 390, 13, 3),
(36, '2023-01-03', 'Tipperary', 350, 12, 2),
(37, '2023-01-03', 'Donegal', 310, 11, 2),
(38, '2024-01-01', 'Dublin', 850, 32, 8),
(39, '2024-01-01', 'Cork', 520, 22, 5),
(40, '2024-01-01', 'Galway', 280, 10, 2),
(41, '2024-01-01', 'Limerick', 250, 8, 1),
(42, '2024-01-01', 'Waterford', 190, 5, 0),
(43, '2024-01-01', 'Kildare', 270, 9, 2),
(44, '2024-01-01', 'Meath', 240, 7, 1),
(45, '2024-01-01', 'Tipperary', 210, 6, 1),
(46, '2024-01-01', 'Donegal', 180, 5, 1),
(47, '2024-01-02', 'Dublin', 880, 33, 9),
(48, '2024-01-02', 'Cork', 540, 23, 6),
(49, '2024-01-02', 'Galway', 290, 11, 2),
(50, '2024-01-02', 'Limerick', 260, 9, 1),
(51, '2024-01-02', 'Waterford', 200, 6, 0),
(52, '2024-01-02', 'Kildare', 280, 10, 2),
(53, '2024-01-02', 'Meath', 250, 8, 1),
(54, '2024-01-02', 'Tipperary', 220, 7, 1),
(55, '2024-01-02', 'Donegal', 190, 6, 1),
(56, '2024-01-03', 'Dublin', 910, 34, 10),
(57, '2024-01-03', 'Cork', 560, 24, 7),
(58, '2024-01-03', 'Galway', 300, 12, 3),
(59, '2024-01-03', 'Limerick', 270, 10, 2),
(60, '2024-01-03', 'Waterford', 210, 7, 1),
(61, '2024-01-03', 'Kildare', 290, 11, 3),
(62, '2024-01-03', 'Meath', 260, 9, 2),
(63, '2024-01-03', 'Tipperary', 230, 8, 1),
(64, '2024-01-03', 'Donegal', 200, 7, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `password`, `username`) VALUES
(1, '$2a$10$dqEi0gymyj.WEj30OifgUuw4eakwc8/DMZM6NiSQ./1DgXps.YCuK', 'CCT1234');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `enabled`) VALUES
(1, 'CCT1234', '$2a$10$45Bvnt9pSnsEfIK./cu/Q.OcM6w5kMiwxpaM99OlvdLp8hs.jF.va', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_seq`
--

CREATE TABLE `user_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_seq`
--

INSERT INTO `user_seq` (`next_val`) VALUES
(51);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `covid_cases`
--
ALTER TABLE `covid_cases`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `covid_cases`
--
ALTER TABLE `covid_cases`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
