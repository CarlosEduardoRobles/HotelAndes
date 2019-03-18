CREATE TABLE Hotel
(
    id INTEGER NOT NULL,
    nombre VARCHAR(80) NOT NULL,
    CONSTRAINT hotel_pk PRIMARY KEY(id)
);

CREATE TABLE Habitacion
(
    numeroHabitacion VARCHAR(80) NOT NULL,
    descripcion VARCHAR(80) NOT NULL,
    idTipoHabitacion INTEGER NOT NULL,
    capacidad INTEGER NOT NULL 
    	CHECK (capacidad > 0),
    precio NUMBER NOT NULL 
    	CHECK (precio >= 0),
    disponible CHAR(1) NOt NULL 
    	CHECK (disponible in ('Y','N')),
    CONSTRAINT habitacion_pk PRIMARY KEY(numeroHabitacion)
);

CREATE TABLE TipoHabitacion
(
    id INTEGER NOT NULL,
    tipoHabitacion VARCHAR(80) NOT NULL 
    	CHECK (tipoHabitacion IN ('Suite','Suite presidencial','Familiar','Doble','Sencilla')),
    CONSTRAINT tipoHabitacion_pk PRIMARY KEY(id)
);

CREATE TABLE Dotacion
(
	id INTEGER NOT NULL,
	nombre VARCHAR(80) NOT NULL,
	descripcion VARCHAR(250) NOT NULL,
	precio NUMBER NOT NULL 
		CHECK (precio >= 0),
	CONSTRAINT dotacion_pk PRIMARY KEY(id)
);

CREATE TABLE Persona
(
    idTipoDocumento INTEGER NOT NULL,
    documento INTEGER NOT NULL,
    nombre VARCHAR(80) NOT NULL,
    correo VARCHAR(80) NOT NULL,
    idRol INTEGER NOT NULL,
    CONSTRAINT persona_pk PRIMARY KEY(idTipoDocumento, documento)
);

CREATE TABLE TipoDocumento
(
	id INTEGER NOT NULL,
    tipoDocumento VARCHAR(80) NOT NULL 
    	CHECK (tipoDocumento IN ('CC','TI','NIT')),   
    CONSTRAINT tipoDocumento_pk PRIMARY KEY(id)
);

CREATE TABLE Rol
(
	id INTEGER NOT NULL,
	nombre VARCHAR(80) NOT NULL,
	CONSTRAINT rol_pk PRIMARY KEY(id)
);

CREATE TABLE Servicio
(
    id INTEGER NOT NULL,
	nombre VARCHAR(80) NOT NULL,
	descripcion VARCHAR(250) NOT NULL,
	idTipoServicio INTEGER NOT NULL,
	costoUso INTEGER NOT NULL,
	capacidad INTEGER NOT NULL,
    CONSTRAINT servicio_pk PRIMARY KEY(id)
);

CREATE TABLE TipoServicio
(
    id INTEGER NOT NULL,
	tipoServicio VARCHAR(250) NOT NULL 
		CHECK (tipoServicio IN ('Piscina','Gimnasio','Internet','Bar','Restaurante','Supermercado','Tienda',
		'Sala reuniones','Sala conferencias','Spa', 'AseoRopa')),
    CONSTRAINT tipoServicio_pk PRIMARY KEY(id)
);

CREATE TABLE Producto
(
	id INTEGER NOT NULL,
	idServicio INTEGER NOT NULL,
	nombre VARCHAR(80) NOT NULL,
	descripcion VARCHAR(250) NOT NULL,
	precio NUMBER NOT NULL 
		CHECK (precio > 0),
	CONSTRAINT producto_pk PRIMARY KEY(id)
);

CREATE TABLE PlanDeConsumo
(
	id INTEGER NOT NULL,
	idTipoConsumo INTEGER NOT NULL,
	tiempoEstadia INTEGER NOT NULL 
		CHECK (tiempoEstadia > 0),
	descuento NUMBER NOT NULL CHECK (descuento >= 0.0),
	CONSTRAINT planConsumo_pk PRIMARY KEY(id)
);

