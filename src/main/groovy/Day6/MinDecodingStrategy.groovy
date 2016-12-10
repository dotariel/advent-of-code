package aoc.day6

public class MinDecodingStrategy implements DecodingStrategy {
  public Closure bind() {
    { c -> c.groupBy().min { it.value.size() }.key }
  }
}
