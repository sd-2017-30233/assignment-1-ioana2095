create database Bank;
use Bank;

create table Employeess
(ID_Employees int PRIMARY KEY,
UserNume nvarchar(50) UNIQUE,
Password nvarchar(50),
UserType nvarchar(50));

create table Client
(CNP nvarchar(50) PRIMARY KEY,
Nume nvarchar(50),
IDCardNumber nvarchar(50),
Adress nvarchar(50)); 

create table Account
(IdNumberAcc nvarchar(50) PRIMARY KEY,
AmmountOfMoney float,
DataCreation date,
CNP nvarchar(50),
IdType int);


create table Process
(ID_Employees int PRIMARY KEY,
IdNumberAcc nvarchar(50),
AmmountOfMoney float,
DataOperation date,
Op nvarchar(50));

create table TypeA
(IdType int PRIMARY KEY,
TypeA nvarchar(50));


create table EmpClient
(CNP nvarchar(50) ,
Operatia nvarchar(50),
DataOp date,
ID_Employees int);

alter table Account
add constraint fk_Account_TypeA
foreign key (IdType)
references TypeA(IdType)
on update cascade
on delete cascade;

alter table EmpClient
add constraint fk_EmpClient_Employeess
foreign key (ID_Employees)
references Employeess(ID_Employees)
on update cascade
on delete cascade;

alter table EmpClient
add constraint fk_EmpClient_Client
foreign key (CNP)
references Client(CNP)
on update cascade
on delete cascade;

alter table Process
add constraint fk_Process_Account
foreign key (IdNumberAcc)
references Account(IdNumberAcc)
on update cascade
on delete cascade;

alter table Account
add constraint fk_Account_Client
foreign key (CNP)
references Client(CNP)
on update cascade
on delete cascade;


insert into Client (CNP, Nume, IDCardNumber, Adress) values ('2831129332306', 'Cheryl', '675920835', '5 Paget Center');
insert into Client (CNP, Nume, IDCardNumber, Adress) values ('2920828524661', 'Anne', '677197070', '4 Laurel Point');
insert into Client (CNP, Nume, IDCardNumber, Adress) values ('1880224247834', 'Carl', '357176736', '1191 Katie Park');
insert into Client (CNP, Nume, IDCardNumber, Adress) values ('1980817097170', 'Lawrence', '357282590', '958 Menomonie Avenue');
insert into Client (CNP, Nume, IDCardNumber, Adress) values ('1720208298159', 'Phillip', '630447282', '416 Merry Trail');
insert into Client (CNP, Nume, IDCardNumber, Adress) values ('2770409113686', 'Kathy', '374283852', '6 Karstens Center');
insert into Client (CNP, Nume, IDCardNumber, Adress) values ('2810314337148', 'Elizabeth', '491169007', '4732 Iowa Plaza');
insert into Client (CNP, Nume, IDCardNumber, Adress) values ('2960220416111', 'Emily', '201870969', '290 Annamark Center');

insert into Employees (ID_Employees, UserNume, Password, UserType) values (1, 'rfranklin0', 'g9mNRKll', 'employee');
insert into Employees (ID_Employees, UserNume, Password, UserType) values (2, 'mlong1', '5J2sXGcfpRE', 'admin');
insert into Employees (ID_Employees, UserNume, Password, UserType) values (3, 'ajohnston2', 'ZmRmfkVqH97', 'employee');
insert into Employees (ID_Employees, UserNume, Password, UserType) values (4, 'dthomas3', 's90qWyf9U', 'employee');
insert into Employees (ID_Employees, UserNume, Password, UserType) values (5, 'ethompson4', 'l9iciru51xb', 'employee');
insert into Employees (ID_Employees, UserNume, Password, UserType) values (6, 'sevans5', 'bnbjelrV80bc', 'employee');
insert into Employees (ID_Employees, UserNume, Password, UserType) values (7, 'bbanks6', 'Mga5p8fPnx', 'admin');
insert into Employees (ID_Employees, UserNume, Password, UserType) values (8, 'jhenderson7', 'l3gqQMJxULV', 'employee');

