package project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import project.entity.Role;
import project.entity.User;
import project.services.UserService;

public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config.xml");

        UserService service = ctx.getBean(UserService.class);

      /*  User user = service.getUser("yuri");
        if (user != null) {
            service.delete(user);
        }

        user = new User();
        user.setName("yuri");
        List<Role> userRoles = new ArrayList<Role>();
        Role role = new Role();
        role.setName("test1");
        userRoles.add(role);
        user.setRoles(userRoles);
        service.save(user);*/

        System.out.println(service.getUser("user"));
        System.out.println(service.getUser("yuri"));

        List<User> users = service.getUsers();
        for(User user:users) {
            System.out.println(user);
        }
        /*
         * try { User user = new User(); user.setName("andrei"); service.save(user); }
         * catch (Exception e) { e.printStackTrace(); }
         * 
         * System.out.println(service.getUser("andrei"));
         */
    }
}
