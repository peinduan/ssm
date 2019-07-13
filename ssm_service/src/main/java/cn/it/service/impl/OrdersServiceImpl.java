package cn.it.service.impl;

import cn.it.dao.IOrdersDao;
import cn.it.domain.Orders;
import cn.it.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;
    @Override
    public List<Orders> findAll() {
        return ordersDao.findAll();
    }
}
