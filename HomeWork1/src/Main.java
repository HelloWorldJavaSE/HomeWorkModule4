public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
       Thread thread1 = new Thread(()->{
           for (int i = 0; i < 1000; i++) {
               counter.increment();
           }
       });
        Thread thread2 = new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter.getValue());
        //1 запуск counter.getValue() = 1894
        //2 запуск counter.getValue() = 1859
        //3 запуск counter.getValue() = 1489

        // Результат counter.getValue() не всегда равен 2000 из за гонки (race condition).
        // Процессор может переключить ресурсы между потоками в произвольный момент времени.
        // Если поток 1 прочитает поле объекта Counter, а потом поток 2 получит доступ и сделает
        // то же самое, они могут оба увеличить свои локальные копии значения на основе устаревшей
        // информации, что приводит к неправильному результату.

    }
}