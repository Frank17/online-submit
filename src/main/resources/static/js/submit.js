$('#btn-select').click(function() {
	$('#file-area').click()
})
$('#file-area').change(function() {
	$('#file-value').val($('#file-area').val())
})
$('#btn-submit').click(function() {
	var name, studentcode, file
	var submit;
	try {
		studentcode = $('#studentcode-value').val().trim()

		if (null == studentcode || studentcode.length <= 0) {
			$('#reason-alert').html('学号不能为空')
			$('#invalid-alert').modal()
			submit = false;
			return false;
		}
	} catch (e) {
		console.log(e)
	}
	try {
		name = $('#name-value').val().trim()
		if (null == name || name.length <= 0) {
			$('#reason-alert').html('姓名不能为空')
			$('#invalid-alert').modal()
			submit = false;
			return false;
		}
	} catch (e) {
		console.log(e)
	}

	try {
		file = $('#file-area').val()
		if (null == file || file.length <= 0) {
			$('#reason-alert').html('请选择文件')
			$('#invalid-alert').modal()
			submit = false;
			return false;
		}
	} catch (e) {
		console.log(e)
	}

	$('#upload-confirm').modal({
		relatedTarget : this,
		onConfirm : function(options) {
			$('#upload-form').attr('action', 'rest/file/upload')
			$('#upload-form').submit()
		}
	});
})

$('#btn-index').click(function() {
	window.location.href = '.'
})

$(function() {
	$('#file-area').on(
			'change',
			function() {
				var fileNames = '';
				$.each(this.files, function() {
					fileNames += '<span class="am-badge am-badge-success">'
							+ this.name + '</span> ';
				});
				$('#file-value').html(fileNames);

			});
});