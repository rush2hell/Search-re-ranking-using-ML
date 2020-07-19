import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import static java.lang.System.in;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rushabh Doshi
 */
public class ScoreCalculation
{

	int[] wordscore(String[] res, String query)
	{
		int occurence[] = { 0, 0, 0, 0, 0 };
		try
		{

			for (int i = 0; i < 5; i++)
			{
				res[i].replace('\\', '/');
				occurence[i] = ScoreCalculation.countoccurence(res[i], query);
				System.out.println("Occurence for query " + res[i] + " = " + occurence[i]);
			}

			for (int i = 0; i < 5; i++)
			{
				System.out.println("URL = " + res[i] + "\t Occur = " + occurence[i]);
			}

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Exception in wordscore");
		}
		return occurence;

	}

	public double[] tfscore(String[] res, String query)
	{

		double tf[] = { 0.0, 0.0, 0.0, 0.0, 0.0 };
		try
		{

			for (int i = 0; i < 5; i++)
			{
				res[i].replace('\\', '/');
				tf[i] = ScoreCalculation.countoccurence2(res[i], query);
				System.out.println("Occurence for query " + res[i] + " = " + tf[i]);
			}

			for (int i = 0; i < 5; i++)
			{
				System.out.println("URL = " + res[i] + "\t TF = " + tf[i]);
			}

		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Exception in tfscore");
		}
		return tf;
	}

	public static int countoccurence(String url1, String query)
	{
		int occurence = 0;
		try
		{

			String querypart[] = query.split(" ");
			for (int i = 0; i < querypart.length; i++)
				System.out.println(querypart[i]);
			System.out.println("Reading URL :" + url1);
			URL url = new URL(url1);
			URLConnection con = url.openConnection();
			InputStream is = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = "", data = "";
			System.out.println("Reading While loop");
			while ((line = br.readLine()) != null)
			{
				// System.out.println(line);
				data = data.concat(line);

			}
			data = data.toUpperCase();

			String textOnly = Jsoup.parse(data.toString()).text();
			data = textOnly;
			System.out.println(data);
			for (int j = 0; j < querypart.length; j++)
			{
				querypart[j] = querypart[j].toUpperCase();
				Pattern p = Pattern.compile(querypart[j].toUpperCase());
				Matcher m = p.matcher(data);
				while (m.find())
				{
					occurence++;
				}

			}

		}
		catch (MalformedURLException ex)
		{
			Logger.getLogger(ScoreCalculation.class.getName()).log(Level.SEVERE, null, ex);
		}
		catch (IOException ex)
		{
			Logger.getLogger(ScoreCalculation.class.getName()).log(Level.SEVERE, null, ex);
		}
		return occurence;
	}

	public static double countoccurence2(String url1, String query)
	{
		int occurence = 0, total = 0;
		double tf;
		try
		{

			String querypart[] = query.split(" ");
			for (int i = 0; i < querypart.length; i++)
				System.out.println(querypart[i]);
			System.out.println("Reading URL :" + url1);
			URL url = new URL(url1);
			URLConnection con = url.openConnection();
			InputStream is = con.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = "", data = "";
			System.out.println("Reading While loop");
			while ((line = br.readLine()) != null)
			{
				// System.out.println(line);
				data = data.concat(line);

			}
			data = data.toUpperCase();

			String textOnly = Jsoup.parse(data.toString()).text();
			data = textOnly;
			System.out.println(data);
			total = data.split("\\s+").length;
			for (int j = 0; j < querypart.length; j++)
			{
				querypart[j] = querypart[j].toUpperCase();
				Pattern p = Pattern.compile(querypart[j].toUpperCase());
				Matcher m = p.matcher(data);
				while (m.find())
				{
					occurence++;
				}

			}

		}
		catch (MalformedURLException ex)
		{
			Logger.getLogger(ScoreCalculation.class.getName()).log(Level.SEVERE, null, ex);
		}
		catch (IOException ex)
		{
			Logger.getLogger(ScoreCalculation.class.getName()).log(Level.SEVERE, null, ex);
		}
		tf = occurence / (total * 1.0);
		return tf;
	}

	public static void main(String args[])
	{
		int occur;
		occur = ScoreCalculation.countoccurence("http://stackoverflow.com/", "stack overflow");
		System.out.println(occur);
	}

}
