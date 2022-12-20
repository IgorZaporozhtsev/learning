package books.ModernJavaInAction.behavior_parameterization.solution;

import books.ModernJavaInAction.util.Apple;
import books.ModernJavaInAction.util.Color;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals(Color.GREEN);
    }
}
