use std::thread;
use std::sync::{Arc,Mutex};

fn start_thread(nb : i32, counter : &i32) -> thread::JoinHandle<()> {
	thread::spawn(|| {
        let c = (0..nb).fold(0,|acc,_|acc+1);
		*counter = nb + c;
    });
}

fn main() {
	let mut counter = 0;
	(0..4)
		.map(|_| start_thread(100000, &counter))
		.map(|j| j.join().unwrap())
		.collect::<Vec<_>>();

	println!("{}",counter);
}
