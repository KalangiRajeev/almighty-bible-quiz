package com.kalangirajeev.almightybiblequiz.services;

import com.kalangirajeev.almightybiblequiz.models.Questionaire;
import com.kalangirajeev.almightybiblequiz.repository.QuestionaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionaireServiceImpl implements QuestionaireService{

    @Autowired
    QuestionaireRepository questionaireRepository;
    @Override
    public Questionaire save(Questionaire questionaire) {
        return questionaireRepository.save(questionaire);
    }

    @Override
    public Optional<Questionaire> findById(String uuid) {
        return questionaireRepository.findById(uuid);
    }

    @Override
    public Page<Questionaire> findAllQuestions(Pageable pageable) {
        return questionaireRepository.findAll(pageable);
    }


}
