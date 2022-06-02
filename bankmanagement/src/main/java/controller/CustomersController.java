package controller;

import DOT.Api;
import lombok.RequiredArgsConstructor;
import model.Customers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import service.CustomersService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@RequiredArgsConstructor
public class CustomersController {

    private final CustomersService customersService;

    @GetMapping
    public ResponseEntity <List<Customers>> getCustomers(){
        return ResponseEntity.status(200).body(customersService.getCustomers());
    }

    @PostMapping
    public ResponseEntity addCustomers(@RequestBody @Valid Customers customers ,Errors errors)throws IllegalAccessError{
        if (errors.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Api("Error server!",400));
        }
        customersService.addCustomer(customers);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("New Customer added !",201));
    }
}
