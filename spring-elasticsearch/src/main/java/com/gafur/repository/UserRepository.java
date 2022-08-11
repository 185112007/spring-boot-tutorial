package com.gafur.repository;

import com.gafur.entity.User;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {
    @Query("{ \"bool\" : { \"must\" : [{ \"match\" : { \"name\" : \"?0\" } }] } }")
    List<User> getByCustomQuery(String search);

    // OR
    List<User> findByName(String search);
}
