$(document).ready(
        function() {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/proyectoDB2-seguro/restAuth/auth/getAuth',
                dataType: 'json',
                success: function(data) {
                    var $fechaC = $('#fecha');
                    $fechaC.append(data[0].fecha);
                    var $hospNum = $('#hospNum');
                    $hospNum.append(data[0].hospital);
                    var $citaId = $('#citaId');
                    $citaId.append(data[0].idCita);
                    var $serv = $('#serv');
                    $serv.append(data[0].servicio);
                    var $monto = $('#monto');
                    $monto.append(data[0].monto);
                    var $porcentaje = $('#porcentaje');
                    $porcentaje.append(data[0].porcentaje);
                    //obtener el numero del porcentaje
                    var $porcentNum = data[0].porcentaje;
                    var $totalC = $('#totalC');
                    $totalC.append(($porcentNum.split("%")[0]*data[0].monto)/100);
                    var $totalP = $('#totalP');
                    $totalP.append((100-($porcentNum.split("%")[0]))*data[0].monto/100);
                    clientInf(data[0].dpi);
                },
                error : function() {
                    var $pData = $('#authNum');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});
function clientInf(dpiNum) {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/proyectoDB2-seguro/GetCliente',
                dataType: 'json',
                data: { 
                    dpi: dpiNum
                },
                success: function(data) {
                    var $nombreP = $('#nombreP');
                    $nombreP.append(data[0].nombre+" "+data[0].apellido);
                    var $dpi = $('#dpi');
                    $dpi.append(data[0].documentoIdentificacion);
                    var $polizaP = $('#polizaP');
                    $polizaP.append(data[0].tipo_poliza);
                    var $cobN = $('#cobN');
                    $cobN.append(data[0].cobertura);
                    var $tel = $('#tel');
                    $tel.append(data[0].telefono);
                    var $email = $('#email');
                    $email.append(data[0].email);
                },
                error : function() {
                    var $pData = $('#nombreP');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
}
