package Belajar.perpustakaan.perpustakaan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Belajar.perpustakaan.perpustakaan.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}

