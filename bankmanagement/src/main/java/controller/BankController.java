package controller;

import DOT.Api;
import lombok.RequiredArgsConstructor;
import model.Bank;
import model.CustomerDetails;
import model.Customers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import service.BankService;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/bank")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

    @GetMapping
    public ResponseEntity getBank() {
        return ResponseEntity.status(200).body(bankService.getBank());
    }
    @PostMapping
    public ResponseEntity<Api> addCustomer(@RequestBody @Valid Bank bank) {
        bankService.addBank(bank);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("New Bank added !", 201));
    }
//    @PostMapping("/withdraws/{amount}/{customerId}")
//    public ResponseEntity<Api> withdraws(@Valid @PathVariable Integer amount, @PathVariable Integer customerId, Errors errors){
//        if (errors.hasErrors()) {
//            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
//        }
//        boolean isWithdraws =bankService.withdraws(customerId,amount);
//        if (!isWithdraws) {
//            return ResponseEntity.status(400).body(new Api("Not found customer", 400));
//        }
//        return ResponseEntity.status(200).body(new Api("Withdraw completed", 200));
//    }
//
//    @PostMapping("/deposits/{amount}/{customerId}")
//    public ResponseEntity<Api> deposits(@Valid @PathVariable Integer amount,@PathVariable Integer customerId, Errors errors){
//        if (errors.hasErrors()) {
//            return ResponseEntity.status(400).body(new Api(errors.getFieldError().getDefaultMessage(), 400));
//        }
//        boolean isDeposits =bankService.deposits(customerId,amount);
//        if (!isDeposits) {
//            return ResponseEntity.status(400).body(new Api("Not found customer", 400));
//        }
//        return ResponseEntity.status(200).body(new Api("Deposits completed", 200));
//    }
}
