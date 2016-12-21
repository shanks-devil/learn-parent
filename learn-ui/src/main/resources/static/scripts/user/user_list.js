;(function($, undefined){
	var app = new Vue({
		el: '#user',
		data: {
			list: []
		  }
		})
	$.get("/ui/user/list", function(data){
		app.$data.list = data;
	});
}(jQuery));