package examples.ch4modelling.s3modellingDataWithTraits

trait B
trait C

// ProductDataType1
case class A1(b: B, c: C)

// ProductDataType2
trait A2 {
  def b: B
  def c: C
}
