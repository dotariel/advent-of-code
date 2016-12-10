package aoc.day7

import aoc.InputReader

class Main {

  public static void main(String[] args) {
    def ips = InputReader.readAsList("resources/Day7/input.txt")

    println "IPs supporting TLS: " + ips.count { new IpAddress7(it).supportsTls() }
    println "IPs supporting SSL: " + ips.count { new IpAddress7(it).supportsSsl() }
  }
}