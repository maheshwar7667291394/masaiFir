package com.masai.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.CurrentUserSesson;

@Repository
public interface CurrentUserSessonDao extends JpaRepository<CurrentUserSesson,String>{
	public CurrentUserSesson findByuuid(String uuid);

}
