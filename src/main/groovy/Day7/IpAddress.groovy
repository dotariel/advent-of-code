package aoc.day7

import java.util.regex.*

class IpAddress7 {

  private String value

  public IpAddress7(String value) {
    this.value = value
  }

  public boolean supportsTls() {
    supernetRegions.any { hasAbba(it) } && !hypernetRegions.any { hasAbba(it) }
  }

  public boolean supportsSsl() {
    
    def abaSequences = supernetRegions.collect { r ->  
      getSequences(r, 3).findAll { s -> isAba(s) } 
    }.flatten()

    hypernetRegions.collect { r -> getSequences(r, 3) }.flatten().any { s ->
      s in abaSequences.collect { getBab(it) }
    }
  }

  protected List<String> getHypernetRegions() {
    def regions = []
    def matcher = (this.value =~ Pattern.compile(/\[([a-z]+)\]/))

    while (matcher.find()) {
      regions << matcher.group().replace('[', "").replace("]", "")
    }

    return regions
  }

  protected List<String> getSupernetRegions() {
    this.value.split("(\\[[a-z]+)\\]")
  }

  /*
  An ABBA is any four-character sequence which consists of a pair of two different 
  characters followed by the reverse of that pair, such as xyyx or abba.
  */
  protected boolean hasAbba(String sequence) {
    getSequences(sequence, 4).any { s -> 
      s[0..1] == s[2..3].reverse() && s.collect().unique().size() > 1 
    }
  }

  /*
  An ABA is any three-character sequence which consists of the same character twice with
  a different character between them, such as xyx or aba.
  */
  protected boolean isAba(String s) {
    s[0] == s[2] && s[0] != s[1]
  }

  /*
  A corresponding BAB is the same characters as the ABA but in reversed positions: 
  yxy and bab, respectively.
  */
  protected String getBab(String aba) {
    aba[1] + aba[0] + aba[1]
  } 

  private List<String> getSequences(String sequence, int chars) {
    def sequences = []

    sequence.eachWithIndex { c, n ->
      int newSize = n + chars

      if (newSize <= sequence.size()) {
        sequences << sequence[n..newSize-1]
      }
    }

    sequences
  }
}
