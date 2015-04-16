--TIPOS_PEDIDO
insert into TIPOS_PEDIDO values ('Powerview', 4)
insert into TIPOS_PEDIDO values ('WPO', 2)
insert into TIPOS_PEDIDO values ('Informe', 8)

--COMPLEJIDADES_PEDIDOS
insert into COMPLEJIDADES_PEDIDOS values ('Alta', 1.5)
insert into COMPLEJIDADES_PEDIDOS values ('Intermedia', 1.2)
insert into COMPLEJIDADES_PEDIDOS values ('Baja', 1)

--CLIENTES
insert into CLIENTES values (11111, 'ArcosDorados', 'Argentina', '4555-1463', 'Sarasa 415', 'contacto@arcos.com')
insert into CLIENTES values (44444, 'Matarazzo', 'Argentina', '4554-1111', 'Villa 31', 'contacto@matarazzo.com')
insert into CLIENTES values (55555, 'UADE', 'Argentina', '4555-1535', 'Italia 2', 'contacto@uade.com')
insert into CLIENTES values (66666, 'Unilever', 'Argentina', '4754-1111', 'Reconquista 415', 'contacto@unilever.com')
insert into CLIENTES values (22222, 'Danone', 'Argentina', '4555-2242', 'Cabildo 5643', 'contacto@danone.com')
insert into CLIENTES values (33333, 'Coca-Cola', 'Argentina', '4555-3333', 'Belgrano 467', 'contacto@coca-cola.com')

--EMPLEADOS
insert into EMPLEADOS values (12601231, 'Juan', 'Alen')
insert into EMPLEADOS values (1362378, 'Juan Manuel', 'Godoy')
insert into EMPLEADOS values (1358354, 'Godoy', 'Martinez')
insert into EMPLEADOS values (1260341, 'Martinez', 'Alen')
insert into EMPLEADOS values (13665378, 'Juan Manuel', 'Martinez Godoy')
insert into EMPLEADOS values (1352854, 'Godoy', 'Juan')

--COMPLEJIDADES_EMPLEADO
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (1362378,1)
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (1358354,1)
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (1358354,2)
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (1260341,2)
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (1358354,1)
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (1358354,3)
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (13665378,3)
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (1352854,3)

--TIPOS_PEDIDO_EMPLEADO
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (1362378,2)
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (1358354,1)
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (1358354,1)
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (1260341,2)
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (1358354,3)
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (1358354,2)
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (13665378,1)
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (1352854,3)