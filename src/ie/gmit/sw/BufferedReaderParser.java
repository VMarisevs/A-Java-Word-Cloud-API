package ie.gmit.sw;

import java.io.*;

public interface BufferedReaderParser {	
	public void parse(BufferedReader in, WordCloudMap wcm) throws IOException;
}
