package com.java.Spring.Boot.Project.with.Web.and.repository;

import com.java.Spring.Boot.Project.with.Web.and.entity.UsersInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UsersInfo, String> {

    List<UsersInfo> findByEmailIdAndPassword(String emailId, String password);

}
