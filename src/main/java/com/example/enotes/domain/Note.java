package com.example.enotes.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Note {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public long id;
    private String message;
    private String tag;


}
