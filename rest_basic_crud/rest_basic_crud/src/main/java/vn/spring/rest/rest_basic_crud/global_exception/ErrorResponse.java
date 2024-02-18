package vn.spring.rest.rest_basic_crud.global_exception;

public class ErrorResponse {
    private int status ;
    private String mess ;
    private long timestamp ;

    public ErrorResponse(int status, String mess) {
        this.status = status;
        this.mess = mess;
        this.timestamp = System.currentTimeMillis();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public ErrorResponse() {
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "status=" + status +
                ", mess='" + mess + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
