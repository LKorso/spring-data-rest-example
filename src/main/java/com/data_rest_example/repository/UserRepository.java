package com.data_rest_example.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import com.data_rest_example.domain.User;


@Repository
public interface UserRepository extends ElasticsearchCrudRepository<User, String> {

    User findUserByEmail(String email);

    default boolean existsByEmail(String email) {
        return findUserByEmail(email) != null;
    }

}

