package service;

import lombok.RequiredArgsConstructor;
import model.Bank;
import model.CustomerDetails;
import model.Customers;
import org.springframework.stereotype.Service;
import repository.BankRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepo bankRepo;
    private final CustomerDetailsService customerDetailsService;
    public List<Bank> getBank() {
        return bankRepo.findAll();
    }
    public void addBank(Bank bank) {
        bankRepo.save(bank);
    }

    public boolean withdraws(Integer customerId, Integer amount) {
        CustomerDetails customerDetails = customerDetailsService.getCustomers(customerId);
        if (customerDetails == null || customerDetails.getBalance()<amount){
            return false;
        }
        customerDetails.setBalance(customerDetails.getBalance()-amount);
        return true;
    }

    public boolean deposits(Integer customerId, Integer amount) {
        CustomerDetails customerDetails = customerDetailsService.getCustomers(customerId);
        if (customerDetails == null || customerDetails.getBalance()<amount){
            return false;
        }
        customerDetails.setBalance(customerDetails.getBalance()+amount);
        return true;
    }
}
