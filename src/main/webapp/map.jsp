<%--
  Created by IntelliJ IDEA.
  User: WH
  Date: 2017/6/26
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MAP</title>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Hello, World</title>
    <style type="text/css">
        html{height:100%}
        body{height:100%;margin:0px;padding:0px}
        #container{height:100%}
    </style>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=Ixat1U8qirT3MYWhsfehASlQY4QLzFc2">
    </script>
</head>
<body>
<div id="container"></div>
<script type="text/javascript">
    var map = new BMap.Map("container");          // 创建地图实例
    var point = new BMap.Point(114.351931,30.52927);  // 创建点坐标
    map.centerAndZoom(point, 15);                 // 初始化地图，设置中心点坐标和地图级别
    map.setMapStyle({style:'grayscale'});
    //添加地图控件
    map.addControl(new BMap.NavigationControl());
    map.addControl(new BMap.ScaleControl());
    map.addControl(new BMap.OverviewMapControl());
    map.enableScrollWheelZoom(); // 开启鼠标滚轮缩放
    //map.addControl(new BMap.MapTypeControl());

    var points=[
        new BMap.Point(114.305902,30.517137),
        new BMap.Point(114.310286,30.51135),
        new BMap.Point(114.321137,30.512782),
        new BMap.Point(114.329546,30.516391),
        new BMap.Point(114.335726,30.522924),
        new BMap.Point(114.342481,30.518382),
        new BMap.Point(114.350458,30.520373)
    ];
    var polyline=new BMap.Polyline(points,{strokeColor:"red",strokeWeight:6,strokeOpacity:0.5}
    );
    map.addOverlay(polyline);


</script>
</body>
</html>
