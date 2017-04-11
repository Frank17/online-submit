/**
 * 
 */

function logout() {
	$('#logout-form').attr('action', 'rest/User/logout')
	$('#logout-form').submit()
}

$(document).ready(function(){
	$('#btn-download-all').click(function(){
		window.open('rest/file/download?code=' + $('#code').val().trim() );
	})
	
	$('.btn-downlaod').click(function(){
		var child = $(this).closest('tr').children()[1]
		var studentcode = $(child).text();
		window.open('rest/file/download/' + studentcode + '/' + $('#code').val().trim())
	})
	
	$('#del-alert').on('closed.modal.amui', function(){
		window.location.href = window.location.href;
	})
	
	$('#btn-index').click(function(){
		window.location.href = '.'
	})
	
	$('.btn-preview').click(function(){
		var children = $(this).closest('tr').children()
		var studentcode = $(children[1]).text();
		window.open('rest/preview/' + studentcode + "/" + $('#code').val().trim())
	})
	
	$('.preview-link').click(function(){
		var children = $(this).closest('tr').children()
		var studentcode = $(children[1]).text();
		window.open('rest/preview/' + studentcode + "/" + $('#code').val().trim())
	})
	
	$('.download-link').click(function(){
		var child = $(this).closest('tr').children()[1]
		var studentcode = $(child).text();
		window.open('rest/file/download/' + studentcode + '/' + $('#code').val().trim())
	}) 
	
	$('.delete-link').click(function(){
		var children = $(this).closest('tr').children()
		var studentcode = $(children[1]).text();
		var name = $(children[2]).text()
		
		$('#del-confirm').children().find('a#del-confirm-datainfo').html('学号：' + studentcode + ', 姓名：' + name);
		
		$('#del-confirm').modal({
			relatedTarget: this,
	        onConfirm: function(options) {
	        	$.ajax({
	    			url : 'rest/file/delete/' + studentcode + "/" + $('#code').val().trim(),
	    			type: 'POST',
	    			data: JSON.stringify({}),
	    			contentType: 'application/json;charset=utf-8',
	    			success: function(model) {
	    				$('#del-alert-reason').html(model.reason)
	    				$('#del-alert').modal()
	    			},
	    			error: function(err) {
	    				console.log(err)
	    			}
	    		})
	        },
	        // closeOnConfirm: false,
	        onCancel: function() {
	          
	        }
		})
		
	})
	
	$('.btn-delete').click(function(){
		var children = $(this).closest('tr').children()
		var studentcode = $(children[1]).text();
		var name = $(children[2]).text()
		
		$('#del-confirm').children().find('a#del-confirm-datainfo').html('学号：' + studentcode + ', 姓名：' + name);
		
		$('#del-confirm').modal({
			relatedTarget: this,
	        onConfirm: function(options) {
	        	$.ajax({
	    			url : 'rest/file/delete/' + studentcode + "/" + $('#code').val().trim(),
	    			type: 'POST',
	    			data: JSON.stringify({}),
	    			contentType: 'application/json;charset=utf-8',
	    			success: function(model) {
	    				$('#del-alert-reason').html(model.reason)
	    				$('#del-alert').modal()
	    			},
	    			error: function(err) {
	    				console.log(err)
	    			}
	    		})
	        },
	        // closeOnConfirm: false,
	        onCancel: function() {
	          
	        }
		})
		
		
	})
})