CREATE DATABASE meuble;
\c meuble

CREATE TABLE categorie (
    idCategorie SERIAL PRIMARY KEY,
    categorie VARCHAR(155)
);

CREATE TABLE modele (
    idModele SERIAL PRIMARY KEY,
    idCategorie INT REFERENCES categorie(idCategorie),
    modelecol1 VARCHAR(155) DEFAULT 'longueur',
    modelecol2 VARCHAR(155) DEFAULT 'largeur',
    modelecol3 VARCHAR(155), -- HAUTEUR// NB PLACE (Canapé)
    modelecol4 VARCHAR(155) DEFAULT 'temps Fabrication'
);

CREATE TABLE sousCategorie (
    idSousCategorie SERIAL PRIMARY KEY,
    idCategorie INT REFERENCES categorie(idCategorie),
    longueur DOUBLE PRECISION DEFAULT 15,
    largeur DOUBLE PRECISION DEFAULT 15,
    plus DOUBLE PRECISION DEFAULT 15, 
    tempsFabrication TIME
);

CREATE TABLE style (
    idStyle SERIAL PRIMARY KEY,
    style VARCHAR(155) DEFAULT 'defaut',
    tempsFabrication TIME DEFAULT CURRENT_TIME
);

CREATE TABLE meuble (
    idMeuble SERIAL PRIMARY KEY,
    idSousCategorie INT REFERENCES sousCategorie(idSousCategorie),
    idStyle INT REFERENCES style(idStyle)
);

CREATE TABLE materiel (
    idMateriel SERIAL PRIMARY KEY,
    materiel VARCHAR(155),
    unite VARCHAR(155)
);

CREATE TABLE styleMateriel (
    idStyleMateriel SERIAL PRIMARY KEY,
    idStyle INT REFERENCES style(idStyle),
    idMateriel INT REFERENCES materiel(idMateriel)
);

CREATE TABLE confectionMeuble (
    idConfectionMeuble SERIAL PRIMARY KEY,
    idMeuble INT REFERENCES meuble(idMeuble),
    idMateriel INT REFERENCES materiel(idMateriel),
    quantiteUtilisee DOUBLE PRECISION DEFAULT 0
);

CREATE TABLE miseEnVente (
    idMiseEnVente SERIAL PRIMARY KEY,
    idMeuble INT REFERENCES meuble(idMeuble),
    quantiteVente DOUBLE PRECISION DEFAULT 0,
    dateVente DATE DEFAULT CURRENT_DATE
);

CREATE TABLE meubleConfectionne (
    idMeubleConfectionne SERIAL PRIMARY KEY,
    idMeuble INT REFERENCES meuble(idMeuble),
    quantite DOUBLE PRECISION DEFAULT 0,
    quantiteMvt DOUBLE PRECISION DEFAULT 0,
    prixUnitaire DOUBLE PRECISION DEFAULT 0,
    dateConfection DATE DEFAULT CURRENT_DATE
);