-- Users: default password is senha123
INSERT INTO users("name","email","password","role")
values('Pedro','pedro@gmail.com', '$2a$10$frioE727xrtUCg3FnSKDJeBn2vE2R74hSuFL9VJjFkQJHzLxJ.xem', '0');

INSERT INTO users("name","email","password","role")
values('Maria', 'maria@gmail.com', '$2a$10$OrPFBmpPqIRftNZNGxzuFeTLI4vmlRT0WAu86fa2ljZ5QbPlszp5O', '1');

INSERT INTO users("name","email","password","role")
values('Ana Maria', 'ana@gmail.com', '$2a$10$lnwTGsFvciLpFljY47THaOdVECEo5p3Dh4CzyLmFeBYCo/edg3kFS', '1');

INSERT INTO users("name","email","password","role")
values('Diego', 'diego@gmail.com', '$2a$10$ezwObsWFznMzArz.aJzPe.vO.oJRWgOJBnUwRg.QpxGJ/irY/hdlK', '1');

INSERT INTO users("name","email","password","role")
values('Carmen', 'carmen@gmail.com', '$2a$10$7LwKytmTsPMLed5uggiv0uu/Xjl/Y6ioZvegaSCu7oMfa2OmHQO/u', '1');

INSERT INTO users("name","email","password","role")
values('Paula', 'paula@gmail.com', '$2a$10$zch7m4NzxwmPgfVtjuEgSufRKwQBxpTUYq7tDeWA3tDvoumOCNb02', '1');

INSERT INTO users("name","email","password","role")
values('Julia', 'julia@gmail.com', '$2a$10$DddKiegStssFxwhpT96ivuw9sFHDKGYMxhE72LmCXEvg1CYfNIKji', '1');

INSERT INTO users("name","email","password","role")
values('Roseli', 'roseli@gmail.com', '$2a$10$JDyupoo0PwInUv.kB.uaM..9sxwNZtJcQb/bW0AGOIOge0BcnK6/a', '1');

INSERT INTO users("name","email","password","role")
values('Andre', 'andre@gmail.com', '$2a$10$l4MCeZbpnpRrbBZWDYCD8ODPFqIdIq6I/5h6B0zBkZ2ZQb.xV9FYm', '1');

INSERT INTO users("name","email","password","role")
values('Dener', 'dener@gmail.com', '$2a$10$BguaCluxfRt3PUlLUuU11.MA/azLGRx/ZL1q.fpwoLus8fBW.5MSi', '1');






-- Restaurant Tables
INSERT INTO restaurant_table(seats)
values('2');
INSERT INTO restaurant_table(seats)
values('2');
INSERT INTO restaurant_table(seats)
values('2');

INSERT INTO restaurant_table(seats)
values('4');
INSERT INTO restaurant_table(seats)
values('4');
INSERT INTO restaurant_table(seats)
values('4');

INSERT INTO restaurant_table(seats)
values('6');
INSERT INTO restaurant_table(seats)
values('6');
INSERT INTO restaurant_table(seats)
values('6');

INSERT INTO restaurant_table(seats)
values('8');
INSERT INTO restaurant_table(seats)
values('8');
INSERT INTO restaurant_table(seats)
values('8');

INSERT INTO restaurant_table(seats)
values('10');
INSERT INTO restaurant_table(seats)
values('10');
INSERT INTO restaurant_table(seats)
values('10');

INSERT INTO restaurant_table(seats)
values('12');
INSERT INTO restaurant_table(seats)
values('12');
INSERT INTO restaurant_table(seats)
values('12');

-- Reserve
INSERT INTO reserve(reserve_time, reserve_date, restaurant_table_id, user_id)
VALUES('17:00:00',CURRENT_DATE, 1, 2);

INSERT INTO reserve(reserve_time, reserve_date, restaurant_table_id, user_id)
VALUES('17:00:00',CURRENT_DATE, 2, 2);

INSERT INTO reserve(reserve_time, reserve_date, restaurant_table_id, user_id)
VALUES('17:30:00',CURRENT_DATE, 3, 2);