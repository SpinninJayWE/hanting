package com.accp.action.DJJ;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.biz.DJJ.HanTingBiz;
import com.accp.pojo.Evaluationservice;
import com.accp.pojo.Goldnotes;
import com.accp.pojo.Integral;
import com.accp.pojo.Integralrecord;
import com.accp.pojo.Login;
import com.accp.pojo.Orders;
import com.accp.pojo.Service;
import com.accp.vo.DJJ.EvaluationOrService;
import com.accp.vo.DJJ.MyServiceCollCetionType;
import com.accp.vo.DJJ.OrdersStateNumber;
import com.accp.vo.DJJ.ServiceCollectionVo;
import com.accp.vo.DJJ.ordersServicesServiceTypeVo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/c")
public class HanTingAction {

	@Autowired
	private HanTingBiz biz;
	
	@GetMapping("Gerenzx")
	public String Gerenzx(HttpSession session,Model model) {
		Login lo = (Login) session.getAttribute("USER");
		List<Service> listservice = biz.findMyServiceByusid(lo.getUserid());
		model.addAttribute("services",listservice);
		
		return "DJJ/memberCenter";
	}
	
	@ResponseBody
	@RequestMapping(value="addJifen",method=RequestMethod.POST)
	public Map<String ,Object> addJifen(int interade,String qdaoguige,HttpSession session){
		Map<String,Object> message=new HashMap<String,Object>();
		Login lo = (Login) session.getAttribute("USER");
		
		
		biz.addJifenRec(lo.getUserid(), "通过"+qdaoguige+"获得", interade, 1, 2);
		int jifen=lo.getUser().getUserintegral()+interade;
		lo.getUser().setUserintegral(jifen);
		int cont = biz.addUserJifen(jifen, lo.getUserid());
		if(cont>0) {
			System.out.println("积分"+jifen);
			 message.put("code", "200");
			 message.put("jifen",jifen);
			 message.put("mgs", "签到成功");
		}else {
			message.put("code", "500");
		}
		return message;
		
	}
	
	@ResponseBody
	@RequestMapping(value="getJifenGuige",method=RequestMethod.GET)
	public Map<String ,Object> getJifenGuige(int inteid){
		Map<String,Object> message=new HashMap<String,Object>();
		System.out.println("积分规格"+inteid);
		Integral integ = biz.findJifenGuige(inteid);
		message.put("code", "200");
		message.put("integralName", integ.getIntegralname());
		message.put("integral", integ.getIntegral());
		
		return message;
	}
	
	@ResponseBody
	@RequestMapping(value="getMyJifenRecord",method=RequestMethod.GET)
	public Map<String ,Object> getMyJifenRecord(HttpSession session){
		Map<String,Object> message=new HashMap<String,Object>();
		Login lo = (Login) session.getAttribute("USER");
		List<Integralrecord> ing = biz.findMyIntegRecord(lo.getUserid());
		System.out.println(ing);
		if(ing.size()==0) {
			System.out.println(111);
			message.put("code", "200");
			message.put("msg", "可以签到");
		}else {
			System.out.println(222);
			message.put("code", "501");
			message.put("msg", "今天已签到");
		}
		
		return message;
		
	}
	
//	@ResponseBody
//	@RequestMapping(value="getAllMyJifenRecord",method=RequestMethod.GET)
	@GetMapping("getAllMyJifenRecord")
	public String getAllMyJifenRecord(int num,int size,HttpSession session,Model model) {
		Login lo = (Login) session.getAttribute("USER");
		PageInfo<Integralrecord> ing = biz.findAllMyJifenRecord(lo.getUserid(), num, size);
		model.addAttribute("ing",ing);
		return "DJJ/wodejifen";
	}
	
	@GetMapping("getAllMyServiceCollection")
	public String getAllMyServiceCollection(int num,int size,String title,HttpSession session,Model model) {
		Login lo = (Login) session.getAttribute("USER");
		PageInfo<ServiceCollectionVo> ServiceCollt = biz.findAllMyServiceCollection(lo.getUserid(),title,num,size);
		List<MyServiceCollCetionType> serviceCollType = biz.findMyServiceCollCetionType(lo.getUserid());
		model.addAttribute("ServiceCollt",ServiceCollt);
		model.addAttribute("serviceCollType",serviceCollType);
		return "DJJ/fuwushoucang";
		
	}
	
	@GetMapping("getAllMyOrders")
	public String getAllMyOrders(int num,int size,String title,HttpSession session,Model model) {
		Login lo = (Login) session.getAttribute("USER");
		System.out.println("标题"+title);
		PageInfo<ordersServicesServiceTypeVo> ordersvo = biz.findAllMyOrder(lo.getUserid(),title,num,size);
		OrdersStateNumber ordersStateNumber = biz.findOrdersStateNumber(lo.getUserid());
		model.addAttribute("ordersvo",ordersvo);
		model.addAttribute("orderstate",ordersStateNumber);
		return "DJJ/wodeyuding";
		
	}
	
	@ResponseBody
	@RequestMapping(value="removeMyServiceCollectionByid",method=RequestMethod.POST)
	public  Map<String ,Object> removeMyServiceCollectionByid(int serviceid){
		Map<String,Object> message=new HashMap<String,Object>();
		int count = biz.removeMyServiceCollection(serviceid);
		if(count>0) {
			message.put("code", "200");
			message.put("msg", "删除成功");
		}else {
			message.put("code", "500");
			message.put("msg", "删除失败");
		}
		
		return message;
		
		
	}
	
