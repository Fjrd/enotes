package com.example.enotes.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Note {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    public Note(String message, String tag) {
        this.message = message;
        this.tag = tag;
    }

    private String message;

    private String tag;


}
