package ir.maktab.manager;

import ir.maktab.dao.StudentDao;
import ir.maktab.entities.Student;

public class StudentManager {
    private static StudentManager instance;
    private static StudentDao studentDao = StudentDao.getInstance();

    private StudentManager() {
        super();
    }

    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    public static void add(Student student) throws Exception {
        studentDao.add(student);
    }

    public static Student[] list() throws Exception {
        return (Student[]) studentDao.list();
    }

    public static void delete(Integer id) throws Exception {
        studentDao.delete(id);
    }

    public void update(Student student) throws Exception {
        studentDao.update(student);
    }
}
