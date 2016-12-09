package aoc.day4

class Room {
  String name
  String encrypted
  String sector
  String checksum

  public Room() { }

  public Room(String name) {
    def matcher = (name =~ /^([a-z\-]+)-([0-9]+)\[([a-z]+)\]$/)

    if (!matcher.matches())
      throw new InvalidRoomName()
    
    this.name = name
    this.encrypted = matcher[0][1]
    this.sector = matcher[0][2]
    this.checksum = matcher[0][3]
  }

  public String getComputedChecksum() {
    encrypted.replaceAll('-', '')
      .collect{ it }
      .groupBy { it }
      .findAll { it.key ==~ /[a-z]/ }
      .sort { a,b -> b.value.size() <=> a.value.size() ?: a.key <=> b.key }
      .collect { k,v -> k }
      .take(5)
      .join('')
  }

  public boolean isValid() {
    return this.checksum == computedChecksum
  }

  public String getDecrypted() {
    encrypted.collect { c -> decode(c) }.join('')
  }

  private String decode(String input) {
    List charset = "abcdefghijklmnopqrstuvwxyz".collect{it}

    if (input ==~ /[a-z]/) 
      return charset[(charset.indexOf(input) + (sector as Integer)) % charset.size()]

    if (input == '-')
      return ' '
  }

  public String toString() {
    "${encrypted}-${sector}[${checksum}]"
  }
}
