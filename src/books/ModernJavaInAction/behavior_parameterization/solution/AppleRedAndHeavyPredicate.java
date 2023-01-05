package books.ModernJavaInAction.behavior_parameterization.solution;

import books.ModernJavaInAction.model.Apple;
import static books.ModernJavaInAction.model.Color.*;

public class AppleRedAndHeavyPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return RED.equals(apple.getColor()) && apple.getWeight() > 200;
    }
}
