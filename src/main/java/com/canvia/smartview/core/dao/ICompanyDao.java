package com.canvia.smartview.core.dao;

import com.canvia.smartview.core.entity.MtCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompanyDao extends JpaRepository<MtCompany, Long> {

    @Query("select new MtCompany(c.companyId,c.companyName,c.mainColor,c.secondaryColor,c.logo,c.backgroundImage,c.cmsSitename) from MtCompany c join c.userList u where u.username = ?1")
    List<MtCompany> findAllByUsername(String username);
}
