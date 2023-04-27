package repository;

import klasser.Kat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KatRepository extends JpaRepository<Kat, Integer> {
}
