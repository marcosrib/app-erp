CREATE TABLE IF NOT EXISTS permission_group_permissions (
    group_id BIGINT,
    permission_id BIGINT,
    CONSTRAINT fk_group_id
    FOREIGN KEY (group_id) REFERENCES permission_groups(id),
    CONSTRAINT fk_permission_id
    FOREIGN KEY (permission_id) REFERENCES permissions(id),
    PRIMARY KEY (group_id, permission_id),
    INDEX `fk_permission_group_permission_id_idx` (`group_id` ASC, `permission_id` ASC) VISIBLE
)
ENGINE = InnoDB;