import java.util.concurrent.atomic.AtomicInteger
import groovy.time.TimeCategory
import groovy.time.TimeDuration
import java.util.concurrent.*

start = new Date();

count = new AtomicInteger(0);

def pool = Executors.newFixedThreadPool(4);

def newAction(nb) {
  return {
    int numbers = nb
    while(nb>0) {
      nb--;
    }
    return numbers
  }
}

def a1 = newAction(10000000);
def a2 = newAction(10000000);
def a3 = newAction(10000000);
def a4 = newAction(10000000);

def f1 = pool.submit(a1 as Callable<Integer>)
def f2 = pool.submit(a2 as Callable<Integer>)
def f3 = pool.submit(a3 as Callable<Integer>)
def f4 = pool.submit(a4 as Callable<Integer>)

count.addAndGet(f1.get())
count.addAndGet(f2.get())
count.addAndGet(f3.get())
count.addAndGet(f4.get())

stop = new Date();

pool.shutdown()

println count
println TimeCategory.minus( stop, start )
