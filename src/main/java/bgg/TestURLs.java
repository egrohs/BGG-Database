package bgg;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestURLs implements Function<String, Optional<TestURLs.Tuple>> {

	public static final int TIMEOUT = 3000;

	public class Tuple {
		final String url;
		final String error;

		public Tuple(String url, String error) {
			this.url = url;
			this.error = error;
		}
	}

	public static enum HostNamePortExtractor implements Function<String, String> {
		INSTANCE;
		@Override
		public String apply(String url) {
			try {
				URL u = new URL(url);
				return u.getHost() + u.getPort();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public Optional<Tuple> apply(String url) {
		HttpURLConnection connection;
		try {
			connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setRequestMethod("GET");
			connection.setReadTimeout(TIMEOUT);
			connection.setConnectTimeout(TIMEOUT);
			connection.connect();
			int responseCode = connection.getResponseCode();
			// are you sure? I think you would have liked to write here "and" not or
			// if (responseCode != 200 || responseCode != 302) {
			if (responseCode != 200 && responseCode != 302) {
				return Optional.of(new Tuple(url, Integer.toString(responseCode)));
			}
			// long t = System.currentTimeMillis();
			String path = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("?")) + ".xml";
			escreve(connection, path);
			// System.out.println(System.currentTimeMillis()-t);
		} catch (IOException e) {
			return Optional.of(new Tuple(url, e.getMessage()));
		}
		return Optional.empty();
	}

	private void escreve(HttpURLConnection connection, String fileName) {
		// Set DoOutput to true if you want to use URLConnection for output.
		// Default is false
//		connection.setDoOutput(true);
//		connection.setUseCaches(true);
//
//		// Set Headers
//		connection.setRequestProperty("Accept", "application/xml");
//		connection.setRequestProperty("Content-Type", "application/xml");

		// String saveFilePath = "300.xml";// saveDir + File.separator + fileName;
		// opens input stream from the HTTP connection

		try (InputStream inputStream = connection.getInputStream();
				FileOutputStream outputStream = new FileOutputStream("output/" + fileName);) {
			inputStream.transferTo(outputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        int bytesRead = -1;
//        byte[] buffer = new byte[BUFFER_SIZE];
//        while ((bytesRead = inputStream.read(buffer)) != -1) {
//            outputStream.write(buffer, 0, bytesRead);
//        }
	}

	static List<String> URLs = new ArrayList<>(); // add urls here
	static {
		for (int i = 0; i < 300000; i++) {
			if (!Files.exists(Paths.get("output/" + i + ".xml"))) {
				URLs.add("https://api.geekdo.com/xmlapi/boardgame/" + i + "?stats=1");
			}
		}
	}

	public Map<String, String> process() {
		// group by hostname+port
		Map<String, List<String>> groupedUrls = URLs.stream()
				.collect(Collectors.groupingBy(HostNamePortExtractor.INSTANCE));
		Stream<Tuple> errors = groupedUrls.keySet().parallelStream()
				// I am not fully sure, but hoping that the stream() will go to the same thread
				.flatMap(host -> groupedUrls.get(host).stream())
				// go to the server
				.map(this::apply)
				// if there was no error, filter out the optional.empties
				.filter(o -> o.isPresent())
				// get the Tuple with url and the error
				.map(o -> o.get());
		// make a map
		return errors.collect(Collectors.toMap(t -> t.url, t -> t.error));
	}

	public static void main(String[] args) {
		System.out.println(new Date());
		TestURLs testUrls = new TestURLs();
		testUrls.process().entrySet().forEach(e -> {
			System.out.println(e.getKey() + " error: " + e.getValue());
		});
		System.out.println(new Date());
	}
}