drop database if exists nerdPlanet;
create database nerdPlanet;
use nerdPlanet;


-- Piattaforme --------------------------------------
drop table if exists Piattaforme;
create table Piattaforme
(
	IDPiattaforma int,
	piattaforma varchar(50)
);
insert into Piattaforme (piattaforma) values (?);


-- GENERI -------------------------------------------
drop table if exists Generi;
create table Generi
(
	IDGenere int,
    genere varchar(50)
);
insert into Generi (genere) values (?);


-- Sviluppatori -------------------------------------
drop table if exists Sviluppatori;
create table Sviluppatori
(
	IDSviluppatore int,
    nomeSviluppatore varchar(50)
);
insert into Sviluppatori (nomeSviluppatore) values (?);

-- Editor ------------------------------------------
drop table if exists Editor;
create table Editor
(
	IDEditor int,
    nomeEditor varchar(50)
);
insert into Editor (nomeEditor) values (?);

-- Utenti ----------------------------------------
drop table if exists Utenti;
create table Utenti
(
	IDUtente int,
    userName varchar(20),
    emailAddress varchar(50),
    pword varchar(32),
    bio varchar (150),
    dataIscrizione date,
    dataCompleanno date
);
insert into Utenti (userName, emailAddress, pword, bio) values (?,?,?,?);

-- Giochi -------------------------------------
drop table if exists Giochi;
create table Giochi
(
	IDGioco int,
	titolo varchar (100),
    dataUscita date,
    serie varchar(100),
    pegi int,
    IDPiattaforma int,
    IDGenere int,
    IDSviluppatore int,
    IDEditor int,
    foreign key (IDPiattaforma) references Piattaforme(IDPiattaforma)
    on update cascade on delete set null,
    foreign key (IDGenere) references Generi(IDGenere)
    on update cascade on delete set null,
    foreign key (IDSviluppatore) references Sviluppatori(IDSviluppatore)
    on update cascade on delete set null,
    foreign key (IDEditor) references Editor(IDEditor)
    on update cascade on delete set null
);
insert into Giochi
(
	titolo,
    dataUscita,
    serie,
    pegi,
    IDPiattaforma,
    IDGenere,
    IDSviluppatore,
    IDEditor) values (?,?,?,?,?,?,?,?,?);

-- GiochiLatoUser --------------------------------
drop table if exists GiocoLatoUser;
create table GiocoLatoUser
(
	IDUtente int,
    IDGioco int,
    IDLista int,
    rating int,
    testoReview varchar(150),
    oreGioco double
);
-- ---------------------------------------
select * from Piattaforme;
select * from Generi;
select * from Sviluppatori;
select * from Editor;
select * from Utenti;