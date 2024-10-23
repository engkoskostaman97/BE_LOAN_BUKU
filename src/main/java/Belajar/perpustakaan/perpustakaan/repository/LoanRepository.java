package Belajar.perpustakaan.perpustakaan.repository;

import Belajar.perpustakaan.perpustakaan.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByUserId(Long userId);
}
