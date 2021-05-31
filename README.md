# Grupo2_LabTBD
Entrega para laboratorio del GRUPO 2 de TBD

Instrucciones de instalación:
1) Descargar o clonar repositorio:

       git clone https://github.com/Vanessa-a/Grupo2_LabTBD
    
2) Ejecutar scripts SQL:
      
      a) Abrir terminal
      
      b) Ejectuar comando en terminal:
      
       sudo su - postgres
            
      c) Ejecutar comando en terminal:
      
       psql -f [rutadelarchivo]/tables_db_emergencies.sql
            
      d) Ejecutar comando en terminal:
      
       psql -f [rutadelarchivo]/data_db_emergencies.sql
            
      e) Cerrar terminal
      
3) Descomprimir frontVfinal.zip en la misma carpeta raíz
4) Abrir terminal en carpeta demo, ejecutar:

    ./gradlew bootRun

5) Abrir terminal en nueva carpeta front creada, ejecutar:

    npm install @nuxtjs/axios

    npm run dev

5) Abrir en navegador la direccion web indicada.
