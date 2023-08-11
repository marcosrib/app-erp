CREATE TABLE IF NOT EXISTS permissions (
  id BIGINT NOT NULL,
  code VARCHAR(100) NULL,
  name VARCHAR(100) NULL,
  permission_group_id BIGINT NULL,
  created_at DATETIME NULL,
  updated_at DATETIME NULL,
  PRIMARY KEY (id),
  INDEX fk_permission_groups_id_idx (permission_group_id ASC) VISIBLE,
  UNIQUE INDEX p_code_idx (code ASC) VISIBLE,
  CONSTRAINT fk_permission_groups_id
    FOREIGN KEY (permission_group_id)
    REFERENCES permission_groups(id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB