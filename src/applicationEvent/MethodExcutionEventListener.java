package applicationEvent;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.util.EventListener;

//自定义MethodExecutionEvent的事件监听器接口
public class MethodExcutionEventListener implements ApplicationListener {

    @Override
    public void onApplicationEvent(ApplicationEvent evt) {
        if (evt instanceof  MethodExecutionEvent) {
            String methodName = ((MethodExecutionEvent) evt).getMethodName();
            System.out.println("execute the method["+methodName+"].");
        }
    }
}
