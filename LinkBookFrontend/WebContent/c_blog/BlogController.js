myApp.controller("BlogController",function($scope,$http,$location,$rootScope,$cookieStore)
             {
	
	          $scope.blog={'blogId':0,'blogName':'','blogContent':'','username':'','status':'','likes':0,'dislikes':0};
	          $scope.blogData;
	          $rootScope.blogInfo;
	          
	          $scope.blogComment={'commentId':0,'blogId':0,'commentText':'','commentDate':'','username':''};
	          
	          $scope.addBlog=function()
	          {
	        	  console.log('Adding Blog');
	        	  
	        	  $scope.blog.username=$rootScope.currentUser.username;
	        	  $scope.blog.status='NA';
	        	 
	        	  
	        	  $http.post('http://localhost:8085/LinkBookMiddleware/addBlog',$scope.blog)
	        	  .then(function(response)
	        			  {
	        		        console.log('Blog Added');  
	        		        console.log(response.data);
	        		  
	        			  });
	        	  
	        	  
	          }
	          
	          function loadBlog()
	          {
	        	  console.log('Loading all Blogs');
	        	  $http.get('http://localhost:8085/LinkBookMiddleware/getBlogDetails')
	        	  .then(function(response)
	        {
	        	  console.log('Loading Blog');
	        	  $scope.blogData=response.data;
	        	  console.log($scope.blogData);
	        	  
	        	  
	          });
	      }
	          
	          $scope.incrementLikes=function(blogId)
	          {
	        	  console.log('Increment Likes');
	        	  $http.get('http://localhost:8085/LinkBookMiddleware/incrementLikes/'+blogId)
	        	  .then(function(response)
	        			  {
	        			  
	          });
	          }
	          
	          $scope.incrementDisLikes=function(blogId)
	          {
	        	  console.log('Increment DisLikes');
	        	  $http.get('http://localhost:8085/LinkBookMiddleware/incrementDisLikes/'+blogId)
	        	  .then(function(response)
	        			  {
	        			  
	          });
	          }
	          
	          $scope.approveBlog=function(blogId)
	          {
	        	  console.log('Blog Accepted');
	        	  $http.get('http://localhost:8085/LinkBookMiddleware/approveBlog/'+blogId)
	        	  .then(function(response)
	        			  {
	        			  
	          });
	          }
	          
	          $scope.rejectBlog=function(blogId)
	          {
	        	  console.log('Blog Rejected');
	        	  $http.get('http://localhost:8085/LinkBookMiddleware/rejectBlog/'+blogId)
	        	  .then(function(response)
	        			  {
	        			  
	          });
	          }
	          
	          $scope.deleteBlog=function(blogId)
	          {
	        	  console.log('Blog Deleted');
	        	  $http.get('http://localhost:8085/LinkBookMiddleware/deleteBlog/'+blogId)
	        	  .then(function(response)
	        			  {
	        			  
	          });
	          }
	          
	          $scope.showBlog=function(blogId)
	          {
	        	  console.log('Displaying Blog Details');
	        	  $http.get('http://localhost:8085/LinkBookMiddleware/getBlog/'+blogId)
	        	  .then(function(response)
	        			  {
	        		  $rootScope.blogInfo=response.data;
	        		  console.log($rootScope.blogInfo);
	        		  $location.path('/showBlogDetail');
	        			  
	          });
	          }
	        	  
	        	  $scope.editBlog=function(blogId)
	        	  {
	        		  console.log('Editing BlogFunction');
		        	  $http.get('http://localhost:8085/LinkBookMiddleware/getBlog/'+blogId)
		        	  .then(function(response)
		        			  { 
		        		         $rootScope.blogInfo=response.data;
		        		         console.log($rootScope.blogInfo);
		        		         $location.path('/updateBlogDetail');
		        			  });
	        	  }
	        		  
	        		          
	          $scope.updateBlog=function()
        	  {
        		  console.log('updating BlogFunction');
        		  $scope.blog=$rootScope.blogInfo;
	        	  $http.post('http://localhost:8085/LinkBookMiddleware/updateBlog',$scope.blog)
	              .then(function(response)
		        			  { 
		        		         
		        		         console.log('Blog Updated');
		        		         $location.path('/showBlogDetail');
		        			  });
	          
	        	  
        	  }
             
              
	          
	          loadBlog();
             });