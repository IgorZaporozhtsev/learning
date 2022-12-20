package books.ModernJavaInAction.behavior_parameterization.solution;

import books.ModernJavaInAction.util.Apple;

public class AppleHeavyWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 250;
    }
}
