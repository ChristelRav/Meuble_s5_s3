-- CATEGORIE
INSERT INTO categorie (categorie) VALUES 
('Canape'),
('Chaises'),
('Lits '),
('Tables '),
('Armoires & dressing');

-- MODELE
INSERT INTO modele (idCategorie,modelecol1,modelecol2, modelecol3) VALUES 
(1,'largeur','longueur','nombre de place','temps de Fabrication'),
(2,'longueur','largeur','hauteur','temps de Fabrication'),
(3,'longueur','largeur','hauteur','temps de Fabrication'),
(4,'longueur','largeur','hauteur','temps de Fabrication'),
(5,'longueur','largeur','hauteur','temps de Fabrication');

-- SOUS-CATEGORIE
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

-- STYLE
INSERT INTO style (style, tempsFabrication) VALUES
 ('Moderne', '12:30:00'),
 ('Royal','14:45:00');

-- MATERIEL
INSERT INTO materiel (materiel, unite) VALUES 
('Bois', 'Metre cube'),
('Metal', 'Kilogramme'),
('Verre', 'Metre carre'),
('Cuir', 'Mètre carre'),
('Plastique', 'Kilogramme'),
('Tissu', 'Metre');

-- STYLEMATERIEL
INSERT INTO styleMateriel (idStyle, idMateriel,quantiteEnplus) VALUES
(1, 6, 2),  -- Moderne + Bois
(1, 2 , 2),  -- Moderne + Métal
(2, 3, 2),  -- Moderne + Verre
(2, 4,4),  -- Royal + Cuir
(1, 5, 3),  -- Royal + Plastique
(2, 6,2);  -- Royal + Tissu









