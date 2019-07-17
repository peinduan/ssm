package cn.it.service;

import cn.it.domain.SysLog;

import java.util.List;

public interface ISysService {

    void saveSysLog(SysLog sysLog);

    List<SysLog> findAll(Integer pageNum,Integer pageSize);


}
