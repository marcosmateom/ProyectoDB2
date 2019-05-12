$(document).ready(
        function() {
            $.ajax({
                type: 'GET',
                url: 'http://25.74.104.162:8080/proyectoDB2-seguro/GetHospitales',
                dataType: 'json',
                success: function(data) {
                    var $pData = $('#example-tabs');
                    $pData.empty();
                    for (var i = 0; i < data.length; i++) {
                        
                        
                        $pData.append('<button class="tabs-titles" onclick="openTabs(event, "panel"'+data[i].hospital+','+data[i].hospital+')"><a href="#panel'+data[i].hospital+'">Hospital '+data[i].hospital+'</a></button>');
 
                       
                    }
                    if(data.length==0){
                        $pData.append("<p>No hay datos disponibles</p>");
                    }
                },
                error : function() {
                    var $pData = $('#hospnum');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});
















