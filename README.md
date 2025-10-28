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

3. Descargar el script automatizado del cliente y el servidor
```shell
wget https://github.com/jnightneko/lshw-server/releases/download/v.1.0.1/lshw-client.sh

# .zip
wget https://github.com/jnightneko/lshw-server/releases/download/v.1.0.1/lshw-server.zip
# .tar.xz
wget https://github.com/jnightneko/lshw-server/releases/download/v.1.0.1/lshw-server.tar.xz
```

4. Preparar el servidor
```shell
# Con unzip
unzip lshw-server.zip

# Con tar.xz
tar -xJf nlshw-server.tar.xz

# Ejecutar servidor
sudo chmod +x lshw-server.sh
./lshw-server.sh
```

5. Ejecutar el cliente con permisos
```shell
sudo chmod +x lshw-client.sh

sudo ./lshw-client.sh
```