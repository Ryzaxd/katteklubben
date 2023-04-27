package com.example.demoIgen;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedlemRepository extends JpaRepository<Medlem, Integer> {
    Medlem findByEmail(String email);
    Medlem findByEmailAndPassword(String email, String password);
}
