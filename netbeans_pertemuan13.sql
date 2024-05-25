-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: May 25, 2024 at 01:29 AM
-- Server version: 5.7.39
-- PHP Version: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `netbeans_pertemuan13`
--

-- --------------------------------------------------------

--
-- Table structure for table `tabel_bunga`
--

CREATE TABLE `tabel_bunga` (
  `id` int(11) NOT NULL,
  `bunga` varchar(50) DEFAULT NULL,
  `harga` double DEFAULT NULL,
  `jumlah` double DEFAULT NULL,
  `diskon` double DEFAULT NULL,
  `ongkir` double DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tabel_bunga`
--

INSERT INTO `tabel_bunga` (`id`, `bunga`, `harga`, `jumlah`, `diskon`, `ongkir`, `total`) VALUES
(1, 'Anggrek', 10000, 2, 0, 0, 20000),
(2, 'Anggrek2', 10000, 2, 0, 0, 20000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tabel_bunga`
--
ALTER TABLE `tabel_bunga`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tabel_bunga`
--
ALTER TABLE `tabel_bunga`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
