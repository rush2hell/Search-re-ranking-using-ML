import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;
import java.io.BufferedReader;
import org.jsoup.Jsoup;

public class HTMLUtils
{
	private HTMLUtils()
	{
	}

	public static String extractText(Reader reader) throws IOException
	{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(reader);
		String line;
		while ((line = br.readLine()) != null)
		{
			sb.append(line);
		}
		String textOnly = Jsoup.parse(sb.toString()).text();
		return textOnly;
	}

	public static String check(String query, String path[]) throws IOException
	{
		String output = "";

		int occurrences = 0;

		for (int i = 0; i < 5; i++)
		{
			System.out.println("Reading Page " + (i + 1));
			FileReader reader = new FileReader(path[i]);
			String data = HTMLUtils.extractText(reader);
			// System.out.println(HTMLUtils.extractText(reader));
			// System.out.println("\n");
			data = data.toUpperCase();
			query = query.toUpperCase();
			if (data.contains(query))
			{
				int withSentenceLength = data.length();
				int withoutSentenceLength = data.replace(query, "").length();
				occurrences = (withSentenceLength - withoutSentenceLength) / query.length();
				System.out.println("Occurence = " + occurrences);
			}

			if (occurrences != 0)
			{
				output = output.concat(path[i]);
				output = output.concat("\n");

			}

			occurrences = 0;

		}
		System.out.println(output);
		return output;

	}

	public final static void main(String[] args) throws Exception
	{

		String path[] = new String[5];
		path[0] = "./WebContent/index.html";
		path[1] = "./WebContent/govern.html";
		path[2] = "./WebContent/principal.html";
		path[3] = "./WebContent/registrar.html";
		path[4] = "./WebContent/contact.html";
		for (int i = 0; i < 5; i++)
		{
			System.out.println("Reading Page " + (i + 1));
			FileReader reader = new FileReader(path[i]);
			System.out.println(HTMLUtils.extractText(reader));
			System.out.println("\n");
		}
	}

}