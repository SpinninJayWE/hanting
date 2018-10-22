package com.accp.biz.DJJ;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.accp.dao.DJJ.IHanTingDao;
import com.accp.pojo.Evaluationservice;
import com.accp.pojo.Goldnotes;
import com.accp.pojo.Integral;
import com.accp.pojo.Integralrecord;
import com.accp.pojo.Orders;
import com.accp.vo.DJJ.EvaluationOrService;
import com.accp.vo.DJJ.MyServiceCollCetionType;
import com.accp.vo.DJJ.OrdersStateNumber;
import com.accp.vo.DJJ.ServiceCollectionVo;
import com.accp.vo.DJJ.ordersServicesServiceTypeVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class HanTingBiz {
	
	@Autowired
	private IHanTingDao dao;
	
	public List<com.accp.pojo.Service> findMyServiceByusid(int usid) {
		
		return dao.queryMyYudin(usid);
	}
	
	public int addUserJifen(int jifen,int usid) {
		return dao.jifenadd(jifen, usid);
		
	}
	
	public Integral findJifenGuige(int inteid) {
		return dao.queryJifenGuige(inteid);
		
	}
	
	public int addJifenRec(int userID,String IRDescribe,int recordInAndOut,int integralID,int auditStatus) {
		return dao.addJifenRecord(userID, IRDescribe, recordInAndOut, integralID, auditStatus);
	}
	
	public List<Integralrecord> findMyIntegRecord(int usid){
		return dao.queryJifenRecord(usid);
	}
	
	public PageInfo<Integralrecord> findAllMyJifenRecord(int usid,int num,int size){
		PageHelper.startPage(num,size);
		return new PageInfo<Integralrecord>(dao.queryAllMyJifenRecord(usid));
		
	}
	
	public PageInfo<ServiceCollectionVo> findAllMyServiceCollection(int usid,String title,int num,int size){
		PageHelper.startPage(num, size);
		return new PageInfo<ServiceCollectionVo>(dao.queryAllMyServicecollection(usid,title));
	}
	
	public PageInfo<ordersServicesServiceTypeVo> findAllMyOrder(int usid,String title,int num,int size){
		PageHelper.startPage(num, size);
		return new PageInfo<ordersServicesServiceTypeVo>(dao.queryAllMyOrder(usid,title));
	}
	
	public OrdersStateNumber findOrdersStateNumber(int usid) {
		return dao.queryordersStateNumber(usid);
	}
	
	public int removeMyServiceCollection(int serviceid) {
		int count =dao.deleteMyServicecollection(serviceid); 
		return count;
	}
	
	public int updateMyOrderState(int state,int oid) {
		int count = dao.updateOrderState(state, oid);
		return count;
	}
	
	public List<MyServiceCollCetionType> findMyServiceCollCetionType(int usid){
		return dao.queryMyServiceCollEctionType(usid);
	}
	
	public Orders findOrdersByoid(String oid) {
		return dao.queryOrderByOid(oid);
	}
	
	public int updateUserMoney(Integer usmoney,Integer usid) {
		return dao.updateUserMoney(usmoney, usid);
	}
	
	public PageInfo<Goldnotes> findMyGoldnotes(int usid,int num,int size){
		PageHelper.startPage(num, size);
		return new PageInfo<Goldnotes>(dao.queryGoldnotes(usid));
	}
	
	public int addGoldNote(Goldnotes gold) {
		int count = dao.addGoldNote(gold);
		return count;
	}
	
	public int findGoldNoteMaxRecordId() {
		return dao.queryMaxgoldrecordId();
	}
	
	public ordersServicesServiceTypeVo findOrdersServicesSTypeByoid(String oid) {
		return dao.querymyOrdersByOid(oid);
	}
	
	public void addEvaluationService(Evaluationservice eva) {
		 dao.addEvaluationService(eva);
	}
	
	public void updateOrdercommentstatusByOid(String oid,int State) {
		dao.updateOrdercommentstatusByOid(oid,State);
	}
	
	public List<EvaluationOrService> findMyEvaluationByusid(Integer usid){
	return dao.queryMyEvaluationByusid(usid);	
		
	}
	

}
