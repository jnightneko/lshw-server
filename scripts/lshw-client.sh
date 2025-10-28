#!/bin/bash

# _ wil _
#=== -------------------------------------------------- ===
#===            CONFIGURACIÓN DEL SERVIDOR              ===
#=== -------------------------------------------------- ===
LSHW_SERVER=localhost
LSHW_PORT=8080
LSHW_ADDRESS="http://$LSHW_SERVER:$LSHW_PORT/lshw"

# Comando para obtener la configuración de las especificaciones
# de la máquina, tanto del hardware general como la cpu
DETALLE_HARDWARE=$(lshw)
DETALLE_CPU=$(lscpu)

HOST_ADDRESS=$(hostname -I)
FILE_REPORT="report.txt"
FILE_CLIENT="client.json"

# Guardar los dos ficheros con la información necesaria para
# enviarlo al servidor principal (reportes)
echo -e "[ \e[35m..\e[0m ] Escanedando equipo..."

echo "$DETALLE_HARDWARE \n\n $DETALLE_CPU" > $FILE_REPORT;
echo "{\"address\": \"$HOST_ADDRESS\"}" > $FILE_CLIENT;

echo -e "[ \e[32mok\e[0m ] Fichero de reportes generados..."
echo -e "[ \e[33m..\e[0m ] Enviando reporte al servidor pirncipal: $LSHW_SERVER:$LSHW_PORT"


#curl -X POST -F "report=@./$FILE_REPORT" -F "client=@./$FILE_CLIENT" $LSHW_ADDRESS
curl -X POST \
    -H "Content-Type: multipart/form-data"\
    -F "report=@./$FILE_REPORT" \
    -F "client=@./$FILE_CLIENT;type=application/json" \
    $LSHW_ADDRESS


echo ""
echo -e "[ \e[32mok\e[0m ] Reporte enviada ($LSHW_ADDRESS)..."
echo -e "[ \e[33m..\e[0m ] Eliminado ficheros temporales"

rm ./$FILE_REPORT
rm ./$FILE_CLIENT

echo -e "[ \e[32mok\e[0m ] Reporte finalizada..."