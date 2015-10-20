$(document).ready(function() {
	
	var cartId;
	
	studentgradeupdate = function(event){
			
		var data;
		data = {		     
		    uploadedfiles: files
		}
		var senddata = JSON.stringify(data);
			$.ajax({
		 		url: '/TitansRecord/updatestudentgrade',
		 		type: 'PUT',
		 		data: senddata,
		 		dataType: 'json',
		 		contentType: false,
				success: function(response){
	 		 		alert("Grade Updated");
	 		 		
				},
				error: function(){						
					alert('Error while update..');
				}
			});
		}  

});

 