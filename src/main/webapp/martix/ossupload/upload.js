
accessid= 'LTAIb7ibuLQWDSIm';
accesskey= 'Pa3gsiNAHC2FlFc0oKgCO3j70R6m8m';
host = 'http://video-yudao-1.oss-cn-beijing.aliyuncs.com';
serviceName = "http://www.niceyuwen.com";
/*accessid= '6MKOqxGiGU4AUk44';
accesskey= 'ufu7nS8kS59awNihtjSonMETLI0KLy';
host = 'http://post-test.oss-cn-hangzhou.aliyuncs.com';*/
videoPath = ''
	g_dirname = ''
		g_object_name = ''
			g_object_name_type = ''
				now = timestamp = Date.parse(new Date()) / 1000; 

var policyText = {
		"expiration": "2020-01-01T12:00:00.000Z", //设置该Policy的失效时间，超过这个失效时间之后，就没有办法通过这个policy上传文件了
		"conditions": [
			["content-length-range", 0, 1048576000] // 设置上传文件的大小限制
			]
};

var policyBase64 = Base64.encode(JSON.stringify(policyText))
message = policyBase64
var bytes = Crypto.HMAC(Crypto.SHA1, message, accesskey, { asBytes: true }) ;
var signature = Crypto.util.bytesToBase64(bytes);

function check_object_radio() {
	var tt = document.getElementsByName('myradio');
	for (var i = 0; i < tt.length ; i++ )
	{
		if(tt[i].checked)
		{
			g_object_name_type = tt[i].value;
			break;
		}
	}
}

function get_dirname()
{
	dir = '';
	if (dir != '' && dir.indexOf('/') != dir.length - 1)
	{
		dir = dir + '/'
	}
	//alert(dir)
	g_dirname = dir
}

