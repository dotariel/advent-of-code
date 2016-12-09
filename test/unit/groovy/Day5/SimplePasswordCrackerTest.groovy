package aoc.day5

import org.junit.*

public class SimplePasswordCrackerTest {

  @Test
  public void should_build_password() {
    def pc = new SimplePasswordCracker() { 
      public List<HashResult> getHashResults(String i, int l, Closure c) {
        [new HashResult(1, 'xxxxx1xxxxx'), new HashResult(2, 'xxxxx2xxxxx')]
      }
    }

    assert pc.generate('foo', 2) == '12'
  }
}