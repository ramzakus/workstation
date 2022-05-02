package com.atos.af.api.repository;

import org.springframework.stereotype.Repository;

import com.atos.af.api.model.User;


import org.springframework.data.repository.CrudRepository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
