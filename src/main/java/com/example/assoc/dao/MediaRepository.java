package com.example.assoc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.example.assoc.entities.Media;

public interface MediaRepository extends JpaRepository<Media, Integer>{
	@Transactional
	@Modifying
	@Query("delete from Media where action.idAction=:id")
	public void deleteMediaByActId(@Param("id")Integer idAction);

}
