--RF1 - Registrar Roles de Usuario
--Se registran los roles de usuario definidos en la descripción del negocio. Esta operación es realizada por
--el administrador del sistema. Debe incluir todos los roles de usuario indicados en el enunciado.
INSERT INTO Rol VALUES (1, 'Cliente');
INSERT INTO Rol VALUES (2, 'Recepcionista');
INSERT INTO Rol VALUES (3, 'Empleado');
INSERT INTO Rol VALUES (4, 'Administrador');
INSERT INTO Rol VALUES (5, 'Gerente');

--RF2 - Registrar Usuario
--Los usuarios tienen una identificación (Tipo de documento, número de documento), un nombre, un correo
--electrónico y su rol respectivo. Esta operación es realizada por el administrador de datos del hotel.
--Considere inicialmente un gerente, un administrador de datos, 2 recepcionistas, 4 empleados y 4 clientes.
INSERT INTO TipoDocumento VALUES (1, 'CC'); --Cedula
INSERT INTO TipoDocumento VALUES (2, 'NIT'); --Nit
INSERT INTO TipoDocumento VALUES (3, 'TI'); --Tarjeta Identidad

INSERT INTO Persona VALUES (1, 1073251033, 'Carlos Robles', 'ce.robles@uniandes.edu.co', 5); --Gerente

INSERT INTO Persona VALUES (1, 2450736189, 'Hazlett Jeffcoat', 'akick0@tripod.com', 4); --Administrador

INSERT INTO Persona VALUES (1, 5970714529, 'Britteny Scamerdine', 'mmacgowing1@barnesandnoble.com', 2); --1er Recepcionista
INSERT INTO Persona VALUES (1, 7443940732, 'Rhianna Rickerd', 'mmaffioni2@networkadvertising.org', 2); --2do Recepcionista

INSERT INTO Persona VALUES (1, 3227492657, 'Marlow Mandell', 'bfilippyev4@seattletimes.com', 3); --1er Empleado
INSERT INTO Persona VALUES (1, 6980626294, 'Ruthie Sheabe', 'seveleigh5@independent.co.uk', 3); --2do Empleado
INSERT INTO Persona VALUES (1, 4620713277, 'Liliane Pieche', 'sloram6@t.co', 3); --3er Empleado
INSERT INTO Persona VALUES (1, 3991351237, 'Baron Robatham', 'aliston8@stanford.edu', 3); --4to Empleado

INSERT INTO Persona VALUES (2, 90080024243, 'Davida Bickerstasse', 'rmatthissonc@google.nl', 1); --1er Cliente
INSERT INTO Persona VALUES (1, 8387371999, 'Anne-marie Revely', 'beynond@infoseek.co.jp', 1); --2do Cliente
INSERT INTO Persona VALUES (3, 98052759820, 'Kathleen Gerauld', 'carillog@storify.com', 1); --3er Cliente
INSERT INTO Persona VALUES (1, 5439778536, 'Timmie Went', 'lduvall@noaa.gov', 1); --4to Cliente

--RF3 - REGISTRAR TIPO DE HABITACIÓN
--Registra la descripción de los tipos de habitaciones de los cuales dispone el hotel con su dotación
--correspondiente. Esta operación es realizada por el administrador de datos del hotel. Considere
--inicialmente por lo menos 3 tipos de habitaciones.
INSERT INTO TipoHabitacion VALUES (1, 'Suite');
INSERT INTO TipoHabitacion VALUES (2, 'Suite presidencial');
INSERT INTO TipoHabitacion VALUES (3, 'Familiar');
INSERT INTO TipoHabitacion VALUES (4, 'Doble');
INSERT INTO TipoHabitacion VALUES (5, 'Sencilla');

--RF4 - REGISTRAR HABITACIÓN
--Registra las instancias de las habitaciones de las cuales dispone el hotel. Esta operación es realizada por
--el administrador de datos del hotel. Considere inicialmente por lo menos 3 habitaciones de cada tipo de
--habitación disponible
--INSERT INTO Habitacion VALUES ('numeroHabitacion', 'descripcion', idTipoHabitacion, capacidad, precio, disponible);
INSERT INTO Habitacion VALUES ('101A', 'Esta es una habitacion Sencilla', 5, 1, 120000, 'Y'); --Sencilla
INSERT INTO Habitacion VALUES ('101B', 'Esta es una habitacion Sencilla', 5, 1, 110000, 'Y'); --Sencilla
INSERT INTO Habitacion VALUES ('102', 'Esta es una habitacion Sencilla', 5, 1, 105000, 'Y'); --Sencilla

