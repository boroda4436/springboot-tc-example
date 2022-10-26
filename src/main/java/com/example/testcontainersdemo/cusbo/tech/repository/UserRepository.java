package com.example.testcontainersdemo.cusbo.tech.repository;

import com.example.testcontainersdemo.cusbo.tech.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query("update User u set u.status = :status where u.name = :name")
    int updateUserSetStatusForName(@Param("status") Integer status,
                                   @Param("name") String name);

    @Modifying
    @Query(value = "UPDATE messenger_user u SET u.status = ? WHERE u.name = ?",
            nativeQuery = true)
    int updateUserSetStatusForNameNative(Integer status, String name);
}
