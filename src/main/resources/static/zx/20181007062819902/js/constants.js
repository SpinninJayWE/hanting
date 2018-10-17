//预加载页面信息
pageInfos = [{
	"url": "shouye.html",
	"id": "shouye",
	"styles": {
		"top": "45px",
		"bottom": "50px"
	}
}, {
	"url": "chuzu.html",
	"id": "chuzu",
	"styles": {
		"top": "45px",
		"bottom": "50px"
	}
}, {
	"url": "shoucang.html",
	"id": "shoucang",
	"styles": {
		"top": "45px",
		"bottom": "50px"
	}
}, {
	"url": "geren.html",
	"id": "geren",
	"styles": {
		"top": "45px",
		"bottom": "50px"
	}
}];


//根应用
basePath="http://111.231.112.241:8080/MoGo";
//登陆
loginInURL=basePath+"/mogo/user/login";
//注册
savaInURL=basePath+"/mogo/user/saveUser";
//切换账号  (注销)
OutInURL=basePath+"/mogo/user/loginOut";
//查询个人资料
getUser=basePath+"/mogo/user/getUser";
//查询首页内容
queryAll=basePath+"/mogo/query/home";
//从session中获得用户信息
getUserURL=basePath+"/user/getUser";
//下拉刷新
downRefreshURL=basePath+"/msg/refresh";
//上拉加载指定条数数据
upLoadURL=basePath+"/msg/load";
//初始化列表数据
initListURL=basePath+"/msg/query";
//查询房屋详情信息
getHouseXq=basePath+"/mogo/query/RoomDetailsInfo"
//收藏房屋
ShouCHouse=basePath+"/mogo/like"
//修改个人资料
UpdateZiliao=basePath+"/mogo/user/updateUser"
//查询并判断我是否收藏此房屋
queryMyHouseSc=basePath+"/mogo/mylike";
//查询所有我收藏的房屋
queryAllMyloveHouse=basePath+"/mogo/likes";
//取消我的收藏
deleteMyLoveHouse=basePath+"/mogo/nlike";
//余额充值
moneycz=basePath+"/mogo/user/updateGold";
//新增房屋
AddHouse=basePath+"/mogo/tenement/saveHome";
//查看我发布的房屋
LookMyHouse=basePath+"/mogo/query/userHome";
//修改头像
updateImgURL=basePath+"/mogo/user/updateImg";
