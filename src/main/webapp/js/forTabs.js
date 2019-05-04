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
  
          
}


















