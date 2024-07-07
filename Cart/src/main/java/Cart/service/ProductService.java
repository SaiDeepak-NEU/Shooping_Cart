package Cart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Cart.models.ProductModel;
import Cart.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductModel addItem(ProductModel item) {
    	
        ProductModel savedItem = productRepository.save(item);
        return savedItem;
    }

    public List<ProductModel> getAllItems() {
        List<ProductModel> items = productRepository.findAll();
        return items;
    }
}
