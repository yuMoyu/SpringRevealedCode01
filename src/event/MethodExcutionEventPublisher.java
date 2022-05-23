package event;

import java.util.ArrayList;
import java.util.List;
//发布事件
public class MethodExcutionEventPublisher {
    //事件监听器列表
    private List<MethodExcutionEventListener> listeners = new
            ArrayList<MethodExcutionEventListener>();

    public void methodToMonitor() {
        MethodExecutionEvent event2Publish =
        new MethodExecutionEvent(this,"methodToMonitor");
        publishEvent(MethodExecutionStatus.BEGIN,event2Publish);
        //....事件具体执行
        publishEvent(MethodExecutionStatus.END,event2Publish);
    }
    protected void publishEvent(MethodExecutionStatus status,
                                MethodExecutionEvent methodExecutionEvent) {
        //为了避免事件处理期间，监听器列表发生变化，所以复制一个当前节点的监听器列表。
        List<MethodExcutionEventListener> copyListeners =
                new ArrayList<MethodExcutionEventListener>(listeners);
        for (MethodExcutionEventListener listener:copyListeners) {
            if (MethodExecutionStatus.BEGIN.equals(status)) {
                listener.onMethodBegin(methodExecutionEvent);
            } else {
                listener.onMethodEnd(methodExecutionEvent);
            }
        }
    }

    //增加事件监听器
    public void addMethodExecutionEventListener(MethodExcutionEventListener listener) {
        this.listeners.add(listener);
    }
    //移除事件监听器
    public void removeListener(MethodExcutionEventListener listener) {
        if (this.listeners.contains(listener)) {
            this.listeners.remove(listener);
        }
    }
    //移除所有事件监听器
    public void removeAllListeners() {
        this.listeners.clear();
    }
    public static void main(String[] args) {
        MethodExcutionEventPublisher eventPublisher =
                new MethodExcutionEventPublisher();
        eventPublisher.addMethodExecutionEventListener(new
                SimpleMethodExcutionEventListener());
        eventPublisher.methodToMonitor();
    }
}
