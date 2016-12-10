package aoc.day2

import aoc.InputReader

class Main {
  public static void main(String[] args) {
    getCode(new StandardKeyPad())
    getCode(new AlternateKeyPad())
  }

  private static void getCode(KeyPad keyPad) {
    def input = InputReader.read("resources/Day2/input.txt")
    def inputList = []

    input.eachLine { l -> inputList << l }
    println "Code (${keyPad.class.simpleName}): " + new KeyTracker('5', keyPad).getCode(inputList).join("")
  }
}