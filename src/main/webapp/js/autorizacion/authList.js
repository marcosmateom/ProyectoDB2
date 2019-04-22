$(document).ready(
        function() {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/proyectoDB2-seguro/restAuth/auth/getAuth',
                dataType: 'json',
                success: function(data) {
                    var $pData = $('#authData');
                    $pData.empty();
                    //$uData.append(data[0].usuario);
                    //$uData.append("holaa 1");
                    for (var i = 0; i < data.length; i++) {
                        //$pData.append("holaa 1");
                        $pData.append("<tr><td>"+data[i]._id+"</td><td>"+data[i].dpi+"</td><td>"+data[i].hospital+"</td><td>"+data[i].servicio+"</td><td>"+data[i].fecha+"</td><td>"+data[i].estado+"</td><td><a href=\"auth.jsp?idAuth="+data[i]._id+"\" class=\"button pLink expanded\">Ver detalles</a></td></tr>");
                    }
                    if(data.length===0){
                        $pData.append("<p>Hubo un error!</p>");
                    }
                },
                error : function() {
                    var $pData = $('#authData');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});
