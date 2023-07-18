CREATE TABLE IF NOT EXISTS `users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL,
  `email` VARCHAR(50) NULL,
  `password` VARCHAR(255) NULL,
   `status` TINYINT NULL DEFAULT 0,
  `created_at` DATETIME NULL,
  `updated_at` DATETIME NULL,
  `deleted_at` DATETIME NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `idx_email_unique` (`email` ASC) VISIBLE)
ENGINE = InnoDB

