package at.ac.fhcampuswien.newsanalyzer.ui;


import at.ac.fhcampuswien.newsanalyzer.ctrl.Controller;
import at.ac.fhcampuswien.newsapi.enums.Category;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInterface
{
	private Controller ctrl = new Controller();

	public void getDataFromCtrl1(){
		System.out.println("Search for Intel");
		ctrl.process("intel", Category.technology);
	}
	public void getDataFromCtrl2(){
		// TODO implement me
		System.out.println("Search for Corona");
		ctrl.process("corona", Category.health);
	}
	public void getDataFromCtrl3(){
		// TODO implement me
		System.out.println("Search for Fußball");
		ctrl.process("fußball", Category.sports);
	}
	public void getDataForCustomInput() {
		// TODO implement me
		System.out.print("Search for?\n>");
		String userInput = readLine();
		System.out.println("Search for " + userInput);
		ctrl.process(userInput, null);
	}
	public void start() {
		Menu<Runnable> menu = new Menu<>("User Interface");
		menu.setTitle("Please Choose:");
		menu.insert("a", "Choice Intel", this::getDataFromCtrl1);
		menu.insert("b", "Choice Corona", this::getDataFromCtrl2);
		menu.insert("c", "Choice Fußball", this::getDataFromCtrl3);
		menu.insert("d", "Choice User Input",this::getDataForCustomInput);
		menu.insert("q", "Quit", null);
		Runnable choice;
		while ((choice = menu.exec()) != null) {
			choice.run();
		}
		System.out.println("Program finished");
	}
	protected String readLine() {
		String value = "\0";
		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			value = inReader.readLine();
		} catch (IOException ignored) {
		}
		return value.trim();
	}
}

