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

CREATE TABLE IF NOT EXISTS suppliers(
  id SERIAL PRIMARY KEY,
  fantasy_name VARCHAR(150),
  company_name VARCHAR(255),
  email VARCHAR(50) UNIQUE,
  cell_phone_number VARCHAR(9),
  phone_number VARCHAR(9),
  cpf_cnpj VARCHAR(14),
  type_of_person VARCHAR(2),
  type_supplier varchar(20),
  address_id BIGINT,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  delete_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS cost_centers (
  id SERIAL PRIMARY KEY,
  name varchar(150),
  created_at TIMESTAMP,
  updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS bills_to_pays (
  id BIGSERIAL PRIMARY KEY,
  value DECIMAL(10,2),
  status varchar(20),
  supplier_id  INTEGER,
  cost_center_id INTEGER,
  payment_date TIMESTAMP,
  due_date TIMESTAMP,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  CONSTRAINT fk_bills_to_pay_supplier_id
    FOREIGN KEY (supplier_id)
    REFERENCES suppliers(id),
  CONSTRAINT fk_bills_to_pay_cost_center_id
    FOREIGN KEY (cost_center_id)
    REFERENCES cost_centers(id)
);

CREATE TABLE IF NOT EXISTS  service_order(
  id BIGSERIAL PRIMARY KEY,
  value DECIMAL(10,2),
  status varchar(20),
  due_date TIMESTAMP,
  supplier_id  INTEGER,
  cost_center_id INTEGER,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  CONSTRAINT fk_service_order_supplier_id
    FOREIGN KEY (supplier_id)
    REFERENCES suppliers(id),
  CONSTRAINT fk_service_order_cost_center_id
    FOREIGN KEY (cost_center_id)
    REFERENCES cost_centers(id)
);