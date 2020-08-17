package com.gaurav.restwebservice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserDataCrudOprearionRepository extends JpaRepository<UserData, Integer> {

}
