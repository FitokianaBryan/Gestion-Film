-- CREATE DATABASE gestionfilm
/*-- TABLES --*/
-- - Realisateur
-- - Type_Tournage
-- - Categorie_Personnage
-- - Tournage
-- - Acteur
-- - Plateau
-- - Scene
-- - Role
-- - Action
-- - Genre

-- Drop all tables
DO $$ DECLARE
r RECORD;
BEGIN
FOR r IN (SELECT tablename FROM pg_tables WHERE schemaname = current_schema()) LOOP
        EXECUTE 'DROP TABLE IF EXISTS ' || quote_ident(r.tablename) || ' CASCADE';
END LOOP;
END $$;

CREATE TABLE Realisateur(
    ID SERIAL PRIMARY KEY,
    email varchar(70) not null,
    mdp varchar (60) not null,
    Nom VARCHAR(150) NULL,
    Prenom VARCHAR(150) NULL,
    DateNaissance DATE NULL,
    Nationalite VARCHAR(70) NOT NULL
);

CREATE TABLE TypeFilm_series(
    ID SERIAL PRIMARY KEY,
    Type VARCHAR(50) NOT NULL
);

CREATE TABLE Categorie_Film_series(
    ID SERIAL PRIMARY KEY,
    Genre VARCHAR(70) NOT NULL
);

CREATE TABLE Film_series(
    ID SERIAL PRIMARY KEY,
    Titre TEXT NOT NULL,
    Duree INT NOT NULL,
    DateTournage DATE NOT NULL,
    IDRealisateur INT NOT NULL REFERENCES Realisateur(ID)
);


CREATE TABLE Film_series_Genre(
    IDFilm_series INT NOT NULL REFERENCES Film_series(ID),
    IDCategorie INT NOT NULL REFERENCES Categorie_Film_series(ID)
);

CREATE TABLE Acteur(
    ID SERIAL PRIMARY KEY,
    Nom VARCHAR(150) NULL,
    Prenom VARCHAR(150) NULL,
    Genre VARCHAR(40) NOT NULL CHECK(Genre IN ('Masculin','Feminin')),
    DateNaissance DATE NOT NULL,
    Nationalite VARCHAR(70) NOT NULL
);

CREATE TABLE Acteur_Film_series(
    IDFilm_series INT NOT NULL REFERENCES Film_series(ID),
    IDActeur INT NOT NULL REFERENCES Acteur(ID)
);

CREATE TABLE Plateau(
    ID SERIAL PRIMARY KEY,
    NomPlateau TEXT NOT NULL
);

CREATE TABLE Scene(
    ID SERIAL primary KEY,
    nom TEXT,
    IDFilm_series INT NOT NULL REFERENCES Film_series(ID),
    IDPlateau INT NOT NULL REFERENCES Plateau(ID),
    Duree INT NOT NULL
);

CREATE TABLE Categorie_Personnage(
    ID SERIAL PRIMARY KEY,
    Categorie VARCHAR(70) NOT NULL
);

CREATE TABLE Role(
    ID SERIAL PRIMARY KEY,
    IDScene INT NOT NULL REFERENCES Scene(ID),
    IDActeur INT NOT NULL REFERENCES Acteur(ID),
    IDCategoriePersonnage INT NOT NULL REFERENCES Categorie_Personnage(ID),
    Nom VARCHAR(70) NOT NULL
);

CREATE TABLE Action(
    ID SERIAL PRIMARY KEY,
    IDRole INT NOT NULL REFERENCES Role(ID),
    Texte TEXT NOT NULL,
    Duree INT NOT NULL
);

-- A revoir
Create table planning_scene(
    idplanning_scene SERIAL PRIMARY KEY,
    idscene int not null references Scene(ID),
    Datedebut timestamp check(Datedebut<planning_scene.Datefin),
    Datefin timestamp check(Datefin>planning_scene.Datedebut)
);

Create or replace view liste_role as
select r.*,concat(a.nom,' '||a.prenom) as nom_prenom,cp.Categorie,S.nom AS scenario from Role r join Acteur a on r.IDActeur = a.ID join Categorie_Personnage CP on r.IDCategoriePersonnage = CP.ID JOIN Scene S on r.IDScene = S.ID;


Create or replace view liste_planning_scene as
select * from planning_scene ps join scene s on ps.idscene=s.id;

CREATE OR REPLACE VIEW Liste_validation_scene as
SELECT l.idscene,l.idplanning_scene,l.datedebut,l.datefin,l.nom,l.idfilm_series,l.idplateau,l.duree,v.etat,v.moment FROM liste_planning_scene l join validation_scene v using(idscene);


-- 14/03/2023



create table administrateur(
    id serial primary key ,
    email varchar(50),
    psswd varchar(50)
);

-- alter table planning_scene
--     add validation int default 0;
--

/*--INDISPONIBILITE PLATEAU ET ACTEUR--*/
CREATE TABLE Indisponibilite_Plateau(
    IDPlateau INT NOT NULL REFERENCES Plateau(ID),
    DateDebut TIMESTAMP NULL,
    DateFin TIMESTAMP NULL
);

CREATE TABLE Indisponibilite_Acteur(
    IDActeur INT NOT NULL REFERENCES Acteur(ID),
    DateDebut TIMESTAMP NULL,
    DateFin TIMESTAMP NULL
);

CREATE TABLE Validation_Scene(
    IDScene INT NOT NULL REFERENCES Scene(ID),
    Etat INT DEFAULT 0,
    Moment TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Priorite_Scene(
    IDScene INT NOT NULL REFERENCES Scene(ID),
    Priorite INT NOT NULL DEFAULT 0
);

