CREATE TABLE IF NOT EXISTS users (
  id BIGSERIAL PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(50) UNIQUE,
  password VARCHAR(255),
  status BOOLEAN DEFAULT false,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  deleted_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS profiles (
   id BIGSERIAL PRIMARY KEY,
   name VARCHAR(45) NOT NULL,
   description VARCHAR(500),
   created_at TIMESTAMP NULL,
   updated_at TIMESTAMP NULL
 );

CREATE TABLE IF NOT EXISTS user_profiles (
  user_id BIGINT,
  profile_id BIGINT,
  CONSTRAINT fk_user_id
    FOREIGN KEY (user_id)
    REFERENCES users (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_profile_id
    FOREIGN KEY (profile_id)
    REFERENCES profiles (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE INDEX fk_user_id_profile_id_idx ON user_profiles (user_id, profile_id);

CREATE TABLE IF NOT EXISTS ability_groups (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    code VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NULL,
    updated_at TIMESTAMP NULL
);

CREATE TABLE IF NOT EXISTS ability_categories (
  id BIGSERIAL PRIMARY KEY,
  code VARCHAR(100) NOT NULL,
  name VARCHAR(100) NOT NULL,
  created_at TIMESTAMP NULL,
  updated_at TIMESTAMP NULL
);

CREATE TABLE IF NOT EXISTS abilities (
  id BIGSERIAL PRIMARY KEY,
  ability_category_id BIGINT,
  ability_group_id BIGINT,
  CONSTRAINT fk_ability_category_id
    FOREIGN KEY (ability_category_id)
    REFERENCES ability_categories(id),
  CONSTRAINT fk_ability_group_id
    FOREIGN KEY (ability_group_id)
    REFERENCES ability_groups(id)
);

CREATE INDEX idx_ability_categories_id ON abilities (ability_category_id);
CREATE INDEX idx_ability_group_id ON abilities (ability_group_id);

CREATE TABLE IF NOT EXISTS profile_abilities (
  profile_id BIGINT,
  ability_id BIGINT,
  CONSTRAINT fk_pa_profile_id
    FOREIGN KEY (profile_id)
    REFERENCES profiles(id),
  CONSTRAINT fk_pa_ability_id
    FOREIGN KEY (ability_id)
    REFERENCES abilities(id),
  PRIMARY KEY (profile_id, ability_id)
);

CREATE INDEX fk_profile_abilities_id_idx ON profile_abilities (ability_id, profile_id);

CREATE TABLE IF NOT EXISTS states (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200),
  code VARCHAR(2),
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS addresses (
  id BIGSERIAL PRIMARY KEY,
  address VARCHAR(200),
  number VARCHAR(10),
  cep VARCHAR(10),
  complement VARCHAR(50),
  city VARCHAR(150),
  state_id INTEGER,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  CONSTRAINT fk_state_id
    FOREIGN KEY (state_id)
    REFERENCES states(id)
);
CREATE TABLE supplier_categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    delete_at TIMESTAMP
);
CREATE TABLE IF NOT EXISTS suppliers(
  id BIGSERIAL PRIMARY KEY,
  fantasy_name VARCHAR(150),
  company_name VARCHAR(255),
  email VARCHAR(50) UNIQUE,
  cell_phone_number VARCHAR(9),
  phone_number VARCHAR(9),
  cpf_cnpj VARCHAR(14),
  type VARCHAR(2),
  supplier_category_id INTEGER NOT NULL,
  address_id BIGINT,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  delete_at TIMESTAMP,
  CONSTRAINT fk_supplier_categories_id
     FOREIGN KEY (supplier_category_id)
     REFERENCES supplier_categories(id)
);