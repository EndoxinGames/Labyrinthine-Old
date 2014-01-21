package thecyberplanners.labyrinthine.localizatoin;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class LocalizationLoader {
	public String language;
	public String[] lines;
	
	public LocalizationLoader(String language) {
		InputStream inputStream = LocalizationLoader.class.getResourceAsStream("/localizations/" + language + ".localization");
		BufferedInputStream bis = new BufferedInputStream(inputStream);
		BufferedReader br = new BufferedReader(new InputStreamReader(bis, Charset.forName("UTF-8")));
		int numberOfLines = 0;
		try {
			numberOfLines = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		lines = new String[numberOfLines];
		String line;
		int lineNum = 0;
		try {
			while ((line = br.readLine()) != null) {
				lines[lineNum] = line;
				System.out.println(line);
				lineNum++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
