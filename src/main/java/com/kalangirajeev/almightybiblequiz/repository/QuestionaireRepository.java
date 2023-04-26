package com.kalangirajeev.almightybiblequiz.repository;

import com.kalangirajeev.almightybiblequiz.models.Questionaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionaireRepository extends JpaRepository<Questionaire, String> {

}
