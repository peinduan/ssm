package cn.it.dao;


import cn.it.domain.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    @Select("select * from product")
    List<Product> finAll();
}
