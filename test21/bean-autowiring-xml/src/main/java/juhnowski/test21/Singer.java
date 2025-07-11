package juhnowski.test21;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Singer implements ApplicationContextAware{

    ApplicationContext applicationContext;

    @Override public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private Guitar guitar;

    public Singer(){
    }

    public void sing() {
        guitar =  applicationContext.getBean("gopher", Guitar.class);
        guitar.sing();
    }
}
