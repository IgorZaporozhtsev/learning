package books.Schildt.core;

@myAnn(tittle = "my article")
public class AnnotationExplainer {

}

@interface myAnn{
    public String tittle();
    public String val() default "other";
}