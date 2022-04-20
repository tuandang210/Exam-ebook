package cmcglobal.ebook.repository;

import cmcglobal.ebook.entity.Customer;
import cmcglobal.ebook.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {
    Order findOrderByCustomer(Customer customer);
}
