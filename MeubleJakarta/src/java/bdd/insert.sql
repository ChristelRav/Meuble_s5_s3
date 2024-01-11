 INSERT INTO categorie (categorie) VALUES 
('Canape'),
('Chaises'),
('Lits '),
('Tables '),
('Armoires & dressing');


INSERT INTO modele (idCategorie,modelecol1,modelecol2, modelecol3,modelecol4) VALUES 
(1,'largeur','longueur','nombre de place','temps de Fabrication'),
(2,'longueur','largeur','hauteur','temps de Fabrication'),
(3,'longueur','largeur','hauteur','temps de Fabrication'),
(4,'longueur','largeur','hauteur','temps de Fabrication'),
(5,'longueur','largeur','hauteur','temps de Fabrication');

-- Pour la sous-catégorie de chaise
INSERT INTO sousCategorie (idCategorie,sousCategorie,longueur,largeur, plus ,tempsFabrication) VALUES
(1,'canape convertible',200,80,5, '12:30:00'),
(1,'canape modulable',200,80,5, '12:30:00'),
(1,'canape meridienne',100,50,2, '09:30:00'),
(1,'canape meridienne',300,100,5, '15:30:00'),
(1,'pouf // repose pieds ',50,50,1, '08:00:00'),

(2,'chaise de gaming',150,80,50, '10:30:00'),
(2,'tabouret',80,50,40, '08:30:00'),
(2,'chaise de bureau',100,90,50, '12:00:00'),
(2,'chaise meridienne',170,120,50, '15:00:00'),

(3,'lit double',150,80,50, '12:30:00'),
(3,'lit simple',80,50,40, '12:30:00'),
(3,'lit rembourre',200,160,140, '09:30:00'),
(3,'lit superposee',200,90,100, '15:30:00'),

(3,'lit double',150,80,50, '12:30:00'),
(3,'lit simple',80,50,40, '12:30:00'),
(3,'lit rembourre',200,160,140, '09:30:00'),
(3,'lit superposee',200,90,100, '15:30:00');

-- Pour la catégorie 'Tables' (idCategorie = 4)
INSERT INTO sousCategorie (idCategorie, sousCategorie, longueur, largeur, plus, tempsFabrication)
VALUES
(4, 'table basse', 120, 60, 3, '10:00:00'),
(4, 'table à manger', 180, 90, 5, '14:00:00'),
(4, 'table d\''appoint', 60, 60, 2, '08:30:00');


-- STYLE
INSERT INTO style (style, tempsFabrication) VALUES
 ('Moderne', '12:30:00'),
 ('Royal','14:45:00');

-- MATERIEL
INSERT INTO materiel (materiel, unite,pu) VALUES 
('Bois', 'Metre cube',5000),
('Metal', 'Kilogramme',10000),
('Verre', 'Metre carre',10000),
('Cuir', 'Mètre carre',5000),
('Plastique', 'Kilogramme',3000),
('Tissu', 'Metre',3000);

-- STYLEMATERIEL
INSERT INTO styleMateriel (idStyle, idMateriel,quantiteEnplus) VALUES
(1, 6, 2),  -- Moderne + Bois
(1, 2 , 2),  -- Moderne + Métal
(2, 3, 2),  -- Moderne + Verre
(2, 4,4),  -- Royal + Cuir
(1, 5, 3),  -- Royal + Plastique
(2, 6,2);  -- Royal + Tissu

-- Insertion dans la table 'meuble'
INSERT INTO meuble (idSousCategorie, idStyle, meuble) VALUES
(1, 1, 'Canapé Convertible Moderne'),
(2, 1, 'Chaise de Gaming Moderne'),
(3, 2, 'Cnape de bureau');

-- Insertion dans la table 'confectionMeuble'
INSERT INTO confectionMeuble (idMeuble, idMateriel, quantiteUtilisee) VALUES
(1, 1, 3.5),  -- Canapé Convertible Moderne utilise 3.5 unités de Bois
(1, 3, 2.0),  -- Canapé Convertible Moderne utilise 2.0 unités de Verre
(1, 4, 3.5),  -- Canapé Convertible Moderne utilise 3.5 unités de Bois
(1, 5, 2.0),  -- Canapé Convertible Moderne utilise 2.0 unités de Verre
(2, 1, 3.5),  -- Canapé Convertible Moderne utilise 3.5 unités de Bois
(2, 3, 2.0),  -- Canapé Convertible Moderne utilise 2.0 unités de Verre
(2, 2, 1.5),  -- Chaise de Gaming Moderne utilise 1.5 unités de Métal
(2, 4, 2.0),  -- Chaise de Gaming Moderne utilise 2.0 unités de Cuir
(3, 1, 3.0);  -- Lit Double Royal utilise 3.0 unités de Palissandre















