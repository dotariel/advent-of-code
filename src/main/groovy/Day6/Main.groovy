package aoc.day6

import aoc.InputReader

class Main {
  public static void main(String[] args) {
    decode(new MaxDecodingStrategy())
    decode(new MinDecodingStrategy())
  }

  private static void decode(DecodingStrategy strategy) {
    def input = InputReader.read("resources/Day6/input.txt")
    println "${strategy.class.simpleName}: " + new Signal(input, strategy).decode()
  }
}