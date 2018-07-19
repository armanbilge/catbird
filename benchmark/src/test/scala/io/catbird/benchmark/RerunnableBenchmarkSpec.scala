package io.catbird.benchmark

import org.scalatest.{ BeforeAndAfter, FlatSpec }

class RerunnableBenchmarkSpec extends FlatSpec with BeforeAndAfter {
  val benchmark: RerunnableBenchmark = new RerunnableBenchmark
  val sum = benchmark.numbers.sum

  before { benchmark.initPool() }
  after { benchmark.shutdownPool() }

  "The benchmark" should "correctly calculate the sum using futures" in {
    assert(benchmark.sumIntsF === sum)
  }

  it should "correctly calculate the sum using futures and future pools" in {
    assert(benchmark.sumIntsPF === sum)
  }

  it should "correctly calculate the sum using rerunnables" in {
    assert(benchmark.sumIntsR === sum)
  }

  it should "correctly calculate the sum using tasks" in {
    assert(benchmark.sumIntsT === sum)
  }

  it should "correctly calculate the sum using rerunnables and future pools" in {
    assert(benchmark.sumIntsPR === sum)
  }

  it should "correctly calculate the sum using tasks and future pools" in {
    assert(benchmark.sumIntsPT === sum)
  }
}
