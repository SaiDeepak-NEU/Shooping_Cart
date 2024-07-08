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
    	
    	try {
    		ProductModel savedItem = productRepository.save(item);
            return savedItem;
    	} catch (Exception e) {
    		throw new RuntimeException("Error adding item: " + e.getMessage());
    	}
        
    }

    public List<ProductModel> getAllItems() {
    	try {
    	       List<ProductModel> items = productRepository.findAll();
    	        return items;
    	} catch (Exception e) {
    		throw new RuntimeException("Error fetching all items: " + e.getMessage());
    	}
 
    }
}
