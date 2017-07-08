package parte1;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;

public class Generador {

	public static void main(String[] args) throws FileNotFoundException {
		PrintStream out=null;
		try {
			Random r = new Random();
			out = new PrintStream(args[0]);
			for(int i=0;i<Integer.parseInt(args[1]);i++) {
				
				out.println(Math.abs(r.nextInt()));
			}
		} finally{
			if(out!=null) out.close();
		}
	}

}
