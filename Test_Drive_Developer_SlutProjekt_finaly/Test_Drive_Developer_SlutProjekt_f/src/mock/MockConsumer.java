package mock;

import main.Consumer;
import main.Item;

public class MockConsumer implements Consumer {

	MockBuffer mockBuffer;
	MockItem mockItem;

	public MockConsumer(MockBuffer mockBuffer) {

		this.mockBuffer = mockBuffer;

	}

	public Item removeItem() {
		
		return mockBuffer.remove();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void stopRunning() {
		// TODO Auto-generated method stub

	}

}