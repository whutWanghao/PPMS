function query(){
    var postdata="eid="+$.trim($("#eid").val())+"&ename="+$.trim($("#ename").val());
    ajax({
        method:"POST",
        url:"employeeAction_queryEmployee.action",
        params:postdata
    })
}