INSERT IGNORE INTO Usuarios (nombre, apellido, email, password) VALUES
('Juan', 'Pérez', 'juan.perez@example.com', 'password123'),
('María', 'González', 'maria.gonzalez@example.com', 'password123'),
('Carlos', 'Lopez', 'carlos.lopez@example.com', 'password123'),
('Ana', 'Martínez', 'ana.martinez@example.com', 'password123'),
('Luis', 'Ramírez', 'luis.ramirez@example.com', 'password123');



INSERT IGNORE INTO tipo_sangre (grupo_sanguineo, factor_rh) VALUES
('A', '+'),
('B', '+'),
('O', '-'),
('AB', '+'),
('O', '+');



INSERT IGNORE INTO centro (nombre, direccion, telefono) VALUES
('Centro de Salud Central', 'Av. Reforma 123, Ciudad', '12345678'),
('Hospital San Juan', 'Calle Principal 45, Ciudad', '23456789'),
('Clínica Santa María', 'Zona 1, Ciudad', '34567890'),
('Unidad Médica La Esperanza', 'Colonia Las Flores, Ciudad', '45678901'),
('Centro de Atención Vital', 'Barrio San José, Ciudad', '56789012');



INSERT INTO donador
(nombres, apellidos, dpi, fecha_nacimiento, genero, telefono, email, direccion, id_tipo_sangre, fecha_ultima_donacion, elegible, fecha_creacion)
VALUES
('Carlos', 'Ramírez', '1234567890123', '1990-05-12', 'Masculino', '12345678', 'carlos.ramirez@gmail.com', 'Calle 1 #23', 1, '2025-01-15', true, '2025-10-08'),
('María', 'Gómez', '2345678901234', '1985-08-23', 'Femenino', '87654321', 'maria.gomez@gmail.com', 'Avenida 5 #45', 2, '2025-06-20', true, '2025-10-08'),
('Luis', 'Fernández', '3456789012345', '1992-11-02', 'Masculino', '11223344', 'luis.fernandez@gmail.com', 'Zona 2 #12', 3, '2025-07-10', true, '2025-10-08'),
('Ana', 'López', '4567890123456', '1988-03-18', 'Femenino', '22334455', 'ana.lopez@gmail.com', 'Colonia Central #7', 1, '2025-09-01', true, '2025-10-08'),
('Sofía', 'Martínez', '5678901234567', '1995-12-30', 'Femenino', '33445566', 'sofia.martinez@gmail.com', 'Callejón 9 #11', 2, '2025-08-15', true, '2025-10-08'),
('Sofía', 'Martínez', '8977755534', '1995-12-30', 'Femenino', '33445566', 'sofia.martinez@gmail.com', 'Callejón 9 #11', 2, '2025-08-15', false, '2025-10-08');





INSERT IGNORE INTO jornada (nombre_jornada, fecha_inicio, fecha_fin, id_centro, meta_unidades) VALUES
('Jornada de Sangre Central', '2025-10-15', '2025-10-15', 1, 50),
('Jornada Hospital San Juan', '2025-10-20', '2025-10-20', 2, 40),
('Jornada Clínica Santa María', '2025-11-01', '2025-11-01', 3, 30),
('Jornada Unidad Médica Esperanza', '2025-11-10', '2025-11-10', 4, 20),
('Jornada Centro Vital', '2025-11-20', '2025-11-20', 5, 25);



INSERT IGNORE INTO enfermero (nombres, apellidos, colegiado, telefono, email, id_centro) VALUES
('Marcos', 'García', 'C-12345', '51123456', 'marcos.garcia@example.com', 1),
('Elena', 'Santos', 'C-23456', '51234567', 'elena.santos@example.com', 2),
('David', 'Ortiz', 'C-34567', '51345678', 'david.ortiz@example.com', 3),
('Claudia', 'Rivas', 'C-45678', '51456789', 'claudia.rivas@example.com', 4),
('Fernando', 'Lozano', 'C-56789', '51567890', 'fernando.lozano@example.com', 5);



INSERT IGNORE INTO cita (fecha_cita, hora, estado, id_donador, id_centro, id_jornada) VALUES
('2025-10-15', '08:00:00', 'Programada', 1, 1, 1),
('2025-10-20', '09:30:00', 'Programada', 2, 2, 2),
('2025-11-01', '10:00:00', 'Programada', 3, 3, 3),
('2025-11-10', '11:15:00', 'Programada', 4, 4, 4),
('2025-11-20', '14:00:00', 'Programada', 5, 5, 5);


INSERT IGNORE INTO donacion (id_cita, id_enfermero, volumen_ml, resultado_serologia, codigo_unidad) VALUES
(1, 1, 450, 'Negativo', 'UNI-20251008-001'),
(2, 2, 500, 'Negativo', 'UNI-20251008-002'),
(3, 3, 400, 'Negativo', 'UNI-20251008-003'),
(4, 4, 350, 'Negativo', 'UNI-20251008-004'),
(5, 5, 420, 'Negativo', 'UNI-20251008-005');

