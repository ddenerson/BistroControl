-- Users: default password is senha123
INSERT INTO users(`name`,email,`password`,`role`)
values('Pedro', 'pedro@gmail.com', '$2a$10$frioE727xrtUCg3FnSKDJeBn2vE2R74hSuFL9VJjFkQJHzLxJ.xem', '0');

INSERT INTO users(`name`,email,`password`,`role`)
values('Maria', 'maria@gmail.com', '$2a$10$OrPFBmpPqIRftNZNGxzuFeTLI4vmlRT0WAu86fa2ljZ5QbPlszp5O', '1');

INSERT INTO users(`name`,email,`password`,`role`)
values('Ana Maria', 'ana@gmail.com', '$2a$10$lnwTGsFvciLpFljY47THaOdVECEo5p3Dh4CzyLmFeBYCo/edg3kFS', '1');

INSERT INTO users(`name`,email,`password`,`role`)
values('Diego', 'diego@gmail.com', '$2a$10$ezwObsWFznMzArz.aJzPe.vO.oJRWgOJBnUwRg.QpxGJ/irY/hdlK', '1');

-- Tables
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