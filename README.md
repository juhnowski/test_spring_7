# Project for testing SPRING 7.x and SPRING BOOT 4.x

# test03 - Внедрение зависимостей через конструктор

Класс аннотируем 
```java
@Service("constructorConfusion")
```

чтобы он появился в контексте
```java
ConstructorConfusion cc = (ConstructorConfusion) ctx.getBean("constructorConfusion");
```

В классе определяем для конструктора автосвязывание
```java
    @Autowired
    public ConstructorConfusion(String someValue) {
        System.out.println("ConstructorConfusion(String) called");
        this.someValue = someValue;
    }
```

В app-context-annotation.xml объявляем бин
```xml
<bean id="message" class="java.lang.String"
          c:_0="Test string"/>
```
Если объявим еще один такой же бин, то будет ошибка

Прописываем область сканирования компонентов
```xml
    <context:component-scan
            base-package="juhnowski.test03"/>
```