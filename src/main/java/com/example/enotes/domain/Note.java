package com.example.enotes.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Note {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    public Long id;
    private String message;
    private String tag;


}
