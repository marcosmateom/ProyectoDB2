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
        function() {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/proyectoDB2-seguro/restC/cliente/getCliente',
                dataType: 'json',
                data: { 
                    pId: query_string('dpi') 
                },
                success: function(data) {
                    var $name = $('#nombreC');
                    $name.append(data[0].nombre);
                    
                    var $lastName = $('#apellidoC');
                    $lastName.append(data[0].apellido);
                    
                    var $fNac = $('#fNacC');
                    $fNac.append(data[0].fNacimiento);
                    
                    var $dir = $('#direccionC');
                    $dir.append(data[0].dir);
                    
                    var $tel = $('#telC');
                    $tel.append(data[0].tel);
                    
                    var $segNum = $('#polizaIdC');
                    $segNum.append(data[0].segNum);
                    
                    var $aseguradora = $('#tipoPolizaC');
                    $aseguradora.append(data[0].asegName);
                },
                error : function() {
                    var $pData = $('#patientData');
                    $pData.empty();
                    $pData.append("<tr><td>No hay datos disponibles</td></tr>");
                }
            });
});







