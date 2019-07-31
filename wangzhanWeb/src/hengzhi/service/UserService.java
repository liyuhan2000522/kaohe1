package hengzhi.service;

import hengzhi.dao.SortInfoDao;
import hengzhi.dao.UserDao;
import hengzhi.entity.SortInfo;
import hengzhi.entity.UserInfo;

import java.util.List;

public class UserService {

    static UserDao dao = new UserDao();

    //分页查询列表
    public List<UserInfo> getUserInfoList(int pageNo){
        return dao.getUserInfoList(pageNo);

    }
    //查询总数
    public static int getTotalPage() {
        return dao.getTotalPage();
    }

    //查询单条详情
    public UserInfo getUserInfo(int id){
        return dao.getUserInfo(id);

    }
    //新增单条
    public static int addUserInfo(UserInfo userInfo) {
        return dao.addUserInfo(userInfo);
    }
    
  //修改修改状态
    public static int upState(UserInfo userInfo) {
        return dao.upState(userInfo);
    }
    
    //修改单条
    public static int upUserInfo(UserInfo userInfo) {
        return dao.upUserInfo(userInfo);
    }
    //删除单条
    public int deleteUserInfo(int id) {
        return dao.deleteUserInfo(id);
    }

    //获取用户名是否存在
    public UserInfo getUserInfoByUserName(String username,int state){
        return dao.getUserInfoByUserName(username,state);
    }


}
