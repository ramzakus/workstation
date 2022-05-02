DROP TABLE IF EXISTS users;
 
CREATE TABLE users (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL,
  birth_day DATE NOT NULL,
  country_of_residence VARCHAR(250) NOT NULL,
  phone_number VARCHAR(250) NULL,
  gender VARCHAR(50) NULL
);
 
INSERT INTO users (user_name, birth_day, country_of_residence, phone_number, gender) VALUES
  ('ATUS43425', '1990-12-11', 'France', '0656456787','M'),
  ('ATUS45655', '1992-11-12', 'Italie', '+34734456789','F');
INSERT INTO users (user_name, birth_day, country_of_residence) VALUES
  ('ATUS45634', '1993-12-11', 'Inde'),
  ('ATUS45634', '1989-11-12', 'Chine');