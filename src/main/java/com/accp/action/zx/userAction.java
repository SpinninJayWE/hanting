package com.accp.action.zx;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accp.biz.zx.userBiz;
import com.accp.pojo.Login;
import com.accp.pojo.User;

@RestController
@RequestMapping("zx")
public class userAction {
    @Autowired
	private userBiz biz;
    
    @RequestMapping(value="login",method=RequestMethod.POST)
    public Map<String ,Object>login(@RequestBody Login lo,HttpSession session){
    	Map<String,Object> message=new HashMap<String,Object>();
    	Login los=biz.queryUser(lo);
    	if(los!=null) {
    		message.put("code", "200");
    		message.put("data", los);
    		session.setAttribute("USER", los);
    	}else {
    		message.put("code", "500");
    	}
    	return message;
    	
    }
}
