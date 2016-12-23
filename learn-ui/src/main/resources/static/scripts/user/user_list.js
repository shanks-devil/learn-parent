;(function($, undefined){
	var app = new Vue({
		el: '#user',
		data: {
			list: [],
			user: {}
        },
        created: function() {
            var _this = this;
            $.get("/ui/user/list", function(data){
                _this.list = data;
            });
        },
		methods: {
		    user_info: function(item, index) {
		       this.user = $.extend({index: index}, item);
		       console.log(this.user);
            },
            user_create: function() {
                var _this = this;
                console.info(this.user);
                $.post("/ui/user", this.user, function(data){
                    alert( "success" );
                    console.log(data);
                    _this.list.unshift(data);
                }, 'json')
                .fail(function(data) {
                    alert( "error" );
                    console.log(data);
                });
            },
            user_delete: function(item, index) {
                var _this = this;
                $.ajax({
                    url: '/ui/user/' + item.id ,
                    type: 'DELETE',
                    success: function(result) {
                      _this.list.splice(index, 1);
                      alert( "success" );

                    },
                    error: function(){
                      alert( "error" );
                    }
                });
            },
            user_update: function() {
                 var _this = this;
                 console.log(_this.user.index);
                 $.ajax({
                     url: '/ui/user/' + _this.user.id ,
                     type: 'PUT',
                     data: _this.user,
                     success: function() {
                       _this.list.splice(_this.user.index, 1, _this.user);
                       _this.user = {};
                       alert( "success" );
                     },
                     error: function(){
                       alert( "error" );
                     }
                 });
            }
        },
        computed: {
            reversedName: function() {
                return "abc";
            }
        }
    })
}(jQuery));