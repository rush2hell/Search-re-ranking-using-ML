import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rushabh Doshi
 */
public class Trial
{
	public static void main(String args[]) throws UnsupportedEncodingException, IOException
	{
		URL url = new URL("http://stackoverflow.com/");

		// Get the input stream through URL Connection
		URLConnection con = url.openConnection();
		InputStream is = con.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line = null;

		// read each line and write to System.out
		while ((line = br.readLine()) != null)
		{
			System.out.println(line);
		}
	}

}