/*function random_string(len) {
　　len = len || 32;
　　var chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';   
　　var maxPos = chars.length;
　　var pwd = '';
　　for (i = 0; i < len; i++) {
    　　pwd += chars.charAt(Math.floor(Math.random() * maxPos));
    }
    return pwd;
}*/
function uuid() {
	var s = [];
	var hexDigits = "0123456789abcdef";
	for (var i = 0; i < 36; i++) {
		s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
	}
	s[14] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
	s[19] = hexDigits.substr((s[19] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01
	s[8] = s[13] = s[18] = s[23] = "-";

	var uuid = s.join("");
	return uuid;
}
function get_suffix(filename) {
	pos = filename.lastIndexOf('.');
	suffix = '';
	if (pos != -1) {  	
		suffix = filename.substring(pos);
		if(suffix == '.mp4' || suffix == '.MP4' ){
			suffix = '.mp4';
		}else{
			suffix = suffix;
		}
	}
	return suffix;
}

function calculate_object_name(filename)
{
	/* if (g_object_name_type == 'local_name')
    {
        g_object_name += "${filename}"
    }
    else if (g_object_name_type == 'random_name')
    {
        suffix = get_suffix(filename)
        g_object_name = g_dirname + random_string(10) + suffix
    }*/
	suffix = get_suffix(filename);
	g_object_name = uuid() + suffix;
	return ''
}

function get_uploaded_object_name(filename)
{
	/* if (g_object_name_type == 'local_name')
    {
        tmp_name = g_object_name
        tmp_name = tmp_name.replace("${filename}", filename);
        return tmp_name
    }
    else if(g_object_name_type == 'random_name')
    {
        return g_object_name
    }*/
	return g_object_name
}

function set_upload_param(up, filename, ret)
{
	g_object_name = g_dirname;
	if (filename != '') {
		suffix = get_suffix(filename)
		calculate_object_name(filename)
	}

	new_multipart_params = {
			'key' : g_object_name,
			'policy': policyBase64,
			'OSSAccessKeyId': accessid, 
			'success_action_status' : '200', //让服务端返回200,不然，默认会返回204
			'signature': signature,
	};

	up.setOption({
		'url': host,
		'multipart_params': new_multipart_params
	});

	up.start();
}

var uploader = new plupload.Uploader({
	runtimes : 'html5,flash,silverlight,html4',
	browse_button : 'selectfiles', 
	multi_selection: false,
	container: document.getElementById('container'),
	flash_swf_url : 'lib/plupload-2.1.2/js/Moxie.swf',
	silverlight_xap_url : 'lib/plupload-2.1.2/js/Moxie.xap',
	url : host,

	init: {
		PostInit: function() {
			document.getElementById('ossfile').innerHTML = '';
			document.getElementById('sub').onclick = function() {
				set_upload_param(uploader, '', false);
				return false;
			};
		},

		FilesAdded: function(up, files) {
			plupload.each(files, function(file) {
				document.getElementById('ossfile').innerHTML += '<div id="' + file.id + '">' + file.name + ' (' + plupload.formatSize(file.size) + ')<b></b>'
				+'<div class="progress"><div class="progress-bar" style="width: 0%"></div></div>'
				+'</div>';				 
			});
		},

		BeforeUpload: function(up, file) {			
			check_object_radio();          
			get_dirname();         
			set_upload_param(up, file.name, true);         
		},

		UploadProgress: function(up, file) {
			var d = document.getElementById(file.id);
			d.getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
			var prog = d.getElementsByTagName('div')[0];
			var progBar = prog.getElementsByTagName('div')[0]
			progBar.style.width= 2*file.percent+'px';
			progBar.setAttribute('aria-valuenow', file.percent);
		},

		FileUploaded: function(up, file, info) {
			if (info.status == 200)
			{
				document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = 'upload to oss success, object name:' + get_uploaded_object_name(file.name);
				videoPath = serviceName+"/video/"+get_uploaded_object_name(file.name);                 
				document.getElementById("video").value = videoPath;		
				getMP4();	
				submit();
			}
			else
			{
				document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = info.response;
			} 
		},

		Error: function(up, err) {
			documeng.getElementById('console').style.display="";
			document.getElementById('console').appendChild(document.createTextNode("\nError xml:" + err.response));
		}
	}
});
var videoTime = 0 ; 

/*function myFunction(ele) {
	//var hour = parseInt((ele.duration)/3600);
	//var minute = parseInt((ele.duration%3600)/60);
	//var second = Math.ceil(ele.duration%60);
	//videoTime ="视频时长："+hour+"小时，"+minute+"分，"+second+"秒";
	videoTime = parseInt(ele.duration);	
	 //上传文件		
	$.ajax({
			type : 'post',		
			data : {video_time:videoTime,video_id:video_id},
			url : '/videoServer/videoTab/updetVideoById.do',
			contentType: false, 
	        processData: false, 
			success : function(data){										
				alert("修改成功");			        					
		        $("#updateVideoModal").modal("hide");
				window.location.href="";					
			},error: function(){
				 alert("submit error");
			}				
		});	 				
} ; */
function submit(){	 
	//表单参数
	var formData = new FormData();  //重点：要用这种方法接收表单的参数  	
	var videoName = $.trim($('#videoName').val());  
	var video_introduce =$.trim($("#video_introduce").val());
	var video_form_id = $.trim($("#kctype").val());
	var video = $('#video').val();	    
	var video_time=videoTime;
	var image = $('#image').prop("files")[0];
	var ppt = $('#ppt').prop("files")[0];
	var video_qz = $.trim($("#video_qz").val());	

	formData.append("videoName",videoName);  
	formData.append("video", video);  
	formData.append("image", image);
	formData.append("video_introduce", video_introduce);
	formData.append("video_form_id", video_form_id);
	formData.append("ppt", ppt);	
	formData.append("video_qz", video_qz);
	formData.append("video_time", video_time);
	//上传文件		
	$.ajax({
		type : 'post',
		data : formData,
		url : '/videoServer/videoTab/uploadflv.do',				
		contentType: false, 
		processData: false, 
		success : function(data){									
			alert("上传成功");			   					
			$("#myModal").modal("hide");
			window.location.href="";			
			// getVideoTime();
		},error: function(){
			alert("submit error");
		}				
	});	 
	return false;
}; 

var url ;

function getMP4(){
	var videoName = $.trim($('#videoName').val());
	$.ajax({
		type : 'post',
		data : {videoPath:videoPath,videoName:videoName},
		url : '/videoServer/videoTab/getmp4.do',				
		success : function(data){									
			//alert("转换成功");			   					
			url = data;		
		},error: function(){
			alert("转换 失败");
		}				
	});	 
};
/*function getVideoTime(){
	if(suffix == ".mp4"){
		document.getElementById("videoTime").src = videoPath; 				 	
	}else{
		$.ajax({
			type : 'post',
			data : {videoName:videoName},
			url : '/videoServer/videoTab/.do',				
			success : function(data){									
				//alert("转换成功");			   					
				document.getElementById("videoTime").src = url; 		
			},error: function(){
				alert("转换 失败");
			}		
		});			
	}		 	
}*/

uploader.init();
