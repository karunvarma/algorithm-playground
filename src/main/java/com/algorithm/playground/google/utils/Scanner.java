package com.algorithm.playground.google.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Scanner implements AutoCloseable {

	private final BufferedReader br;
	private StringTokenizer st;

	public Scanner(InputStream is) {
		this.br = new BufferedReader(new InputStreamReader(is));
	}

	@Override
	public void close() {
		try {
			br.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public String next() {
		read();
		return st == null ? null : st.nextToken();
	}

	public boolean hasNext() {
		read();
		return st != null;
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	private void read() {
		if (st == null || !st.hasMoreTokens()) {
			try {
				String line = br.readLine();
				if (line == null) {
					st = null;
				} else {
					st = new StringTokenizer(line);
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
