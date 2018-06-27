<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>�Ⱥ�</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">    
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
<script>
var imgUrl = '
 
var lineLink = '
 
var descContent = "���񻶽�, �ᱦ�����Ǵ�齱���ʼ����";
var shareTitle = '���񻶽�';
var appid = 'wxc9937e3a66af6dc8';
function shareFriend() {
    WeixinJSBridge.invoke('sendAppMessage',{
                            "appid": appid,
                            "img_url": imgUrl,
                            "img_width": "640",
                            "img_height": "640",
                            "link": lineLink,
                            "desc": descContent,
                            "title": shareTitle
                            }, function(res) {
                            _report('send_msg', res.err_msg);
                            })
}
function shareTimeline() {
    WeixinJSBridge.invoke('shareTimeline',{
                            "img_url": imgUrl,
                            "img_width": "640",
                            "img_height": "640",
                            "link": lineLink,
                            "desc": descContent,
                            "title": shareTitle
                            }, function(res) {
                            _report('timeline', res.err_msg);
                            });
}
function shareWeibo() {
    WeixinJSBridge.invoke('shareWeibo',{
                            "content": descContent,
                            "url": lineLink,
                            }, function(res) {
                            _report('weibo', res.err_msg);
                            });
}
// ��΢���������������ڲ���ʼ����ᴥ��WeixinJSBridgeReady�¼���
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
        // ���͸�����
        WeixinJSBridge.on('menu:share:appmessage', function(argv){
            shareFriend();
            });
        // ��������Ȧ
        WeixinJSBridge.on('menu:share:timeline', function(argv){
            shareTimeline();
            });
        // ����΢��
        WeixinJSBridge.on('menu:share:weibo', function(argv){
            shareWeibo();
            });
        }, false);
</script>
  </head>
   
  <body>
       <!-- <script>
       var imgUrl = "
 
         var lineLink = "
 
         var descContent = '���Ա���';
         var shareTitle = '����';
        var appid = 'wx1259b351c201841d';
        function shareFriend() {
            WeixinJSBridge.invoke('sendAppMessage',{
                "appid": appid,
                "img_url": imgUrl,
                "img_width": "200",
                "img_height": "200",
                "link": lineLink,
                "desc": descContent,
                "title": shareTitle
            }, function(res) {
                //_report('send_msg', res.err_msg);
            });
        }
        function shareTimeline() {
            WeixinJSBridge.invoke('shareTimeline',{
                "img_url": imgUrl,
                "img_width": "200",
                "img_height": "200",
                "link": lineLink,
                "desc": descContent,
                "title": shareTitle
            }, function(res) {
                   //_report('timeline', res.err_msg);
            });
        }
        function shareWeibo() {
            WeixinJSBridge.invoke('shareWeibo',{
                "content": descContent,
                "url": lineLink,
            }, function(res) {
                //_report('weibo', res.err_msg);
            });
        }
        // ��΢���������������ڲ���ʼ����ᴥ��WeixinJSBridgeReady�¼���
        document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
            // ���͸�����
            WeixinJSBridge.on('menu:share:appmessage', function(argv){
                shareFriend();
            });
            // ��������Ȧ
            WeixinJSBridge.on('menu:share:timeline', function(argv){
                shareTimeline();
            });
            // ����΢��
            WeixinJSBridge.on('menu:share:weibo', function(argv){
                shareWeibo();
            });
        }, false);
        </script> -->
            <h1>�ǺǺǺ�</h1>           
  </body>
</html>