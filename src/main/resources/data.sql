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



INSERT IGNORE INTO centro (nombre, direccion, telefono) VALUES
('Centro de Salud Central', 'Av. Reforma 123, Ciudad', '12345678'),
('Hospital San Juan', 'Calle Principal 45, Ciudad', '23456789'),
('Clínica Santa María', 'Zona 1, Ciudad', '34567890'),
('Unidad Médica La Esperanza', 'Colonia Las Flores, Ciudad', '45678901'),
('Centro de Atención Vital', 'Barrio San José, Ciudad', '56789012');

INSERT IGNORE INTO donador (nombres, apellidos, dpi, fecha_nacimiento, genero, telefono, email, direccion, id_tipo_sangre, fecha_ultima_donacion, elegible) VALUES
('Pedro', 'Alvarado', '1234567890123', '1985-04-12', 'Masculino', '50123456', 'pedro.alvarado@example.com', 'Col. Centro 1', 1, '2025-06-01', true),
('Lucía', 'Mejía', '2345678901234', '1990-08-23', 'Femenino', '50234567', 'lucia.mejia@example.com', 'Col. Norte 2', 2, '2025-05-15', true),
('Miguel', 'Hernández', '3456789012345', '1982-01-30', 'Masculino', '50345678', 'miguel.hernandez@example.com', 'Zona 3', 3, '2025-07-10', true),
('Sofía', 'Cruz', '4567890123456', '1995-11-05', 'Femenino', '50456789', 'sofia.cruz@example.com', 'Barrio San José', 4, '2025-06-20', true),
('Ricardo', 'Vásquez', '5678901234567', '1988-03-17', 'Masculino', '50567890', 'ricardo.vasquez@example.com', 'Col. Las Flores', 5, '2025-07-01', true);



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

