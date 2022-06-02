package service;

import lombok.RequiredArgsConstructor;
import model.CustomerDetails;
import org.springframework.stereotype.Service;
import repository.CustomersDetailsRepo;
import repository.CustomersRepo;


import java.util.List;
@Service @RequiredArgsConstructor
public class CustomerDetailsService {

    private final CustomersDetailsRepo customersDetailsRepo;

    public List<CustomerDetails> getCustomerDetails() {
        return customersDetailsRepo.findAll();
    }

    public void addCustomer(CustomerDetails customerDetails) {
        customersDetailsRepo.save(customerDetails);
    }

    public CustomerDetails getCustomers(Integer customerId) {
        return customersDetailsRepo.findById(customerId).get();
    }
}
