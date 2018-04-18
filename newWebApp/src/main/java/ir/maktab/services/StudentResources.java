package ir.maktab.services;

import ir.maktab.entities.Student;
import ir.maktab.manager.StudentManager;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentResources {
    @POST
    @Path("/add")
    public String add(Student student) {
        try {
            StudentManager.getInstance().add(student);

        } catch (Exception e) {
            e.printStackTrace();
            return "Student don't added";

        }
        return "Student is added";
    }

    @GET
    @Path("/delete")
    public String delete(@QueryParam("id") Integer id) throws Exception {
        StudentManager.getInstance().delete(id);
        return "Student is deleted";
    }

    @POST
    @Path("/update")
    public String update(Student student) throws Exception {
        StudentManager.getInstance().update(student);
        return "Student is updated";
    }

    @GET
    @Path("/list")
    public Student[] list() throws Exception {
        return (Student[]) StudentManager.getInstance().list();
    }
}
