package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array

		byte[] strByte = str.getBytes();
		encoded = new byte[strByte.length + 1];
		encoded[0] = rpcid;
		System.arraycopy(strByte, 0, encoded, 1, strByte.length);

		/*if (true) {
			throw new UnsupportedOperationException(TODO.method());
		}*/

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded;

		// TODO: unmarshall String contained in data into decoded

		byte[] temp = new byte[data.length - 1];
		System.arraycopy(data, 1, temp, 0, temp.length);

		decoded = new String(temp, StandardCharsets.UTF_8);
		//decoded = new String(temp, Charset.defaultCharset());

		/*if (true) {
			throw new UnsupportedOperationException(TODO.method());
		}*/

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded;

		// TODO: marshall RPC identifier in case of void type

		encoded = new byte[1];
		encoded[0] = rpcid;

		/*if (true) {
			throw new UnsupportedOperationException(TODO.method());
		}*/

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type

		// Metoden gjor ingenting
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array

		encoded = new byte[5];
		encoded[0] = rpcid;
		byte[] temp = ByteBuffer.allocate(4).putInt(x).array();
		System.arraycopy(temp, 0, encoded, 1, 4);

		/*if (true) {
			throw new UnsupportedOperationException(TODO.method());
		}*/

		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		// TODO: unmarshall integer contained in data

		decoded = ByteBuffer.wrap(data, 1, 4).getInt();

		/*if (true) {
			throw new UnsupportedOperationException(TODO.method());
		}*/

		return decoded;

	}
}