INSERT INTO Habitacion VALUES ('201', 'Esta es una habitacion Doble', 4, 2, 160000, 'Y'); --Doble
INSERT INTO Habitacion VALUES ('202', 'Esta es una habitacion Doble', 4, 3, 175000, 'Y'); --Doble
INSERT INTO Habitacion VALUES ('203', 'Esta es una habitacion Doble', 4, 2, 155000, 'Y'); --Doble

INSERT INTO Habitacion VALUES ('301', 'Esta es una habitacion Familiar', 3, 8, 230000, 'Y'); --Familiar
INSERT INTO Habitacion VALUES ('302', 'Esta es una habitacion Familiar', 3, 7, 210000, 'Y'); --Familiar
INSERT INTO Habitacion VALUES ('303', 'Esta es una habitacion Familiar', 3, 6, 200000, 'Y'); --Familiar

INSERT INTO Habitacion VALUES ('401', 'Esta es una Suite presidencial', 2, 10, 1200000, 'Y'); --Suite presidencial
INSERT INTO Habitacion VALUES ('402', 'Esta es una Suite presidencial', 2, 5, 50000, 'Y'); --Suite presidencial
INSERT INTO Habitacion VALUES ('403', 'Esta es una Suite presidencial', 2, 1, 400000, 'Y'); --Suite presidencial

INSERT INTO Habitacion VALUES ('501', 'Esta es una Suite', 1, 3, 400000, 'Y'); --Suite
INSERT INTO Habitacion VALUES ('502', 'Esta es una Suite', 1, 4, 400000, 'Y'); --Suite
INSERT INTO Habitacion VALUES ('503', 'Esta es una Suite', 1, 1, 350000, 'Y'); --Suite

--RF5 - REGISTRAR UN SERVICIO DEL HOTEL
--Registra la descripción de los servicios de los cuales dispone el hotel. Esta operación es realizada por el
--administrador de datos del hotel. Considere inicialmente por lo menos 1 servicio de cada uno de los tipos
--de servicio descritos en el enunciado (piscina, spa, bar, … El menú de los bares y restaurantes debe tener
--por lo menos tres productos)
--INSERT INTO TipoServicio VALUES (id, tipoServicio);
INSERT INTO TipoServicio VALUES (1, 'Piscina');
INSERT INTO TipoServicio VALUES (2, 'Gimnasio');
INSERT INTO TipoServicio VALUES (3, 'Internet');
INSERT INTO TipoServicio VALUES (4, 'Bar');
INSERT INTO TipoServicio VALUES (5, 'Restaurante');
INSERT INTO TipoServicio VALUES (6, 'Supermercado');
INSERT INTO TipoServicio VALUES (7, 'Tienda');
INSERT INTO TipoServicio VALUES (8, 'Sala reuniones');
INSERT INTO TipoServicio VALUES (9, 'Sala conferencias');
INSERT INTO TipoServicio VALUES (10, 'Spa');
INSERT INTO TipoServicio VALUES (11, 'AseoRopa');

--INSERT INTO Servicio VALUES (id, nombre, descripcion, idTipo,costoUso, capacidad);
INSERT INTO Servicio VALUES (1, 'PiscinAndes', '15m', 1, 0, 1000);
INSERT INTO Servicio VALUES (2, 'GimnasioAndes', 'Tiene varias maquinas', 2, 0, 100);
INSERT INTO Servicio VALUES (3, 'WifiAndes', 'La clave es: Clave', 3, 1000, 1000);
INSERT INTO Servicio VALUES (4, 'Bar de Carlos', 'Jazz', 4, 0, 100);
INSERT INTO Servicio VALUES (5, 'Restaurante las Marianas', 'Mexicano', 5, 0, 100);
INSERT INTO Servicio VALUES (6, 'Supermercado Jupiter', 'Nada que decir aqui', 6, 0, -1);
INSERT INTO Servicio VALUES (7, 'TiendAndes', 'Joyeria', 7, 0, -1);
INSERT INTO Servicio VALUES (8, 'Sala de reuniones primer piso', 'Es una reunion', 8, 10552, 12);
INSERT INTO Servicio VALUES (9, 'Sala de conferencias segundo piso', 'Incluye todo', 9, 12136, 100);
INSERT INTO Servicio VALUES (10,'SpAndes', 'El mejor espa del hotel', 10, 0, 65);
INSERT INTO Servicio VALUES (11,'LavaRopAndes', 'El mejor espa del hotel', 11, 0, -1);

--INSERT INTO Producto VALUES (id, idServicio, 'nombre', 'descripcion', precio);
INSERT INTO Producto VALUES (1, 4, 'Mojito', 'Es un mojito', 15000); --Bar
INSERT INTO Producto VALUES (2, 4, 'Cerveza BBC', 'Botella de cerveza', 8000); --Bar
INSERT INTO Producto VALUES (3, 4, 'Destornillador', 'Cuidado, es fuerte', 25000); --Bar

