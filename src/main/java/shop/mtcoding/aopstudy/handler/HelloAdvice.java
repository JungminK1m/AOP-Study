package shop.mtcoding.aopstudy.handler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // 관점지향프로그래밍
@Component
public class HelloAdvice {
    // shop.mtcoding.aopstudy.handler.aop.Hello <- 깃발이름
    // 이름이 너무 기니 별칭을 정해주자!

    @Pointcut("@annotation(shop.mtcoding.aopstudy.handler.aop.Hello)")
    public void hello() { // 이제 hello 이름으로 깃발 이르믈 꽂을 수 있다!!

    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getMapping() {

    }

    // @Before("hello()")
    // public void helloAdvice() {
    // System.out.println("안녕안녕");
    // }

    @After("getMapping() || hello()")
    public void getAdvice() {
        System.out.println("헉헉");
    }

    // @Around("hello()")
    // public Object helloAdvice() {
    // System.out.println("하하하하");
    // return null;
    // }

    @Around("hello()")
    public Object helloAdvice(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        System.out.println("파라메터 사이즈 : " + args.length);

        for (Object arg : args) {
            if (arg instanceof String) {
                String username = (String) arg;
                System.out.println(username + "님 안녕!");
            }
        }

        return jp.proceed(); // 메서드로 진입해!
    }

}
