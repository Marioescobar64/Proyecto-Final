INSERT IGNORE INTO Usuarios (nombre, apellido, email, password) VALUES
('Mario', 'Díaz', 'mario.diaz@correo.com', '12345'),
('Lucía', 'García', 'lucia.garcia@correo.com', '12345'),
('Carlos', 'López', 'carlos.lopez@correo.com', '12345'),
('Ana', 'Martínez', 'ana.martinez@correo.com', '12345'),
('Sofía', 'Ramírez', 'sofia.ramirez@correo.com', '12345');




INSERT IGNORE INTO tipo_sangre (grupo_sanguineo, factor_rh) VALUES
('A', '+'),
('A', '-'),
('B', '+'),
('B', '-'),
('AB', '+'),
('AB', '-'),
('O', '+'),
('O', '-');



INSERT IGNORE INTO centro (nombre, direccion, telefono) VALUES
('Centro Nacional de Donación', 'Zona 1, Ciudad Capital', '50112233'),
('Banco de Sangre Regional Norte', 'Zona 5, Cobán', '50223344'),
('Centro Médico del Sur', 'Zona 4, Escuintla', '50334455'),
('Hospital General Central', 'Zona 9, Ciudad Capital', '50445566'),
('Clínica La Esperanza', 'Zona 2, Quetzaltenango', '50556677');




INSERT IGNORE INTO donador
(nombres, apellidos, dpi, edad, fecha_nacimiento, genero, telefono, email, direccion, id_tipo_sangre, fecha_ultima_donacion, elegible, fecha_creacion)
VALUES
('Pedro', 'Alvarado', '1234567890101', 39, '1986-04-12', 'Masculino', '50123456', 'pedro.alvarado@example.com', 'Zona 1, Ciudad Capital', 1, '2025-06-01', TRUE, '2025-01-01'),
('Lucía', 'Mejía', '2345678901234', 34, '1991-08-23', 'Femenino', '50234567', 'lucia.mejia@example.com', 'Zona 2, Ciudad Capital', 2, '2025-05-15', TRUE, '2025-01-02'),
('Miguel', 'Hernández', '3456789012345', 43, '1982-01-30', 'Masculino', '50345678', 'miguel.hernandez@example.com', 'Zona 3, Cobán', 3, '2025-07-10', TRUE, '2025-01-03'),
('Sofía', 'Cruz', '4567890123456', 30, '1995-11-05', 'Femenino', '50456789', 'sofia.cruz@example.com', 'Zona 4, Escuintla', 4, '2025-06-20', TRUE, '2025-01-04'),
('Ricardo', 'Vásquez', '5678901234567', 37, '1988-03-17', 'Masculino', '50567890', 'ricardo.vasquez@example.com', 'Zona 5, Quetzaltenango', 5, '2025-07-01', TRUE, '2025-01-05');





INSERT IGNORE INTO jornada (nombre_jornada, fecha_inicio, fecha_fin, id_centro, meta_unidades) VALUES
('Jornada Vida', '2025-06-01', '2025-06-05', 1, 100),
('Donación Esperanza', '2025-07-10', '2025-07-15', 2, 80),
('Héroes del Sur', '2025-08-01', '2025-08-03', 3, 60),
('Salvando Vidas', '2025-09-01', '2025-09-04', 4, 120),
('Corazón Solidario', '2025-10-01', '2025-10-03', 5, 90);




INSERT IGNORE INTO enfermero
(nombres, apellidos, colegiado, telefono, email, id_centro, idUsuario) VALUES
('María', 'González', 'ENF-001', '60112233', 'maria.gonzalez@centro1.com', 1, 1),
('José', 'Pérez', 'ENF-002', '60223344', 'jose.perez@centro2.com', 2, 2),
('Ana', 'Morales', 'ENF-003', '60334455', 'ana.morales@centro3.com', 3, 3),
('Luis', 'Hernández', 'ENF-004', '60445566', 'luis.hernandez@centro4.com', 4, 4),
('Elena', 'Ramírez', 'ENF-005', '60556677', 'elena.ramirez@centro5.com', 5, 5);




INSERT IGNORE INTO cita
(fecha_cita, hora, estado, id_donador, id_centro, id_jornada) VALUES
('2025-06-02', '09:00:00', 'Programada', 1, 1, 1),
('2025-07-11', '10:00:00', 'Programada', 2, 2, 2),
('2025-08-02', '08:30:00', 'Programada', 3, 3, 3),
('2025-09-02', '11:00:00', 'Programada', 4, 4, 4),
('2025-10-02', '09:45:00', 'Programada', 5, 5, 5);



INSERT IGNORE INTO donacion
(id_cita, id_enfermero, fecha_donacion, volumen_ml, resultado_serologia, codigo_unidad) VALUES
(1, 1, '2025-06-02', 450, 'Negativo', 'UNID-001'),
(2, 2, '2025-07-11', 470, 'Negativo', 'UNID-002'),
(3, 3, '2025-08-02', 460, 'Negativo', 'UNID-003'),
(4, 4, '2025-09-02', 480, 'Negativo', 'UNID-004'),
(5, 5, '2025-10-02', 455, 'Negativo', 'UNID-005');

