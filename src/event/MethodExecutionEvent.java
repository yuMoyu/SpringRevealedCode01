package event;

import java.util.EventObject;

//自定义事件类型：MethodExecutionEvent
public class MethodExecutionEvent extends EventObject {
    private static final long serialVersionUID = 1L;
    private String methodName;

    public MethodExecutionEvent(Object source) {
        super(source);
    }
    public MethodExecutionEvent(Object source,String methodName) {
        super(source);
        this.methodName = methodName;
    }
    public String getMethodName() {
        return methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
