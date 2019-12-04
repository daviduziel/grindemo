

CREATE TABLE `scooters` (
  `id_scooter` varchar(4) NOT NULL,
  `user` varchar(255) NOT NULL,
  `scooter_state` smallint(6) NOT NULL,
  PRIMARY KEY (`id_scooter`),
  KEY `SCOOTERS_FK` (`scooter_state`),
  CONSTRAINT `SCOOTERS_FK` FOREIGN KEY (`scooter_state`) REFERENCES `scooters_states` (`id_state`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `users` (
  `id_user` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_email` varchar(255) NOT NULL,
  `status` varchar(100) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `scooters_states` (
  `id_state` smallint(6) NOT NULL AUTO_INCREMENT,
  `desc_state` varchar(255) NOT NULL,
  PRIMARY KEY (`id_state`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO grindemo.scooters_states (desc_state) VALUES 
('CREATED')
,('MAINTENANCE')
,('DISTRIBUTING')
,('ON_STREET')
;