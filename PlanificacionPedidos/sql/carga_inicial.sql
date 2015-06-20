--TIPOS_PEDIDO
insert into TIPOS_PEDIDO values ('Powerview', 4)
GO
insert into TIPOS_PEDIDO values ('WPO', 2)
GO
insert into TIPOS_PEDIDO values ('Informe', 8)
GO

--COMPLEJIDADES_PEDIDOS
insert into COMPLEJIDADES_PEDIDOS values ('Alta', 1.5)
GO
insert into COMPLEJIDADES_PEDIDOS values ('Intermedia', 1.2)
GO
insert into COMPLEJIDADES_PEDIDOS values ('Baja', 1)
GO

--CLIENTES
insert into CLIENTES values (11111, 'ArcosDorados', 'Argentina', '4555-1463', 'Sarasa 415', 'contacto@arcos.com')
GO
insert into CLIENTES values (44444, 'Matarazzo', 'Argentina', '4554-1111', 'Villa 31', 'contacto@matarazzo.com')
GO
insert into CLIENTES values (55555, 'UADE', 'Argentina', '4555-1535', 'Italia 2', 'contacto@uade.com')
GO
insert into CLIENTES values (66666, 'Unilever', 'Argentina', '4754-1111', 'Reconquista 415', 'contacto@unilever.com')
GO
insert into CLIENTES values (22222, 'Danone', 'Argentina', '4555-2242', 'Cabildo 5643', 'contacto@danone.com')
GO
insert into CLIENTES values (33333, 'Coca-Cola', 'Argentina', '4555-3333', 'Belgrano 467', 'contacto@coca-cola.com')
GO

--EMPLEADOS
insert into EMPLEADOS values (12601231, 'Juan', 'Alen')
GO
insert into EMPLEADOS values (1362378, 'Juan Manuel', 'Godoy')
GO
insert into EMPLEADOS values (1358354, 'Godoy', 'Martinez')
GO
insert into EMPLEADOS values (1260341, 'Martinez', 'Alen')
GO
insert into EMPLEADOS values (13665378, 'Juan Manuel', 'Martinez Godoy')
GO
insert into EMPLEADOS values (1352854, 'Godoy', 'Juan')
GO

--COMPLEJIDADES_EMPLEADO
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (1362378,1)
GO
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (1358354,1)
GO
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (1358354,2)
GO
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (1260341,2)
GO
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (1358354,3)
GO
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (13665378,3)
GO
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (1352854,3)
GO

--TIPOS_PEDIDO_EMPLEADO
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (1362378,2)
GO
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (1358354,1)
GO
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (1260341,2)
GO
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (1358354,3)
GO
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (1358354,2)
GO
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (13665378,1)
GO
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (1352854,3)
GO


--PEDIDOS Programados

INSERT INTO PEDIDOS VALUES
           ( 'Reporte temprano',
           0,
			getdate(),
			null,
			getdate()+5,
			null,
           'Programado',
           1,
           3,
		   11111,
           1362378)
GO
INSERT INTO PEDIDOS VALUES
           ( 'Informe temprano',
           0,
			getdate(),
			null,
			getdate()+3,
			null,
           'Programado',
           3,
           1,
		   11111,
           1362378)
GO
INSERT INTO PEDIDOS VALUES
           ( 'Reporte genial',
           0,
			getdate(),
			null,
			getdate()+9,
			null,
           'Programado',
           2,
           1,
		   11111,
           1352854)
GO
INSERT INTO PEDIDOS VALUES
           ( 'Soy un pedido',
           0,
			getdate(),
			null,
			getdate()+5,
			null,
           'Programado',
           1,
           3,
		   11111,
           1352854)
GO

--PEDIDOS pendientes

INSERT INTO PEDIDOS VALUES
           ( 'Reporte temprano',
           0,
			getdate(),
			null,
			getdate()+5,
			null,
           'Pendiente',
			null,
           null,
		   11111,
           null)
GO
INSERT INTO PEDIDOS VALUES
           ( 'Informe temprano',
           0,
			getdate(),
			null,
			getdate()+3,
			null,
           'Pendiente',
           null,
           null,
		   11111,
           null)
GO
INSERT INTO PEDIDOS VALUES
           ( 'Reporte genial',
           0,
			getdate(),
			null,
			getdate()+9,
			null,
           'Pendiente',
            null,
           null,
		   11111,
           null)
GO
INSERT INTO PEDIDOS VALUES
           ( 'Soy un pedido',
           0,
			getdate(),
			null,
			getdate()+5,
			null,
           'Pendiente',
           null,
           null,
		   11111,
           null)
GO
--PEDIDOS finalizados

INSERT INTO PEDIDOS VALUES
           ( 'Reporte temprano',
           0,
			getdate(),
			getdate()+7,
			getdate()+5,
			null,
           'Finalizado',
           1,
           1,
		   11111,
           1358354)
GO
INSERT INTO PEDIDOS VALUES
           ( 'Informe temprano',
           0,
			getdate(),
			getdate()+6,
			getdate()+3,
			null,
           'Finalizado',
           1,
          2,
		   11111,
           1358354)
GO
INSERT INTO PEDIDOS VALUES
           ( 'Reporte genial',
           0,
			getdate(),
			getdate()+7,
			getdate()+9,
			null,
           'Finalizado',
           3,
           1,
		   11111,
           1358354)
GO
INSERT INTO PEDIDOS VALUES
           ( 'Soy un pedido',
           0,
			getdate(),
			getdate()+7,
			getdate()+5,
			null,
           'Finalizado',
           1,
           2,
		   11111,
           1358354)
GO
