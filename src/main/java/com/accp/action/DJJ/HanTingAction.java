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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.biz.DJJ.HanTingBiz;
import com.accp.pojo.Integral;
import com.accp.pojo.Integralrecord;
import com.accp.pojo.Login;
import com.accp.pojo.Service;
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
		int jifen=lo.getUesr().getUserintegral()+interade;
		lo.getUesr().setUserintegral(jifen);
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
		model.addAttribute("ServiceCollt",ServiceCollt);
		
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
	public Map<String ,Object> updateMyOrderState(int state,int oid){
		Map<String,Object> message=new HashMap<String,Object>();
		int count = biz.updateMyOrderState(state, oid);
		if(count>0) {
			message.put("code", "200");
			message.put("msg", "取消服务成功");
		}else {
			message.put("code", "500");
			message.put("msg", "取消服务失败");
		}
		
		return message;
		
	}
	
	
	
	

	
}
