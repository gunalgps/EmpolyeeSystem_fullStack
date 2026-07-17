package employemangemnetSystem.EmployeSystem.execpection;

public class ResourceNotFoundExpection extends RuntimeException {
 public ResourceNotFoundExpection (String message){
     super(message);
 }
}
