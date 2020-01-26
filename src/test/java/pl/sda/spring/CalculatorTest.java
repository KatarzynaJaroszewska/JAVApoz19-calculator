package pl.sda.spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.sda.spring.exception.DivisionByZeroException;
import pl.sda.spring.operation.OperationType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class CalculatorTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void shouldReturnFiveForGivenArgumentsOnAdditionOperation() {
        //given
        double arg1 = 2.0;
        double arg2 = 3.0;

        //when
        double actual = calculator.calculate(OperationType.ADDITION, arg1, arg2);

        //then
        Assert.assertEquals(5.0, actual, 0.00000001);
    }

    @Test
    public void shouldReturnTenForGivenArgumentsOnSubtractionOperation() {
        //given
        double arg1 = 15.0;
        double arg2 = 5.0;

        //when
        double actual = calculator.calculate(OperationType.SUBTRACTION, arg1, arg2);

        //then
        Assert.assertEquals(10.0, actual, 0.0000001);
    }

    @Test
    public void shouldReturnFortyForGivenArgumentsOnMultiplicationOperation() {
        //given
        double arg1 = 4.0;
        double arg2 = 10.0;

        //when
        double actual = calculator.calculate(OperationType.MULTIPLICATION, arg1, arg2);

        //then
        Assert.assertEquals(40.0, actual,0.0000001);
    }
    @Test
    public void shouldReturnTenForGivenArgumentsOnDivisionOperation() {
        //given
        double arg1 = 100.0;
        double arg2 = 10.0;

        //when
        double actual = calculator.calculate(OperationType.DIVISION, arg1, arg2);

        //then
        Assert.assertEquals(10.0, actual,0.0000001);
    }

    @Test(expected = DivisionByZeroException.class)
    public void shouldThrowExceptionWhenDivisionByZero() {
        //given
        double arg1 = 100.0;
        double arg2 = 0.00;

        //when
        double actual = calculator.calculate(OperationType.DIVISION, arg1, arg2);
    }

    @Test
    public void shouldReturnFiveForGivenArgumentsOnPercentageOperation() {
        //given
        double arg1 = 100.0;
        double arg2 = 5.00;

        //when
        double actual = calculator.calculate(OperationType.PERCENTAGEOPERATION, arg1, arg2);

        //then
        Assert.assertEquals(5.0, actual,0.0000001);
    }

    @Test
    public void shouldReturnSixteenForGivenArgumentsOnPowerOperation() {
        //given
        double arg1 = 2.00;
        double arg2 = 4.00;

        //when
        double actual = calculator.calculate(OperationType.POWEROPERATION, arg1, arg2);

        //then
        Assert.assertEquals(16.0, actual,0.0000001);
    }
    @Test
    public void shouldReturnForuForGivenArgumentsOnPowerOperation() {
        //given
        double arg1 = 2.00;
        double arg2 = 2.00;

        //when
        double actual = calculator.calculate(OperationType.POWEROPERATION, arg1, arg2);

        //then
        Assert.assertEquals(4, actual,0.0000001);
    }
}
