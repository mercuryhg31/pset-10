module dictionary {
	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.media;
	requires javafx.swing;
	requires javafx.swt;
	requires javafx.web;

	requires com.google.gson;
	requires json.simple;
	requires java.desktop;
	
	exports app;
	opens dict;
}