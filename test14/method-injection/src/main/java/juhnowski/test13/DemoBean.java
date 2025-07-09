package juhnowski.test13;

public interface DemoBean {
    /**
     * Если этот компонент с методом поиска, то метод выполняет конкретный поиск
     * @return ссылка на экземпляр Singer
     */
    Singer getMySinger();

    /**
     * Действие этого метода зависит от класса Singer
     */
    void doSomething();
}
