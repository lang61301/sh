"use strict"
/**
 * 2016-09-07
 * 重新修订版本;
 */
if(!!!me){ var me = {};};

/**
 * 工具类;
 */
if(!!!(me.Util))me.Util = (function($){
	function session_ajax_timeout(xhr){
		/**
		 * 状态
		 * 是否有json数据返回
		 * 是否有json 超时返回
		 * 防止弹出过多弹出框
		 */
		if(xhr.status == 200
				&& (window.sessionTimeout == undefined
						|| window.sessionTimeout == false)
				&& (xhr["responseJSON"] != undefined )
				&& ( (typeof xhr["responseJSON"]) == "object")
				&& (9998 == xhr["responseJSON"]["status"])){
			window.sessionTimeout = true;
			return true;
		}
		return false;
	}
	
	/**
	 * ie9 jquery.form.ajax文件上传返回是字符串,转换成对象;
	 */
	function fixie9(d){
		if(typeof d == "string"){
			return JSON.parse(d);
		}
		return d;
	}
	
	function go(url, $container, data){
		if(!!!$container)
			$container = $(".detail-right-content");
		
		var opt = {
			url: url,
			cache:false,
			complete: function ( data ) {
				//如果session超时什么都不做;
				if(!!window.sessionTimeout){
				}else{
					$container.html( data.responseText );
				}
			}	
		}
		if(!!data && $.type(data) == "object"){
			$.extend(opt, {type:"post", data:data});
		}
		$.ajax(opt);
	}
	
	return {
		"session_ajax_timeout":session_ajax_timeout,
		"go":go,
		"fixie9":fixie9
	};
})(jQuery);

/**
 * datatables fix;
 */
if(!!!(me.DataTable))me.DataTable = (function($) {
	/**
	 * column[0][search][regex]为column[0][searchRegex]
	 * 修正datatables参数传递;
	 * 否则映射java对象;
	 */
	function plainfy_datatables(data){
		for (var i = 0; i < data.columns.length; i++) {
	        var column = data.columns[i];
	        column.searchRegex = column.search.regex;
	        column.searchValue = column.search.value;
	        delete(column.search);
	    }
	}
	
	return {
		"plainfy_datatables":plainfy_datatables,
	};
})(jQuery);

/**
 * form工具类;
 */
if(!!!(me.Form))me.Form = (function($){
	function getForm (form){
		var inputs = $(form).find(":input");
	      var tmp = {};
		inputs.each(function(){
		//	console.info(this.type);
			var key = this.name;
			if(!!key){
				var arr = tmp[key];
				if(!!arr){
				}else{
					arr = [];
					tmp[key] = arr;
				}
				var type = this.type.toLowerCase();
				var t = {"value":$(this).val(),"type":type};
				if("checkbox" == type
						|| "radio" == type){
					t["checked"] = this.checked;
				}
				arr.push(t);
			}
		});
		
		var rtn = {};
		for(var key in tmp){
			var arr2 = tmp[key];
			var a = [];
			for(var i = 0; i < arr2.length; i++){
				var e = arr2[i];
				if("checkbox" == e["type"]
						|| "radio" == e["type"]){
					if(!!e["checked"]){
						a.push(e["value"]);
					}
				}else{
					a.push(e["value"]);
				}
			}
			if(a.length >0){
				if(arr2.length == 1){
					rtn[key] = a[0];	
				}else{
					rtn[key] = a;	
				}
			}
		}
		return rtn;
	}
	
	/**
	 * setval:当该函数不为空时,设值操作交由用户;
	 */
	function setForm(form, obj, setval){
		clearForm(form);
		var cus = false;
		if(!!setval && (typeof setval) == "function"){
			cus = true;
		}
		
		for(var name in obj){
			var e = obj[name];
			if($.isArray(e)){
				for(var i = 0; i < e.length; i++){
					var o = e[i];
					for(var k in o){
						var n = name+"["+i+"]."+k;
						var input = $(form).find(":input[name='" + n + "']");
						if(cus)
							setval.apply(this, [input, o[k]]);
						else
							input.val(o[k]);
					}
				}
			}else{
				var input = $(form).find(":input[name=" + name + "]");
				if(cus)
					setval.apply(this, [input, e]);
				else
					input.val(e);
			}
		}
	}
	
	function clearSameNameInput(inputs, callback){
		$(inputs).each(function(){
			var type = this.type.toLowerCase();
			if("checkbox" == type
					|| "radio" == type){
				this.checked = false;	
			}else if("select-one" == type){
				if(this.length >0){
					this.selectedIndex =0;
				}
			}else if("select-multiple" == type){
				$(this).val([]);
			}else{
				$(this).val("");
			}
			
			if(!!callback 
				&& (typeof callback) == "function"){
					callback.apply(this);
			}
		});
	}
	function clearForm(form, callbacks){
		callbacks = $.extend({},callbacks);
		$(form).find(":input").each(function(){
			var key = this.name;
			if(!!key){
				clearSameNameInput($(this), callbacks[key]);
			}
		});
	}
	
	return {
		"getForm":getForm,
		"setForm":setForm,
		"clearSameNameInput":clearSameNameInput,
		"clearForm":clearForm
	};
})(jQuery);
