package com.kalangirajeev.almightybiblequiz.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Questionaire {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    String id;

    @NotNull (message = "Book Number cannot be null")
    @NotBlank(message = "Book Number cannot be blank")
    String bookNumber;

    @NotNull (message = "Chapter Number cannot be null")
    @NotBlank(message = "Chapter Number cannot be blank")
    String chapterNumber;

    @NotNull (message = "Question cannot be null")
    @NotBlank(message = "Question cannot be blank")
    String question;

    @NotNull (message = "Option A cannot be null")
    @NotBlank(message = "Option A cannot be blank")
    String optionA;

    @NotNull (message = "Option B cannot be null")
    @NotBlank(message = "Option B cannot be blank")
    String optionB;

    @NotNull (message = "Option C cannot be null")
    @NotBlank(message = "Option C cannot be blank")
    String optionC;

    @NotNull (message = "Option D cannot be null")
    @NotBlank(message = "Option D cannot be blank")
    String optionD;

    @NotNull (message = "Correct Answer cannot be null")
    @NotBlank(message = "Correct Answer cannot be blank")
    String correctAnswer;


    Long createdOn;

    @NotNull (message = "Person Created cannot be null")
    @NotBlank(message = "Person Created cannot be blank")
    String createdBy;

    Long updatedOn;

    @NotNull (message = "Person Updated cannot be null")
    @NotBlank(message = "Person Updated cannot be blank")
    String updatedBy;
}
