package com.dreamsathis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dreamsathis.entity.Course;

@Repository
public interface CourseRepositoty extends JpaRepository<Course, Long>{

	boolean existsByCourseName(String courseName);

	//List<Course> findByStatus(boolean b);

	List<Course> findBycourseNameAndStatus(String courseName, boolean b);

}
