"use strict"
if(!!!me){ var me = {};};
if(!!!(me.pdd))me.pdd={};
if(!!!(me.pdd.DataTable))me.pdd.DataTable = (function($) {
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
		"plainfy_datatables":plainfy_datatables
	};
})($);

/**
 * form工具类;
 */
if(!!!(me.pdd.Util))me.pdd.Form = (function($){
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
	function setForm(form, obj){
		clearForm(form);
		for(var name in obj){
			var e = obj[name];
			var input = $(form).find(":input[name=" + name + "]");
			input.val(e);
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
})($);
