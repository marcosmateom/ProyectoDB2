function query_string(variable)
{
   var query = window.location.search.substring(1);
   var vars = query.split("&");
   for (var i=0;i<vars.length;i++) {
           var pair = vars[i].split("=");
           if(pair[0] == variable){return pair[1];}
   }
   return(false);
}
$(document).ready(
        function(){
            datosAuth(); 
            infoCitas();
});
function datosAuth() {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/proyectoDB2-seguro/GetAuth',
                dataType: 'json',
                data:{
                    idCita:query_string("idCita"),
                    hospNum: query_string('hospNum') 
                },
                success: function(data) {
                    var $hospNum = $('#hospNum');
                    $hospNum.append(data[0].hospital);
                    var $fecha = $('#fecha');
                    $fecha.append(data[0].fecha);
                    var $dpi = $('#dpi');
                    $dpi.append(data[0].dpi);
                    var $serv = $('#serv');
                    $serv.append(data[0].servicio);
                    var $costo = $('#costo');
                    $costo.append(data[0].monto);
                    var $coPago = $('#coPago');
                    var $pago = (data[0].monto*(1-data[0].porcentaje)).toFixed(2);
                    $coPago.append($pago);
                }
            });
}
function infoCitas() {
            var $idNum = $('#idNum');
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/proyectoDB2-seguro/GetCita',
                dataType: 'json',
                data: { 
                    citaId: query_string('idCita'),
                    hosp: query_string('hospNum') 
                },
                success: function(data) {
                    var $pData = $('#historialData');
                    $pData.empty();
                    $pData.append("<h3>Detalles:</h3><article>");
                    $pData.append("<p><strong>Id Cita: </strong> "+data[0].id+"</p><p><strong>Fecha de la cita: </strong>"+data[0].fecha+"</p><p><strong>Area: </strong>"+data[0].cat+"</p><p><strong>Servicio: </strong>"+data[0].subCat+"</p><p><strong>Doctor o Encargado: </strong>"+data[0].docName+" "+data[0].docLastName+"</p><p><strong>Diagnostico: </strong>"+data[0].diag+"</p><p><strong>Resultados: </strong>"+data[0].res+"</p><p><strong>Medicamentos: </strong>"+data[0].meds+"</p><p><strong>Pasos a seguir: </strong>"+data[0].pasos+"</p><p><strong>Observaciones: </strong>"+data[0].observ+"</p>");
                    $pData.append("</article>");
                    

                },
                error : function() {
                    var $pData = $('#patientData');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
}



