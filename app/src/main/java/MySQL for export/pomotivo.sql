-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 10-Mar-2023 às 22:39
-- Versão do servidor: 10.4.20-MariaDB
-- versão do PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `pomotivo`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `schedules`
--

CREATE TABLE `schedules` (
  `id` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL,
  `timeWorking` int(11) NOT NULL,
  `shortBreak` int(11) NOT NULL,
  `bigBreak` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `schedules`
--

INSERT INTO `schedules` (`id`, `idUser`, `name`, `description`, `createdAt`, `updatedAt`, `timeWorking`, `shortBreak`, `bigBreak`) VALUES
(2, 1, 'Cronograma', 'Não utiliza tempo padrão', '2023-03-10 00:00:00', '2023-03-07 00:00:00', 30, 10, 30),
(3, 1, 'Cronograma 2', 'Utiliza tempo padrão', '2023-03-10 00:00:00', '2023-03-08 00:00:00', 25, 5, 25);

-- --------------------------------------------------------

--
-- Estrutura da tabela `scheduletasks`
--

CREATE TABLE `scheduletasks` (
  `id` int(11) NOT NULL,
  `idUser` int(11) DEFAULT NULL,
  `idSchedule` int(11) DEFAULT NULL,
  `idTask` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `scheduletasks`
--

INSERT INTO `scheduletasks` (`id`, `idUser`, `idSchedule`, `idTask`) VALUES
(1, 1, 2, 1),
(10, 1, 2, 5),
(11, 1, 3, 1),
(12, 1, 3, 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tasks`
--

CREATE TABLE `tasks` (
  `id` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `completed` tinyint(1) NOT NULL,
  `notes` varchar(255) DEFAULT NULL,
  `deadline` date DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tasks`
--

INSERT INTO `tasks` (`id`, `idUser`, `name`, `description`, `completed`, `notes`, `deadline`, `createdAt`, `updatedAt`) VALUES
(1, 1, 'Tarefa com prazo', 'Descrição', 0, 'Nota', '2023-03-24', '2023-03-10 00:00:00', '2023-03-06 00:00:00'),
(5, 1, 'Tarefa sem prazo', '', 0, '', NULL, '2023-03-10 00:00:00', '2023-03-10 00:00:00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `users`
--

INSERT INTO `users` (`id`, `name`, `password`) VALUES
(1, 'primeiro', 'senha1'),
(2, 'segundo', 'senha2');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `schedules`
--
ALTER TABLE `schedules`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_users` (`idUser`);

--
-- Índices para tabela `scheduletasks`
--
ALTER TABLE `scheduletasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_users` (`idUser`) USING BTREE,
  ADD KEY `fk_schedules` (`idSchedule`),
  ADD KEY `fk_tasks` (`idTask`);

--
-- Índices para tabela `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_users` (`idUser`) USING BTREE;

--
-- Índices para tabela `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `schedules`
--
ALTER TABLE `schedules`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `scheduletasks`
--
ALTER TABLE `scheduletasks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `tasks`
--
ALTER TABLE `tasks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `schedules`
--
ALTER TABLE `schedules`
  ADD CONSTRAINT `fk_users` FOREIGN KEY (`idUser`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limitadores para a tabela `scheduletasks`
--
ALTER TABLE `scheduletasks`
  ADD CONSTRAINT `fk_schedules` FOREIGN KEY (`idSchedule`) REFERENCES `schedules` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_tasks` FOREIGN KEY (`idTask`) REFERENCES `tasks` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`idUser`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
