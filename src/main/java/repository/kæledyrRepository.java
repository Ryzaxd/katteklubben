package repository;

import klasser.Kæledyr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface kæledyrRepository extends JpaRepository<Kæledyr, Long> {
    Kæledyr save(Kæledyr kæledyr);
}
