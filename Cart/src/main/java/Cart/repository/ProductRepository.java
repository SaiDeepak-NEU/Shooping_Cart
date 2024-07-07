package Cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Cart.models.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
