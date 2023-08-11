CREATE TABLE IF NOT EXISTS permissions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    permission_name VARCHAR(100) NOT NULL,
    created_at DATETIME NULL,
    updated_at DATETIME NULL
)
ENGINE = InnoDB;