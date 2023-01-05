package books.ModernJavaInAction.behavior_parameterization.solution;

import books.ModernJavaInAction.model.Apple;
import books.ModernJavaInAction.model.Color;

public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals(Color.GREEN);
    }
}
