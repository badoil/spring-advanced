package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        call();
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis(); long resultTime = endTime - startTime; log.info("resultTime={}", resultTime);
    }

    protected abstract void call();

    // 변하는 부분 콜 함수는 자식 클래스가 상속해서 오버라이딩 구현(다형성)
    // 불변하고 중복되는 exucute 함수 부분을 실행할때
    // 각각 다른 콜함수를 콜하게됨
}