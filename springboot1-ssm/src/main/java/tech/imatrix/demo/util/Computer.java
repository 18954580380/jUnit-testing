package tech.imatrix.demo.util;

public class Computer {
	/**
	 * 除法
	 * @param op1
	 * @param op2
	 * @return
	 */
   public int divide(int op1,int op2){
	   if(op2==0){
		   throw new IllegalArgumentException("op2 is zero");
	   }
	   return op1/op2;
   }
   /**
    * 加法
    * @param op1
    * @param op2
    * @return
    */
   public int addition(int op1,int op2){
	   return op1+op2;
   }
}
