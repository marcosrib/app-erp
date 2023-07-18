CREATE TABLE IF NOT EXISTS `profiles` (
  `id` BIGINT NOT NULL,
  `name` VARCHAR(45) NULL,
  `created_at` DATETIME NULL,
  `update_at` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB