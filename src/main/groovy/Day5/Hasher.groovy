package aoc.day5

import java.util.concurrent.Callable
import java.security.MessageDigest

class Hasher implements Callable {
  private String input
  private int index

  public Hasher(String input, int index) {
    this.input = input
    this.index = index
  }

  public HashResult call() {
    def hash = generateMD5(input)

    new HashResult(index, hash)
  }

  private String generateMD5(String s) {
    MessageDigest digest = MessageDigest.getInstance("MD5")
    digest.update(s.bytes);
    new BigInteger(1, digest.digest()).toString(16).padLeft(32, '0')
 } 
}
