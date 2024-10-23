package Belajar.perpustakaan.perpustakaan.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Belajar.perpustakaan.perpustakaan.model.Loan;
import Belajar.perpustakaan.perpustakaan.service.LoanService;

@RestController
@RequestMapping("/api/loans")

@CrossOrigin(origins = "http://127.0.0.1:5173")

public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        return loanService.createLoan(loan);
    }

    @GetMapping("/user/{userId}")
    public List<Loan> getLoansByUserId(@PathVariable Long userId) {
        return loanService.findByUserId(userId);
    }
}
 
