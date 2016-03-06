package com.io.task.pdp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Stream {

	public static void main(String[] args) throws IOException {
		try (InputStream input = new FileInputStream("src/main/resources/input.txt");
				OutputStream output = new FileOutputStream("src/main/resources/output.txt")) {
			int data = input.read();

			while (data != -1) {
				System.out.print((char) data);
				output.write(data);
				data = input.read();
			}

		}

	}
}
