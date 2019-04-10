$(document).ready(
        function() {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/proyectoDB2-seguro/restCo/cobertura/getCobertura',
                dataType: 'json',
                success: function(data) {
                    var $pData = $('#datosS');
                    $pData.empty();
                    //$uData.append(data[0].usuario);
                    //$uData.append("holaa 1");
                    for (var i = 0; i < data.length; i++) {
                        //$pData.append("holaa 1");
                        //$pData.append("<tr><td>"+data[i].tipo_poliza+"</td>"+"<td>"+data[i].cobertura+"</td><td><a href=\"modificarPoliza0.jsp?nPoliza="+data[i].tipo_poliza+"\" class=\"button pLink expanded\">Modificar</a><a href=\"eliminarPoliza.jsp?nPoliza="+data[i].tipo_poliza+"\" class=\"button pLink expanded\">Eliminar</a></td></tr>");
                        $pData.append("<tr><td>"+data[i].cita_id+"</td>"+"<td>"+data[i].subcat+"</td>"+"<td>"+data[i].costo+"</td>"+"<td>"+data[i].pCobertura+"</td><td>"+data[i].tipoSeguro+"</td></tr>");
                    }
                    if(data.length===0){
                        $pData.append("<p>No hay datos disponibles</p>");
                    }
                },
                error : function() {
                    var $pData = $('#datosS');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});