CREATE TABLE TipoConsumo
(
	id INTEGER NOT NULL,
	tipoConsumo VARCHAR(80) NOT NULL 
		CHECK (tipoConsumo IN ('Larga estadia','Tiempo compartido','Todo incluido','Promocion')),
	CONSTRAINT tipoConsumo_pk PRIMARY KEY(id)
);

CREATE TABLE Reserva
(
	id INTEGER NOT NULL,
	idTipoDocumentoPersona INTEGER NOT NULL,
    documentoPersona INTEGER NOT NULL,
    numeroHabitacion VARCHAR(80) NOT NULL,
    numeroPersonas INTEGER NOT NULL 
    	CHECK (numeroPersonas > 0),
    checkIn CHAR(1) NOT NULL 
    	CHECK (checkIn IN ('Y','N')),
    checkOut CHAR(1) NOT NULL 
    	CHECK (checkOut IN ('Y','N')),
    fechaEntrada DATE NOT NULL,
    fechaSalida DATE NOT NULL,
	CONSTRAINT reserva_pk PRIMARY KEY(id)
);

CREATE TABLE Utencilio
(
	id INTEGER NOT NULL,
	nombre VARCHAR(80) NOT NULL,
	descripcion VARCHAR(250) NOT NULL,
	precio NUMBER NOT NULL 
		CHECK (precio >= 0),
	buenEstado CHAR(1) NOT NULL 
    	CHECK (buenEstado IN ('Y','N')),
	CONSTRAINT utencilio_pk PRIMARY KEY(id)
);

CREATE TABLE PersonasHotel
(
	idHotel INTEGER NOT NULL,
    idTipoDocumentoPersona INTEGER,
    documentoPersona INTEGER NOT NULL,
    CONSTRAINT personasHotel_pk PRIMARY KEY(idHotel, idTipoDocumentoPersona, documentoPersona)
);

CREATE TABLE HabitacionesHotel
(
	idHotel INTEGER NOT NULL,
    numeroHabitacion VARCHAR(80) NOT NULL,
    CONSTRAINT habitacionesHotel_pk PRIMARY KEY(idHotel, numeroHabitacion)
);

CREATE TABLE ServiciosHotel
(
	idHotel INTEGER NOT NULL,
    idServicio INTEGER NOT NULL,
    CONSTRAINT serviciosHotel_pk PRIMARY KEY(idHotel, idServicio)
);

CREATE TABLE PlanesHotel
(
	idHotel INTEGER NOT NULL,
    idPlanConsumo INTEGER NOT NULL,
    CONSTRAINT planesHotel_pk PRIMARY KEY(idHotel, idPlanConsumo)
);

CREATE TABLE DotacionHabitacion
(
	numeroHabitacion VARCHAR(80) NOT NULL,
	idDotacion INTEGER NOT NULL,
	cantidad INTEGER NOT NULL
		CHECK (cantidad > 0),
    CONSTRAINT dotacionHabitacion_pk PRIMARY KEY(numeroHabitacion, idDotacion)
);

CREATE TABLE Factura
(
	idServicio INTEGER NOT NULL,
    id INTEGER NOT NULL,
    totalFactura NUMBER NOT NULL
    	CHECK (totalFactura > 0),
    fecha DATE NOT NULL,
    CONSTRAINT factura_pk PRIMARY KEY(id)
);

CREATE TABLE ConsumoReserva
(
	idReserva INTEGER NOT NULL,
    idPlanConsumo INTEGER NOT NULL,
    CONSTRAINT consumoReserva_pk PRIMARY KEY(idReserva)
);

CREATE TABLE ServiciosPlanConsumo	
(
	idServicio INTEGER NOT NULL,
    idPlanConsumo INTEGER NOT NULL,
    CONSTRAINT serviciosPlanConsumo_pk PRIMARY KEY(idServicio,idPlanConsumo)
);

CREATE TABLE HorarioServicio	
(
	idServicio INTEGER NOT NULL,
    inicioServicio DATE NOT NULL,
    finalServicio DATE NOT NULL,
    CONSTRAINT horaServicio_pk PRIMARY KEY(idServicio)
);

