(function(obj){
	var _y =window._yinda = obj;
	
	//_y.defaultOpts = {"index":0,"baseUrl":"//47.94.18.182:8082/"};
	_y.defaultOpts = {"index":0,"baseUrl":"//localhost:18080/yindacloud/"};
	_y.callFunc = function(obj, callback, options) {
		if (callback && _y.isFunction(callback)) {
			callback.call(obj, options);
		}
	};
	_y.js = {
			post : function(url, par) {
				var postDom = document.createElement("form");
				postDom.method = "post";
				postDom.action = url;
				postDom.style.display = "none";
				_y.each(par,function(i, n) {
					if(_y.isArray(n)){
						_y.each(n,function(j, k) {
							var pageInput = document.createElement("input"); // page
							pageInput.setAttribute("name", k.name);
							pageInput.setAttribute("value", k.value);
							postDom.appendChild(pageInput);
						});
					}
					else{
						var pageInput = document.createElement("input"); // page
						pageInput.setAttribute("name", i);
						pageInput.setAttribute("value", n);
						postDom.appendChild(pageInput);
					}
				});
				document.body.appendChild(postDom);
				postDom.submit();
			} ,
			postArr : function(url, par) {
				var postDom = document.createElement("form");
				postDom.method = "post";
				postDom.action = url;
				postDom.style.display = "none";
				_y.each(par,function(i, n) {
					var pageInput = document.createElement("input"); // page
					pageInput.setAttribute("name", n.name);
					pageInput.setAttribute("value", n.value);
					postDom.appendChild(pageInput);
				});
				document.body.appendChild(postDom);
				postDom.submit();
			} ,
			isEmpty : function(obj){
				return obj == null || obj == undefined || obj == '';
			} ,
			isDeclare : function(obj){
				return "undefined" == typeof obj;
			} ,
			stopDefault : function(e) { 
			     if (e && e.preventDefault) {//如果是FF下执行这个
			        e.preventDefault();
			    }else{ 
			        window.event.returnValue = false;//如果是IE下执行这个
			    }
			    return false;
			},// 获取地址栏携带的参数
			getUrlParam :function (name){
				var reg = new RegExp("(^|&)"+name+"=([^&]*)(&|$)", "i");
				var r = window.location.search.substr(1).match(reg);
				if(r != null){
					return unescape(r[2]);
				}
				return null;	
			}
	}
})(window.jQuery);