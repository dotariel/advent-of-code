package aoc.day5

import org.junit.*

public class AdvancedPasswordCrackerTest {

  @Test
  public void should_build_password() {
    def pc = new AdvancedPasswordCracker() { 
      public List<HashResult> getHashResults(String i, int l, Closure c) {
        return [new HashResult(1, 'xxxxx02xxxxx'), new HashResult(2, 'xxxxx14xxxxx') ]
      }
    }

    assert pc.generate('foo', 2) == '24'
  }
}