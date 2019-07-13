package cn.it.service;

import cn.it.domain.Orders;

import java.util.List;

public interface IOrdersService {

    List<Orders> findAll();
}
