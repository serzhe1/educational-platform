package com.edpl.article.model;

import lombok.*;

import javax.persistence.*;
@Data
@Entity
@Table(name = "articles", schema = "public")
public class ArticlesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column
    private String ownerUuid;

}
