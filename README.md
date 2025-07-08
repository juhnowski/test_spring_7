# Project for testing SPRING 7.x and SPRING BOOT 4.x

# Поиск зависимостей
# test02 - CDL
Зависимый объект --> Поиск --> Контейнер
![test02.png](diagrams/test02.png)
# Внедрение зависимостей
# test03 - Внедрение зависимостей через конструктор с помощью аннотаций

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

# test04 - Внедрение зависимостей через конструктор с помощью xml

Имеем класс с двумя конструкторами
```java
public ConstructorConfusion(String someValue) ...
public ConstructorConfusion(int someValue) ...
```

В app-context-xml.xml прописываем бин с конструктором
```xml
    <bean id="constructorConfusion"
          class="juhnowski.test04.ConstructorConfusion">
    <constructor-arg type="int">
        <value>90</value>
    </constructor-arg>
</bean>
```

Получаем компонент из контекста
```java
ConstructorConfusion cc = (ConstructorConfusion) ctx.getBean("constructorConfusion");
```

# test05 - Внедрение зависимостей через конструктор с помощью xml

Имеем класс, реализующий иннтерфейс
```java
ConfigurableMessageProvider implements MessageProvider...
```

с конструктором
```java
  public ConfigurableMessageProvider(String message) 
```

прописываем бин
```xml
<bean id="provider"
          class="juhnowski.test05.ConfigurableMessageProvider"
          c:message="I hope that someone gets my message in a bottle"/>
```

Извлекаем компонент из контекста
```java
MessageProvider messageProvider = ctx.getBean("provider",
                MessageProvider.class);
```