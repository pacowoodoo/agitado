CREATE TABLE `agidata`.`temp_logs` (
  `idtemp_logs` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `zone_id` INT NOT NULL,
  `zone_desc` VARCHAR(45) NOT NULL,
  `event_date` DATETIME NOT NULL,
  `temp_logscol` VARCHAR(45) NOT NULL,
  `heating_active` TINYINT NOT NULL,
  `temperature` INT NOT NULL,
  `umidity` INT NOT NULL,
  `ext_temperature` INT NOT NULL,
  `ext_umidity` INT NOT NULL,
  PRIMARY KEY (`idtemp_logs`))
COMMENT = '\n-- temperature\n-- umidity\n-- ext-temperature\n-- ext-umidity';