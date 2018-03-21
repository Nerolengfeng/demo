function initDmb(boz, tablename, dmid) {
	$.ajax({
		url : "/yyjgpt/common/tableoperator/getHtmlDmb.do",
		type : "post",
		data : {
			"tablename" : tablename
		},
		dataType : "json",
		success : function(data) {
			$("[name='" + boz + "']").html(data.returnData);
		},
		complete : function () {
			if (dmid != undefined) {
				$("[name='" + boz + "']").val(dmid)
			}
		}
	});
}

var Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ]; // 加权因子
var ValideCode = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ]; // 身份证验证位值.10代表X
function IdCardValidate(idCard) {
	idCard = trim(idCard.replace(/ /g, "")); // 去掉字符串头尾空格
	if (idCard.length == 15) {
		return isValidityBrithBy15IdCard(idCard); // 进行15位身份证的验证
	} else if (idCard.length == 18) {
		var a_idCard = idCard.split(""); // 得到身份证数组
		if (isValidityBrithBy18IdCard(idCard)
				&& isTrueValidateCodeBy18IdCard(a_idCard)) { // 进行18位身份证的基本验证和第18位的验证
			return true;
		} else {
			return false;
		}
	} else {
		if (idCard.length == 0) {
			alert("请输入身份证号码！");
		} else {
			alert("身份证号码为15位或18位！");
		}
		return false;
	}
}
/**
 * 判断身份证号码为18位时最后的验证位是否正确
 * 
 * @param a_idCard
 *            身份证号码数组
 * @return
 */
function isTrueValidateCodeBy18IdCard(a_idCard) {
	var sum = 0; // 声明加权求和变量
	if (a_idCard[17].toLowerCase() == 'x') {
		a_idCard[17] = 10; // 将最后位为x的验证码替换为10方便后续操作
	}
	for (var i = 0; i < 17; i++) {
		sum += Wi[i] * a_idCard[i]; // 加权求和
	}
	valCodePosition = sum % 11; // 得到验证码所位置
	if (a_idCard[17] == ValideCode[valCodePosition]) {
		return true;
	} else {
		alert("身份证号码校验位错误，请输入正确的身份证号码");
		return false;
	}
}
/**
 * 将15位身份证号码转换为18位
 * @param {} idCardNo
 */
function transformatIdFrom15To18(idCardNo) {
    var v = new Array(2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4, 8, 5, 10, 9, 7);
    var vs = "10X98765432";
    if (idCardNo == null || trim(idCardNo).length != 15) {
        return "";
    }
    idCardNo = trim(idCardNo);
    // 将15位的号码转换位17位
    var cardID17 = idCardNo.substring(0, 6) + "19" + idCardNo.substring(6);
    var N = 0;
    var R = -1;
    var T = '0';// 储存最后一个数字
    var j = 0;
    var cardID18 = "";
    // 计数出第18位数字
    for (var i = 16; i >= 0; i--) {
        N += parseInt(cardID17.substring(i, i + 1)) * v[j];
        j++;
    }
    R = N % 11;
    T = vs.charAt(R);
    cardID18 = cardID17 + T;
    return cardID18;
}

/**
 * 验证18位数身份证号码中的生日是否是有效生日
 * 
 * @param idCard
 *            18位书身份证字符串
 * @return
 */
function isValidityBrithBy18IdCard(idCard18) {
	var year = idCard18.substring(6, 10);
	var month = idCard18.substring(10, 12);
	var day = idCard18.substring(12, 14);
	var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
	// 这里用getFullYear()获取年份，避免千年虫问题
	if (temp_date.getFullYear() != parseFloat(year)
			|| temp_date.getMonth() != parseFloat(month) - 1
			|| temp_date.getDate() != parseFloat(day)) {
		alert("输入的身份证号码出生日期不正确！");
		return false;
	} else {
		return true;
	}
}
/**
 * 验证15位数身份证号码中的生日是否是有效生日
 * 
 * @param idCard15
 *            15位书身份证字符串
 * @return
 */
function isValidityBrithBy15IdCard(idCard15) {
	var year = idCard15.substring(6, 8);
	var month = idCard15.substring(8, 10);
	var day = idCard15.substring(10, 12);
	var temp_date = new Date(year, parseFloat(month) - 1, parseFloat(day));
	// 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法
	if (temp_date.getYear() != parseFloat(year)
			|| temp_date.getMonth() != parseFloat(month) - 1
			|| temp_date.getDate() != parseFloat(day)) {
		alert("输入的身份证号码出生日期不正确！");
		return false;
	} else {
		return true;
	}
}
// 去掉字符串头尾空格
function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}



function initXzqh(boz, xzqhdm) {
	var dqjb = new Array('','','s','q','x','z','c');
	var xzqh = $("[name='"+boz+"dxzqh']");
	var info = "";
	if (xzqhdm != undefined) {
		info = xzqhdm.substring(0,2);
	}	
	loadXzqh(boz+dqjb[2],2,"",info);

	if (xzqhdm != undefined && xzqhdm.length > 0) {
		
		info = xzqhdm.substring(0,4);
		xzqh.val(info);
		loadXzqh(boz+dqjb[2+1],2+1,xzqh.val(),info);
		info = xzqhdm.substring(0,6);
		xzqh.val(info);
		loadXzqh(boz+dqjb[3+1],3+1,xzqh.val(),info);
		info = xzqhdm.substring(0,9);
		xzqh.val(info);
		loadXzqh(boz+dqjb[4+1],4+1,xzqh.val(),info);
		info = xzqhdm;
		xzqh.val(info);
		loadXzqh(boz+dqjb[5+1],5+1,xzqh.val(),info);
	}
	
	
	$("[name='"+boz+dqjb[2]+"']").change(function(){
		xzqh.val($(this).val());
		loadXzqh(boz+dqjb[2+1],2+1,xzqh.val());
	});
	$("[name='"+boz+dqjb[3]+"']").change(function(){
		xzqh.val($(this).val());
		loadXzqh(boz+dqjb[3+1],3+1,xzqh.val());
	});
	$("[name='"+boz+dqjb[4]+"']").change(function(){
		xzqh.val($(this).val());
		loadXzqh(boz+dqjb[4+1],4+1,xzqh.val());
	});
	$("[name='"+boz+dqjb[5]+"']").change(function(){
		xzqh.val($(this).val());
		loadXzqh(boz+dqjb[5+1],5+1,xzqh.val());
	});
	$("[name='"+boz+dqjb[6]+"']").change(function(){
		xzqh.val($(this).val());
	});
	
	function loadXzqh(box, level, longcode,xzqhdm1) {
		for (var j=level; j<dqjb.length; j++) {
			$("[name='"+boz+dqjb[j]+"']").html("<option><span>请选择</span></option>");
		}
		$.ajax({
			url : "/yyjgpt/common/region/getRegionHtml.do",
			type : "post",
			data : {
				"level" : level,
				"longcode" : longcode
			},
			dataType : "json",
			success : function(data) {
				$("[name='" + box + "']").html(data.returnData);
			},
			complete : function () {
				$("[name='" + box + "']").val(xzqhdm1);			
			}
		});
	}
	
}


function diffDays(t1, t2) {
	if (t1 == "" || t2 == "") {
		throw "时间参数错误";
	}
	
	var s1 = t1.replace("/-/g","/");
	var s2 = t2.replace("/-/g","/");
	var d1 = new Date(s1);
	var d2 = new Date(s2);
	var time = d2.getTime()-d1.getTime();
	var day = parseInt(time/(1000*60*60*24));
	return day+1;
}








