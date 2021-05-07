package com.example.dao;

import com.example.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from test where NAME like %?1%", nativeQuery = true)
    Page<User> findByNameLike(String name, Pageable pageRequest);

    @Query(value = "select * from test where NAME like %?1%", nativeQuery = true)
    User findByName(String name);

}
