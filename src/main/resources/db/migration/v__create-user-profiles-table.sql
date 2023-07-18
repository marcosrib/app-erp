CREATE TABLE IF NOT EXISTS `user_profiles` (
  `user_id` BIGINT NULL,
  `profile_id` BIGINT NULL,
  INDEX `fk_user_id_profile_id_idx` (`user_id` ASC, `profile_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_profile_id`
    FOREIGN KEY (`profile_id`)
    REFERENCES `profiles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
ENGINE = InnoDB;
