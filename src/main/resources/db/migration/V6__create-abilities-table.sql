CREATE TABLE IF NOT EXISTS abilities (
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        ability_category_id BIGINT,
        ability_group_id BIGINT,
        FOREIGN KEY (ability_category_id) REFERENCES ability_categories(id),
        FOREIGN KEY (ability_group_id) REFERENCES ability_groups(id),
        INDEX idx_ability_name_id (ability_category_id),
        INDEX idx_ability_group_id (ability_group_id)
 )
ENGINE = InnoDB;