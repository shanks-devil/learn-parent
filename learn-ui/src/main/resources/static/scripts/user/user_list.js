;(function($, undefined){
	var app = new Vue({
		el: '#user',
		data: {
			list: []
        },
		methods: {
		    user_info : function(item) {
               console.log(item.id);
               console.log(item.name);
               console.log(item.mail);
            }
        }
    })
	$.get("/ui/user/list", function(data){
		app.list = data;
	});
}(jQuery));