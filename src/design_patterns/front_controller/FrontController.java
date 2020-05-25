package design_patterns.front_controller;

import java.util.Scanner;

public class FrontController {
    public static void main(String[] args) {
        try (Scanner urlScanner = new Scanner(System.in)){
            while (urlScanner.hasNext()){
                Runnable runnable = () -> {
                    new DispatcherServlet().process(urlScanner.nextLine());
                };
                new Thread(runnable).start();
            }
        }
    }
}

class DispatcherServlet{
    public void process(String url) {
        switch (url){
            case "home" : new HomeController().show(); break;
            case "user" : new UserController().show(); break;
            default: new DefaultController().show();
        }
    }
}
class HomeController{
    void show(){
        System.out.println("this is a home page");
    }
}

class UserController{
    void show(){
        System.out.println("this is a user page");
    }
}

class DefaultController{
    void show(){
        System.out.println("error");
    }
}
