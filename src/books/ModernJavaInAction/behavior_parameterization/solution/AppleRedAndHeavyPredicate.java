package books.ModernJavaInAction.behavior_parameterization.solution;

import books.ModernJavaInAction.util.Apple;
import static books.ModernJavaInAction.util.Color.*;

public class AppleRedAndHeavyPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return RED.equals(apple.getColor()) && apple.getWeight() > 200;
    }
}
