package Belajar.perpustakaan.perpustakaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Belajar.perpustakaan.perpustakaan.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

