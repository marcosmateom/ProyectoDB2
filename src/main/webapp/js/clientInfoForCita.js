function getValue(variable)
{
    var value = document.getElementById(variable).value;
    if (value !== null || value !== "") {
        return value;
    } else {
        return("");
    }
}

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
                url: 'http://localhost:8080/proyectoDB2-seguro/GetPatientDPI',
                dataType: 'json',
                data: { 
                    dpi: query_string('dpi'),
                    hosp: query_string('hosp') 
                },
                success: function(data) {
                    
                    var $pInfo = 'pacienteC';
                    document.getElementById($pInfo).value= data[0].nombre+" "+data[0].apellido;
                    
                    var $pId = 'patientId';
                    document.getElementById($pId).value=data[0].id ;
                    
                    
                    
                },
                error : function() {
                    var $pData = $('#patientData');
                    $pData.empty();
                    $pData.append("<tr><td>No hay datos disponibles</td></tr>");
                }
            });
});








































