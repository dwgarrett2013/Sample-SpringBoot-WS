package hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.dao.StudentService;
import hello.domain.Student;

@RestController
@RequestMapping("/service/student/")
public class StudentController {
    @Autowired
    private StudentService studentService;

   
    @RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Student> getAllStudents() {
        List<Student> Students = studentService.getAllStudents();
        return Students;
    }
   
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Student getStudentById(@PathVariable int id) {
        Student Student = studentService.getStudentById(id);
        return Student;
    }
}