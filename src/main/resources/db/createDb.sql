CREATE TABLE `temp_logs` (
  `idtemp_logs` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `zone_id` int(11) NOT NULL,
  `zone_desc` varchar(45) NOT NULL,
  `event_date` datetime NOT NULL,
  `temp_goal` decimal(4,2) NOT NULL,
  `heating_active` tinyint(4) NOT NULL,
  `heating_percentage` decimal(4,2) NOT NULL,
  `temperature` decimal(4,2) NOT NULL,
  `umidity` decimal(4,2) NOT NULL,
  `ext_temperature` decimal(4,2) NOT NULL,
  `ext_solar_intensity` decimal(4,2) NOT NULL,
  PRIMARY KEY (`idtemp_logs`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='\n-- temperature\n-- umidity\n-- ext-temperature\n-- ext-umidity';
