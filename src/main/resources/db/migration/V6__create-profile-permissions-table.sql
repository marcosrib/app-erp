CREATE TABLE IF NOT EXISTS profile_permissions (
    profile_id BIGINT,
    permission_id BIGINT,
    CONSTRAINT fk_ppg_profile_id
    FOREIGN KEY (profile_id) REFERENCES profiles(id),
    CONSTRAINT fk_p_permission_id
    FOREIGN KEY (permission_id) REFERENCES permissions(id),
    PRIMARY KEY (profile_id, permission_id),
    INDEX fk_profile_permission_id_idx (permission_id ASC, profile_id ASC) VISIBLE
)
ENGINE = InnoDB;