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
                    dpi: query_string('dpi') 
                },
                success: function(data) {
                                        
                    var $nameP = 'nombreC';
                    document.getElementById($nameP).value= data[0].nombre;
                    
                    var $lastNameP = 'apellidoC';
                    document.getElementById($lastNameP).value= data[0].apellido;
                    
                    var $phoneC = 'telC';
                    document.getElementById($phoneC).value= data[0].telefono;
                    
                    var $polizaType = 'tipoPolizaC';
                    document.getElementById($polizaType).value= data[0].tipo_poliza;
                    
                    /*var $polizaNum = 'polizaIdC';
                    document.getElementById($polizaNum).value= data[0].dpi;*/
                    
                },
                error : function() {
                    var $pData = $('#patientData');
                    $pData.empty();
                    $pData.append("<tr><td>No hay datos disponibles</td></tr>");
                }
            });
});




























