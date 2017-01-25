count = 0

def newThread(nb) {
  return Thread.start {
    while(nb>0) {
      nb--;
      count++;
    }
  }
}

def t1 = newThread(100000000);
def t2 = newThread(100000000);
def t3 = newThread(100000000);
def t4 = newThread(100000000);

t1.join()
t2.join()
t3.join()
t4.join()

println count
