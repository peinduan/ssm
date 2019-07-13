package cn.it.dao;


import cn.it.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface IProductDao {

    @Select("select * from product")
    List<Product> finAll();

    @Insert("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus)\n" +
            "values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void add(Product product);


    @Select("select * from product where id=#{id}")
    Product findById(String id);
}
