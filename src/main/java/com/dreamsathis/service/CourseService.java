package com.dreamsathis.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dreamsathis.entity.Course;
import com.dreamsathis.repository.CourseRepositoty;
import com.dreamsathis.utils.Constants;

@Service
public class CourseService {

	@Autowired
	private CourseRepositoty courseRepositoty;

	public void addCourse(Course course, MultipartFile file,MultipartFile teacherFile) {

		String path = Constants.BASE_DIR + Constants.BLOG_IMAGE;
		String fname = Constants.getRandomPassword() + ".jpg";
		String fname1 = Constants.getRandomPassword() + ".jpg";
		String fileName = Constants.saveMultiPartFile(file, path, fname);
		String fileName2 = Constants.saveMultiPartFile(teacherFile, path, fname1);
		String url = Constants.BASE_IP + Constants.BASE_DIR + Constants.BLOG_IMAGE;
		System.err.println("::::::url.addBlog::::" + url);
		course.setLogo(fileName);
		course.setTeacherimage(fileName2);
		course.setImgUrl(url);
		course.setCreatedAt(Constants.getDateAndTime());
		course.setUpdatedAt(Constants.getDateAndTime());
		course.setStatus(true);
		courseRepositoty.save(course);

	}

	public void updateCourse(Course course, Optional<Course> courses, MultipartFile file, MultipartFile teacherFile) {
		
		String path = Constants.BASE_DIR + Constants.BLOG_IMAGE;
		String fname = Constants.getRandomPassword() + ".jpg";
		String fileName = Constants.saveMultiPartFile(file, path, fname);
		
		String fname1 = Constants.getRandomPassword() + ".jpg";
		String fileName1 = Constants.saveMultiPartFile(teacherFile, path, fname1);
		String url = Constants.BASE_IP + Constants.BASE_DIR + Constants.BLOG_IMAGE;
		Course data = courses.get();
		data.setCourseAmount(course.getCourseAmount());
		data.setCourseDescription(course.getCourseDescription());
		data.setCourseName(course.getCourseName());
		data.setCourseType(course.getCourseType());
		data.setImgUrl(url);
		data.setLogo(fileName);
		data.setTeacherimage(fileName1);
		data.setRating(course.getRating());
		data.setUpdatedAt(Constants.getDateAndTime());
		courseRepositoty.save(data);
	}


}
