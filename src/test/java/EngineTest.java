import com.aidangordon.mastermind.bean.Code;
import com.aidangordon.mastermind.bean.Color;
import com.aidangordon.mastermind.service.Engine;
import com.aidangordon.mastermind.bean.GuessResult;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class EngineTest {


    @Test
    public void shouldReturn4BlackAll4SameColorAreCorrect(){
        Code secretCode = new Code(Color.red, Color.red, Color.red, Color.red);
        Engine engine = new Engine(secretCode);
        GuessResult guessResult = engine.getResults(new Code(Color.red, Color.red, Color.red, Color.red));
        assertEquals(new Integer(4), guessResult.getNumberOfBlack());
        assertEquals(new Integer(0), guessResult.getNumberOfWhite());
    }

    @Test
    public void shouldReturn3BlackWhen3SameSpot(){
        Code secretCode = new Code(Color.red,Color.red, Color.red, Color.red);
        Engine engine = new Engine(secretCode);
        GuessResult guessResult = engine.getResults(new Code(Color.red, Color.red, Color.red, Color.white));
        assertEquals(new Integer(3), guessResult.getNumberOfBlack());
        assertEquals(new Integer(0), guessResult.getNumberOfWhite());
    }

    @Test
    public void shouldReturn3BlackWhen3SameSpotSecondLastWrong(){
        Code secretCode = new Code(Color.red, Color.red, Color.red, Color.red);
        Engine engine = new Engine(secretCode);
        GuessResult guessResult = engine.getResults(new Code(Color.red, Color.red, Color.white, Color.red));
        assertEquals(new Integer(3), guessResult.getNumberOfBlack());
        assertEquals(new Integer(0), guessResult.getNumberOfWhite());
    }

    @Test
    public void shouldReturn3BlackWhen3SameSpotSecondWrong(){
        Code secretCode = new Code(Color.red, Color.red, Color.red, Color.red);
        Engine engine = new Engine(secretCode);
        GuessResult guessResult = engine.getResults(new Code(Color.red, Color.white, Color.red, Color.red));
        assertEquals(new Integer(3), guessResult.getNumberOfBlack());
        assertEquals(new Integer(0), guessResult.getNumberOfWhite());
    }

    @Test
    public void shouldReturn3BlackWhen3SameFirstWrong(){
        Code secretCode = new Code(Color.red, Color.red, Color.red, Color.red);
        Engine engine = new Engine(secretCode);
        GuessResult guessResult = engine.getResults(new Code(Color.white, Color.red, Color.red, Color.red));
        assertEquals(new Integer(3), guessResult.getNumberOfBlack());
        assertEquals(new Integer(0), guessResult.getNumberOfWhite());
    }

    @Test
    public void shouldBeEqualWhenAllColorsDifferentButCorrect(){
        Code secretCode = new Code(Color.black, Color.blue, Color.red, Color.green);
        Engine engine = new Engine(secretCode);
        GuessResult guessResult = engine.getResults(new Code(Color.black, Color.blue, Color.red, Color.green));
        assertEquals(new Integer(4), guessResult.getNumberOfBlack());
        assertEquals(new Integer(0), guessResult.getNumberOfWhite());
    }
}
