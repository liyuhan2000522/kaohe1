package hengzhi.service;

import hengzhi.dao.SortInfoDao;
import hengzhi.entity.SortInfo;
import java.util.List;

public class SortInfoService {

    static SortInfoDao dao = new SortInfoDao();

    //分页查询列表
    public List<SortInfo> getSortList(int pageNo){
        return dao.getSortList(pageNo);

    }
    //查询总数
    public static int getTotalPage() {
        return dao.getTotalPage();
    }

    //查询单条详情
    public SortInfo getSortInfo(int id){
        return dao.getSortInfo(id);

    }
    //新增单条
    public static int addSortInfo(SortInfo sortInfo) {
        return dao.addSortInfo(sortInfo);
    }
    //修改单条
    public static int upSortInfo(SortInfo sortInfo) {
        return dao.upSortInfo(sortInfo);
    }
    //删除单条
    public int deleteSortInfo(int id) {
        return dao.deleteSortInfo(id);
    }

}
