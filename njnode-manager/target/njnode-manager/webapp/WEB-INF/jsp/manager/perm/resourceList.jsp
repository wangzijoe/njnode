<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/H-ui/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/H-ui/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/H-ui/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/H-ui/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/H-ui/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/H-ui/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css">
<title>资源管理</title>
<style type="text/css">
.ztree li span.button.add {
       margin-left:2px; 
       margin-right: -1px; 
       background-position:-144px 0; 
       vertical-align:top; 
       *vertical-align:middle
 }
 /* 使Iframe位置固定，不会滚动 */
 .configResource {
	position: fixed;
	top: 30px;
	left: auto;
	right: auto;
	bottom: auto;
	width: 90%;
	height: 390px;
}
</style>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 资源管理 <span class="c-gray en">&gt;</span> 资源列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
<table class="table">
	<tr>
		<td width="200" class="va-t"><ul id="treeDemo" class="ztree"></ul></td>
		<td class="va-t">
			<div class="configResource">
				<iframe ID="testIframe" Name="testIframe" FRAMEBORDER=0 SCROLLING=AUTO width=100%  height=390px SRC="${pageContext.request.contextPath }/page/manager_perm_addResource/toPage"></iframe>
			</div>
		</td>
	</tr>
</table>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath }/H-ui/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/H-ui/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/H-ui/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/H-ui/static/h-ui.admin/js/H-ui.admin.js"></script>

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath }/H-ui/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script> 
<script type="text/javascript">
var setting = {
	view: {
		dblClickExpand: true,
		showLine: true,
		selectedMulti: false,
		addHoverDom: addHoverDom,		// 用于当鼠标移动到节点上时，显示用户自定义控件。务必与 setting.view.removeHoverDom 同时使用
		removeHoverDom: removeHoverDom	// 用于当鼠标移出节点时，隐藏用户自定义控件。务必与 addHoverDom 同时使用
	},
	check: {
		enable: true
	},
	edit: {
		enable:true
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {

		beforeClick: function(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			if (treeNode.isParent) {
				zTree.expandNode(treeNode);
				return false;
			} else {
				demoIframe.attr("${pageContext.request.contextPath }/page/manager_perm_addResource/toPage");
				return true;
			}
		}
	}
};

var zNodes = [
      {"id":1,"name":"资源","pId":0,"open":true},
      {"id":201,"name":"代理管理","pId":1},
      {"id":204,"name":"录入代理商(翰奎医疗)","pId":201},
      {"id":203,"name":"录入经理(翰奎医疗)","pId":201},
      {"id":202,"name":"代理列表(翰奎医疗)","pId":201},
      {"id":190,"name":"券管理","pId":1},
      {"id":192,"name":"券规则列表","pId":190},
      {"id":191,"name":"券列表","pId":190},
      {"id":181,"name":"餐协会管理","pId":1},{"id":184,"name":"会员申请(餐协)","pId":181},{"id":183,"name":"企业列表(餐协)","pId":181},{"id":182,"name":"企业分类(餐协)","pId":181},{"id":158,"name":"会员管理","pId":1},{"id":180,"name":"会员列表(餐协)","pId":158},{"id":159,"name":"会员申请(餐协)","pId":158},{"id":155,"name":"活动管理","pId":1},{"id":163,"name":"活动列表(买单小程序)","pId":155},{"id":156,"name":"活动修改(餐协)","pId":155},{"id":152,"name":"新闻管理","pId":1},{"id":154,"name":"类型管理(餐协)","pId":152},{"id":153,"name":"新闻列表(餐协)","pId":152},{"id":146,"name":"个人资料","pId":1},{"id":147,"name":"密码修改(通用)","pId":146},{"id":144,"name":"骑手管理","pId":1},{"id":161,"name":"骑手列表(名校优选)","pId":144},{"id":145,"name":"添加骑手(名校优选)","pId":144},{"id":137,"name":"店铺管理","pId":1},{"id":193,"name":"店铺管理(先锋书店)","pId":137},{"id":185,"name":"店铺管理(永城轮胎)","pId":137},{"id":169,"name":"店铺管理(名校优选)","pId":137},{"id":166,"name":"店铺管理(买单小程序)","pId":137},{"id":165,"name":"Logo修改(公用)","pId":137},{"id":160,"name":"店铺列表(餐协)","pId":137},{"id":140,"name":"店铺列表(美肤)","pId":137},{"id":139,"name":"店铺列表(支点健身)","pId":137},{"id":138,"name":"店铺列表(祁冠茗茶)","pId":137},{"id":133,"name":"车辆信息","pId":1},{"id":134,"name":"车辆信息","pId":133},{"id":131,"name":"服务管理","pId":1},{"id":132,"name":"服务管理(永城轮胎)","pId":131},{"id":127,"name":"品牌详情","pId":1},{"id":128,"name":"品牌详情","pId":127},{"id":115,"name":"茶叶管理","pId":1},{"id":116,"name":"茶叶列表","pId":115},{"id":113,"name":"意见反馈","pId":1},{"id":114,"name":"意见反馈()","pId":113},{"id":111,"name":"教练管理","pId":1},{"id":112,"name":"教练列表(支点健身)","pId":111},{"id":106,"name":"课程管理","pId":1},{"id":179,"name":"课程核销(支点健身)","pId":106},{"id":178,"name":"科普详情(支点健身)","pId":106},{"id":110,"name":"近期活动(支点健身)","pId":106},{"id":109,"name":"免费课程","pId":106},{"id":108,"name":"精选课程","pId":106},{"id":107,"name":"人气单项","pId":106},{"id":103,"name":"卡片管理","pId":1},{"id":105,"name":"卡片类型","pId":103},{"id":104,"name":"会员卡管理","pId":103},{"id":93,"name":"主题管理","pId":1},{"id":198,"name":"类型管理(先锋书店)","pId":93},{"id":197,"name":"主题管理(先锋书店)","pId":93},{"id":187,"name":"主题管理(翰奎医疗)","pId":93},{"id":168,"name":"主题类型(名校优选)","pId":93},{"id":167,"name":"主题列表(名校优选)","pId":93},{"id":142,"name":"主题列表(茶叶主题管理)","pId":93},{"id":94,"name":"主题列表","pId":93},{"id":81,"name":"分销管理","pId":1},{"id":82,"name":"分销管理","pId":81},{"id":68,"name":"数据总览","pId":1},{"id":69,"name":"数据总览","pId":68},{"id":66,"name":"轮播图管理","pId":1},{"id":196,"name":"轮播图管理(先锋书店)","pId":66},{"id":186,"name":"轮播图管理(翰奎医疗)","pId":66},{"id":173,"name":"轮播图管理(名校优选)","pId":66},{"id":162,"name":"轮播图管理(买单小程序)","pId":66},{"id":157,"name":"轮播图管理(餐协)","pId":66},{"id":143,"name":"轮播图管理(永城轮胎)","pId":66},{"id":141,"name":"轮播图管理(支点健身)","pId":66},{"id":67,"name":"轮播图管理","pId":66},{"id":61,"name":"产品管理","pId":1},{"id":195,"name":"书籍管理(先锋书店)","pId":61},{"id":194,"name":"分类管理(先锋书店)","pId":61},{"id":189,"name":"分类管理(翰奎医疗)","pId":61},{"id":188,"name":"商品管理(翰奎医疗)","pId":61},{"id":177,"name":"轮胎列表(永城轮胎)","pId":61},{"id":171,"name":"分类管理(名校优选)","pId":61},{"id":170,"name":"商品管理(名校优选)","pId":61},{"id":95,"name":"科普详情","pId":61},{"id":63,"name":"分类管理","pId":61},{"id":62,"name":"商品管理","pId":61},{"id":59,"name":"订单管理","pId":1},{"id":200,"name":"核销(翰奎医疗)","pId":59},{"id":199,"name":"订单管理(翰奎医疗)","pId":59},{"id":176,"name":"订单核销(公用的)","pId":59},{"id":164,"name":"订单列表(买单小程序)","pId":59},{"id":60,"name":"订单列表","pId":59},{"id":57,"name":"优惠券管理","pId":1},{"id":175,"name":"优惠券规则(买单小程序)","pId":57},{"id":174,"name":"优惠券列表(买单小程序)","pId":57},{"id":172,"name":"优惠券列表(名校优选)","pId":57},{"id":58,"name":"优惠券列表","pId":57},{"id":55,"name":"投票管理","pId":1},{"id":56,"name":"投票统计","pId":55},{"id":53,"name":"网红管理","pId":1},{"id":54,"name":"网红列表","pId":53},{"id":51,"name":"支付管理","pId":1},{"id":52,"name":"支付配置","pId":51},{"id":47,"name":"权限管理","pId":1},{"id":50,"name":"资源管理","pId":47},{"id":49,"name":"角色管理","pId":47},{"id":48,"name":"用户管理","pId":47}];
		
var code;
		
function showCode(str) {
	if (!code) code = $("#code");
	code.empty();
	code.append("<li>"+str+"</li>");
}

/*
 * 节点鼠标移入事件 
 */
function addHoverDom(treeId, treeNode){
	console.log(treeId+''+treeNode);
	var sObj = $("#" + treeNode.tId + "_span");
	if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
	var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
		+ "' title='添加' onfocus='this.blur();'></span>";
	sObj.after(addStr);

}
/*
 * 鼠标移除事件
 */
function removeHoverDom(treeId, treeNode){
	console.log(treeId+''+treeNode);
	$("#addBtn_"+treeNode.tId).unbind().remove();
}

$(document).ready(function(){
	var t = $("#treeDemo");
	t = $.fn.zTree.init(t, setting, zNodes);
	demoIframe = $("#testIframe");
	//demoIframe.on("load", loadReady);
	var zTree = $.fn.zTree.getZTreeObj("tree");
	//zTree.selectNode(zTree.getNodeByParam("id",'11'));
});
</script>
</body>
</html>