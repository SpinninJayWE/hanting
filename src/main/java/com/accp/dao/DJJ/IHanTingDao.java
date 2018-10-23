package com.accp.dao.DJJ;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.pojo.Evaluationservice;
import com.accp.pojo.Goldnotes;
import com.accp.pojo.Integral;
import com.accp.pojo.Integralrecord;
import com.accp.pojo.Orders;
import com.accp.pojo.Service;
import com.accp.vo.DJJ.EvaluationOrService;
import com.accp.vo.DJJ.MyServiceCollCetionType;
import com.accp.vo.DJJ.OrdersStateNumber;
import com.accp.vo.DJJ.ServiceCollectionVo;
import com.accp.vo.DJJ.ordersServicesServiceTypeVo;

public interface IHanTingDao {
	
	public List<Service> queryMyYudin(@Param("usid")int usid);
	
	public int jifenadd(@Param("jifen") int jifen,@Param("usid")int usid);
	
	public Integral queryJifenGuige(@Param("inteid")int inteid);
	
	public int addJifenRecord(@Param("userID")int userID,@Param("IRDescribe")String IRDescribe,@Param("recordInAndOut")int recordInAndOut,@Param("integralID")int integralID,@Param("auditStatus")int auditStatus);

	public List<Integralrecord> queryJifenRecord(@Param("usid")int usid);
	
	public List<Integralrecord> queryAllMyJifenRecord(@Param("usid")int usid);
	
	public List<ServiceCollectionVo> queryAllMyServicecollection(@Param("usid")int usid,@Param("title")String title);
	
	public List<ordersServicesServiceTypeVo> queryAllMyOrder(@Param("usid")int usid,@Param("title")String title);
	
	public OrdersStateNumber queryordersStateNumber(@Param("usid")int usid);
	
	public int deleteMyServicecollection(@Param("sercolleid") int sercolleid);
	
	public int updateOrderState(@Param("State")int State,@Param("oid")String oid);
	
	public List<MyServiceCollCetionType> queryMyServiceCollEctionType(@Param("usid")int usid);
	
	public Orders queryOrderByOid(@Param("oid")String oid);
	
	public int updateUserMoney(@Param("usmoney")Integer usmoney,@Param("usid")Integer usid);
	
	public List<Goldnotes> queryGoldnotes(@Param("usid")Integer usid);
	
	public int addGoldNote(@Param("Gold") Goldnotes Gold);
	
	public int queryMaxgoldrecordId();
	
	public ordersServicesServiceTypeVo querymyOrdersByOid(@Param("oid") String oid);
	
	public void addEvaluationService(@Param("eva")Evaluationservice eva);
	
	public void updateOrdercommentstatusByOid(@Param("oid")String oid,@Param("State")int state);
	
	public List<EvaluationOrService> queryMyEvaluationByusid(@Param("usid")Integer usid);
	
	public void updateOrderspaymentTimeByoid(@Param("oid")String oid);
}
