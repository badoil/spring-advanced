package hello.advanced.trace.template;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    //객체를 생성할 때 내부에서 사용할 LogTrace trace 를 전달 받는다.
    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message) {
        TraceStatus status = null;
        try{
            status = trace.begin(message);
            T result = call();
            trace.end(status);
            return result;
        }catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    //변하는 부분을 처리하는 메서드이다. 이 부분은 상속으로 구현해야 한다
    protected abstract T call();
}
