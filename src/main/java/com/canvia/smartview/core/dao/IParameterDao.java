package com.canvia.smartview.core.dao;

import com.canvia.smartview.core.entity.MtParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IParameterDao extends JpaRepository<MtParameter, Long> {

}
