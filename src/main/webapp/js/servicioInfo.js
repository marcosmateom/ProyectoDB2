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
                url: 'http://25.74.104.162:8080/proyectoDB2-seguro/HospitalServicio',
                dataType: 'json',
                data: { 
                    servicioId: query_string('servicioId'),
                    hosp: query_string('hosp')
                },
                success: function(data) {
                    
                    var $service = 'serviceName';
                    document.getElementById($service).value= data[0].subcat;
                    
                    var $sId = 'serviceId';
                    document.getElementById($sId).value=data[0].id_subcat;
                    
                    
                    
                },
                error : function() {
                    var $pData = $('#patientData');
                    $pData.empty();
                    $pData.append("<tr><td>No hay datos disponibles</td></tr>");
                }
            });
});













































