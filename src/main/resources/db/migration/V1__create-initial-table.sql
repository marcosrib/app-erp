CREATE TABLE IF NOT EXISTS users (
  id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(50) UNIQUE,
  password VARCHAR(255),
  status BOOLEAN DEFAULT false,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  deleted_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS profiles (
   id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
   name VARCHAR(45) NOT NULL,
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
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    code VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NULL,
    updated_at TIMESTAMP NULL
);

CREATE TABLE IF NOT EXISTS ability_categories (
  id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  code VARCHAR(100) NOT NULL,
  name VARCHAR(100) NOT NULL,
  created_at TIMESTAMP NULL,
  updated_at TIMESTAMP NULL
);

CREATE TABLE IF NOT EXISTS abilities (
  id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
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

