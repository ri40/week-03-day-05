package repository;

import model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersDetailsRepo extends JpaRepository<CustomerDetails,Integer> {
}
