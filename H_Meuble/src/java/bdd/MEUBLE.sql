create database meuble;
\c meuble


CREATE TABLE categorie (
    idCategorie SERIAL PRIMARY KEY,
    categorie VARCHAR(155)
);
CREATE TABLE style (
    idStyle SERIAL PRIMARY KEY,
    style VARCHAR(155)
);

CREATE table meuble (
    idMeuble SERIAL PRIMARY KEY,
    idCategorie INT REFERENCES categorie(idCategorie),
    idStyle INT REFERENCES style(idStyle),
    meuble VARCHAR(155),
    taille INT,
    prix DOUBLE PRECISION,
    tps_fabrication TIME
);

CREATE TABLE matiere (
    idMatiere SERIAL PRIMARY KEY,
    matiere VARCHAR(255)
);

CREATE TABLE matiereMeuble (
    idMatiereMeuble SERIAL PRIMARY KEY,
    idMatiere INT REFERENCES matiere(idMatiere),
    idStyle INT REFERENCES style(idStyle),
    quantite DOUBLE PRECISION,
    dateMiseJour DATE
);