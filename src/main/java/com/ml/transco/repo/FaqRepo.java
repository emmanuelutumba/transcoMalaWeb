package com.ml.transco.repo;


import com.ml.transco.model.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqRepo extends JpaRepository<Faq, Long> {
}
