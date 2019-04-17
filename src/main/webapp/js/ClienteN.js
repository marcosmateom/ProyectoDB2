
$(document).ready(
        function() {
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/proyectoDB2-seguro/restP/poliza/getPoliza/',
                dataType: 'json',
                success: function(data) {
                    var $pData = $('#tipoP');
                    $pData.empty();
                    //$uData.append(data[0].usuario);
                    //$uData.append("holaa 1");
                    for (var i = 0; i < data.length; i++) {
                        //$pData.append("holaa 1");
                        $pData.append("<option value="+data[i].tipo_poliza+">"+data[i].tipo_poliza+"</option>");
                    }
                    if(data.length===0){
                        $pData.append("<p>No hay datos disponibles</p>");
                    }
                },
                error : function() {
                    var $pData = $('#tipoP');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});


