use std::thread;
use std::sync::{Arc,Mutex};

fn start_thread(nb : i32, counter : &Arc<Mutex<i32>>) -> thread::JoinHandle<()> {
	let a = counter.clone();
	thread::spawn(move || {
		let mut v = a.lock().unwrap();
        let c = (0..nb).fold(0,|acc,_|acc+1);
		*v += c;
    })
}

fn main() {
	let counter = Arc::new(Mutex::new(0));
	(0..4)
		.map(|_| start_thread(100000, &counter))
		.map(|j| j.join().unwrap())
		.collect::<Vec<_>>();

	println!("{}",*counter.lock().unwrap());
}
