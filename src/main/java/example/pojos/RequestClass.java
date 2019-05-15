package example.pojos;

public class RequestClass {
    private String firstName;
    private String bucketName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public RequestClass(String firstName, String bucketName) {
        this.firstName = firstName;
        this.bucketName = bucketName;
    }

    public RequestClass() {
    }
}