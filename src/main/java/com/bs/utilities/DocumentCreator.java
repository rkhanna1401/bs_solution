package com.bs.utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DocumentCreator {

	public static void writeToFile(Map<String, String> content, String filename) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))) {

			content.entrySet().stream().forEach(entry -> {
				try {
					bufferedWriter.write("****************");
					bufferedWriter.newLine();
					bufferedWriter.write(entry.getKey());
					bufferedWriter.newLine();
					bufferedWriter.write(entry.getValue());
					bufferedWriter.newLine();
					bufferedWriter.newLine();
					bufferedWriter.flush();
				} catch (IOException e) {
					e.printStackTrace(); 
				}
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public static void writeToFile(List<String> convertedTitles, String filename) {
		try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename))){
			convertedTitles.stream().forEach(content ->{
				try {
					bufferedWriter.newLine();
					bufferedWriter.newLine();
					bufferedWriter.write(content);
					bufferedWriter.flush();

				} catch (IOException e) {

					e.printStackTrace();
				}
			});
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
}

