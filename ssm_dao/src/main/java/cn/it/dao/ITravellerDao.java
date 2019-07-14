package cn.it.dao;

import cn.it.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITravellerDao {

    @Select("SELECT traveller.*\n" +
            "FROM traveller,order_traveller\n" +
            "WHERE traveller.`id`=order_traveller.`travellerid` AND order_traveller.`orderid`=#{ordersId}")
    List<Traveller> findByOrdersId(String ordersId);
}
