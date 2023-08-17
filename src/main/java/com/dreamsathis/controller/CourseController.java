package com.dreamsathis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dreamsathis.bean.ResultDTO;
import com.dreamsathis.entity.Course;
import com.dreamsathis.utils.Constants;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/home")
public class CourseController extends BaseController {

	@PostMapping("/addCourse")
	public ResponseEntity<?> addCourse(@ModelAttribute Course course,
			@RequestParam(value = "file", required = true) MultipartFile file,
			@RequestParam(value = "teacherFile", required =true) MultipartFile teacherFile) {
		System.err.println("::::::CourseController.addCourse::::");
		try {
			if (courseRepositoty.existsByCourseName(course.getCourseName())) {
				responsePacket = new ResultDTO<>(true, null, "This Course is Already exists !!");
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else if (course.getCourseName().isEmpty()) {
				responsePacket = new ResultDTO<>(true, null, "Please enter course name  !!");
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				courseService.addCourse(course, file,teacherFile);
				responsePacket = new ResultDTO<>(true, null, Constants.addData);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getCourseList")
	public ResponseEntity<?> getCourseList() {
		System.err.println("::::::CourseController.getCourseList::::");
		try {
			List<Course> courses = courseRepositoty.findAll();
			if (courses.isEmpty()) {
				responsePacket = new ResultDTO<>(true, null, Constants.recordNotFound);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>(true, courses, Constants.dataGetSucceed);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}

		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/getCourseName")
	public ResponseEntity<?> getCourseName(@ModelAttribute Course course) {
		System.err.println("::::::CourseController.getCourseName::::");
		try {
			List<Course> courses = courseRepositoty.findBycourseNameAndStatus(course.getCourseName(), true);
			if (courses.isEmpty()) {
				responsePacket = new ResultDTO<>(true, null, Constants.recordNotFound);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>(true, courses, Constants.dataGetSucceed);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@PostMapping("/updateCourse")
	public ResponseEntity<?> updateCourse(@ModelAttribute Course course,
			@RequestParam(value = "file", required = false) MultipartFile file,
			@RequestParam(value = "teacherFile", required =false) MultipartFile teacherFile) {
		System.err.println("::::::CourseController.getCourseName::::");
		try {
			Optional<Course> courses = courseRepositoty.findById(course.getId());
			if (courses.isPresent()) {
				courseService.updateCourse(course,courses,file,teacherFile);
				responsePacket = new ResultDTO<>(true, courses, Constants.dataGetSucceed);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			} else {
				responsePacket = new ResultDTO<>(true, null, Constants.recordNotFound);
				return new ResponseEntity<>(responsePacket, HttpStatus.OK);
			}
		} catch (Exception e) {
			responsePacket = new ResultDTO<>(false, null, e.getMessage());
			return new ResponseEntity<>(responsePacket, HttpStatus.BAD_REQUEST);
		}
	}
	
	

}
