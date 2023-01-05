package books.ModernJavaInAction.behavior_parameterization.solution;

import books.ModernJavaInAction.model.Apple;

public interface ApplePredicate {
    boolean test(Apple apple);
}
