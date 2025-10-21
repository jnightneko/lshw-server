# lshw-server

Servidor para recuperar información de equipos de computo de forma masiva

## Cliente

Es necesario instalar los siguientes paquetes en los clientes

1. Muestra información detallada de todo el hardware. Se puede usar con opciones para filtrar la información.
```shell
sudo apt-get install pciutils
```

2.  Muestra información específica sobre la CPU, como arquitectura, número de núcleos y modelo.
```shell
sudo apt-get install lshw
```

3. Descargar el script automatizado del cliente
```shell
wget https://github.com/jnightneko/lshw-server/blob/master/scripts/lshw-client.sh
```

4. Ejecutar el cliente con permisos
```shell
sudo chmod +x lshw-client.sh

sudo ./lshw-client.sh
```