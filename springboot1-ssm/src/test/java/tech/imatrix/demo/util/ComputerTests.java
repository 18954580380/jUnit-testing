package tech.imatrix.demo.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class ComputerTests {
    Computer computer;
	@Before
	public void init(){
		computer=new Computer();
	}
 @Test
 public void testDivide(){
    
     int reslut=computer.divide(4,2);
     //至少一句断言，有且只有一种断言
     assertThat(reslut).isEqualTo(2);
 }
 //expected=IllegalArgumentException.class允许抛异常
 @Test(expected=IllegalArgumentException.class)
 public void testDivideByZero(){
	 assertThat(computer.divide(1, 0));
 }
}
