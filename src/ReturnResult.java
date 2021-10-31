import java.util.Objects;

public class ReturnResult<S,R> {

    private S taskId;
    private R result;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReturnResult<?, ?> that = (ReturnResult<?, ?>) o;
        return Objects.equals(taskId, that.taskId) && Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, result);
    }

    @Override
    public String toString() {
        return "ReturnResult{" +
                "taskId=" + taskId +
                ", result=" + result +
                '}';
    }

    ReturnResult(S taskId, R result){
        this.taskId=taskId;
        this.result=result;

    }
}
