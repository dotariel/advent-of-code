package aoc.day6

import org.junit.*

class SignalTest {

  @Test(expected=InvalidMessage)
  public void should_throw_exception_for_invalid_message() {
    def input = new StringBuilder()

    input.append('abcdefg' + '\n')  // 6 columns
    input.append('hijklmn' + '\n')  // 6 columns
    input.append('opqrs')           // 5 columns

    new Signal(input.toString()).decode()
  }

  @Test
  public void should_decode_with_max_strategy() {
    assert 'easter' == new Signal(getInput()).decode()
  }

  @Test
  public void should_decode_with_min_strategy() {
    assert 'advent' == new Signal(getInput(), new MinDecodingStrategy()).decode()
  }  

  private String getInput() {
    def input = new StringBuilder()

    input.append('eedadn' + '\n')
    input.append('drvtee' + '\n')
    input.append('eandsr' + '\n')
    input.append('raavrd' + '\n')
    input.append('atevrs' + '\n')
    input.append('tsrnev' + '\n')
    input.append('sdttsa' + '\n')
    input.append('rasrtv' + '\n')
    input.append('nssdts' + '\n')
    input.append('ntnada' + '\n')
    input.append('svetve' + '\n')
    input.append('tesnvt' + '\n')
    input.append('vntsnd' + '\n')
    input.append('vrdear' + '\n')
    input.append('dvrsen' + '\n')
    input.append('enarar')

    return input.toString()
  }
}