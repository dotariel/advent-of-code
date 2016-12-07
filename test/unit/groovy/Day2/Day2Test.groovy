package aoc.day2

import org.junit.*

class Day2Test {

  @Test
  public void should_track_keys_pressed() {
    def kt = new KeyTracker('5')

    kt.track('2')
    kt.track('1')
    kt.track('3')
    kt.track(new Key('5'))

    assert kt.keysTracked.collect { k -> k.value } == ['2','1','3','5']
  }

  @Test
  public void should_move_from_key_to_key() {
    
    new KeyTracker('5').with { kt ->
      kt.move('U')
      kt.move('L')
      kt.move('L')
      assert kt.keysTracked.collect { k -> k.value } == ['2','1','1']

      kt.move('R')
      kt.move('R')
      kt.move('D')
      kt.move('D')
      kt.move('R')
      assert kt.currentKey.value == '9'

      kt.move('L')
      kt.move('U')
      kt.move('R')
      kt.move('D')
      kt.move('L')
      assert kt.currentKey.value == '8'

      kt.move('U')
      kt.move('U')
      kt.move('U')
      kt.move('U')
      kt.move('D')

      assert kt.currentKey.value == '5'
    }
  }

  @Test
  public void should_determine_code_with_standard_keypad() {
    def kt = new KeyTracker('5')
    def inputList = ['ULL', 'RRDDD', 'LURDL', 'UUUD']
    
    assert ['1','9','8','5'] ==  kt.getCode(inputList)
  }

  @Test
  public void should_determine_code_with_alternate_keypad() {
    def kt = new KeyTracker('5', new AlternateKeyPad())
    def inputList = ['ULL', 'RRDDD', 'LURDL', 'UUUD']

    assert ['5','D','B','3'] ==  kt.getCode(inputList)
  }
}