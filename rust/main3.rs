use std::thread;
use std::time::{SystemTime};

fn start_thread(nb : i32) -> thread::JoinHandle<i32> {
	thread::spawn(move || {
        (0..nb).fold(0,|acc,_|acc+1)
    })
}

fn main() {
	let now = SystemTime::now();
	let v : i32 = (0..4)
		.map(|_| start_thread(10000000))
		.collect::<Vec<thread::JoinHandle<i32>>>()
		.into_iter()
		.map(|j| j.join().unwrap())
		.sum();
	println!("{}",v);
	println!("{}", now.elapsed().unwrap().as_secs());
}
