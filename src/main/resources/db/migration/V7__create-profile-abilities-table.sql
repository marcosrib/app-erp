CREATE TABLE IF NOT EXISTS profile_abilities(
    profile_id BIGINT,
    ability_id BIGINT,
    CONSTRAINT fk_pa_profile_id
    FOREIGN KEY (profile_id) REFERENCES profiles(id),
    CONSTRAINT fk_pa_ability_id
    FOREIGN KEY (ability_id) REFERENCES abilities(id),
    PRIMARY KEY (profile_id, ability_id),
    INDEX fk_profile_abilities_id_idx (ability_id ASC, profile_id ASC) VISIBLE
)
ENGINE = InnoDB;