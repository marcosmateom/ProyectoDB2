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
                url: 'http://localhost:8080/proyectoDB2-seguro/restAuth/auth/getAuth',
                dataType: 'json',
                data: { 
                    idAuth: query_string('idAuth') 
                    
                },
                success: function(data) {
                    var $fechaC = 'fecha';
                    document.getElementById($fechaC).value= data[0].fecha;
                    var $hospNum = 'hospNum';
                    document.getElementById($hospNum).value= data[0].hospital;;
                    var $authNum = 'authNum';
                    document.getElementById($authNum).value= data[0]._id;
                    var $citaId = 'citaId';
                    document.getElementById($citaId).value= data[0].idCita;
                    var $serv = 'serv';
                    document.getElementById($serv).value= data[0].servicio;
                    var $monto = 'monto';
                    document.getElementById($monto).value= data[0].monto;
                    var $porcentaje = 'porcentaje';
                    document.getElementById($porcentaje).value= data[0].porcentaje;
                },
                error : function() {
                    var $pData = $('#authData');
                    $pData.empty();
                    $pData.append("<p>No hay datos disponibles</p>");
                }
            });
});
