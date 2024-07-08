package Cart;

import Cart.controllers.ProductController;
import Cart.models.ProductModel;
import Cart.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductControllerTest {
    

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;
    private MockMvc mockMvc;
    private ObjectMapper objectMapper;
    
    

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        objectMapper = new ObjectMapper();
    }

    @Test
    void addItem_Success() {
        ProductModel item = new ProductModel();
        item.setName("Laptop");
        item.setPrice(999.99);
        item.setQuantity(5);
        
        ProductModel savedItem = new ProductModel();
        savedItem.setId(1); // Assuming the service layer assigns an ID
        savedItem.setName(item.getName());
        savedItem.setPrice(item.getPrice());
        savedItem.setQuantity(item.getQuantity());

        when(productService.addItem(any(ProductModel.class))).thenReturn(savedItem);

        ResponseEntity<ProductModel> response = productController.addItem(item);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        verify(productService, times(1)).addItem(any(ProductModel.class));
    }

    @Test
    void getAllItems_Success() {
        List<ProductModel> items = Arrays.asList(new ProductModel(), new ProductModel());
        when(productService.getAllItems()).thenReturn(items);

        ResponseEntity<List<ProductModel>> response = productController.getAllItems();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
        verify(productService, times(1)).getAllItems();
    }
    

    
    @Test
    void addItem_Invalid() throws Exception {
        ProductModel invalidItem = new ProductModel();
        invalidItem.setName(""); 
        invalidItem.setPrice(10.0);
        invalidItem.setQuantity(5);

        mockMvc.perform(post("/api/cart/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidItem)))
                .andExpect(status().isBadRequest());

        verify(productService, never()).addItem(any(ProductModel.class));
    }

    @Test
    void getAllItems_Empty() {
        when(productService.getAllItems()).thenReturn(Collections.emptyList());
        
        ResponseEntity<List<ProductModel>> response = productController.getAllItems();
        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().isEmpty());
    }
    
}