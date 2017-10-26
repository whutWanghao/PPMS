window.onload = new function(){
    ajax(
        {
            url:"departmentAction_getAllDepartmentNames.action",
            type:"json",
            callback:function(data) {
                // 循环遍历每个部门分类，每个名称生成一个option对象，添加到<select>中
                for(var index in data) {
                    var op = document.createElement("option");//创建一个指名名称元素
                    op.value = data[index].did;//设置op的实际值为当前的读者分类编号
                    var textNode = document.createTextNode(data[index].dname);//创建文本节点
                    op.appendChild(textNode);//把文本子节点添加到op元素中，指定其显示值

                    document.getElementById("adddept").appendChild(op);
                }
            }
        }
    );
};
/**
 * ajax提交添加员工的信息
 *
 */
$(function () {


    $('#addEmployee').click(function () {

        if (!validAddEmployee()) {
            return;
        }

        var postdata = "eid="+$.trim($("#addeid").val())+"&ename="+$.trim($("#addename").val())+"&department="+ $.trim($("#adddept").val())+"&gender="+ $.trim($("#addgender").val())
            +"&birthday="+ $.trim($("#addbirthday").val())+"&joindate="+$.trim($("#addjoindate").val())+"&phone="+$.trim($("#addphone").val())+"&level="+$.trim($("#addlevel").val());
        ajax(
            {
                method:'POST',
                url:'employeeManageAction_addEmployee.action',
                params: postdata,
                callback:function(data) {
                    if (data == 1) {
                        $("#addModal").modal("hide");//关闭模糊框
                        showInfo("添加成功");

                    }else if (data == -1) {
                        $("#addModal").modal("hide");//关闭模糊框
                        showInfo("该员工已存在");
                    }else {
                        $("#addModal").modal("hide");//关闭模糊框
                        showInfo("添加失败");
                    }

                }
            }

        );


    });

    $('#modal_info').on('hide.bs.modal',function() {//提示模糊框隐藏时候触发
        location.reload();  	//刷新当前页面
    });



});



function validAddEmployee() {
    var flag = true;

    var eid = $.trim($("#addeid").val());
    if (eid == "") {
        $('#addeid').parent().addClass("has-error");
        $('#addeid').next().text("请输入员工编号");
        $("#addeid").next().show();
        flag = false;
    }else {
        $('#addeid').parent().removeClass("has-error");
        $('#addeid').next().text("");
        $("#addeid").next().hide();
    }



    var reg = new RegExp("[\\u4E00-\\u9FFF]+","g");
    var name = $.trim($("#addename").val());
    if(name == ""){
        $('#addename').parent().addClass("has-error");
        $('#addename').next().text("请输入真实姓名");
        $("#addename").next().show();
        flag = false;
    }else if(!reg.test(name)){
        $('#addename').parent().addClass("has-error");
        $('#addename').next().text("真实姓名必须为中文");
        $("#addename").next().show();
        flag = false;
    }else {
        $('#addename').parent().removeClass("has-error");
        $('#addename').next().text("");
        $("#addename").next().hide();
    }

    return flag;
}







function showInfo(msg) {
    $("#div_info").text(msg);
    $("#modal_info").modal('show');
}