
/* global BSON */

$(document).ready(
        function() {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/proyectoDB2/restC/cliente/getCliente/',
                dataType: 'json',
                success: function(data) {
                    var $cData = $('#datosClientes');
                    $cData.empty();
                    //$uData.append(data[0].usuario);
                    //$cData.append("holaa 1");
                    for (var i = 0; i < data.length; i++) {
                        //$cData.append(data[i]._id); Aqui me quede
                        
                        $cData.append("<tr><td>"+data[i].tipo_poliza+"</td><td>"+data[i].nombre+"</td><td>"+data[i].apellido+"</td><td>"+data[i].telefono+"</td><td>"+data[i].email+"</td><td>"+data[i].documentoIdentificacion+"</td><td>"+data[i].contacto_emergencia+"</td><td>"+data[i].telefono_contacto_e+"</td><td><a href=\"modificarCliente0.jsp?identificacion="+data[i].documentoIdentificacion+"\" class=\"button pLink expanded\">Modificar</a><a href=\"eliminarCliente.jsp?identificacion="+data[i].documentoIdentificacion+"\" class=\"button pLink expanded\">Eliminar</a></td></tr>");
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
