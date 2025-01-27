package com.example.reddit.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class Role {

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleid;

    @Column(nullable=false, unique=true)
    private String name;

    public Role(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

}

