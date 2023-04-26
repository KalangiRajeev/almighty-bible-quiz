package com.kalangirajeev.almightybiblequiz.services;

import com.kalangirajeev.almightybiblequiz.models.Questionaire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface QuestionaireService {
    Questionaire save(Questionaire questionaire);

    Optional<Questionaire> findById(String uuid);

    Page<Questionaire> findAllQuestions(Pageable pageable);

}
