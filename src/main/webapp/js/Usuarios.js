
$(document).ready(
        function() {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/proyectoDB2-seguro/rest/usuario/getUsuario/',
                dataType: 'json',
                success: function(data) {
                    var $uData = $('#dat');
                    $uData.empty();
                    //$uData.append(data[0].usuario);
                    //$uData.append("holaa 1");
                    for (var i = 0; i < data.length; i++) {
                        //$pData.append("holaa 1");
                        $uData.append("<tr><td>"+data[i].usuario+"</td>"+"<td>"+data[i].nombre+"</td>"+"<td>"+data[i].apellido+"</td>"+"<td>"+data[i].email+"</td>"+"<td>"+data[i].puesto+"</td><td><a href=\"modificarUsuario0.jsp?usuario="+data[i].usuario+"\" class=\"button pLink expanded\">Modificar</a><a href=\"eliminarUsuario.jsp?usuario="+data[i].usuario+"\" class=\"button pLink expanded\">Eliminar</a></td></tr>");
                    }
                    if(data.length===0){
                        $uData.append("<p>No hay datos disponibles</p>");
                    }
                },
                error : function() {
                    var $uData = $('#dat');
                    $uData.empty();
                    $uData.append("<p>No hay datos disponibles</p>");
                }
            });
});
