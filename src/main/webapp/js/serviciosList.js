$(document).ready(
        function() {
            $.ajax({
                type: 'GET',
                url: 'http://25.74.104.162:8080/proyectoDB2-seguro/getServicios',
                dataType: 'json',
                success: function(data) {
                    var $pData = $('#serviciosData');
                    $pData.empty();
                    for (var i = 0; i < data.length; i++) {
                        $pData.append("<option value="+data[i].subCatId+">"+data[i].subCat+"</option>");
                    }
                    if(data.length==0){
                        $pData.append("<p>No hay datos disponibles</p>");
                    }
                },
                error : function() {
                    var $pData = $('#patientData');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});


