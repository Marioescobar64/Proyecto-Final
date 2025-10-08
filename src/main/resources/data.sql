INSERT IGNORE INTO Usuarios (nombre, apellido, email, password, rol) VALUES
('Carlos', 'Ramírez', 'carlos.ramirez@gmail.com', '12345', 'administrador'),
('María', 'Gómez', 'maria.gomez@gmail.com', 'abcde', 'Usuario'),
('Luis', 'Fernández', 'luis.fernandez@gmail.com', 'pass123', 'Usuario'),
('Ana', 'López', 'ana.lopez@gmail.com', 'admin2024', 'administrador'),
('Sofía', 'Martínez', 'sofia.martinez@gmail.com', 'sof123', 'Usuario');


INSERT IGNORE INTO tipo_sangre (grupo_sanguineo, factor_rh) VALUES
('A', '+'),
('A', '-'),
('B', '+'),
('O', '+'),
('AB', '-');


INSERT IGNORE INTO donador (nombres, apellidos, dpi, fecha_nacimiento, genero, telefono, email, direccion, id_tipo_sangre, fecha_ultima_donacion, elegible) VALUES
('Juan', 'Pérez', '1234567890101', '1990-05-12', 'Masculino', '45678901', 'juan.perez@gmail.com', 'Zona 1, Guatemala', 1, '2025-05-10', true),
('Lucía', 'Ramírez', '2345678901212', '1988-09-23', 'Femenino', '47890123', 'lucia.ramirez@gmail.com', 'Mixco, Guatemala', 2, '2024-10-15', true),
('Pedro', 'López', '3456789012323', '1995-02-17', 'Masculino', '48901234', 'pedro.lopez@gmail.com', 'Villa Nueva', 3, null, true),
('Carla', 'Hernández', '4567890123434', '1992-07-30', 'Femenino', '49012345', 'carla.hernandez@gmail.com', 'Zona 7, Guatemala', 4, '2025-02-01', false),
('Miguel', 'Duarte', '5678901234545', '1998-11-05', 'Masculino', '50123456', 'miguel.duarte@gmail.com', 'Amatitlán', 5, null, true);


INSERT IGNORE INTO centro (nombre, direccion, telefono) VALUES
('Hospital San Juan de Dios', '6a Avenida 7-55, Zona 1, Guatemala', '22004567'),
('Hospital Roosevelt', 'Calzada Roosevelt 6-55, Zona 11, Guatemala', '22113344'),
('Banco Nacional de Sangre', 'Zona 9, Guatemala', '22334455'),
('Centro Médico de Mixco', 'Boulevard El Naranjo, Mixco', '22556677'),
('Hospital de Villa Nueva', 'Zona 5, Villa Nueva', '22887766');


INSERT IGNORE INTO jornada (nombre_jornada, fecha_inicio, fecha_fin, id_centro, meta_unidades) VALUES
('Jornada de Donación Mayo 2025', '2025-05-01', '2025-05-03', 1, 200),
('Campaña “Vida por Vida”', '2025-06-10', '2025-06-12', 2, 150),
('Donación Universitaria USAC', '2025-07-15', '2025-07-17', 3, 300),
('Ayuda al Prójimo', '2025-08-05', '2025-08-06', 4, 100),
('Semana Roja', '2025-09-20', '2025-09-22', 5, 250);


INSERT IGNORE INTO enfermero (nombres, apellidos, colegiado, telefono, email, id_centro) VALUES
('Andrea', 'González', 'ENF-1001', '33445566', 'andrea.gonzalez@hospital.com', 1),
('Ricardo', 'López', 'ENF-1002', '33446677', 'ricardo.lopez@hospital.com', 2),
('Paola', 'Martínez', 'ENF-1003', '33447788', 'paola.martinez@hospital.com', 3),
('Javier', 'Santos', 'ENF-1004', '33448899', 'javier.santos@hospital.com', 4),
('Laura', 'Reyes', 'ENF-1005', '33449900', 'laura.reyes@hospital.com', 5);


INSERT IGNORE INTO cita (id_donador, id_centro, id_jornada, fecha_hora_cita, estado) VALUES
(1, 1, 1, '2025-05-01 09:00:00', 'Completada'),
(2, 2, 2, '2025-06-10 10:30:00', 'Programada'),
(3, 3, 3, '2025-07-15 08:00:00', 'Completada'),
(4, 4, 4, '2025-08-05 09:15:00', 'Cancelada'),
(5, 5, 5, '2025-09-20 10:00:00', 'Completada');


INSERT IGNORE INTO donacion (id_cita, id_enfermero, volumen_ml, resultado_serologia, codigo_unidad) VALUES
(1, 1, 450, 'Negativo', 'UNID-0001'),
(3, 3, 470, 'Negativo', 'UNID-0002'),
(5, 5, 460, 'Positivo Hepatitis', 'UNID-0003'),
(1, 2, 455, 'Negativo', 'UNID-0004'),
(3, 4, 480, 'Negativo', 'UNID-0005');
