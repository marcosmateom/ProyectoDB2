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
            var $idNum = $('#idNum');
            $.ajax({
                type: 'GET',
                url: 'http://localhost:8080/proyectoDB2-seguro/DocInfo',
                dataType: 'json',
                data: { 
                    hosp: query_string('hosp') 
                },
                success: function(data) {
                    var $pData = $('#doctoresData');
                    $pData.empty();
                    for (var i = 0; i < data.length; i++) {
                        $pData.append("<option value="+data[i].id+">"+data[i].firstName+" "+data[i].lastName+"</option>");
                    }
                    if(data.length==0){
                        $pData.append("<p>No hay datos disponibles</p>");
                    }
                },
                error : function() {
                    var $pData = $('#doctoresData');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});













