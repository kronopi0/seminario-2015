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
insert into CLIENTES values (111, 'ArcosDorados', 'Argentina', '4555-1463', 'Sarasa 415', 'contacto@arcos.com')
GO
insert into CLIENTES values (222, 'Danone', 'Argentina', '4555-2242', 'Cabildo 5643', 'contacto@danone.com')
GO
insert into CLIENTES values (333, 'Coca-Cola', 'Argentina', '4555-3333', 'Belgrano 467', 'contacto@coca-cola.com')
GO
insert into CLIENTES values (444, 'Matarazzo', 'Argentina', '4554-1111', 'Villa 31', 'contacto@matarazzo.com')
GO
insert into CLIENTES values (555, 'UADE', 'Argentina', '4555-1535', 'Italia 2', 'contacto@uade.com')
GO
insert into CLIENTES values (666, 'Unilever', 'Argentina', '4754-1111', 'Reconquista 415', 'contacto@unilever.com')
GO

--EMPLEADOS
insert into EMPLEADOS values (111111, 'Juan', 'Godoy')
GO
insert into EMPLEADOS values (222222, 'Manuel', 'Alen')
GO
insert into EMPLEADOS values (333333, 'Roberto', 'Giordano')
GO
insert into EMPLEADOS values (444444, 'Eduardo', 'Sara')
GO
insert into EMPLEADOS values (555555, 'Carlos', 'Menem')
GO

--COMPLEJIDADES_EMPLEADO
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (111111,1)
GO
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (111111,2)
GO
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (111111,3)
GO
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (222222,2)
GO
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (333333,2)
GO
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (333333,3)
GO
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (444444,2)
GO
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (444444,3)
GO
INSERT INTO COMPLEJIDADES_EMPLEADO VALUES (555555,3)
GO

--TIPOS_PEDIDO_EMPLEADO
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (111111,1)
GO
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (111111,2)
GO
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (111111,3)
GO
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (222222,1)
GO
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (333333,1)
GO
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (333333,2)
GO
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (444444,1)
GO
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (444444,2)
GO
INSERT INTO TIPOS_PEDIDO_EMPLEADO VALUES (555555,1)
GO

/*
--PEDIDOS Programados

INSERT INTO PEDIDOS VALUES
           ( 'Reporte mensual',
           0,
			getdate(),
			null,
			getdate()+5,
			null,
           'Programado',
           1,
           3,
		   111,
           1362378)
GO
INSERT INTO PEDIDOS VALUES
           ( 'Informe semanal',
           0,
			getdate(),
			null,
			getdate()+3,
			null,
           'Programado',
           3,
           1,
		   111,
           1362378)
GO
INSERT INTO PEDIDOS VALUES
           ( 'Reporte trimestral',
           0,
			getdate(),
			null,
			getdate()+9,
			null,
           'Programado',
           2,
           1,
		   111,
           1352854)
GO
INSERT INTO PEDIDOS VALUES
           ( 'Reporte custom',
           0,
			getdate(),
			null,
			getdate()+5,
			null,
           'Programado',
           1,
           3,
		   111,
           1352854)
GO

--PEDIDOS pendientes

INSERT INTO PEDIDOS VALUES
           ( 'Reporte mensual',
           0,
			getdate(),
			null,
			getdate()+5,
			null,
          'Pendiente',
			null,
           null,
		   111,
           null)
GO
INSERT INTO PEDIDOS VALUES
           ( 'Informe semanal',
           0,
			getdate(),
			null,
			getdate()+3,
			null,
           'Pendiente',
           null,
           null,
		   111,
           null)
GO
INSERT INTO PEDIDOS VALUES
           ( 'Reporte trimestral',
           0,
			getdate(),
			null,
			getdate()+9,
			null,
           'Pendiente',
            null,
           null,
		   111,
           null)
GO
INSERT INTO PEDIDOS VALUES
           ( 'Reporte custom',
            0,
			getdate(),
			null,
			getdate()+5,
			null,
           'Pendiente',
           null,
           null,
		   111,
           null)
GO
*/

--PEDIDOS finalizados

INSERT INTO PEDIDOS(descripcion, periodicidad, fechaSolicitud, fechaInicio, fechaFinalizado, fechaEntrega,
	estado, idComplejidad, idTipoPedido, cuit, idEmpleado) VALUES
           ('TEST - Reporte mensual',
           	0,
			getdate(),
			getdate(),
			getdate()+7,
			getdate()+5,
           'Finalizado',
           	1,
           	1,
		   	111,
           	111111)
GO
INSERT INTO PEDIDOS(descripcion, periodicidad, fechaSolicitud, fechaInicio, fechaFinalizado, fechaEntrega,
	estado, idComplejidad, idTipoPedido, cuit, idEmpleado) VALUES
           ('TEST - Informe semanal',
           	0,
			getdate(),
			getdate(),
			getdate()+6,
			getdate()+3,
           'Finalizado',
           	1,
          	2,
		   	111,
           	111111)
GO
INSERT INTO PEDIDOS(descripcion, periodicidad, fechaSolicitud, fechaInicio, fechaFinalizado, fechaEntrega,
	estado, idComplejidad, idTipoPedido, cuit, idEmpleado) VALUES
           ('TEST - Reporte trimestral',
           	0,
			getdate(),
			getdate(),
			getdate()+7,
			getdate()+9,
           'Finalizado',
          	3,
           	1,
		   	111,
           	333333)
GO
INSERT INTO PEDIDOS(descripcion, periodicidad, fechaSolicitud, fechaInicio, fechaFinalizado, fechaEntrega,
	estado, idComplejidad, idTipoPedido, cuit, idEmpleado) VALUES
           ('TEST - Reporte custom',
           	0,
			getdate(),
			getdate(),
			getdate()+7,
			getdate()+5,
           'Finalizado',
           	1,
           	2,
		   	111,
           	333333)
GO
