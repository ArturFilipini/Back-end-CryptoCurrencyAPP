package com.main.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "description")
    private String description;
    @Lob
    @Column(name = "image")
    private byte[] image;
}
