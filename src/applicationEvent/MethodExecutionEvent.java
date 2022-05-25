package applicationEvent;

import org.springframework.context.ApplicationEvent;

import java.util.EventObject;

//自定义事件类型：MethodExecutionEvent
public class MethodExecutionEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;
    private String methodName;
    private MethodExecutionStatus methodExecutionStatus;
    public MethodExecutionEvent(Object source) {
        super(source);
    }
    public MethodExecutionEvent(Object source,String methodName,
    MethodExecutionStatus methodExecutionStatus) {
        super(source);
        this.methodName = methodName;
        this.methodExecutionStatus = methodExecutionStatus;
    }
    public String getMethodName() {
        return methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public MethodExecutionStatus getMethodExecutionStatus() {
        return methodExecutionStatus;
    }

    public void setMethodExecutionStatus(MethodExecutionStatus methodExecutionStatus) {
        this.methodExecutionStatus = methodExecutionStatus;
    }
}
