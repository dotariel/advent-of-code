package aoc

class InputReader {
  public static String read(String resourcePath) {
    def input = new InputReader().class.classLoader.getResource(resourcePath)

    return new File(input.path).text
  }

  public static List<String> readAsList(String resourcePath) {
    def lines = []
    
    read(resourcePath).eachLine { lines << it }

    return lines
  }
}
