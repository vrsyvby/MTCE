public class SumObserver implements ResultListener<Integer>{

    private String taskId;

    @Override
    public void notifyResult(Integer result) {
      System.out.println("sum returned from task "+taskId+" "+result);
    }

    SumObserver(String taskId){
        this.taskId=taskId;
    }



}
