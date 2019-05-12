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
                url: 'http://localhost:8080/proyectoDB2-seguro/GetAuth',
                dataType: 'json',
                data:{
                    dpi:query_string("dpi")
                },
                success: function(data) {
                    var $cData = $('#clientData');
                    $cData.empty();
                    for (var i = 0; i < data.length; i++) {
                        $cData.append("<tr><td>"+data[i]._id+"</td><td>"+data[i].hospital+"</td><td>"+data[i].fecha+"</td><td>"+data[i].servicio+"</td><td>"+data[i].monto+"</td><td>"+(data[i].monto*(1-data[i].porcentaje)).toFixed(2)+"</td><td><a href=\"verAuth.jsp?dpi="+query_string("dpi")+"&idCita="+data[i].idCita+"&hospNum="+data[i].hospital+"\" class=\"button pLink expanded\">Ver mas</a></td></tr>");
                    }
                    if(data.length===0){
                        $cData.append("<p>No hay datos disponibles</p>");
                    }
                },
                error : function() {
                    var $cData = $('#datosClientes');
                    $cData.empty();
                    $cData.append("<p>No hay datos disponibles</p>");
                }
            });
});

