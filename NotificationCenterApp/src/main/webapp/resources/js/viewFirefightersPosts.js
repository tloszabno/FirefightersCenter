$(document).ready(function() {

    var postTemplate = {
        id: null,
        address: null,
        city: null,
        community: null,
        name: null,
        systemIpAddress: null
    };



    $.getJSON("getAllFirefightersPosts", function(data){
        var firefightersPostsMVVM = new Vue({
            el: "#firefightersPosts",
            data: {
                posts : data
            },
            methods: {
                addNewPost: function(e){
                    var posts = this.$data.posts;
                    posts.push(clone(postTemplate));
                },
                removePost: function(i, e){
                    var posts = this.$data.posts;
                    if( i > -1){
                        posts.splice(i, 1);
                    }
                },
                savePosts: function(e){
                    $.ajax({
                        type: "POST",
                        url: "saveFirefightersPosts",
                        data: JSON.stringify(this.$data.posts),
                        contentType: "application/json; charset=utf-8",
                        success: function(e){ alert("Zapisano"); refreshPage();  },
                        error: function(e){ alert("Błąd");  }
                    });
                }
            }
        });
    });





});
