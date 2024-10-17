package com.esoft.ICTSS.model;

import com.esoft.ICTSS.enums.RoleType;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String contact;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType role; // This will store the role of the user

    @Column(nullable = true)
    private String profileImage; // Image path

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

}