	@ResponseBody
	@RequestMapping(value="updateMyOrderState",method=RequestMethod.POST)
	public Map<String ,Object> updateMyOrderState(int state,String oid)throws Exception{
		Map<String,Object> message=new HashMap<String,Object>();
		int count = biz.updateMyOrderState(state, oid);
		if(count>0) {
			biz.updateOrderspaymentTimeByoid(oid);
			message.put("code", "200");
			message.put("msg", "成功修改状态");
		}else {
			message.put("code", "500");
			message.put("msg", "修改状态失败");
		}
		
		return message;
		
	}
	
	
	@GetMapping("getOrdersByoid")
	public String getOrdersByoid(String oid,HttpSession session,Model model) {
		Orders order =biz.findOrdersByoid(oid);
		Login lo = (Login) session.getAttribute("USER");
		model.addAttribute("order",order);
		
		return "DJJ/zhifu";
	}
	
	@ResponseBody
	@RequestMapping(value="updateUserMoney",method=RequestMethod.POST)
	public Map<String ,Object> updateUserMoney(int usmoney,HttpSession session){
		Map<String,Object> message=new HashMap<String,Object>();
		Login lo = (Login) session.getAttribute("USER");
		int count = biz.updateUserMoney(usmoney, lo.getUserid());
		if(count>0) {
			lo.getUser().setUsermoney(usmoney);
			message.put("code", "200");
			message.put("msg", "金额已扣除");
		}else {
			message.put("code", "500");
			message.put("msg", "金额扣除失败");
		}
		
		return message;
	}
	
	@GetMapping("getMyGoldnotes")
	public String getMyGoldnotes(int num,int size,Model model,HttpSession session) {
		Login lo = (Login) session.getAttribute("USER");
		System.out.println(num+"/"+size);
		PageInfo<Goldnotes> goldnotes = biz.findMyGoldnotes(lo.getUserid(), num, size);
		model.addAttribute("goldnotes",goldnotes);
		
		return "DJJ/wodejinbi";
		
	}
	
	@ResponseBody
	@RequestMapping(value="addGoldNote",method=RequestMethod.POST)
	public Map<String ,Object> addGoldNote(String recordDescribe,Float recordInAndOut,int auditStatus,HttpSession session){
		Map<String,Object> message=new HashMap<String,Object>();
		Login lo = (Login) session.getAttribute("USER");
		Goldnotes gold =new Goldnotes(0, lo.getUserid(), 1,null, recordDescribe, recordInAndOut, auditStatus);
		int count = biz.addGoldNote(gold);
		if(count>0) {
			message.put("code", "200");
			message.put("msg", "金币流向表更新成功");
		}else {
			message.put("code", "500");
			message.put("msg", "金币流向表更新失败");
		}
		
		return message;
	}
	
	@GetMapping("cz")
	public String cz(HttpSession session) {
		Login lo = (Login) session.getAttribute("USER");
		
		return "DJJ/jinb-index";
	}
	
	@GetMapping("getOrderByoid")
	public String getOrderByoid(String oid,Model model) {
		ordersServicesServiceTypeVo ordervo = biz.findOrdersServicesSTypeByoid(oid);
		
		model.addAttribute("Ordervo",ordervo);
		
		return "DJJ/fabupingjia";
	}
	
	@GetMapping("getOrderOrServicesByoid")
	public String getOrderOrServicesByoid(String oid,Model model) {
		ordersServicesServiceTypeVo ordervo = biz.findOrdersServicesSTypeByoid(oid);
		model.addAttribute("ordervo",ordervo);
		
		return "DJJ/MyYudinXq";
	}
	
	@ResponseBody
	@RequestMapping(value="addEvaluationService",method=RequestMethod.POST)
	public Map<String,Object> addEvaluationService(@RequestBody Evaluationservice eva)throws Exception{
		Map<String,Object> message=new HashMap<String,Object>();
		
		try {
			biz.addEvaluationService(eva);
			message.put("code", "200");
			message.put("msg", "服务评价成功");
		} catch (Exception e) {
			message.put("code", "500");
			message.put("msg", "服务评价失败");
		}
		

		
		return message;
		
	}
	
	@ResponseBody
	@RequestMapping(value="updateOrdercommentstatusByOid",method=RequestMethod.POST)
	public Map<String,Object> updateOrdercommentstatusByOid(String oid,int state)throws Exception{
		Map<String,Object> message=new HashMap<String,Object>();
		
		try {
			biz.updateOrdercommentstatusByOid(oid,state);
			message.put("code", "200");
			message.put("msg", "订单评价状态修改成功");
		} catch (Exception e) {
			message.put("code", "500");
			message.put("msg", "订单评价状态修改失败");
		}
		
		return message;
		
		
	}
	
	@GetMapping("getMyEvaluationByusid")
	public String MyEvaluationByusid(HttpSession session,Model model) {
		Login lo = (Login) session.getAttribute("USER");
		List<EvaluationOrService> evas= biz.findMyEvaluationByusid(lo.getUserid());
		model.addAttribute("evas",evas);
		return "DJJ/wodepingjia";
		
	}
	

	
}
