1
select 
	p.ID_Proyecto, 
	p.Clasificacion, 
	sum(c.Cantidad * mc.Precio_Unidad) as "Gasto_Compras", 
	p.Serial 
from Proyecto p 
join Compra c on p.ID_Proyecto = c.ID_Proyecto
join MaterialConstruccion mc on c.ID_MaterialConstruccion = mc.ID_MaterialConstruccion
group by p.ID_Proyecto 
order by Gasto_Compras desc
limit 10


2
select l.ID_Lider, l.Nombre, l.Primer_Apellido, l.Clasificacion from Lider l 
where l.Clasificacion != 2.0 and l.Clasificacion != 5.0
order by l.Clasificacion DESC

3
select 
	p.Banco_Vinculado, 
	AVG(tipo.Area_Max) as "Area_Promedio"
from Proyecto p 
join tipo on p.ID_Tipo = tipo.ID_Tipo 
group by p.Banco_Vinculado 
order by Area_Promedio desc

4
select 
	p.Constructora, 
	count(p.Constructora) as "Numero_Proyectos"
from Proyecto p 
group by p.Constructora 
order by Numero_Proyectos desc

5
select 
	mc.Nombre_Material, 	
	mc.Importado, 
	count(mc.Nombre_Material) as "No_Compras"
from MaterialConstruccion mc
join Compra c on mc.ID_MaterialConstruccion = c.ID_MaterialConstruccion 
where mc.Importado = "Si"
group by mc.Nombre_Material 
order by No_Compras desc