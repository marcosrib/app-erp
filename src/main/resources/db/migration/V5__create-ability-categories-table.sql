CREATE TABLE IF NOT EXISTS ability_categories (
  id BIGINT NOT NULL,
  code VARCHAR(100) NULL,
  name VARCHAR(100) NULL,
  created_at DATETIME NULL,
  updated_at DATETIME NULL,
  PRIMARY KEY (id)
  )
ENGINE = InnoDB