DELETE FROM APARTMENT;
DELETE FROM USER;
DELETE FROM RESERVATION;
insert into APARTMENT(name,description,price,surface) values
('house1','middle',1500.00,60.00), ('house2','big',3300.00,90.00),('house3','small',800.00,30.00);

insert into USER(name,role) values
('Marcin','Borrower'),('Wojtek','Borrower'), ('Jacek','Owner'),('Czeslaw','Owner');

insert into RESERVATION(start_reservation,finish_reservation,apartment_name,owner_name,borrower_name,price) values
('2020-05-12','2020-05-24','house1','Jacek','Wojtek',1500.00),('2020-06-17','2020-06-30','house2','Czeslaw','Marcin',3300.00);
