import java.util.concurrent.atomic.AtomicInteger
import groovy.time.TimeCategory
import groovy.time.TimeDuration

start = new Date();

count = new AtomicInteger(0);

def newThread(nb) {
  return Thread.start {
    while(nb>0) {
      nb--;
      count.incrementAndGet()
    }
  }
}

def t1 = newThread(10000000);
def t2 = newThread(10000000);
def t3 = newThread(10000000);
def t4 = newThread(10000000);

t1.join()
t2.join()
t3.join()
t4.join()

stop = new Date();

println count
println TimeCategory.minus( stop, start )
