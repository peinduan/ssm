package cn.it.dao;

import cn.it.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISysDao {


    @Insert("insert into syslog values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void saveSysLog(SysLog sysLog);


    @Select("select * from syslog")
    List<SysLog> findAll();

}
