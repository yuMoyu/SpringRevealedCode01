package scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        //创建Spring的ioc容器，读取配置文件的beans.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("scopeBeans.xml");
        //通过bean的id获取实例
        Object user1 = context.getBean("user");
        Object user2 = context.getBean("user");
        System.out.println(user1);
        System.out.println(user2);
        Object car1 = context.getBean("car");
        Object car2 = context.getBean("car");
        System.out.println(car1);
        System.out.println(car2);
    }
}
