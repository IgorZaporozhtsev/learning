package JavaCore.multithreading.synchronization.blockClass;

//Блокировка на уровне класса
// https://javarush.ru/groups/posts/1055-sinkhronizacija-potokov-blokirovka-obhhekta-i-blokirovka-klassa

public class DemoClass {
        public synchronized static void demoMethod(){}
}

  //-----------------------------------------------------или-----------------------------------------------------------
    class DemoObject{
        public void demoMethod(){
        //это означает что только экземпляры DemoObject класса смогут имеют приоритет выполнения метод,
        // а остальные экземпляры других классов будут ждать
            synchronized (DemoObject.class){

                //other thread safe code
            }
        }
    }

/*
    -----------------------------------------------------или-----------------------------------------------------------

    public class DemoObject
    {
        private final static Object lock = new Object();

        public void demoMethod(){
            synchronized (lock)        {
                //other thread safe code
            }
        }
    }*/