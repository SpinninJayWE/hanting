package com.accp.biz.zx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.zx.IUserDao;
import com.accp.pojo.Login;
import com.accp.pojo.User;

@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class userBiz {
    @Autowired
	private IUserDao dao;
    
    public Login queryUser(Login lo) {
    	return dao.LoginCheck(lo);
    	
    }
}
