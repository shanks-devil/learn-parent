;(function($, undefined){
	var app = new Vue({
		el: '#user',
		data: {
			list: []
        },
		methods: {
		    user_info : function() {
                alert("1");
            }
        }
    })
	$.get("/ui/user/list", function(data){
		app.list = data;
	});
}(jQuery));