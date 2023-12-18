package mock;

import java.util.Queue;
import java.util.function.BooleanSupplier;

import main.Buffer;
import main.Item;

public class MockBuffer extends Buffer {
	

	public Queue<Item> getBuffer() {
		return buffer;

	}

	public boolean isEmpty() {
		return buffer.isEmpty();
	}

}