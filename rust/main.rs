use std::thread;

fn start_thread(nb : i32) -> thread::JoinHandle<i32> {
	thread::spawn(move || {
        (0..nb).fold(0,|acc,_|acc+1)
    })
}

fn main() {
	let t1 = start_thread(10000000000);
	let t2 = start_thread(10000000000);
	let t3 = start_thread(10000000000);
	let t4 = start_thread(10000000000);
	t1.join();
	t2.join();
	t3.join();
	t4.join();
}
