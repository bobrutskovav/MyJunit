package com.myLogicTest;

import com.myLogic.Calculator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


/**
 * Created by Aleks on 06.03.2016.
 */
@RunWith(Parameterized.class)
public class TestJUnit {

    public int firstParameter;
    public int secondParameter;
    public String operation;
    public int expectedResult;



    public static Object[][] data;

    public TestJUnit(int firstParameter, int secondParameter, String operation, int expectedResult) {
        this.firstParameter = firstParameter;
        this.secondParameter = secondParameter;
        this.expectedResult = expectedResult;
        this.operation = operation;

    }

        @BeforeClass
        public static void makeData() throws IOException {

            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\third\\IdeaProjects\\MyJunit\\src\\test\\java\\com\\myLogicTest\\datafile.csv"));

            ArrayList<Object[]> tempArray = new ArrayList<Object[]>();
            String newLine;
            Object[] oneString;
            while ((newLine = reader.readLine()) != null) {


                oneString = newLine.split(";");
                tempArray.add(oneString);
            }
            data = new Object[tempArray.size()][];
            for (int i = 0; i < data.length; i++) {
                Object[] row = tempArray.get(i); data[i] = row; }
            }









        @Test
    public void checkCalculator() {
            final Calculator calculator = new Calculator(firstParameter, secondParameter, operation);
            int result;
            if (operation.equals("*")) {
                result = calculator.multi();
                Assert.assertTrue("Результат (" + result + ") не равен" + expectedResult, result == expectedResult);
            }
            else if (operation.equals("+")) {
                result = calculator.plus();
                Assert.assertTrue("Результат (" + result + ") не равен" + expectedResult, result == expectedResult);
            }
            else if (operation.equals("-")) {
                result = calculator.minus();
                Assert.assertTrue("Результат (" + result + ") не равен" + expectedResult, result == expectedResult);
            }
            else if (operation.equals("/")) {
                result = calculator.del();

                Assert.assertTrue("Результат (" + result + ") не равен" + expectedResult, result == expectedResult);
            }

            }


        @Parameterized.Parameters(name = "{index}: Действие {0} {2} {1} = {3}")
        public static Collection<Object[]> getTestData() {
            return Arrays.asList(data
                    /* new Object[][]{
                    {2, 2, "*", 4},
                    {2, 0, "+" , 2},
                    {2, 2,"/", 1},
                    {0, 2,"-",-2}
            }*/);
        }
}
