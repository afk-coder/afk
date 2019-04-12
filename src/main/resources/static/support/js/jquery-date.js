// 对Date的扩展，将 Date 转化为指定格式的String
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
// 例子：   
// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423   
// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18   
Date.prototype.format = function(fmt)   
{ //author: meizz   
  var o = {   
    "M+" : this.getMonth()+1,                 //月份   
    "d+" : this.getDate(),                    //日   
    "H+" : this.getHours(),                   //小时   
    "m+" : this.getMinutes(),                 //分   
    "s+" : this.getSeconds(),                 //秒   
    "q+" : Math.floor((this.getMonth()+3)/3), //季度   
    "S"  : this.getMilliseconds()             //毫秒   
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
} 

Date.prototype.addDays = function(d) {  
    this.setDate(this.getDate() + d); 
    return this;
};  
  
Date.prototype.addWeeks = function(w) {  
    this.addDays(w * 7);  
    return this;
};  
  
Date.prototype.addMonths = function(m) {  
    var d = this.getDate();  
    this.setMonth(this.getMonth() + m);  
  
    if (this.getDate() < d)  
        this.setDate(0);  
    return this;
};  
  
Date.prototype.addYears = function(y) {  
    var m = this.getMonth();  
    this.setFullYear(this.getFullYear() + y);  
  
    if (m < this.getMonth()) {  
        this.setDate(0);  
    }  
    return this;
}; 

//格式化时间  
Date.prototype.toDateString = function(formatStr) {  
    var date = this;  
    var timeValues = function() {  
    };  
    timeValues.prototype = {  
        year : function() {  
            if (formatStr.indexOf("yyyy") >= 0) {  
                return date.getYear();  
            } else {  
                return date.getYear().toString().substr(2);  
            }  
        },  
        elseTime : function(val, formatVal) {  
            return formatVal >= 0 ? (val < 10 ? "0" + val : val) : (val);  
        },  
        month : function() {  
            return this.elseTime(date.getMonth() + 1, formatStr.indexOf("MM"));  
        },  
        day : function() {  
            return this.elseTime(date.getDate(), formatStr.indexOf("dd"));  
        },  
        hour : function() {  
            return this.elseTime(date.getHours(), formatStr.indexOf("hh"));  
        },  
        minute : function() {  
            return this.elseTime(date.getMinutes(), formatStr.indexOf("mm"));  
        },  
        second : function() {  
            return this.elseTime(date.getSeconds(), formatStr.indexOf("ss"));  
        }  
    }  
    var tV = new timeValues();  
    var replaceStr = {  
        year : ["yyyy", "yy"],  
        month : ["MM", "M"],  
        day : ["dd", "d"],  
        hour : ["hh", "h"],  
        minute : ["mm", "m"],  
        second : ["ss", "s"]  
    };  
    for (var key in replaceStr) {  
        formatStr = formatStr.replace(replaceStr[key][0], eval("tV." + key  
                + "()"));  
        formatStr = formatStr.replace(replaceStr[key][1], eval("tV." + key  
                + "()"));  
    }  
    return formatStr;  
}  
//获取日期对应的星期
Date.prototype.showWeeks = function(){
	var day=new Array(7);
	day[0]="星期日";
	day[1]="星期一";
	day[2]="星期二";
	day[3]="星期三";
	day[4]="星期四";
	day[5]="星期五";
	day[6]="星期六";
	return day[this.getDay()];
}
//比较日期差
Date.prototype.DateDiff = function(strInterval, dtEnd) {   
    var dtStart = this;  
    if (typeof dtEnd == 'string' )//如果是字符串转换为日期型  
    {   
        dtEnd = StringToDate(dtEnd);  
    }  
    switch (strInterval) {   
        case 's' :return parseInt((dtEnd - dtStart) / 1000);  
        case 'n' :return parseInt((dtEnd - dtStart) / 60000);  
        case 'h' :return parseInt((dtEnd - dtStart) / 3600000);  
        case 'd' :return parseInt((dtEnd - dtStart) / 86400000);  
        case 'w' :return parseInt((dtEnd - dtStart) / (86400000 * 7));  
        case 'm' :return (dtEnd.getMonth()+1)+((dtEnd.getFullYear()-dtStart.getFullYear())*12) - (dtStart.getMonth()+1);  
        case 'y' :return dtEnd.getFullYear() - dtStart.getFullYear();  
    }  
}
//字符串转换成日期类型(仅yyyy-MM-dd格式)
function StringToDate(DateStr)  
{   
  
    var converted = Date.parse(DateStr);  
    var myDate = new Date(converted);  
    if (isNaN(myDate))  
    {   
        var arys= DateStr.split('-');  
        myDate = new Date(arys[0],--arys[1],arys[2]);  
    }  
    return myDate;  
}  