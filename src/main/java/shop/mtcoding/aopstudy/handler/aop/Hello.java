package shop.mtcoding.aopstudy.handler.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 깃발만 있는 상태
@Retention(RetentionPolicy.RUNTIME)
public @interface Hello {

}
