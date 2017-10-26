/**
 * Created by WH on 2017/7/20.
 */
$(function () {



    $('#modal_info').on('hide.bs.modal',function() {//提示模糊框隐藏时候触发
        location.reload();  	//刷新当前页面
    });



});



function getEmployeeInfo(id){

    ajax(
        {
            method:'POST',
            url:'employeeAction_getEmployee.action',
            params: "eid=" + id,
            type:"json",
            callback:function(data) {
                $("#findEid").val(data.eid);
                $("#findEname").val(data.ename);
                $("#findGender").val(data.gender);
                $("#findBirthday").val(data.birthday);
                $("#findJoindate").val(data.joindate);
                $("#findPhone").val(data.phone);
                $("#findDepartment").val(data.department.dname);
                $("#findLevel").val(data.level);
                $("#findDeptId").val(data.department.did);
            }
        }



    );







}



function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}