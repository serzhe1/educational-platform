package com.edpl.article.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


/**
 * @author ogbozoyan
 * @date 07.05.2023
 */
@Data
@Entity
@Table(name = "users", schema = "public", catalog = "serega")
public class UsersEntity extends AbstractEntity{
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "full_name")
    private String fullName;
}
