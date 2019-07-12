package cn.it.service.impl;

import cn.it.dao.ProductDao;
import cn.it.domain.Product;
import cn.it.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iProductService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.finAll();
    }

    @Override
    public void add(Product product) {
        productDao.add(product);
    }
}