insert into Account (IdNumberAcc, AmmountOfMoney, DataCreation, CNP, IdType) values ('RO3550432360829223BT', 255.82, '2/15/2017', '2831129332306', 1);
insert into Account (IdNumberAcc, AmmountOfMoney, DataCreation, CNP, IdType) values ('RO201405344303282BT', 1035.42, '8/30/2016', '2920828524661', 2);
insert into Account (IdNumberAcc, AmmountOfMoney, DataCreation, CNP, IdType) values ('RO3566405524705630BT', 377.02, '9/12/2016', '1880224247834', 3);
insert into Account (IdNumberAcc, AmmountOfMoney, DataCreation, CNP, IdType) values ('RO3574716286738894BT', 58.63, '3/22/2017', '2920828524661', 1);
insert into Account (IdNumberAcc, AmmountOfMoney, DataCreation, CNP, IdType) values ('RO3549226635244919BT', 1605.17, '11/24/2016', '2831129332306', 2);
insert into Account (IdNumberAcc, AmmountOfMoney, DataCreation, CNP, IdType) values ('RO377219802976861BT', 209.43, '10/3/2016', '1980817097170', 3);
insert into Account (IdNumberAcc, AmmountOfMoney, DataCreation, CNP, IdType) values ('RO3562475122789017BT', 1168.28, '3/19/2017', '1720208298159', 1);
insert into Account (IdNumberAcc, AmmountOfMoney, DataCreation, CNP, IdType) values ('RO3543630975001365BT', 709.53, '6/25/2016', '1980817097170', 2);
insert into Account (IdNumberAcc, AmmountOfMoney, DataCreation, CNP, IdType) values ('RO3537624629171839BT', 739.7, '2/8/2017', '2770409113686', 3);
insert into Account (IdNumberAcc, AmmountOfMoney, DataCreation, CNP, IdType) values ('RO374622257123959BT', 1674.88, '3/13/2017', '2920828524661', 1);
insert into Account (IdNumberAcc, AmmountOfMoney, DataCreation, CNP, IdType) values ('RO67620722437883828BT', 1105.71, '1/7/2017', '2810314337148', 2);
insert into Account (IdNumberAcc, AmmountOfMoney, DataCreation, CNP, IdType) values ('RO3576592518980762BT', 2496.12, '4/19/2016', '2810314337148', 3);
insert into Account (IdNumberAcc, AmmountOfMoney, DataCreation, CNP, IdType) values ('RO3549226364414584BT', 978.49, '6/5/2016', '2770409113686', 1);
insert into Account (IdNumberAcc, AmmountOfMoney, DataCreation, CNP, IdType) values ('RO4026548120825377BT', 1600.52, '3/13/2017', '2770409113686', 2);
insert into Account (IdNumberAcc, AmmountOfMoney, DataCreation, CNP, IdType) values ('RO3554967380334510BT', 775.68, '12/20/2016', '2960220416111', 3);
insert into Account (IdNumberAcc, AmmountOfMoney, DataCreation, CNP, IdType) values ('RO3557546155152740BT', 1035.11, '9/14/2016', '2960220416111', 1);

insert into Process (ID_Employees,IdNumberAcc,AmmountOfMoney,DataOperation,Op) values (1,'RO3566405524705630BT',256,'3/13/2017','Tranzactie');
insert into Process (ID_Employees,IdNumberAcc,AmmountOfMoney,DataOperation,Op) values (1,'RO3549226635244919BT',296,'12/20/2016','PayUtility');
insert into Process (ID_Employees,IdNumberAcc,AmmountOfMoney,DataOperation,Op) values (1,'RO3549226364414584BT',256,'3/13/2017','Tranzactie');
insert into Process (ID_Employees,IdNumberAcc,AmmountOfMoney,DataOperation,Op) values (3,'RO3566405524705630BT',256,'3/13/2017','Tranzactie');
insert into Process (ID_Employees,IdNumberAcc,AmmountOfMoney,DataOperation,Op) values (3,'RO3554967380334510BT',256,'3/13/2017','Tranzactie');
insert into Process (ID_Employees,IdNumberAcc,AmmountOfMoney,DataOperation,Op) values (3,'RO3562475122789017BT',256,'6/5/2016','PayUtility');

insert into TypeA (IdType ,TypeA ) values (1,'economii');
insert into TypeA (IdType ,TypeA ) values (2,'obisnuit');
insert into TypeA (IdType ,TypeA ) values (3,'de credit');

insert into EmpClient(CNP,Operatia,DataOp ,ID_Employees ) values ('2831129332306','Creare','6/5/2016',1);
insert into EmpClient(CNP,Operatia,DataOp ,ID_Employees ) values ('2920828524661','Creare','6/9/2016',1);
insert into EmpClient(CNP,Operatia,DataOp ,ID_Employees ) values ('1880224247834','Creare','12/9/2016',3);
insert into EmpClient(CNP,Operatia,DataOp ,ID_Employees ) values ('1980817097170','Creare','23/1/2017',1);
insert into EmpClient(CNP,Operatia,DataOp ,ID_Employees ) values ('1720208298159','Creare','3/6/2016',3);
insert into EmpClient(CNP,Operatia,DataOp ,ID_Employees ) values ('2770409113686','Creare','12/5/2016',6);
insert into EmpClient(CNP,Operatia,DataOp ,ID_Employees ) values ('2810314337148','Creare','30/11/2016',6);
insert into EmpClient(CNP,Operatia,DataOp ,ID_Employees ) values ('2960220416111','Creare','4/2/2017',8);

