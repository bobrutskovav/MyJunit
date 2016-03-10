package com.myLogicTest;

import com.myLogic.Calculator;
import org.junit.Assert;
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

       // @BeforeClass










        @Test
    public void checkCalculator() {
            final Calculator calculator = new Calculator(firstParameter, secondParameter, operation);
            int result;
            switch (operation) {
                case "*":
                    result = calculator.multi();
                    Assert.assertTrue("Результат (" + result + ") не равен" + expectedResult, result == expectedResult);
                    break;
                case "+":
                    result = calculator.plus();
                    Assert.assertTrue("Результат (" + result + ") не равен" + expectedResult, result == expectedResult);
                    break;
                case "-":
                    result = calculator.minus();
                    Assert.assertTrue("Результат (" + result + ") не равен" + expectedResult, result == expectedResult);
                    break;
                case "/":
                    result = calculator.del();

                    Assert.assertTrue("Результат (" + result + ") не равен" + expectedResult, result == expectedResult);
                    break;
            }

            }


        @Parameterized.Parameters(name = "{index}: Действие {0} {2} {1} = {3}")
        public static Collection<Object[]> getTestData() {

            try {
                makeData();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return Arrays.asList(data);
        }

    /* new Object[][]{
                    {2, 2, "*", 4},
                    {2, 0, "+" , 2},
                    {2, 2,"/", 1},
                    {0, 2,"-",-2}
            }*/

    public static void makeData() throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\third\\IdeaProjects\\MyJunit\\src\\test\\java\\com\\myLogicTest\\datafile.csv"));

        ArrayList<Object[]> tempArray = new ArrayList<>();
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
}
