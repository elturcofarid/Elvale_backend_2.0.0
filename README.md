Instrucciones para crear la bd
 abre una consola  CDM y ejecuta el siguiente comando en la ruta principal del repo

1. Creación imagen con configuración el vale
  docker build -f DockerfileSql -t  postgres15:elvale .

2. Creación del contenedor de BD
  docker run -d -p5432:5432  --name postgres2 postgres15:elvale

3. Ingresa en el Dbeaver y prueba la conexión



Creación y levantamiento del Backend

1. crear imagen backend
    mvn clean package \n
    docker build -t elvale_backend:2.0.0 . \n

2. levantar contenedor
   docker run -d -p8083:8083 --name elvale-backend  elvale_backend:2.0.0



 
