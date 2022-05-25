package applicationEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

//发布事件
public class MethodExcutionEventPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher eventPublisher;

    public void methodToMonitor() {
        MethodExecutionEvent beginEvt =
        new MethodExecutionEvent(this,"methodToMonitor",
                MethodExecutionStatus.BEGIN);
        this.eventPublisher.publishEvent(beginEvt);
        //....事件具体执行
        MethodExecutionEvent endEvt =
                new MethodExecutionEvent(this,"methodToMonitor",
                        MethodExecutionStatus.END);
        this.eventPublisher.publishEvent(endEvt);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public static void main(String[] args) {
        //创建Spring的ioc容器，读取配置文件的beans.xml
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MethodExcutionEventPublisher evtPublisher = context.getBean(MethodExcutionEventPublisher.class);
        evtPublisher.methodToMonitor();
    }
}
