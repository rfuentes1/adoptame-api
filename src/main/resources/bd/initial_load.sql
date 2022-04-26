INSERT INTO rol (nombre)
VALUES ('administrador'), ('albergue');

INSERT INTO usuario(correo, password_hash, activo, fecha_alta, id_rol)
VALUES ('sociedad@opa.org', '$2b$10$zJ2CDAFElHKQnWM7cbWQaOwuNARqQw8Jd7898fzChulbow32d/ody', true, date('2015-12-17'), 1),
       ('frucevolucion12@gmail.com', '$2b$10$S0OQjgLoCM1RX6nBe3oOJOmFbRcY.tzgjdY4PSfLV.MA6FUX38cDy', false, date('2021-11-02'), 2),
       ('a.c.proanimal@gmail.com', '$2b$10$nIqon8bT5E2YwRntvUVWAe6BPcZkA6wUrdOBfhnJVKCPplJuU55ci', true, date('2021-12-01'), 2);

INSERT INTO albergue(nombre, direccion, contacto, telefono, correo)
VALUES ('Sociedad por los Animalitos', 'Calle 11B Col Los Girasoles Mérida Yucatán', 'Mila Martinez', '999 5678243', 'sociedad@opa.org' ),
       ('Evolución Animal', 'Merida-Uman, Fracc. San Lorenzo', 'Francisco Uc', '999 1930628', 'frucevolucion12@gmail.com'),
       ('Acción pro animal AC', 'Calle 46 No. 400 x 21 Fraccionamiento Pacabtun', 'Gilberto Vaquerano', '999 7487079','a.c.proanimal@gmail.com');

INSERT INTO mascota(nombre, tipo_mascota, sexo, fecha_nacimiento, raza, descripcion, castrado, fecha_registro, disponible, id_albergue)
VALUES ('Gato', 'Gato', 'Macho', date('2015-03-27'), 'Domestico pelo medio', 'Es un gato de tamaño gande, muy juguetón, le gustan mucho los treats y toma muchas siestas durante el día, su ronroneo es muy bajito.', true, date('2022-04-19'), false, 3),
       ('Mercurio', 'Perro', 'Macho', date('2007-09-09'), 'Mestizo', 'Es un perro juguetón, de pelo corto, tamaño mediano y le gusta comer carne de pollo.', false, date('2017-03-03'), false, 2),
       ('Kiki', 'Gato', 'Hembra', date('2018-06-27'), 'Gato doméstico, pelo largo', 'Es una gatita muy tierna, le gusta correr, su ronroneo es muy fuerte que parece una olla de tamales hirviendo, su maullido es muy pequeño pero cuando tiene hambre puede sonar mucho más.', true, date('2018-01-02'), false, 1);

