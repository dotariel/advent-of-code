package aoc.day5

import org.junit.*

public class PasswordCrackerTest {

  @Test
  public void should_collect_hash_results() {
    def pc = new PasswordCracker() { }
    
    assert [0,2,4,6] == pc.getHashResults('foo', 4) { r,rs -> r.index % 2 == 0 }.collect { it.index }
  }
}