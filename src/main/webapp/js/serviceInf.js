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
        
        document.getElementById('hospnum').onchange = function () {
            getServicio();
            
        });
function getServicio() {
    $.ajax({
        type: 'GET',
        url: 'http://25.74.104.162:8080/proyectoDB2-seguro/GetServices',
        dataType: 'json',
        data: {
            
            hospnum: getValue('hospnum')
            
        },
        success: function (data) {
            var $pData = $('#serviciosData');
            $pData.empty();
            for (var i = 0; i < data.length; i++) {
                $pData.append("<option value=" + data[i] + ">" + data[i] + "</option>");
            }
            if (data.length == 0) {
                $pData.append("<optgroup>No hay servicios disponibles</optgroup>");
            }
        },
        error: function () {
            var $pData = $('#serviciosData');
            $pData.empty();
            $pData.append("<p>No hay datos disponibles</p>");
        }
    });
}











