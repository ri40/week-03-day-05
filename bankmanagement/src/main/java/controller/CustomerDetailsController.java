package controller;

import DOT.Api;
import lombok.RequiredArgsConstructor;
import model.CustomerDetails;
import model.Customers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import service.CustomerDetailsService;

import javax.validation.Valid;


@RestController
@RequestMapping("api/v1/customer-details")
@RequiredArgsConstructor
public class CustomerDetailsController {
    private final CustomerDetailsService customerDetailsService;

    @GetMapping
    public ResponseEntity getCustomersDetails(){
        return ResponseEntity.status(200).body(customerDetailsService.getCustomerDetails());
    }
    @PostMapping
    public ResponseEntity addCustomersDetails(@RequestBody @Valid CustomerDetails customerDetails, Errors errors)throws IllegalAccessError {
        if (errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api("Error server!",400));
        }
        customerDetailsService.addCustomer(customerDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("New Customer added !",201));
    }


}
