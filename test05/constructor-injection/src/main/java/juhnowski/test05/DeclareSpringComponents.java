package juhnowski.test05;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DeclareSpringComponents {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        MessageProvider messageProvider = ctx.getBean("provider",
                MessageProvider.class);

        System.out.println(messageProvider.getMessage());
        ctx.close();

    }
}