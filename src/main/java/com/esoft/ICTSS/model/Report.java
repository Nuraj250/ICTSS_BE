package com.esoft.ICTSS.model;

import jakarta.persistence.Entity;
import lombok.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Report{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "generated_date")
    private LocalDate generatedDate;

    @Lob
    private String content;
}
