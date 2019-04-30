myApp.controller("UserController",function($scope,$http,$location,$rootScope,$cookieStore)
             {
	         
	          $scope.User={'username':'','password':'','customerName':'','emailId':'','role':'','status':'','isOnline':''}
	
	          
	          
	          
	          	          
	          
	
	          $scope.register=function()
	          {
	        	  console.log('Register Function');
	        	  
	        	  $scope.User.role='Student';
	        	  $scope.User.status='A';
	        	  $scope.User.isOnline='ON';
	        	  
	        	  console.log('UserDetails are: ');
	        	  console.log($scope.User);
	        	  
	        	  $http.post('http://localhost:8085/LinkBookMiddleware/registerUser',$scope.User)
	        	  .then(function(response){
	        		  
	        		  console.log('Registered');
	        		  $location.path('/login');
	        	  
	        			  
	          });
	        
	        	  
	        	  
	        	  
             }
	          
	          $scope.logincheck=function()
	          {
	        	  console.log('LogIn Function');
	        	  
	        	  $http.post('http://localhost:8085/LinkBookMiddleware/checkLogin',$scope.User)
	        	  .then(function(response){
	        		  
	        		  console.log('Logged In Successfully');
	        		  $scope.User=response.data;
	        		  $rootScope.currentUser=response.data;
	        		  console.log($rootScope.currentUser);
	        		  $cookieStore.put('userDetails',$rootScope.currentUser);
	        		  $location.path('/userhome');
	        		  
	        		  
	        	  });
	        	  
	        	  
	          }
	          
	          $scope.logout=function()
	          {
	        	  console.log('Log out function');
	        	  delete $rootScope.currentUser;
	        	  $cookieStore.remove('userDetails');
	        	  $location.path('/logout');
	          }
	          
	          
             });