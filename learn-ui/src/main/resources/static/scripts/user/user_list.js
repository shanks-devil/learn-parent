;(function($, undefined){
	var app = new Vue({
		el: '#user',
		data: {
			list: []
        },
        created : function() {
            var _this = this;
            $.get("/ui/user/list", function(data){
                _this.list = data;
            });
        },
		methods: {
		    user_info : function(item) {
               console.log(item.id);
               console.log(item.name);
               console.log(item.mail);
            }
        }
    })
}(jQuery));