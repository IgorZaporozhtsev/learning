package cources.stepic.base.ExeptionsTask.Robot;

public class RobotConnectionException extends RuntimeException {

    public RobotConnectionException(RobotConnectionException message) {
        super(message);

    }

    public RobotConnectionException(String message, Throwable cause) {
        super(message, cause);
    }
}
