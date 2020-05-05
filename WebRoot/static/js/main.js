$(document).ready(function() {
	initDataTable();
})

function initDataTable() {
	$('#table_id_example').DataTable( {
		"info" : true,
		"paging" : true,
		"processing" : false,
		"searching" : true,
		"serverSide" : true,
		"ajax" : {
			type : 'POST',
			url : 'UserQuery.action'
		},
		"columns" : [ {
			data : 'username'
		}, {
			data : 'password'
		} ]
	});
	
}