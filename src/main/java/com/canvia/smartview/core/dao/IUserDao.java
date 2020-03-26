package com.canvia.smartview.core.dao;
import com.canvia.smartview.core.entity.MtUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao extends JpaRepository<MtUser, Long> {

    MtUser findByUsername(String username);
}
