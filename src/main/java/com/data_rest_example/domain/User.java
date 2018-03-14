package com.data_rest_example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@Document(indexName = "user", type = "user", shards = 1, replicas = 0)
public class User {

    @Id
    private String id;

    private String email;

    private String firstName;

    private String lastName;

    private String password;

    private List<String> roles;

    public User() {
    }

    public User(String id, String email, String firstName, String lastName, String password) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }
}
