
<%@include file="../login/header.jsp" %>
<a href="/RPSMarksheet/MS9331.pdf">MS9331</a>

<script>
     $.ajax({type: "post",url: "/RPSMarksheet",data: {},success: function(msg){
             alert(msg);
         }});
    
</script>