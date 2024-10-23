package Belajar.perpustakaan.perpustakaan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Belajar.perpustakaan.perpustakaan.model.Book;
import Belajar.perpustakaan.perpustakaan.model.Loan;
import Belajar.perpustakaan.perpustakaan.model.User;
import Belajar.perpustakaan.perpustakaan.repository.BookRepository;
import Belajar.perpustakaan.perpustakaan.repository.LoanRepository;
import Belajar.perpustakaan.perpustakaan.repository.UserRepository;

import java.util.List;

@Service
public class LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public Loan createLoan(Loan loan) {
        populateLoanDefaults(loan);
        return loanRepository.save(loan);
    }

    public List<Loan> findByUserId(Long userId) {
        List<Loan> loans = loanRepository.findByUserId(userId);
        return populateLoanDefaults(loans);
    }

    private List<Loan> populateLoanDefaults(List<Loan> loans) {
        for (Loan loan : loans) {
            populateLoanDefaults(loan);
        }
        return loans;
    }

    private Loan populateLoanDefaults(Loan loan) {
        if (loan.getUser() != null && loan.getUser().getId() != null) {
            User user = userRepository.findById(loan.getUser().getId()).orElse(new User());
            if (loan.getUser().getEmail() == null) {
                loan.getUser().setEmail(user.getEmail());
            }
            if (loan.getUser().getPassword() == null) {
                loan.getUser().setPassword(user.getPassword());
            }
            if (loan.getUser().getIsAdmin() == null) {
                loan.getUser().setIsAdmin(user.getIsAdmin());
            }
        }

        if (loan.getBook() != null && loan.getBook().getId() != null) {
            Book book = bookRepository.findById(loan.getBook().getId()).orElse(new Book());
            if (loan.getBook().getTitle() == null) {
                loan.getBook().setTitle(book.getTitle());
            }
            if (loan.getBook().getAuthor() == null) {
                loan.getBook().setAuthor(book.getAuthor());
            }
        }

        return loan;
    }
}
