package hengzhi.service;

import hengzhi.dao.DaoHangDao;
import hengzhi.entity.DaoHang;
import hengzhi.entity.News;

import java.util.List;

public class DaoHangService {

  static  DaoHangDao dao = new DaoHangDao();

  
  //修改单条
  public static int upDaoHang(DaoHang daohang) {
      return dao.upDaoHang(daohang);
  }
  
//分页查询列表
  public List<DaoHang> getDaoHangList(int pageNo){
      return dao.getDaoHangList(pageNo);
  }
  
  //查询单条详情
  public DaoHang getDaoHang(int id){
      return dao.getDaoHang(id);
  }  
  
//新增单条
  public static int addDaoHang(DaoHang daohang) {
     return dao.addDaoHang(daohang);
  }
  
  
  //删除单条
  public int delete(int id) {
      return dao.delete(id);
  }
}
