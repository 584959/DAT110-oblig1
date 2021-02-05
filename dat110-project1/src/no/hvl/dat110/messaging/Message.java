package no.hvl.dat110.messaging;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import no.hvl.dat110.todo.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		if (payload.length < MessageConfig.SEGMENTSIZE) {
			this.payload = payload; // TODO: check for length within boundary
		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}

	public byte[] encapsulate() {

		byte[] encoded = null;
		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format

		encoded = new byte[128];
		encoded[0] = (byte)payload.length;
		if (payload.length > 0) {
			System.arraycopy(payload, 0, encoded, 1, payload.length	);
		}

		return encoded;

	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it
		// in the payload of this message
			int j = received[0];
			payload = new byte[j];
		if (j >= 0) {
			System.arraycopy(received, 1, payload, 0, j);
		}
		/*throw new UnsupportedOperationException(TODO.method());*/

	}
}