CREATE TABLE CuentaConsumo	
(
	idReserva INTEGER NOT NULL,
    id INTEGER NOT NULL,
    costo NUMBER NOT NULL,
    CONSTRAINT cuentaConsumo_pk PRIMARY KEY(id)
);

CREATE TABLE UtenciliosPrestados	
(
	idUtencilio INTEGER NOT NULL,
    idReserva INTEGER NOT NULL,
    CONSTRAINT utenciliosPrestados_pk PRIMARY KEY(idReserva, idUtencilio)
);

CREATE TABLE ProductosFactura	
(
	idFactura INTEGER NOT NULL,
    idProducto INTEGER NOT NULL,
    cantidad INTEGER NOT NULL
    	CHECK (cantidad > 0),
    CONSTRAINT productosFactura_pk PRIMARY KEY(idProducto, idFactura)
);

CREATE TABLE ServiciosTomados
(
	idReserva INTEGER NOT NULL,
    idServicio INTEGER NOT NULL,
    costo NUMBER NOT NULL,
	tiempoUso NUMBER NOT NULL,
    CONSTRAINT serviciosTomados_pk PRIMARY KEY(idReserva, idServicio)
);

CREATE TABLE ReservaServicio
(
	idReserva INTEGER NOT NULL,
    idServicio INTEGER NOT NULL,
    comienzoReserva DATE NOT NULL,
    finalReserva DATE NOT NULL,
    cantidadAsistentes INTEGER NOT NULL,
    CONSTRAINT reservaServicio_pk PRIMARY KEY(idReserva, idServicio)
);

CREATE TABLE FacturasCuentaConsumo
(
	idFactura INTEGER NOT NULL,
    idCuentaConsumo INTEGER NOT NULL,
    CONSTRAINT facturasCuentaConsumo_pk PRIMARY KEY(idFactura, idCuentaConsumo)
);
------------------------Modificaciones Tablas------------------------
ALTER TABLE FacturasCuentaConsumo
    ADD    FOREIGN KEY (idFactura)
    REFERENCES Factura(id)
    ON DELETE CASCADE
;

ALTER TABLE FacturasCuentaConsumo
    ADD    FOREIGN KEY (idCuentaConsumo)
    REFERENCES CuentaConsumo(id)
    ON DELETE CASCADE
;

ALTER TABLE Persona
    ADD    FOREIGN KEY (idRol)
    REFERENCES Rol(id)
    ON DELETE CASCADE
;

ALTER TABLE Reserva
    ADD    FOREIGN KEY (idTipoDocumentoPersona, documentoPersona)
    REFERENCES Persona(idTipoDocumento, documento)
    ON DELETE CASCADE
;

ALTER TABLE Reserva
    ADD    FOREIGN KEY (numeroHabitacion)
    REFERENCES Habitacion(numeroHabitacion)
    ON DELETE CASCADE
;

ALTER TABLE Reserva
   ADD CHECK (fechaEntrada <= fechaSalida AND fechaSalida >= fechaEntrada)
;

ALTER TABLE PersonasHotel
    ADD    FOREIGN KEY (idHotel)
    REFERENCES Hotel(id)
    ON DELETE CASCADE
;

ALTER TABLE PersonasHotel
    ADD    FOREIGN KEY (idTipoDocumentoPersona, documentoPersona)
    REFERENCES Persona(idTipoDocumento, documento)
    ON DELETE CASCADE
;

ALTER TABLE HabitacionesHotel
    ADD    FOREIGN KEY (idHotel)
    REFERENCES Hotel(id)
    ON DELETE CASCADE
;

ALTER TABLE HabitacionesHotel
    ADD    FOREIGN KEY (numeroHabitacion)
    REFERENCES Habitacion(numeroHabitacion)
    ON DELETE CASCADE
;

ALTER TABLE ServiciosHotel
    ADD    FOREIGN KEY (idHotel)
    REFERENCES Hotel(id)
    ON DELETE CASCADE
;

ALTER TABLE ServiciosHotel
    ADD    FOREIGN KEY (idServicio)
    REFERENCES Servicio(id)
    ON DELETE CASCADE
