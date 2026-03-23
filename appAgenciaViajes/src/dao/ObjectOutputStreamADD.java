package dao;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ObjectOutputStreamADD extends ObjectOutputStream{

	public ObjectOutputStreamADD(OutputStream os) throws IOException {
		super(os);
		
	}
	
	@Override
	public void writeStreamHeader(){
		
	}

}
