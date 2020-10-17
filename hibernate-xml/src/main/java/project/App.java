package project;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import project.entity.User;
import project.services.UserService;

public class App {

    public static void main(String[] args) {
        
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config.xml");
        
        //RoleService service = ctx.getBean(RoleService.class);
        //System.out.println(service.getRole(1L));
       // System.out.println(service.getUsersRoles(1L));
        
       //  List<Role> roles = service.getRoles(); for (Role role : roles) {
        // System.out.println(role); }
         
        //org.hibernate.type.CollectionType
        
        UserService service = ctx.getBean(UserService.class);
        //System.out.println(service.getUser("user"));
       // List<User> users = service.getUsers();
       // for (User user : users) {
      //      System.out.println(user);
       // }

        User user = new User();
        user.setName("Test 30/1");
        service.save(user);
    }
 
}
