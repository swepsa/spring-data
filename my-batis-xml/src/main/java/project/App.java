package project;


import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import project.entity.User;
import project.services.UserService;

public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config.xml");

        UserService service = ctx.getBean(UserService.class);

        User user = service.getUser("user");
        service.save(user);

        System.out.println(user);
    }
}
