package com.example.enotes.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Entity
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Note {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Message should not be empty")
    @Size(min = 3, max = 155, message = "Message size [3 - 155]")
    private String message;

    private String tag;

    public Note(String message, String tag) {
        this.message = message;
        this.tag = tag;
    }

}
