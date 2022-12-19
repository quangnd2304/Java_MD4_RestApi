package ra.model.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.model.entity.Student;
import ra.model.repository.StudentRepository;
import ra.model.service.StudentService;

import java.sql.SQLException;
import java.util.List;
@Service
@Transactional(rollbackFor = SQLException.class)
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(int studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public Student saveOrUpdate(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void delete(int studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public List<Student> searchByName(String studentName, int studentId) {
        return studentRepository.findByStudentNameOrStudentId(studentName,studentId);
    }

    @Override
    public List<Student> getStudentByAgeBetween(int ageFrom, int ageTo) {
        return studentRepository.getStudentByAgeBetween(ageFrom,ageTo);
    }
}
