function openTabs(evt, panel, hospNum) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabs-panels");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tabs-titles");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(panel).style.display = "block";
    evt.currentTarget.className += " active";
    function llamar() {
        getData(hospNum);
    }
    llamar();
}
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
function getData(hospNum) {
    $.ajax({
        type: 'GET',
        //cambiar path a 25.66.75.32:8080
        url: 'http://localhost:8080/proyectoDB2-seguro/GetAllCitas?hospNum=' + hospNum,
        dataType: 'json',
        success: function (data) {
            var $pData = $('#historialData' + hospNum);
            $pData.empty();
            for (var i = 0; i < data.length; i++) {
                //$pData.append("<tr><td>"+data[i].id+"</td><td>"+data[i].cat+"</td><td>"+data[i].docName+" "+data[i].docLastName+"</td><td>"+data[i].pName+" "+data[i].pLastName+"</td><td>"+data[i].fecha+"</td><td><a class=\"button\" href=\"cita_h.jsp?citaId="+data[i].id+"&pId="+data[i].pId+"\">Ver detalles</a> <a class=\"button\" href=\"deleteC_h.jsp?citaId="+data[i].id+"\">Eliminar Cita</a></td></tr>");
                $pData.append("<tr><td>" + data[i].id + "</td><td>" + data[i].cat + "</td><td>" + data[i].docName + " " + data[i].docLastName + "</td><td>" + data[i].pName + " " + data[i].pLastName + "</td><td>" + data[i].fecha + "</td><td><a class=\"button\" href=\"cita_h.jsp?citaId=" + data[i].id + "&pId=" + data[i].pId +"&hosp="+query_string('hosp') + "\">Ver detalles</a></td></tr>");
            }
            if (data.length == 0) {
                $pData.append("<p>No hay datos disponibles</p>");
            }

        },
        error: function () {
            var $pData = $('#historialData');
            $pData.empty();
            $pData.append("<p>No hay datos disponibles</p>");
        }
    });
}























