CREATE TABLE IF NOT EXISTS profile_permission_groups (
    profile_id BIGINT,
    group_id BIGINT,
    CONSTRAINT fk_ppg_profile_id
    FOREIGN KEY (profile_id) REFERENCES profiles(id),
    CONSTRAINT fk_ppg_group_id
    FOREIGN KEY (group_id) REFERENCES permission_groups(id),
    PRIMARY KEY (profile_id, group_id),
    INDEX fk_profile_permission_groups_id_idx (group_id ASC, profile_id ASC) VISIBLE
)
ENGINE = InnoDB;