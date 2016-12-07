package aoc

class InputReader {
  public static String readInput(String resourcePath) {
    def input = new InputReader().class.classLoader.getResource(resourcePath)

    return new File(input.path).text
  }
}
