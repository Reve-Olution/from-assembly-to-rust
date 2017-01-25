use std::thread;

fn start_thread(nb : i32) -> thread::JoinHandle<i32> {
	thread::spawn(move || {
        (0..nb).fold(0,|acc,_|acc+1)
    })
}

fn main() {
	let v : i32 = (0..4)
		.map(|_| start_thread(10000000))
		.map(|j : thread::JoinHandle<i32>| j.join().unwrap())
		.sum();
	println!("{}",v);
}
