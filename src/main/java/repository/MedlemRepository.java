package repository;

import klasser.Medlem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedlemRepository extends JpaRepository<Medlem, Long> {

    Medlem findByEmail(String email);
    Medlem findByEmailAndPassword(String email, String password);
}
