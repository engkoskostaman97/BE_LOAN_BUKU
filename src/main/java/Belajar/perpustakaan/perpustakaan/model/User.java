package Belajar.perpustakaan.perpustakaan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    @Column(name = "is_admin", nullable = false)
    private Boolean isAdmin = false; //

    @JsonIgnore // Tambahkan anotasi ini untuk menghindari siklus referensi
    @OneToOne(mappedBy = "user")
    private Loan loan;
}

