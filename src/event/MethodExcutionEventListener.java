package event;

import java.util.EventListener;

//自定义MethodExecutionEvent的事件监听器接口
public interface MethodExcutionEventListener extends EventListener {
    /**
     * 处理方法开始执行的时候发布的MethodExecutionEvent事件
     * @param evt
     */
    void onMethodBegin(MethodExecutionEvent evt);

    /**
     * 处理方法执行结束时发布的MethodExecutionEvent事件
     * @param evt
     */
    void onMethodEnd(MethodExecutionEvent evt);
}
