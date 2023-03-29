INSERT INTO Realisateur (email,mdp,Nom, Prenom, DateNaissance, Nationalite) VALUES
                                                                                ('Berlanti@gmail.com','Berlanti','Berlanti', 'Greg', '1963-03-27', 'Américaine'),
                                                                                ('Spielberg@gmail.com','Spielberg','Spielberg', 'Steven', '1972-05-24', 'Américaine'),


                                                                                ('Kenneth@gmail.com','Kenneth','Kenneth','Branagh','1960-12-10','Britannique');
INSERT INTO TypeFilm_series(Type) VALUES ('Film'),('Séries');

INSERT INTO Plateau (NomPlateau) values('Plateau 1');
INSERT INTO Plateau (NomPlateau) values('Plateau 2');
INSERT INTO Plateau (NomPlateau) values('Plateau 3');
INSERT INTO Plateau (NomPlateau) values('Plateau 4');
INSERT INTO Plateau (NomPlateau) values('Plateau 5');
INSERT INTO Plateau (NomPlateau) values('Plateau 6');
INSERT INTO Plateau (NomPlateau) values('Plateau 7');
INSERT INTO Plateau (NomPlateau) values('Plateau 8');
INSERT INTO Plateau (NomPlateau) values('Plateau 9');
INSERT INTO Plateau (NomPlateau) values('Plateau 10');


INSERT INTO Acteur(Nom,Prenom,genre,datenaissance,Nationalite) values('Acteur1','Acteur1','Masculin','2002-10-10','Malagasy');
INSERT INTO Acteur(Nom,Prenom,genre,datenaissance,Nationalite) values('Acteur2','Acteur2','Feminin','1999-07-24','Malagasy');
INSERT INTO Acteur(Nom,Prenom,genre,datenaissance,Nationalite) values('Acteur3','Acteur3','Masculin','2000-08-01','Malagasy');
INSERT INTO Acteur(Nom,Prenom,genre,datenaissance,Nationalite) values('Acteur4','Acteur4','Masculin','2001-11-10','Malagasy');


INSERT INTO Categorie_personnage(categorie) values('Personnage principale');
INSERT INTO Categorie_personnage(categorie) values('Protagoniste');
INSERT INTO Categorie_personnage(categorie) values('Antagoniste');
INSERT INTO Categorie_personnage(categorie) values('Personnage secondaire');
INSERT INTO Categorie_personnage(categorie) values('Figurant');


INSERT INTO Categorie_Film_series(Genre) VALUES
                                          ('Comédie'),('Action'),('Policière'),('Science-Fiction'),('Horreur'),('Romance'),('Aventure'),('Drame');


INSERT INTO Film_series(Titre, Duree, DateTournage, IDRealisateur) VALUES
                                                                    ('You',420,'2022-03-01',1),
                                                                    ('Idiana Jones et le cadran de la destinée',165,'2022-01-01',2),
                                                                    ('Le crime de l''Orient Express',165,'2013-01-20',3);

INSERT INTO Film_series_Genre VALUES(1,6),(2,7),(3,3);

INSERT INTO Film_series_Genre VALUES(1,6),(2,7),(3,3);

INSERT INTO scene(nom,idfilm_series,idplateau,duree) values('scene1',1,2,3);
INSERT INTO scene(nom,idfilm_series,idplateau,duree) values('scene2',1,3,2);
INSERT INTO scene(nom,idfilm_series,idplateau,duree) values('scene3',1,4,1);
INSERT INTO scene(nom,idfilm_series,idplateau,duree) values('scene4',1,1,2);



INSERT INTO role (idscene,idacteur,idcategoriepersonnage,nom) values(1,1,1,'Jack');
INSERT INTO role (idscene,idacteur,idcategoriepersonnage,nom) values(1,2,1,'Syrie');
INSERT INTO role (idscene,idacteur,idcategoriepersonnage,nom) values(2,3,2,'Fidgerald');
INSERT INTO role (idscene,idacteur,idcategoriepersonnage,nom) values(2,4,3,'Selena');



INSERT INTO Action (idrole,texte,duree) values(1,'Mety !',20);
INSERT INTO Action (idrole,texte,duree) values(1,'Tsy mety !',30);
INSERT INTO Action (idrole,texte,duree) values(2,'Mety !',50);
INSERT INTO Action (idrole,texte,duree) values(2,'Tsy mety !',20);

insert into administrateur (email, psswd) VALUES ('admin', 'admin');
