package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("resources.xml");
        Student s = (Student) context.getBean("st");
        s.internshipProgram();
        SpringBoot f = (SpringBoot) context.getBean("fun");
        f.hello("fun");
        Staffs staff= (Staffs) context.getBean("staf");
        staff.name("Shifali");
        ResourcePerson rp = (ResourcePerson) context.getBean("resper");
        rp.industry("RamPex");
        Training t= (Training) context.getBean("train");
        t.domain("SpringBoot + React");
    }
}