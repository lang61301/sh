var Index = (function(){

	var $container = $(".detail-right-content");
	
	function init(){
		$(".sidebar").on("click.nav-link", ".nav-link", function(e){
			e.preventDefault();
			e.stopPropagation();
			
			var $self = $( this );
			var url = $self.data("href");
			if(url == undefined 
					|| url == null 
					|| url == "")
				return;
		
			$.ajax( {
				url: url,
				cache:false,
				complete: function ( data ) {
					//如果session超时什么都不做;
					if(!!window.sessionTimeout){
					}else{
						$container.html( data.responseText );
					}
				}
			} );
		});
	}
	
	return {
		"init":init
	};
})();
