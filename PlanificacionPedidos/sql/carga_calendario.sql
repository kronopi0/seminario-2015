-------------------------------------------
---CREACION TABLAS FESTIVOS Y CALENDARIO---
-------------------------------------------
CREATE TABLE [dbo].[FESTIVOS](
    [nombre] [nvarchar](255) NULL,
    [fecha] [datetime] NULL
) ON [PRIMARY]

CREATE TABLE [dbo].[CALENDARIO](
    [id] [int] IDENTITY(1,1) NOT NULL,
   [fecha] [datetime] NOT NULL,
    [diahabil] [bit] NOT NULL,
 CONSTRAINT [PK_Calendario] PRIMARY KEY CLUSTERED 
(
    [Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

--Asignacion de lenguage de la sesion de base de datos
SET LANGUAGE SPANISH

---------------------------------------------
---INSERCION DE DATOS EN LA TABLA FESTIVOS---
---------------------------------------------
--Enero
INSERT [dbo].[FESTIVOS] ([nombre], [fecha]) VALUES ('Año Nuevo', '1/1/2015')
--Febrero
INSERT [dbo].[FESTIVOS] ([nombre], [fecha]) VALUES ('Carnaval', '16/2/2015')
INSERT [dbo].[FESTIVOS] ([nombre], [fecha]) VALUES ('Carnaval', '17/2/2015')
--Marzo
INSERT [dbo].[FESTIVOS] ([nombre], [fecha]) VALUES ('Día Nacional de la Memoria por la Verdad y la Justicia', '24/3/2015')
--Abril
INSERT [dbo].[FESTIVOS] ([nombre], [fecha]) VALUES ('Día del Veterano y de los Caídos en la Guerra de Malvinas', '2/4/2015')
INSERT [dbo].[FESTIVOS] ([nombre], [fecha]) VALUES ('Viernes Santo', '3/4/2015')
--Mayo
INSERT [dbo].[FESTIVOS] ([nombre], [fecha]) VALUES ('Día del trabajador', '1/5/2015')
INSERT [dbo].[FESTIVOS] ([nombre], [fecha]) VALUES ('Día de la Revolución de Mayo', '25/5/2015')
--Junio
INSERT [dbo].[FESTIVOS] ([nombre], [fecha]) VALUES ('Día Paso a la Inmortalidad del General Manuel Belgrano', '20/6/2015')
--Julio
INSERT [dbo].[FESTIVOS] ([nombre], [fecha]) VALUES ('Día de la Independencia', '9/7/2015')
--Agosto
INSERT [dbo].[FESTIVOS] ([nombre], [fecha]) VALUES ('Paso a la Inmortalidad del General José de San Martín', '17/8/2015')
--Octubre
INSERT [dbo].[FESTIVOS] ([nombre], [fecha]) VALUES ('Día del Respeto a la Diversidad Cultural', '12/10/2015')
--Noviembre
INSERT [dbo].[FESTIVOS] ([nombre], [fecha]) VALUES ('Día de la Soberanía Nacional', '23/11/2015')
--Diciembre
INSERT [dbo].[FESTIVOS] ([nombre], [fecha]) VALUES ('Inmaculada Concepción de María', '9/12/2015')
INSERT [dbo].[FESTIVOS] ([nombre], [fecha]) VALUES ('Navidad', '25/12/2015')



---------------------------------------------------------
---SCRIPT DE INSERCION DE DATOS EN LA TABLA CALENDARIO---
---------------------------------------------------------




--Fecha inicial desde la cual se va a crear la tabla con los dias festivos
DECLARE @fecha AS DATETIME
SET @fecha = '2015-01-01 00:00:00.000'


--Se eliminan datos de la tabla de Fechas
IF EXISTS(SELECT name FROM sysobjects WHERE name = 'FECHAS' AND xtype='U')
    DROP TABLE FECHAS
create table FECHAS( 
fecha datetime
)


-- Se inserta las fechas para el año calendario 2015-01-01
while (@fecha < '2016-01-01 00:00:00.000')
begin
    INSERT INTO fechas
    SELECT @fecha
    SELECT @fecha = @fecha + 1
END


--Se declara cursor para generar la insercion de datos en la tabla tiempo
DECLARE fechas_cursor CURSOR FOR
SELECT fecha FROM FECHAS
 
OPEN fechas_cursor
 
FETCH NEXT FROM fechas_cursor
INTO @fecha
 
WHILE @@FETCH_STATUS = 0
BEGIN
    INSERT INTO CALENDARIO
    SELECT @fecha fecha,
           CASE WHEN DATEPART(DW, @fecha) = 6 THEN 0 -- Se marca el dia sabado como dia no habil
                WHEN DATEPART(DW, @fecha) = 7 THEN 0 -- Se marca el dia domingo como dia no habil
                ELSE 1 END diahabil
 
    FETCH NEXT FROM fechas_cursor
    INTO @fecha
END
CLOSE fechas_cursor;
DEALLOCATE fechas_cursor;
 

-- Se marcan los dias festivos como dias no habiles en la tabla Calendario
UPDATE CALENDARIO 
SET diahabil = 0
FROM CALENDARIO C INNER JOIN FESTIVOS F ON Convert(varchar(10),C.fecha,101) = Convert(varchar(10),F.[fecha],101)
 

--Eliminar tabla temporal
IF EXISTS(SELECT name FROM sysobjects WHERE name = 'FECHAS' AND xtype='U')
    DROP TABLE FECHAS


--Resultado final
select * from CALENDARIO