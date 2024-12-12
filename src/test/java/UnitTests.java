import org.example.StateMachine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class UnitTests {
    @Test
    public void canFindWord()
    {
        String str = "abcTESTabc";
        String word = "TEST";
        var sm= new StateMachine(word,str);
        var res=sm.search();
        assertEquals("F",res);
    }
    @Test
    public void canNotFindWord()
    {
        String str = "abcabc";
        String word = "TEST";
        var sm= new StateMachine(word,str);
        var res=sm.search();
        assertEquals("0",res);
    }
    @Test
    public  void canFindPartOfWord()
    {
        String str = "abcTESabc";
        String word = "TEST";
        var sm= new StateMachine(word,str);
        var res=sm.search();
        assertEquals("3",res);
    }
    @Test
    public  void canFindBiggestPartOfWord()
    {
        String str = "atcTeTESabcTe";
        String word = "TEST";
        var sm= new StateMachine(word,str);
        var res=sm.search();
        assertEquals("3",res);
    }
    @Test
    public void canIgnoreEmpty()
    {
        var sm= new StateMachine("","");
        var res=sm.search();
        assertEquals("0",res);
         sm= new StateMachine("TEST","");
         res=sm.search();
        assertEquals("0",res);
        sm= new StateMachine("","TEST");
        res=sm.search();
        assertEquals("0",res);
    }



}
