# Custom Repository

https://docs.spring.io/spring-data/jpa/reference/repositories/custom-implementations.html

Spring Data JPA와 Custom Repository를 Fragment 형식으로 복합적으로 사용할수 있다.
관습적으로 Custom Repository에 @Component, @Repository를 붙이는데 Bean을 선언하지 않아도
Spring Boot에서 Bean으로 등록해준다.

```java
class RepositoryBeanDefinitionBuilder {
...

    private void potentiallyRegisterFragmentImplementation(RepositoryConfiguration<?> repositoryConfiguration,
                                                           RepositoryFragmentConfiguration fragmentConfiguration) {

        String beanName = fragmentConfiguration.getImplementationBeanName();

        // Already a bean configured?
        if (registry.containsBeanDefinition(beanName)) {

            if (logger.isDebugEnabled()) {
                logger.debug(String.format("Repository fragment implementation already registered: %s", beanName));
            }

            return;
        }

        fragmentConfiguration.getBeanDefinition().ifPresent(bd -> {

            if (logger.isDebugEnabled()) {
                logger.debug(String.format("Registering repository fragment implementation: %s %s", beanName,
                                           fragmentConfiguration.getClassName()));
            }

            bd.setSource(repositoryConfiguration.getSource());
            registry.registerBeanDefinition(beanName, bd);
        });
    }
...
}
```

## Custom Repository

* @Repository @Component를 붙이지 않아도 자동으로 Bean로 생성된다.
* 명시적으로 빈으로 선언하면 중복되지 않고 선언되는 형식으로(이름 변경 가능) 빈이 생성된다.