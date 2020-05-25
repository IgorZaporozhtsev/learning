package cources.stepic.base.GCS.Post_2;

public interface Sendable <T> {
    String getTo();
    String getFrom();
    T getContent();
}
