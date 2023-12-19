SELECT m.materiel,m.unite,sm.quantiteEnplus
FROM stylemateriel sm 
JOIN materiel m ON m.idMateriel = sm.idMateriel
JOIN style s ON s.idStyle = sm.idStyle
WHERE s.idStyle =2;