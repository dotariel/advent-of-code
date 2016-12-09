package aoc.day3

import org.junit.*

class Day3Test {

  @Test
  public void should_determine_valid_triangle() {
    assert !new Triangle(5, 10, 25).valid
    assert !new Triangle(6, 10, 25).valid
    assert new Triangle(5, 5, 5).valid
    assert new Triangle('5,5,5').valid
  }
}