;

ALTER TABLE PlanesHotel
    ADD    FOREIGN KEY (idHotel)
    REFERENCES Hotel(id)
    ON DELETE CASCADE
;

ALTER TABLE PlanesHotel
    ADD    FOREIGN KEY (idPlanConsumo)
    REFERENCES PlanDeConsumo(id)
    ON DELETE CASCADE
;

ALTER TABLE ConsumoReserva
    ADD    FOREIGN KEY (idReserva)
    REFERENCES Reserva(id)
    ON DELETE CASCADE
;

ALTER TABLE ConsumoReserva
    ADD    FOREIGN KEY (idPlanConsumo)
    REFERENCES PlanDeConsumo(id)
    ON DELETE CASCADE
;

ALTER TABLE ServiciosPlanConsumo
    ADD    FOREIGN KEY (idPlanConsumo)
    REFERENCES PlanDeConsumo(id)
    ON DELETE CASCADE
;

ALTER TABLE ServiciosPlanConsumo
    ADD    FOREIGN KEY (idServicio)
    REFERENCES Servicio(id)
    ON DELETE CASCADE
;

ALTER TABLE HorarioServicio
    ADD    FOREIGN KEY (idServicio)
    REFERENCES Servicio(id)
    ON DELETE CASCADE
;

ALTER TABLE HorarioServicio
   ADD CHECK (inicioServicio <= finalServicio AND finalServicio >= inicioServicio)
;

ALTER TABLE CuentaConsumo
    ADD    FOREIGN KEY (idReserva)
    REFERENCES Reserva(id)
    ON DELETE CASCADE
;

ALTER TABLE UtenciliosPrestados
    ADD    FOREIGN KEY (idReserva)
    REFERENCES Reserva(id)
    ON DELETE CASCADE
;

ALTER TABLE UtenciliosPrestados
    ADD    FOREIGN KEY (idUtencilio)
    REFERENCES Utencilio(id)
    ON DELETE CASCADE
;

ALTER TABLE ProductosFactura
    ADD    FOREIGN KEY (idProducto)
    REFERENCES Producto(id)
    ON DELETE CASCADE
;

ALTER TABLE Factura
    ADD    FOREIGN KEY (idServicio)
    REFERENCES Servicio(id)
    ON DELETE CASCADE
;

ALTER TABLE ProductosFactura
    ADD    FOREIGN KEY (idFactura)
    REFERENCES Factura(id)
    ON DELETE CASCADE
;

ALTER TABLE ServiciosTomados
    ADD    FOREIGN KEY (idReserva)
    REFERENCES Factura(id)
    ON DELETE CASCADE
;

ALTER TABLE ServiciosTomados
    ADD    FOREIGN KEY (idServicio)
    REFERENCES Servicio(id)
    ON DELETE CASCADE
;

ALTER TABLE ReservaServicio
    ADD    FOREIGN KEY (idReserva)
    REFERENCES Factura(id)
    ON DELETE CASCADE
;

ALTER TABLE ReservaServicio
    ADD    FOREIGN KEY (idServicio)
    REFERENCES Servicio(id)
    ON DELETE CASCADE
;

ALTER TABLE Habitacion
    ADD    FOREIGN KEY (idTipoHabitacion)
    REFERENCES TipoHabitacion(id)
    ON DELETE CASCADE
;

ALTER TABLE Persona
    ADD    FOREIGN KEY (idTipoDocumento)
    REFERENCES TipoDocumento(id)
    ON DELETE CASCADE
;

ALTER TABLE Servicio
    ADD    FOREIGN KEY (idTipoServicio)
    REFERENCES TipoServicio(id)
    ON DELETE CASCADE
;

ALTER TABLE Producto
    ADD    FOREIGN KEY (idServicio)
    REFERENCES Servicio(id)
    ON DELETE CASCADE
;

ALTER TABLE PlanDeConsumo
    ADD    FOREIGN KEY (idTipoConsumo)
    REFERENCES TipoConsumo(id)
    ON DELETE CASCADE
;