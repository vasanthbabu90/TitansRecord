 
function makeEnrollCourseAjaxCall(){
	
	 var firstBlock = $('#firstBlock').val();
	 var secondBlock = $('#secondBlock').val();
	var send = "firstBlock=" + firstBlock + "&secondBlock=" + secondBlock;
	alert(send);
	
	
	$.ajax({
 		url: '/portal/student/enrollCourses',
		type: 'POST',
		data: "firstBlock=" + firstBlock + "&secondBlock=" + secondBlock,
			
		success: function(response) {
			alert("success"+response);
		},

		error: function(errorObject ){	
			alert("error"+errorObject);
			}
	
	});
}

function updateStudentProfileAjaxCall(){
	
//	alert("student update ");
	var send = JSON.stringify(serializeObject($('#studentForm')));
	alert(send);
	console.log(send);
	
	$.ajax({
		url: '/portal/student/editProfile',
		type: 'POST',
		data: send,
		contentType: 'application/json',
		async: false,
		//dataType: 'json',
		
		success: function(response) {
			alert("success"+response);
		},

		error: function(errorObject ){	
			alert("error"+errorObject);
			}
	
	});
}

toggle_visibility = function(id) {
    var element = document.getElementById(id);
    if(element.style.display == 'block')
    	element.style.display = 'none';
    else
    	element.style.display = 'block';
 }	

make_hidden = function(id) {
    var element = document.getElementById(id);
    element.style.display = 'none';
        }	   

make_visible = function(id) {
    var element = document.getElementById(id);
    element.style.display = 'block';
 }	   

resetForm = function(id) {
    var element = document.getElementById(id);
    $(element)[0].reset();

    }	  

// Translate form to array
// Then put in JSON format
 function serializeObject (form)
{
    var jsonObject = {};
    var array = form.serializeArray();
    $.each(array, function() {
         	jsonObject[this.name] = this.value;
    });
    return jsonObject;

};

