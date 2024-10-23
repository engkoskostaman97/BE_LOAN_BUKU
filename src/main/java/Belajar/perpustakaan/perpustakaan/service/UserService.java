package Belajar.perpustakaan.perpustakaan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import Belajar.perpustakaan.perpustakaan.model.User;
import Belajar.perpustakaan.perpustakaan.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        // Check if email is already registered
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email sudah terdaftar");
        }

        // Validate the password
        if (!isValidPassword(user.getPassword())) {
            throw new RuntimeException("Password tidak memenuhi kriteria: minimal 8 karakter, setidaknya 1 huruf kapital,tidak boleh mengandung special karakter.");
        }

        // Encode the password and set user attributes
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setIsAdmin(false); // Set isAdmin to false by default

        // Save the user to the repository
        return userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    // Method to validate password
    private boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        if (!password.matches("[A-Za-z0-9]+")) {
            return false;
        }

        return true; 
    }
}
