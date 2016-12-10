package aoc.day6

public class MaxDecodingStrategy implements DecodingStrategy {
  public Closure bind() {
    { c -> c.groupBy().max { it.value.size() }.key }
  }
}
