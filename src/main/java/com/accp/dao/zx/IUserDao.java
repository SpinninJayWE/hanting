package com.accp.dao.zx;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Login;
import com.accp.pojo.User;

public interface IUserDao {
    
	public Login LoginCheck(@Param("lo")Login lo );
}
