package com.kalangirajeev.almightybiblequiz.controllers;

import com.kalangirajeev.almightybiblequiz.models.Questionaire;
import com.kalangirajeev.almightybiblequiz.services.QuestionaireService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@RestController
@RequestMapping("questionaire")
public class QuestionaireController {
    @Autowired
    QuestionaireService questionaireService;

    @GetMapping(value = "test")
    public ResponseEntity<?> test() {
        return new ResponseEntity<>("Connection Accepted", HttpStatus.OK);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> create(@RequestBody @Valid Questionaire questionaire) {
        questionaire.setCreatedOn(System.currentTimeMillis());
        questionaire.setUpdatedOn(System.currentTimeMillis());
        return new ResponseEntity<>(questionaireService.save(questionaire), HttpStatus.CREATED);
    }

    @PostMapping(value = "/update/{uuid}")
    public ResponseEntity<?> update(@RequestBody @Valid Questionaire questionaire, @PathVariable String uuid) {
        Optional<Questionaire> optionalQuestionaire = questionaireService.findById(uuid);
        if (optionalQuestionaire.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            Questionaire q = optionalQuestionaire.get();
            questionaire.setId(q.getId());
            questionaire.setCreatedOn(q.getCreatedOn());
            questionaire.setCreatedBy(q.getCreatedBy());
            questionaire.setUpdatedOn(System.currentTimeMillis());
            return new ResponseEntity<>(questionaireService.save(questionaire), HttpStatus.CREATED);
        }
    }

    @GetMapping(value = "get-all-questions")
    public ResponseEntity<?> getAllQuestions(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                             @RequestParam(value = "size", required = false, defaultValue = "2") Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdBy").descending());
        return new ResponseEntity<>(questionaireService.findAllQuestions(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{uuid}")
    public ResponseEntity<?> getQuestionaire(@PathVariable("uuid") String uuid) {
        Optional<Questionaire> q = questionaireService.findById(uuid);
        if (q.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(q.get(), HttpStatus.OK);
        }
    }

}
