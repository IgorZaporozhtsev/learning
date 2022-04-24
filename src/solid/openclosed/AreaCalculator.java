package solid.openclosed;

import java.util.List;

public class AreaCalculator {
    public int sum(List<Object> shapes) {
        int sum = 0;
        for (int i = 0; i < shapes.size(); i++){
            Object shape = shapes.get(i);
            if (shape instanceof Square){
                sum += Math.pow(((Square) shape).getLength(), 2);
            }
            if (shape instanceof Circle){
                sum += Math.PI * Math.pow(((Circle) shape).getRadius(), 2);

            }
            if (shape instanceof Circle){
                sum += Math.PI * Math.pow(((Circle) shape).getRadius(), 2);
            }
            //TODO break OpenClosePrinciple because we add new functionality (modifying class) instead expand
            // look to solid-resolve brunch how to make refactoring and avoid such situation
            if (shape instanceof Circle){
                sum += Math.PI * Math.pow(((Circle) shape).getRadius(), 2);
            }
        }
        return sum;
    }
}
