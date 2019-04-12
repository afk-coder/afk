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
