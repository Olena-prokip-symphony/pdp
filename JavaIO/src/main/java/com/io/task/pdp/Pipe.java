package com.io.task.pdp;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Pipe {

	public static void main(String[] args) throws IOException {

		final PipedOutputStream output = new PipedOutputStream();
		final PipedInputStream input = new PipedInputStream(output);

		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {

				try {
					output.write("This is the pipe example...".getBytes());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {

				int data;
				try {
					data = input.read();

					while (data != -1) {
						System.out.print((char) data);
						data = input.read();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		thread1.start();
		thread2.start();
	}
}
