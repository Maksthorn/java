public class MyException extends Exception{
    /*String badString;
    int badInt;*/

    @Override
    public String getMessage(){
        return "is not a valid input , please enter numerical values within the specified range";

    }


    /*public MyException(String message,Throwable cause ,String s) {
      super(message,cause);
      badString = s;
   }

    public MyException(String message,Throwable cause ,int i) {
      super(message,cause);
      badInt = i;
   }

@Override
 public String toString() {
      return "CustomException[" + badInt + "," + badString +"]"+ "is not a valid input , please enter numerical values within the specified range";
   }*/


}
