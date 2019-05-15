package example.pojos;

import java.util.List;

public class ResponseClass {
    private String message;
    private List<String> bucketNames;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseClass(String message, List<String> bucketNames) {
        this.message = message;
        this.bucketNames = bucketNames;
    }

    public ResponseClass() {
    }

    public List<String> getBucketNames() {
        return bucketNames;
    }

    public void setBucketNames(List<String> bucketNames) {
        this.bucketNames = bucketNames;
    }

    @Override
    public String toString() {
        return "ResponseClass{" +
                "message='" + message + '\'' +
                ", bucketNames=" + bucketNames.toString() +
                '}';
    }
}