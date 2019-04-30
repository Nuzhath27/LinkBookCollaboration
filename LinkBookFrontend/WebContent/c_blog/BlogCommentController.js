myApp.controller("BlogCommentController",function($scope,$http,$location,$rootScope,$cookieStore)
             {
	          
	        $scope.blogComment={'commentId':0,'blogId':0,'commentText':'','commentDate':'','username':''};
	        
	        $scope.blogComments;
	        
	        $scope.addComment=function()
	        {
	        	$scope.blogComment.blogId=$rootScope.blogInfo.blogId;
	        	$scope.blogComment.username=$rootScope.currentUser.username;
	        	
	        	$http.post('http://localhost:8085/LinkBookMiddleware/addBlogComment',$scope.blogComment)
	        	.then(function(response)
	        			{
	        		      console.log('Adding Blog Comments');
	        		      console.log(response.data);
	        		
	        			});
	        }
	        
	        $scope.deleteBlogComment=function(commentId)
	          {
	        	  console.log('BlogComment Deleted');
	        	  $http.get('http://localhost:8085/LinkBookMiddleware/deleteBlogComment/'+commentId)
	        	  .then(function(response)
	        			  {
	        			  
	          });
	          }
	        
	        function loadBlogComments()
	        {
	        	$http.get('http://localhost:8085/LinkBookMiddleware/getBlogComments/'+$rootScope.blogInfo.blogId)
	        	.then(function(response)
	            {
	        		
	        		$scope.blogComments=response.data;
	        	});
	        }
	 
	        loadBlogComments();
	
             });