var ecredit;
$(document).ready(function(){
	$('#ecr_form').bind('submit',function() {
		if($('#rid').val()==""||$('#source').val()==""||$('#target').val()==""||$('#ontname').val()==""){
			alert('请将表单填写完整!!')
		}else{
			input = {};
			if(ecredit==0)
				input["ecrid"] = 0;
			else
				input["ecrid"] = parseInt($("#rid").attr("ecrid"));
			input["rid"]=$('#rid').val();
			input["target"]=$('#target').val();
			input["source"]=$('#source').val();
			input["ontname"]=$('#ontname').val();
			console.log(input);
			inputstr = JSON.stringify(input);
			$.ajax({
				url: "ecRelationAction!upsertECRelation",
		        type: "post",
		        async: true,
		        data: {
		            inputStr: inputstr,
		        },
		        success: function(data){
		        	window.location.href = "ecRelationAction!queryList";
		        }
			})
		}
		return false;
    });

	$('.editecr').click(function(){
		ecredit = 1;
		$('#rid').attr("ecrid",$(this).parent().parent().children().get(0).textContent);
		$('#rid').val($(this).parent().parent().children().get(1).textContent);
		$('#source').val($(this).parent().parent().children().get(2).textContent);
		$('#target').val($(this).parent().parent().children().get(3).textContent);
		$('#ontname').val($(this).parent().parent().children().get(4).textContent);
	});
	$('#new_ecr').click(function(){
		ecredit = 0;
	})
})