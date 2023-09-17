# SpringBoot General Functions

记录一下工作中遇到的一些与业务无关的通用功能。

## 1. SpringBeansUtil

`SpringBeansUtil`提供了在Spring环境下可以随时随地从Spring容器中获取Bean的能力。

```java
import org.springframework.stereotype.Component;

@Component
public class Demo {

    public static void main(String[] args) {

        // 通过name获取Bean
        Demo t1 = SpringBeansUtil.getBean("demo");

        // 通过class获取Bean
        Demo t2 = SpringBeansUtil.getBean(Demo.calss);

        // 通过name,以及Clazz返回指定的Bean
        Demo t3 = SpringBeansUtil.getBean("demo", Demo.calss);
    }
}
```
