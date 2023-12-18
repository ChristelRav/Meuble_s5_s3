 INSERT INTO categorie (categorie) VALUES 
('Canape'),
('Chaises'),
('Lits '),
('Tables '),
('Armoires & dressing');


INSERT INTO modele (idCategorie,modelecol1,modelecol2, modelecol3) VALUES 
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
(3,'lit superposee',200,90,100, '15:30:00'),





