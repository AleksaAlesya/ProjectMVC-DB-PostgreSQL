DROP  TABLE Person;
--удалить все данные из таблицы
TRUNCATE TABLE Person;

--Добавить столбец в таблицу
ALTER TABLE person ADD  COLUMN address varchar(50) NOT NULL ;

CREATE TABLE person(
    id int GENERATED BY DEFAULT AS IDENTITY  PRIMARY KEY ,
    name varchar(30) NOT NULL ,
    age int check ( age < 100 and age >= 0),
    email varchar(30) UNIQUE,
    address varchar(50) NOT NULL
);

INSERT INTO person(name, age, email,address) VALUES ('Aleksa',40,'aleksa@email.ru', 'Belarus, Gomel, 246005');
INSERT INTO person(name, age, email,address) VALUES ('Edvard',44, 'edvard@email.ru', 'Belarus, Gomel, 246005');
INSERT INTO person(name, age, email, address) VALUES ( 'Evgeny', 33, 'evgeny@email.ru', 'Belarus, Gomel, 246005');
INSERT INTO person(name, age, email, address) VALUES ( 'Egor', 33, 'egor@email.ru', 'Belarus, Gomel, 246005');


SELECT *FROM person;

SELECT name, email FROM person WHERE id=1;