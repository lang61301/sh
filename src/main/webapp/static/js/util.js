"use strict"
if(!!!me){ var me = {};};
if(!!!(me.pdd))me.pdd={};
if(!!!(me.pdd.Util))me.pdd.Util ={
	/**
	 * column[0][search][regex]为column[0][searchRegex]
	 * 修正datatables参数传递;
	 * 否则映射java对象;
	 */
	"plainfy_datatables":function(data){
		for (var i = 0; i < data.columns.length; i++) {
	        column = data.columns[i];
	        column.searchRegex = column.search.regex;
	        column.searchValue = column.search.value;
	        delete(column.search);
	    }
	}
}
