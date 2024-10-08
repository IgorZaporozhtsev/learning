package design_patterns.patterns.structural.proxy;

public class Proxy_DesignPattern {
    public static void main(String[] args) {
        Project image = new ProxyProject("d/path/to/file");
        image.display();
    }
}

interface Project {
    void display();
}

class RealProject implements Project {

    String file;

    public RealProject(String file) {
        this.file = file;
        load();
    }

    void load(){
        System.out.println("Downloading project form GitHub ...." + file);
    }

    @Override
    public void display() {
        System.out.println("Running project from GitHub ...." + file);
    }
}

// lazy downloading ленивая загрузка
class ProxyProject implements Project {

    String file;
    RealProject realImage;

    public ProxyProject(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        if (realImage == null){
            realImage = new RealProject(file);
        }

        realImage.display();
    }
}