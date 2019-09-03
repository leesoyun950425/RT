$(document).ready(function() {
   $("#update").click(function() {
      document.form1.action = "updateAll";
      document.form1.submit();
   })
})