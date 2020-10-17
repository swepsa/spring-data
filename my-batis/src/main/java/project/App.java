package project;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import project.entity.Role;
import project.entity.User;
import project.services.RoleService;
import project.services.UserService;

public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config.xml");

        UserService service = ctx.getBean(UserService.class);
        User user = service.getUser(1L);
        service.save(user);
       // User user = service.getUser("user");
        System.out.println(user);
        
        
        
   /*     RoleService service = ctx.getBean(RoleService.class);
         Role role = service.getRole(1L);
         System.out.println(role);
  */      

        /*
        for(User user: ctx.getBean(UserService.class).getUsers()) {
            System.out.println(user);
        }
*/
    }
}
