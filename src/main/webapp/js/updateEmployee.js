$(function () {


    $('#updateEmployee').click(function () {


        if (!validUpdateEmployee()) {
            return;
        }

        var postdata = "eid="+$.trim($("#updateEid").val())+"&ename="+$.trim($("#updateEname").val())+"&gender="+$.trim($("#updateGender").val())
            +"&department="+ $.trim($("#updateDept").val())+"&birthday="+ $.trim($("#updateBirthday").val())+"&joindate="+ $.trim($("#updateJoindate").val())
            +"&level="+ $.trim($("#updateLevel").val())+"&phone="+ $.trim($("#updatePhone").val());
        ajax(
            {
                method:'POST',
                url:'employeeManageAction_updateEmployee.action',
                params: postdata,
                callback:function(data) {
                    if (data == 1) {
                        $("#updateModal").modal("hide");//关闭模糊框
                        showInfo("修改成功");

                    }else {
                        $("#updateinfo").modal("hide");//关闭模糊框
                        showInfo("修改失败");
                    }

                }
            }

        );


    });






    $('#modal_info').on('hide.bs.modal',function() {//提示模糊框隐藏时候触发
        location.reload();  	//刷新当前页面
    });



});






function updateEmployee(id){
    $("#updateDept option[value!=-1]").remove();//移除先前的选项
    ajax(
        {
            url:"departmentAction_getAllDepartmentNames.action",
            type:"json",
            callback:function(data) {
                // 循环遍历每个部门分类，每个名称生成一个option对象，添加到<select>中
                for(var index in data) {
                    var op = document.createElement("option");//创建一个指名名称元素
                    op.value = data[index].did;//设置op的实际值为当前的部门编号
                    var textNode = document.createTextNode(data[index].dname);//创建文本节点
                    op.appendChild(textNode);//把文本子节点添加到op元素中，指定其显示值
                    document.getElementById("updateDept").appendChild(op);
                }
                var departmentName=document.getElementById("updateDept")[data].selected=true;
                ajax(
                    {
                        method:'POST',
                        url:'employeeAction_getEmployee.action',
                        params: "eid=" + id,
                        type:"json",
                        callback:function(data) {
                            $("#updateEid").val(data.eid);
                            $("#updateEname").val(data.ename);
                            $("#updateGender").val(data.gender);
                            $("#updateDept").val(data.department.dname);
                            $("#updateBirthday").val(data.birthday);
                            $("#updateJoindate").val(data.joindate);
                            $("#updatePhone").val(data.phone);
                            $("#updateLevel").val(data.level);

                        }
                    }

                );
            }
        }
    );


}



function validUpdateEmployee() {
    var flag = true;

    var eid = $.trim($("#updateEid").val());
    if (eid == "") {
        $('#updateEid').parent().addClass("has-error");
        $('#updateEid').next().text("请输入员工编号");
        $("#updateEid").next().show();
        flag = false;
    }else {
        $('#updateEid').parent().removeClass("has-error");
        $('#updateEid').next().text("");
        $("#updateEid").next().hide();
    }



    var reg = new RegExp("[\\u4E00-\\u9FFF]+","g");
    var name = $.trim($("#updateEname").val());
    if(name == ""){
        $('#updateEname').parent().addClass("has-error");
        $('#updateEname').next().text("请输入真实姓名");
        $("#updateEname").next().show();
        flag = false;
    }else if(!reg.test(name)){
        $('#updateEname').parent().addClass("has-error");
        $('#updateEname').next().text("真实姓名必须为中文");
        $("#updateEname").next().show();
        flag = false;
    }else {
        $('#updateEname').parent().removeClass("has-error");
        $('#updateEname').next().text("");
        $("#updateEname").next().hide();
    }


    return flag;
}



function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}