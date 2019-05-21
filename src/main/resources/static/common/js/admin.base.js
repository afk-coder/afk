function searchParams(params) {
    var args = {};
    $('#myform').find('*[name]').each(function() {
        var value = $.trim($(this).val());
        var name = $.trim($(this).attr('name'));
        if(name && value){
            args[name] = value;
        }
    });
    var temp = {
        page: params.pageIndex,
        rows: params.pageSize,
        direct: params.order,
        filed: params.sort,
        args : args
    };
    return temp;
}

function date_format(value, pattern) {
    if(value == null || value == '') {
        return '';
    }
    return new Date(value).format(pattern);
}


var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "parentId",
            rootPId: 0
        }
    },
    callback: {
        onClick: onTreeClick
    }
};

function onTreeClick() {
    var zTree = $.fn.zTree.getZTreeObj("ztree"),
        nodes = zTree.getSelectedNodes();
    $("#deptName").val(nodes[0].name);
    $("#deptId").val(nodes[0].id);
}

function initTree(url) {
    $.ajax({
        type: "POST",
        url: url,
        dataType:'json',
        success: function(data){
            $.fn.zTree.init($("#ztree"), setting, data);
        }
    });
}

function showTreeMenu() {
    var cityObj = $("#deptName");
    var cityOffset = $("#deptName").offset();
    $("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
    $("body").bind("mousedown", onBodyDown);
}
function hideTreeMenu() {
    $("#menuContent").fadeOut("fast");
    $("body").unbind("mousedown", onBodyDown);
}
function onBodyDown(event) {
    if (!(event.target.id == "menuBtn" || event.target.id == "citySel" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
        hideTreeMenu();
    }
}
