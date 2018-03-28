/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    $(document).ready(function(){
    $("#dataTable").DataTable({
        "info":true,
        "paging":true,
        "ordering":true,
        "lengthMenu":[[10,25,50,-1],[10,25,50,"All"]]
    });
});