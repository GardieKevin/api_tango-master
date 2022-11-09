DROP TABLE IF EXISTS lessons;
DROP TABLE IF EXISTS dancers;
DROP TABLE IF EXISTS dancer_lesson_associations;

CREATE TABLE lessons (
                           id INT AUTO_INCREMENT  PRIMARY KEY,
                           lesson_name VARCHAR(25) NOT NULL,
                           description VARCHAR(250) NOT NULL,
                           lesson_date DATE NOT NULL,
                           lesson_time VARCHAR(10) NOT NULL,
                           dance_level VARCHAR(20) NOT NULL,
                           price INT NOT NULL
);

INSERT INTO lessons (lesson_name, description, lesson_date, lesson_time, dance_level, price) VALUES

                                            ('Cours 1', 'pour bien débuter', '2022-10-22', '14:00', 'Débutant', 18),
                                            ('Cours 2', 'pour bien continuer', '2022-10-22', '15:15', 'Intermédiaire', 18),
                                            ('Cours 3', 'pour bien approfondir', '2022-10-21', '19:45', 'Avancé', 20);

CREATE TABLE dancers (
                         id INT AUTO_INCREMENT  PRIMARY KEY,
                         firstname VARCHAR(50) NOT NULL,
                         lastname VARCHAR(50) NOT NULL,
                         dance_level VARCHAR(20) NOT NULL,
                         telephone VARCHAR(10) NOT NULL,
                         email VARCHAR(255) NOT NULL,
                         gender VARCHAR(5) NOT NULL
);

INSERT INTO dancers (firstname, lastname, dance_level, telephone, email, gender) VALUES

                                             ('Maëlenn', 'Dagorne', 'Avancé', '0123456789', 'maëlenn.dagorne@gmail.com', 'Femme'),
                                             ('Pierre', 'Alluchon', 'Avancé', '0987654321', 'pierre.alluchon@yahoo.fr', 'Homme'),
                                             ('Céline', 'Vauléon', 'Débutant', '1325476970', 'céline.vauléon@gmail.com', 'Femme'),
                                             ('Ekaterina', 'Kaykieva', 'Intermédiaire', '0896745231', 'ekaterine.kaykieva@sfr.com', 'Femme');