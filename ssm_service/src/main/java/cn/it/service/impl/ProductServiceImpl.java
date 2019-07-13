package cn.it.service.impl;

import cn.it.dao.IProductDao;
import cn.it.domain.Product;
import cn.it.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iProductService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao IProductDao;

    @Override
    public List<Product> findAll() {
        return IProductDao.finAll();
    }

    @Override
    public void add(Product product) {
        IProductDao.add(product);
    }
}
