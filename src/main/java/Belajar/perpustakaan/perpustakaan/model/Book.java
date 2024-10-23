package Belajar.perpustakaan.perpustakaan.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private boolean isAvailable = true;

    @JsonIgnore // Tambahkan anotasi ini jika ada referensi balik
    @OneToMany(mappedBy = "book")
    private List<Loan> loans;

}
