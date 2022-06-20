drop database if exists roille_sa;
create database roille_sa;
use roille_sa;

-- Tables
create table client(
	idC int(4) not null auto_increment,
	nom varchar(25),
	prenom varchar(50),
	adresse varchar(30),
	ville varchar(20),
	cp varchar(5),
	societe varchar(30),
	mail varchar(40),
	tel varchar(10),
	username varchar(100),
    mdp varchar(255),
    role enum("superadmin","admin","user") default "user",
	primary key (idC)
)ENGINE=InnoDB;
create table contrat(
	idCo int(5) not null auto_increment,
	datedebut date,
	datedefin date,
	etat enum('en_cours','termine' ) default 'en_cours',
	idC int(4) not null,
	primary key (idCo),
	foreign key (idC) references client(idC)
)ENGINE=InnoDB;
create table facture(
	idF int(5) not null auto_increment,
	montantHT double(8,2),
	TVA double(8,2),
	montantTTC double(8,2),
	dateF date,
	idCo int(5) not null,
	primary key (idF),
	foreign key (idCo) references contrat(idCo)
)ENGINE=InnoDB;
create table typeMat(
	idTM int(4) not null auto_increment,
	designation varchar(25),
	primary key (idTM)
)ENGINE=InnoDB;
create table materiel(
	idM int(5) not null auto_increment,
	prixM double(5,2) not null,
	qtStockM int(3),
	nomM varchar(25),
	idTM int(4) not null,
	primary key (idM),
	foreign key (idTM) references typeMat(idTM)
)ENGINE=InnoDB;
create table location(
	idL int(5) not null auto_increment,
	idCo int(5) not null,
	idM int(5) not null,
	qtM int(5) not null,
	primary key (idL),
	foreign key (idCo) references contrat(idCo),
	foreign key (idM) references materiel(idM)
)ENGINE=InnoDB;
create table archiveContrat(
	idCo int(5) not null auto_increment,
	datedebut date,
	datedefin date,
	datearchivage date,
	idC int(4) not null,
	primary key (idCo),
	foreign key (idC) references client(idC)
)ENGINE = InnoDB;

-- Views
create or replace view contrat_client as(
	select co.idCo, co.datedebut, co.datedefin, co.idC, cl.nom, cl.societe
	from contrat co
	join client cl on co.idC=cl.idC
);
create or replace view location_materiel as(
	select l.idL, l.idCo, l.idM, l.qtM, m.nomM
	from location l
	join materiel m on m.idM=l.idM
);
create or replace view materiel_typeMat as(
	select m.idM, m.prixM, m.qtStockM, m.nomM, m.idTM, tm.designation
	from materiel m
	join typeMat tm on m.idTM=tm.idTM
);

-- Triggers
drop trigger if exists MontantUp;
delimiter //
create trigger MontantUp
	before update on facture
		for each row
		begin
			set new.TVA = new.montantHT * 0.20;
			set new.montantTTC = new.montantHT + new.TVA;
		end //
delimiter ;

drop trigger if exists MontantIns;
delimiter //
create trigger MontantIns
	before insert on facture
		for each row
		begin
			set new.TVA = new.montantHT * 0.20;
			set new.montantTTC = new.montantHT + new.TVA;
		end //
delimiter ;

Drop trigger if exists archiveCoUp;
delimiter //
CREATE trigger archiveCoUp 
after update on contrat
for each row
 begin
	if new.etat = 'terminee'
	then
		insert into archiveContrat values
		(new.idCo, new.datedebut, new.datedefin,new.idC);
	end if;
end//
delimiter ; 

create event suppCon
on schedule every 1 minute
do delete from contrat where etat = 'terminee';

/*delimiter //
create or replace procedure reserver (in idClient, in idContrat, in idMateriel, in nbMateriel)
begin
    insert into 
end //
delimiter ;

-- create or replace procedure finReserver (in )

-- TODO : Créer une procédure pour créer les utilisateurs
/* delimiter //
create procedure  gest_user(nom varchar(60),hoste varchar(60),passwd varchar(250))
	begin
	insert into user(host,user,password) values (hoste,nom,passwd);
	-- create user `nom`@`hoste` identified by 'passwd' ;
	end //
delimiter ; */

-- Inserts
insert into client values 	(null, "June", "Jane", "8 rue du Charpentier", "Paris", "75009", "July", "june@july.com", "0610111213", "JJ", "KK", "user"),
							(null, "Mars", "April", "4 avenue Foret", "Lille", "59000", "Saturne", "mars@saturne.com", "0710111213", "MA", "NB", "user"),
							(null, "Admin", "Saturne", "4 avenue Foret", "Lille", "59000", "Saturne", "admin@saturne.com", "0700000000", "a", "s", "admin"),
							(null, "SuperAdmin", "Null", "IRIS", "Paris", "75000", "Null", "null@news.nll", "0000000000", "SuperAdmin", "1", "superadmin"),
							(null, "Admin", "Null", "IRIS", "Paris", "75000", "Null", "null@news.nll", "0000000000", "Admin", "1", "admin"),
							(null, "User", "Null", "IRIS", "Paris", "75000", "Null", "null@news.nll", "0000000000", "User", "1", "user");
insert into contrat values 	(null, "2022-01-17", null, "en_cours", 1),
							(null, "2022-01-20", null, "en_cours", 2);
insert into facture values 	(null, 80.00, null, null, "2022-01-18", 1),
							(null, 120.00, null, null, "2022-01-21", 2);
insert into typeMat values 	(null, "Outil"),
							(null, "Matieres premieres");
insert into materiel values (null, 30, 2, "Pelle", 1),
							(null, 25, 3, "Marteau", 1),
							(null, 9, 5, "Sac de ciment", 2),
							(null, 5, 20, "Planches en bois", 2);
insert into location values (null, 1, 2, 1),
							(null, 2, 3, 1);