package com.edpl.article.model;

import lombok.*;

import javax.persistence.*;

/**
 * @author ogbozoyan
 * @date 07.05.2023
 */
@Data
@Entity
@Table(name = "articles", schema = "public", catalog = "serega")
public class ArticlesEntity extends AbstractEntity{
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "content")
    private String content;
    @ManyToOne
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    private UsersEntity ownerId;

}
