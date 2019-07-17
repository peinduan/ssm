package cn.it.service.impl;

import cn.it.dao.ISysDao;
import cn.it.domain.SysLog;
import cn.it.service.ISysService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SysServiceImpl implements ISysService {

    @Autowired
    private ISysDao sd;

    @Override
    public void saveSysLog(SysLog sysLog) {
        sd.saveSysLog(sysLog);
    }

    @Override
    public List<SysLog> findAll(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return sd.findAll();
    }
}
