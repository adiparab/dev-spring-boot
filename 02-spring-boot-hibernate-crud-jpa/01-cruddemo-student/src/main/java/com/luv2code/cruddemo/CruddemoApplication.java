package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner CommandLineRunner(StudentDao studentDao){

    return runner -> {

		//createStudent(studentDao);

		//readStudent(studentDao);

		//findAllStudents(studentDao);

		//findStudentByLatsName(studentDao);

		//updateStudent(studentDao);

		//deleteStudent(studentDao);

		deleteAllStudents(studentDao);
	};
	}

	private void deleteAllStudents(StudentDao studentDao) {
		System.out.println("Deleting all students ");
		int deleteRows =studentDao.deleteAll();
		System.out.println("Total deleted rows- "+deleteRows);

	}

	private void deleteStudent(StudentDao studentDao) {


		//delete the student
		System.out.println("deleting student");
		studentDao.delete(1);
	}

	private void updateStudent(StudentDao studentDao) {

		//retrieve student on primary key id
		int studentId =1;
       Student myStudent = studentDao.findById(studentId);

		//change first name to sagar
		System.out.println("updating student ");
		myStudent.setFirstName("Sagar");

		//update the student
		studentDao.update(myStudent);

		// display the updated student
		System.out.println("Updated student:- "+myStudent);
	}

	private void findStudentByLatsName(StudentDao studentDao) {

		List<Student> studentList = studentDao.findByLastName("Sharma");

		for(Student student : studentList){
			System.out.println("student "+student);
		}
	}

	private void findAllStudents(StudentDao studentDao) {

		List<Student> studentList = studentDao.findAll();

		for(Student student : studentList){
			System.out.println("student "+student);
		}

	}

	private void readStudent(StudentDao studentDao) {

		//create the student object
		System.out.println("Creating new student object");
		Student student1 = new Student("Rohit", "Sharma", "sharma.rohit@tcs.com");

		//Save the object
		System.out.println("Saving new student object");
		studentDao.save(student1);

		//deisplay id of the save student
		System.out.println("Saved student, generated id:- "+ student1.getId());

		System.out.println("get student, by id:- "+ studentDao.findById(student1.getId()));
	}

	private void createStudent(StudentDao studentDao) {

		//create the student object
		System.out.println("Creating new student object");
       Student student1 = new Student("Aditya", "Parab", "parab.aditya1@tcs.com");

		//Save the object
		System.out.println("Saving new student object");
		studentDao.save(student1);

		//deisplay id of the save student
		System.out.println("Saved student, generated id:- "+ student1.getId());





	}

}
