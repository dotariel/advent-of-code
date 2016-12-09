package aoc.day5

import java.util.concurrent.*

class AdvancedPasswordCracker extends PasswordCracker {

  /*
  Instead of simply filling in the password from left to right, the hash now 
  also indicates the position within the password to fill. You still look for
  hashes that begin with five zeroes; however, now, the sixth character 
  represents the position (0-7), and the seventh character is the character 
  to put in that position.
  */

  public String generate(String input, int length) {

    List<HashResult> hashResults = getHashResults(input, length) { hr, results -> 
      shouldAdd(hr, results, length) 
    }

    return buildPassword(hashResults)
  }

  private boolean shouldAdd(HashResult hashResult, List<HashResult> results, int length) {
    boolean add = true

    add &= hashResult.hash.startsWith('00000') 
    add &= isValidPosition(length, hashResult.hash[5]) 
    add &= !(hashResult.hash[5] in results.collect { r -> r.hash[5] })

    add
  }

  private boolean isValidPosition(int length, String position) {
    position in (0..length-1).collect { it.toString() }
  }

  private String buildPassword(List<HashResult> hashResults) {
    List characters = []

    hashResults.sort { a,b -> a.index <=> b.index }.each { r ->
      setCharacter(characters, r)
    }

    return characters.findAll { it != null }.join("")
  }

  protected void setCharacter(List characters, HashResult hashResult) {
    int position = hashResult.hash[5] as Integer
    String value = hashResult.hash[6]
      
    characters[position] = value
  }
}
