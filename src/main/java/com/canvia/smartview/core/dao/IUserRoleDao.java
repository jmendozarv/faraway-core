package com.canvia.smartview.core.dao;

import com.canvia.smartview.core.entity.TtUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRoleDao extends JpaRepository<TtUserRole, Long> {

    @Query("select ur from TtUserRole ur join ur.user u where u.username = ?1")
    List<TtUserRole> findAllByUsername(String username);
}
