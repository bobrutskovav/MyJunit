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
import java.util.Collection;
import java.util.List;


/**
 * Created by Aleks on 06.03.2016.
 */
@RunWith(Parameterized.class)
public class TestJUnit {

    public int firstParameter;
    public int secondParameter;
    public String operation;
    public int expectedResult;





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
        public static Collection testData() throws IOException {
            return getTestData("C:\\Users\\third\\IdeaProjects\\MyJunit\\src\\test\\java\\com\\myLogicTest\\datafile.csv");
        }

    /* new Object[][]{
                    {2, 2, "*", 4},
                    {2, 0, "+" , 2},
                    {2, 2,"/", 1},
                    {0, 2,"-",-2}
            }*/

    public static Collection<String[]> getTestData(String fileName)
            throws IOException {
        List<String[]> records = new ArrayList<>();
        String record;
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        while ((record = file.readLine()) != null) {
            String fields[] = record.split(",");
            records.add(fields);
        }
        //TODO For each record in records convert char to int?
        file.close();
        return records;
    }

}
