package vn.quantda.example.osgi.config.configapp;

public class MyApp {

	String title;

	public void setTitle(String title) {
		this.title = title;
	}

	public void refresh() {
		System.out.println("Configuration updated (title=" + title + ")");
	}
}
