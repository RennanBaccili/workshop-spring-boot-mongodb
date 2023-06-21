package com.rennanbacili.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rennanbacili.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
/*Permite diversas funções*/