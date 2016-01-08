package curl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class HelloCurl {
	public static void main(String args[]) throws KeyManagementException, NoSuchAlgorithmException {
		// System.out.println("hi");

		String params = "token_source+Parse-token+a2j0glmxey82xkl97gakmgla";
		String body = "{\"cmd\":\"220.137.65.234:9000/restapi/lan/GetAddress?token_source=Parse&token=a2j0glmxey82xkl97gakmgla\"}";
		String bodynew = "{\"cmd\":\"61.228.249.124:8080/restapi/lan/GetAddress?token=CAAHak57rPdEBAFup7K0oTyxFwchV3cxSCoqZBjCz5FI252CPmNTPS05JBnpP0jHJR5Xgp7EqQyRMdEzWRMBIf229oaQgG1Rtz3BrDIPwAm7i1PzMWr06bsJd6icM6ia9n7ZC0gJsnnjzgKT37ZCp7ZALcKG0O853jMf3PWjTmbSahNj58Yk0\"}";
		/*
		 * try { System.out.println(paramParse(params)); } catch (Exception e) {
		 * // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		// executeGet("https://cpedev-umediaiot.rhcloud.com/Rest/hello","");
		// executePost("http://localhost:8080/helloworldmvc/rest/xpb124/v1",
		// body);

		// executePost("http://localhost:8080/helloworldmvc/rest/xpb124/echo",
		// body);

		/*
		 * HostnameVerifier bypassSSl = new HostnameVerifier() { public boolean
		 * verify(String hostname, SSLSession session) { return true; } };
		 * HttpsURLConnection.setDefaultHostnameVerifier(bypassSSl);
		 */

		// Create a trust manager that does not validate certificate chains
		/*TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			@Override
			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}

		} };

		// Install the all-trusting trust manager
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

		// Create all-trusting host name verifier
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};

		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);*/

		/*
		 * executeGet(
		 * "https://61.228.249.124:8080/restapi/lan/GetAddress?token=CAAHak57rPdEBAFup7K0oTyxFwchV3cxSCoqZBjCz5FI252CPmNTPS05JBnpP0jHJR5Xgp7EqQyRMdEzWRMBIf229oaQgG1Rtz3BrDIPwAm7i1PzMWr06bsJd6icM6ia9n7ZC0gJsnnjzgKT37ZCp7ZALcKG0O853jMf3PWjTmbSahNj58Yk0"
		 * );
		 */

		String unsafewebsite = "{\"verb\":\"GET\",\"cmd\":\"www.senslink.net\",\"payload\":\"payload data\"}";
		//executePost("https://cpedev-umediaiot.rhcloud.com/Rest/xpb124/v1", unsafewebsite);
		executePost("http://localhost:8080/helloworldmvc/rest/xpb124/v1", unsafewebsite);
	}

	public static void executeGet(String targetURL, String urlParameters) {
		HttpURLConnection connection = null;
		try {
			// Create connection
			URL url = new URL(targetURL + "?" + urlParameters);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			connection.setRequestProperty("Content-Length", Integer.toString(urlParameters.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");

			connection.setUseCaches(false);
			connection.setDoOutput(true);

			int code = connection.getResponseCode();
			System.out.println("response code " + code);
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
			// return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	public static void executeGet(String targetURL) {
		HttpURLConnection connection = null;
		try {
			// Create connection
			URL url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			connection.setRequestProperty("Content-Length", "0");
			connection.setRequestProperty("Content-Language", "en-US");

			connection.setUseCaches(false);
			connection.setDoOutput(true);

			connection.setConnectTimeout(5000);

			int code = connection.getResponseCode();
			System.out.println("response code " + code);
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
			// return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	public static void executePost(String targetURL, String requestbody) {
		HttpURLConnection connection = null;
		try {
			// Create connection
			URL url = new URL(targetURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			// connection.setRequestProperty("Content-Type",
			// "application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("Accept", "'application/json");
			connection.setRequestProperty("Content-Length", Integer.toString(requestbody.getBytes().length));
			connection.setRequestProperty("Content-Language", "en-US");

			connection.setUseCaches(false);
			connection.setDoOutput(true);

			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());

			writer.write(requestbody);
			writer.flush();
			writer.close();

			int code = connection.getResponseCode();
			System.out.println("response code " + code);

			//System.out.println("response code " + code);
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
			// return null;
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	private static String paramParse(String inputStr) throws Exception {
		// build new parameteres list
		StringBuilder sb = new StringBuilder();

		String patternStr = "[a-zA-Z0-9_]+\\+[^\\+^\\-]+";
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(inputStr);
		boolean matchFound = matcher.find();
		int groupcount = 0;
		while (matchFound) {
			// System.out.println(matcher.start() + "-" + matcher.end());
			for (int i = 0; i <= matcher.groupCount(); i++) {
				String groupStr = matcher.group(i);
				// System.out.println(i + ":" + groupStr);

				try {
					String[] tokens = groupStr.split("\\+", 2);
					// System.out.println("key " + tokens[0]);
					// System.out.println("value " + tokens[1]);
					if (groupcount > 0) {
						sb.append('&');
					}
					sb.append(tokens[0]).append('=').append(tokens[1]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					// throw exception
					throw new Exception("Parameters parse fail");
				}
			}
			if (matcher.end() + 1 <= inputStr.length()) {
				matchFound = matcher.find(matcher.end());
				groupcount++;
			} else {
				break;
			}
		}
		return sb.toString();
	}
}
