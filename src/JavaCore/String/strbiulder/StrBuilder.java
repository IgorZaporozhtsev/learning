package JavaCore.String.strbiulder;

public class StrBuilder {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("1111111111111111");
        s.append("!");
        System.out.println(s.toString());

//по умолчанию capacity массива StringBuilder формируеться как 16 + (значение в конструкторе)
// дальше когда capacity маленький то размер рассчитываеться по формуле (capacity << 1) + 2

        StringBuilder s2 = new StringBuilder("1111");
        s2.append("!!!!!!!!!!!!!!!!"); //16 восклицательных знаков
        s2.append("+");
        System.out.println(s2.toString());

        s2.insert(3, new StrBuilder()); //можно добавлять и обьекты
        System.out.println(s2.toString());
    }



    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
