SELECT m.materiel,m.unite,sm.quantiteEnplus
FROM stylemateriel sm 
JOIN materiel m ON m.idMateriel = sm.idMateriel
JOIN style s ON s.idStyle = sm.idStyle
WHERE s.idStyle =2;


SELECT me.meuble,m.unite,cm.quantiteUtilisee
FROM confectionMeuble cm 
JOIN materiel m ON m.idMateriel = cm.idMateriel
JOIN meuble me ON cm.idMeuble = me.idMeuble
WHERE m.idMateriel=2;


SELECT m.meuble ,cm.quantiteutilisee ,mat.materiel , mat.pu FROM meuble m 
JOIN confectionmeuble cm ON cm.idMeuble = m.idMeuble
JOIN materiel mat ON mat.idMateriel = cm.idMateriel
where m.idMeuble = 1;

SELECT m.meuble ,cm.quantiteutilisee ,mat.materiel ,sc.idcategorie, mat.pu, (cm.quantiteutilisee * mat.pu) as prix FROM meuble m 
JOIN confectionmeuble cm ON cm.idMeuble = m.idMeuble
JOIN materiel mat ON mat.idMateriel = cm.idMateriel
JOIN souscategorie sc ON sc. idsouscategorie = m. idsouscategorie 
where m.idMeuble = 3;

SELECT sum(cm.quantiteutilisee * mat.pu) as prix FROM meuble m 
JOIN confectionmeuble cm ON cm.idMeuble = m.idMeuble
JOIN materiel mat ON mat.idMateriel = cm.idMateriel
where m.idMeuble = 1;



SELECT m.meuble, SUM(cm.quantiteutilisee * mat.pu) as prix
FROM meuble m
JOIN confectionmeuble cm ON cm.idMeuble = m.idMeuble
JOIN materiel mat ON mat.idMateriel = cm.idMateriel
JOIN souscategorie sc ON sc. idsouscategorie = m. idsouscategorie 
where sc.idcategorie =1
GROUP BY m.meuble;

CREATE VIEW get_prix AS (
SELECT m.meuble, SUM(cm.quantiteutilisee * mat.pu) as prix
FROM meuble m
JOIN confectionmeuble cm ON cm.idMeuble = m.idMeuble
JOIN materiel mat ON mat.idMateriel = cm.idMateriel
JOIN souscategorie sc ON sc. idsouscategorie = m. idsouscategorie 
GROUP BY m.meuble); 


-- Drop foreign key constraints
ALTER TABLE confectionMeuble DROP CONSTRAINT confectionmeuble_idmeuble_fkey;
ALTER TABLE confectionMeuble DROP CONSTRAINT confectionmeuble_idmateriel_fkey;
ALTER TABLE miseEnVente DROP CONSTRAINT miseenvente_idmeuble_fkey;
ALTER TABLE meubleConfectionne DROP CONSTRAINT meubleconfectionne_idmeuble_fkey;

-- Drop tables
DROP VIEW get_prix;
DROP TABLE IF EXISTS meubleConfectionne;
DROP TABLE IF EXISTS miseEnVente;
DROP TABLE IF EXISTS confectionMeuble;
DROP TABLE IF EXISTS styleMateriel;
DROP TABLE IF EXISTS materiel;
DROP TABLE IF EXISTS meuble;
DROP TABLE IF EXISTS style;
DROP TABLE IF EXISTS sousCategorie;
DROP TABLE IF EXISTS modele;
DROP TABLE IF EXISTS categorie;

-- Drop sequences
DROP SEQUENCE IF EXISTS meubleconfectionne_idmeubleconfectionne_seq;
DROP SEQUENCE IF EXISTS miseenvente_idmiseenvente_seq;
DROP SEQUENCE IF EXISTS confectionmeuble_idconfectionmeuble_seq;
DROP SEQUENCE IF EXISTS stylemateriel_idstylemateriel_seq;
DROP SEQUENCE IF EXISTS materiel_idmateriel_seq;
DROP SEQUENCE IF EXISTS meuble_idmeuble_seq;
DROP SEQUENCE IF EXISTS style_idstyle_seq;
DROP SEQUENCE IF EXISTS souscategorie_idsouscategorie_seq;
DROP SEQUENCE IF EXISTS modele_idmodele_seq;
DROP SEQUENCE IF EXISTS categorie_idcategorie_seq;
