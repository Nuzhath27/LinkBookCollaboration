var myApp=angular.module("myApp",["ngRoute","ngCookies"]);
myApp.config(function($routeProvider)
		
{
	
         alert("This is RouteConfig");
         $routeProvider.when("/login",{templateUrl:"c_user/Login.html"})
         .when("/register",{templateUrl:"c_user/Register.html"})
         .when("/aboutus",{templateUrl:"c_user/AboutUs.html"})
         .when("/AddBlog",{templateUrl:"c_blog/Blog.html"})
         .when("/showBlog",{templateUrl:"c_blog/ShowBlog.html"})
         .when("/manageBlog",{templateUrl:"c_blog/ManageBlog.html"})
         .when("/showBlogDetail",{templateUrl:"c_blog/BlogDetail.html"})
         .when("/updateBlogDetail",{templateUrl:"c_blog/UpdateBlog.html"})
         .when("/profilepicture",{templateUrl:"c_user/ProfilePicture.html"})
         .when("/chat",{templateUrl:"c_chat/Chat.html"});
         

});

myApp.run(function($rootScope,$cookieStore){
	console.log('Run Function');
	console.log($rootScope.currentUser);
    
	if($rootScope.currentUser==undefined)
       {
		    console.log($cookieStore.get('userDetails'));
		    $rootScope.currentUser=$cookieStore.get('userDetails');
		    
       }	

});
