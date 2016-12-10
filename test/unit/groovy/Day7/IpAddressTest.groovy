package aoc.day7

import org.junit.*

class IpAddress7Test {

  @Test
  public void should_parse_hypernet_regions() {
    def ip = new IpAddress7('abcdefg[foo]hijklmn[bar]opqrstuv[baz]xyz')

    assert ip.hypernetRegions == ['foo', 'bar', 'baz']
    assert ip.supernetRegions == ['abcdefg', 'hijklmn', 'opqrstuv', 'xyz']
  }

  @Test
  public void should_determine_has_abba() {
    assert new IpAddress7('foo').hasAbba('abbafoomanchu')
    assert new IpAddress7('foo').hasAbba('foomabbaanchu')
    assert new IpAddress7('foo').hasAbba('foomanchuabba')
    assert !new IpAddress7('foo').hasAbba('aaaa')
  }

  @Test
  public void should_determine_is_aba() {
    assert new IpAddress7('foo').isAba('xyx')
    assert !new IpAddress7('foo').isAba('aaa')
  }

  @Test
  public void should_derive_bab() {
    assert new IpAddress7('foo').getBab('xyx') == 'yxy'
    assert new IpAddress7('foo').getBab('aba') == 'bab'
  }

  @Test
  public void should_determine_if_address_supports_tls() {
    assert true == new IpAddress7('abba[mnop]qrst').supportsTls()
    assert false == new IpAddress7('abcd[bddb]xyyx').supportsTls()
    assert false == new IpAddress7('aaaa[qwer]tyui').supportsTls()
    assert true == new IpAddress7('ioxxoj[asdfgh]zxcvbn').supportsTls()
  }

  @Test
  public void should_determine_if_address_supports_ssl() {
    assert true == new IpAddress7('aba[bab]xyz').supportsSsl()
    assert false == new IpAddress7('xyx[xyx]xyx').supportsSsl()
    assert true == new IpAddress7('aaa[kek]eke').supportsSsl()
    assert true == new IpAddress7('zazbz[bzb]cdb').supportsSsl()
  }
}