--1.
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

--------------------------------------------------------------------------------------------------------------
--2.
create procedure diashabiles
@fechaDesde datetime,
@fechaHasta datetime
as
declare @cantidadDias int
declare @idDisponibilidad int = 1

--Calculo la cantidad de dias habiles que va a demandar el pedido
select @cantidadDias=(select(select count(*) from Calendario
where diahabil=1 and (fecha BETWEEN @fechaDesde AND @fechaHasta)))

--Calculo el id para la nueva Disponibilidad
if (select max(idDisponibilidad) from Disponibilidades) is not null
	begin
	select @idDisponibilidad=(select max(idDisponibilidad)+1 from Disponibilidades)
	end

--Devuelvo como resultado la Dispobilidad
select @idDisponibilidad as idDisponibilidad, @fechaDesde as fechaInicio, @fechaHasta as fechaFin, @cantidadDias as cantidadDias

--------------------------------------------------------------------------------------------------------------
--3.
create proc disponibilidad
@idEmpleado int

as
select d.idDisponibilidad,d.fechaInicio,d.fechaFin,d.cantidadDias
from DISPONIBILIDADES d
where d.idEmpleado = @idEmpleado