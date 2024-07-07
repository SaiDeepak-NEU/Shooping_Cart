package Cart.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank(message = "Name is mandatory")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;
    

    @NotNull(message = "Price is mandatory")
    @Positive(message = "Price must be positive")
    private Double price;
    
    @NotNull(message = "Quantity is mandatory")
    @PositiveOrZero(message = "Quantity must be zero or positive")
    private Integer quantity;
}
