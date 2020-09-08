package JavaCore.multithreading.synchronization.blockObject;

//Блокировка на уровне обьекта
// https://javarush.ru/groups/posts/1055-sinkhronizacija-potokov-blokirovka-obhhekta-i-blokirovka-klassa
public class DemoObject {
        public synchronized void demoMethod(){}
}


   /*  -----------------------------------------------------или-----------------------------------------------------------
    public class DemoObject{
        public void demoMethod(){
            synchronized (this)        {
                //other thread safe code
            }
        }
    }
     -----------------------------------------------------или-----------------------------------------------------------
    public class DemoObject{
        private final Object lock = new Object();
        public void demoMethod(){
            synchronized (lock)        {
                //other thread safe code
            }
        }
    }*/