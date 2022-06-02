package service;

import lombok.RequiredArgsConstructor;
import model.Customers;
import org.springframework.stereotype.Service;
import repository.CustomersRepo;

import java.util.List;

@Service @RequiredArgsConstructor
public class CustomersService {

    private final CustomersRepo customersRepo;
    public List<Customers> getCustomers() {
        return customersRepo.findAll();
    }

    public void addCustomer(Customers customers) {
        customersRepo.save(customers);
    }

}
