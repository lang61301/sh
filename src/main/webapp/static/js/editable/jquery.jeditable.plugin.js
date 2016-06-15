$.editable.types.text.content = function(string, settings, original) {
							        $(':input:first', this).val($.trim(string));
							    };
$.editable.addInputType('inputmask', {
    element : function(settings, original) {
        /* Create an input. Mask it using masked input plugin. Settings  */
        /* for mask can be passed with Jeditable settings hash.          */
        var input = $('<input />').inputmask(settings.mask);
        $(this).append(input);
        return(input);
    }
});