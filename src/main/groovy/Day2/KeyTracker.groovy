package aoc.day2

class KeyTracker {
  KeyPad keyPad
  Key startingKey
  Key currentKey
  List<Key> keysTracked = []

  public KeyTracker(String startingKeyValue) {
    this.keyPad = new StandardKeyPad()

    keyPad.getKeyFromValue(startingKeyValue).with { k ->
      this.startingKey = k
      this.currentKey = k
    }
  }

  public KeyTracker(String startingKeyValue, KeyPad keyPad) {
    this.keyPad = keyPad

    keyPad.getKeyFromValue(startingKeyValue).with { k ->
      this.startingKey = k
      this.currentKey = k
    }
  }

  public void track(String keyValue) {
    def theKey = keyPad.getKeyFromValue(keyValue)
    
    if (theKey) {
      this.currentKey = theKey
      this.keysTracked << theKey
    }
  }

  public void track(Key key) {
    track(key.value)
  }

  public List<String> getCode(List<String> inputs) {
    def code = []

    inputs.each { input -> 
      input.each { direction -> 
        move(direction) 
      }

      code << currentKey.value
    }

    return code
  }

  public void move(String direction) {
    if (direction ==~ /[UDLR]/) {
      currentKey = keyPad.getKeyFromValue(currentKey.neighbors[direction] ?: currentKey.value)
      keysTracked << currentKey
    }
  }
}