package beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        //创建Spring的ioc容器，读取配置文件的beans.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //通过bean的id获取实例
        Object person = context.getBean("person");
        //也可以通过bean的类型：context.getBean(Person.class);
        System.out.println(person);
    }
}
