function XzqhTools(obj) {
	if (obj == null) {
		throw "地址对象为空！";
	}
	if (obj.dzszs == null && obj.sxzqh == null) {
		throw "省级地址或省行政区划同时为空！";
	}
	if (obj.sxzqh != null && obj.dzszq == null && obj.qxzqh == null) {
		throw "市级地址或市行政区划同时为空";
	}
	if (obj.qxzqh != null && obj.dzszx == null && obj.xxzqh == null) {
		throw "县级地址或县行政区划同时为空";
	}
	if (obj.zxzqh != null && obj.dzszz == null && obj.zxzqh == null) {
		throw "镇级地址或镇行政区划同时为空";
	}
	if (obj.cxzqh != null && obj.dzszc == null && obj.cxzqh == null) {
		throw "市级地址或市行政区划同时为空";
	}
	this.dzszs = obj.dzszs;// 地址所在省（省级市）
	this.dzszq = obj.dzszq;// 地址所在市（区）
	this.dzszx = obj.dzszx;// 地址所在县（地级市）
	this.dzszz = obj.dzszz;// 地址所在镇（街道）
	this.dzszc = obj.dzszc;// 地址所在村（居委会）

	this.sxzqh = obj.sxzqh;// 省（省级市）行政区划
	this.qxzqh = obj.qxzqh;// 市（区）行政区划
	this.xxzqh = obj.xxzqh;// 县（地级市）行政区划
	this.zxzqh = obj.zxzqh;// 镇（街道）行政区划
	this.cxzqh = obj.cxzqh;// 村（居委会）行政区划
}

Xzqhtools.prototype.init = function() {

};

function setEvent(grade, dz, xzqh) {
	$.ajax({
		url : "/yyjgpt/common/region/getRegionHtml.do",
		type : "post",
		data : {"grade" : grade, "longcode" : xzqh},
		dataType : "json",
		success : function (data) {
			if (data.returnCode == 1) {
				$("#"+dz).html(data.returnData);
			} else {
				alert(data.returnMsg);
			}
		},
		complete : function () {
			$("#"+dz).val(xzqh);
		}
	});
}












