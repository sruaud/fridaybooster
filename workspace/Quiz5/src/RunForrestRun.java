public class RunForrestRun {
  private Runnable r = new Forrest()::wrooom;
  
  public void foo(){
     r.run();
  }
}

