package UIController;

import entiteter.Kæledyr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface kæledyrRepository extends JpaRepository<Kæledyr, Integer> {
}