INSERT INTO Producto VALUES (4, 5, 'Tacos al pastor', 'No querras comer otra cosa', 12000); --Restaurante
INSERT INTO Producto VALUES (5, 5, 'Burrito', 'Tiene 5 carnes, CINCO!', 9000); --Restaurante
INSERT INTO Producto VALUES (6, 5, 'Quesadilla', 'no tiene queso', 5000); --Restaurante

--RF6 - REGISTRAR UN PLAN DE CONSUMO
--Registra los planes de consumo disponibles en el hotel. Esta operación es realizada por el administrador
--de datos del hotel. Considere los planes descritos en el enunciado y por lo menos uno de promoción
--particular.
--INSERT INTO TipoConsumo VALUES (id, 'tipoConsumo')
INSERT INTO TipoConsumo VALUES (1, 'Larga estadia');
INSERT INTO TipoConsumo VALUES (2, 'Tiempo compartido');
INSERT INTO TipoConsumo VALUES (3, 'Todo incluido');
INSERT INTO TipoConsumo VALUES (4, 'Promocion');

--INSERT INTO PlanDeConsumo VALUES (id, idTipoConsumo, tiempoEstadia, descuento);
INSERT INTO PlanDeConsumo VALUES (1, 1, 10, 5);
INSERT INTO PlanDeConsumo VALUES (2, 2, 7, 0);
INSERT INTO PlanDeConsumo VALUES (3, 3, 15, 0);
INSERT INTO PlanDeConsumo VALUES (4, 4, 7, 10);

INSERT INTO Hotel VALUES(1, 'HotelAndes');
INSERT INTO HabitacionesHotel VALUES(1,'101A');
INSERT INTO HabitacionesHotel VALUES(1,'101B');
INSERT INTO HabitacionesHotel VALUES(1,'102');
INSERT INTO HabitacionesHotel VALUES(1,'201');
INSERT INTO HabitacionesHotel VALUES(1,'202');
INSERT INTO HabitacionesHotel VALUES(1,'203');
INSERT INTO HabitacionesHotel VALUES(1,'301');
INSERT INTO HabitacionesHotel VALUES(1,'302');
INSERT INTO HabitacionesHotel VALUES(1,'303');
INSERT INTO HabitacionesHotel VALUES(1,'401');
INSERT INTO HabitacionesHotel VALUES(1,'402');
INSERT INTO HabitacionesHotel VALUES(1,'403');
INSERT INTO HabitacionesHotel VALUES(1,'501');
INSERT INTO HabitacionesHotel VALUES(1,'502');
INSERT INTO HabitacionesHotel VALUES(1,'503');

INSERT INTO PersonasHotel VALUES(1, 1, 1073251033);
INSERT INTO PersonasHotel VALUES(1, 1, 2450736189);
INSERT INTO PersonasHotel VALUES(1, 1, 5970714529);
INSERT INTO PersonasHotel VALUES(1, 1, 7443940732);
INSERT INTO PersonasHotel VALUES(1, 1, 3227492657);
INSERT INTO PersonasHotel VALUES(1, 1, 6980626294);
INSERT INTO PersonasHotel VALUES(1, 1, 4620713277);
INSERT INTO PersonasHotel VALUES(1, 1, 3991351237);
INSERT INTO PersonasHotel VALUES(1, 2, 90080024243);
INSERT INTO PersonasHotel VALUES(1, 1, 8387371999);
INSERT INTO PersonasHotel VALUES(1, 3, 98052759820);
INSERT INTO PersonasHotel VALUES(1, 1, 5439778536);

INSERT INTO PlanesHotel VALUES(1, 1);
INSERT INTO PlanesHotel VALUES(1, 2);
INSERT INTO PlanesHotel VALUES(1, 3);
INSERT INTO PlanesHotel VALUES(1, 4);

INSERT INTO ServiciosHotel VALUES(1, 1);
INSERT INTO ServiciosHotel VALUES(1, 2);
INSERT INTO ServiciosHotel VALUES(1, 3);
INSERT INTO ServiciosHotel VALUES(1, 4);
INSERT INTO ServiciosHotel VALUES(1, 5);
INSERT INTO ServiciosHotel VALUES(1, 6);
INSERT INTO ServiciosHotel VALUES(1, 7);
INSERT INTO ServiciosHotel VALUES(1, 8);
INSERT INTO ServiciosHotel VALUES(1, 9);
INSERT INTO ServiciosHotel VALUES(1, 10);
INSERT INTO ServiciosHotel VALUES(1, 11);