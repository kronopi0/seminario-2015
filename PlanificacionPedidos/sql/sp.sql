create proc empleados_capacitados
@complejidad varchar(20),
@tipoEstudio varchar(20)
as
select e.idEmpleado, e.nombre, e.apellido from Empleados e
inner join Complejidades_Empleado ce on ce.idempleado=e.idempleado
inner join Complejidades_Pedidos cp on cp.idcomplejidad=ce.idcomplejidad
inner join Tipos_Pedido_Empleado tpe on tpe.idempleado=e.idempleado
inner join Tipos_Pedido tp on tp.idtipopedido=tpe.idtipopedido
where cp.nombre like @complejidad and tp.descripcion like @tipoEstudio