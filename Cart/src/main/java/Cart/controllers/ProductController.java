package Cart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Cart.models.ProductModel;
import Cart.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ProductModel> addItem(@RequestBody ProductModel item) {
        ProductModel createdItem = productService.addItem(item);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @GetMapping("/items")
    public ResponseEntity<List<ProductModel>> getAllItems() {
    	List<ProductModel> productList = productService.getAllItems();
        return ResponseEntity.ok(productList);
    }
}
